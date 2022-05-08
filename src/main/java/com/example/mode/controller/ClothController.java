package com.example.mode.controller;

import com.example.mode.db.ClothData;
import com.example.mode.db.MasterData;
import com.example.mode.model.Client;
import com.example.mode.model.Cloth;
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
@RequestMapping("/cloth")
public class ClothController {

    @Autowired
    ClothData clothData;

    private static final Logger logger = LoggerFactory.getLogger(ClothController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("clothes", clothData.index());
        return "cloth/cloth";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("cloth", new Cloth());
        return "cloth/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("cloth") Cloth cloth, Model model, Authentication authentication) {
        clothData.save(cloth);
        logger.info("Админ " + authentication.getName() + " добавил ткань " + cloth.getName());
        return "redirect:/cloth";
    }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id , Authentication authentication) {
        Cloth cloth = clothData.show(id);
        clothData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил ткань " + cloth.getName());
        return "redirect:/cloth";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //  model.addAttribute("driver", driverData.show(id));
        //  model.addAttribute("count", driverData.count(id));
        return "driver/show";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @RequestParam("l") int l, Authentication authentication) {
        Cloth cloth = clothData.show(id);
        int le = cloth.getLength() + l;
        clothData.update(id,le);
        logger.info("Админ " + authentication.getName() + " купил " + l + " метра ткани" + cloth.getName());
        return "redirect:/cloth";
    }
}
