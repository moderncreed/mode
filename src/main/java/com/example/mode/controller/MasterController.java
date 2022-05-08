package com.example.mode.controller;

import com.example.mode.db.ClientData;
import com.example.mode.db.MasterData;
import com.example.mode.model.Client;
import com.example.mode.model.Master;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    MasterData masterData;

    private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("masters", masterData.index());
        return "master/master";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("master", new Master());
        return "master/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("master") Master master, Model model, Authentication authentication) {
        masterData.save(master);
        logger.info("Админ " + authentication.getName() + " добавил мастера " + master.getName() + " " + master.getSurname());
        return "redirect:/master";
    }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id , Authentication authentication) {
        Master master = masterData.show(id);
        masterData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил мастера " + master.getName() + " " + master.getSurname());
        return "redirect:/master";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("master", masterData.show(id));
        model.addAttribute("deals", masterData.showByMaster(id));
        model.addAttribute("count", masterData.count(id));
        return "master/show";
    }
}
