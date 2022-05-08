package com.example.mode.controller;

import com.example.mode.db.ClientData;
import com.example.mode.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientData clientData;

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("clients", clientData.index());
        return "client/client";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("client", new Client());
        return "client/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("client") Client client, Model model, Authentication authentication) {
        clientData.save(client);
        logger.info("Админ " + authentication.getName() + " добавил клиента " + client.getName() + " " + client.getSurname());
        return "redirect:/client";
    }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id , Authentication authentication) {
        Client client = clientData.show(id);
        clientData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил клиента " + client.getName());
        return "redirect:/client";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientData.show(id));
        model.addAttribute("deals", clientData.showByClient(id));
        model.addAttribute("count", clientData.count(id));
        return "client/show";
    }
}
