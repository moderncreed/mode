package com.example.mode.controller;

import com.example.mode.db.*;
import com.example.mode.model.Deal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deal")
public class DealController {

    @Autowired
    DealData dealData;
    @Autowired
    ClientData clientData;
    @Autowired
    MasterData masterData;
    @Autowired
    ModelData modelData;
    @Autowired
    ClothData clothData;

    private static final Logger logger = LoggerFactory.getLogger(DealController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("deals", dealData.index());
        return "deal/deal";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("deal", new Deal());
        model.addAttribute("clients", clientData.index());
        model.addAttribute("masters", masterData.index());
        model.addAttribute("models", modelData.index());
        model.addAttribute("clothes", clothData.index());
        return "deal/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("deal") Deal deal, BindingResult bindingResult, @RequestParam("client") int idCl,
                      @RequestParam("master") int idM, @RequestParam("model") int idMod, @RequestParam("cloth") int idCloth,
                      Authentication authentication, Model model) {
        deal.setDone(false);
        deal.setClient(clientData.show(idCl));
        deal.setMaster(masterData.show(idM));
        deal.setModel(modelData.show(idMod));
        deal.setCloth(clothData.show(idCloth));
        if (deal.getCloth().getLength()<deal.getModel().getLength()) {
            model.addAttribute("len", "Длины на складе недостаточно");
            return "deal/add";
        } else {
            int le = deal.getCloth().getLength() - deal.getModel().getLength();
            clothData.show(idCloth).setLength(le);
            clothData.update(idCloth,le);
            dealData.save(deal);
            logger.info("Админ " + authentication.getName() + " добавил сделку c клиентом " + clientData.show(idCl).getName() + " " + clientData.show(idCl).getSurname());
            return "redirect:/deal";
        }
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/show/{id}")
    public String add(@PathVariable("id") int id, Model model) {
        model.addAttribute("deal", dealData.show(id));
        return "deal/show";
    }

    @PostMapping("/show/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("deal") Deal deal, BindingResult bindingResult,
                      Authentication authentication) {
        dealData.update(deal);
        logger.info("Админ " + authentication.getName() + " обновил сделку c клиентом  " + dealData.show(id).getClient().getName()
                + " " + dealData.show(id).getClient().getSurname() );
        return "redirect:/deal";
    }
}