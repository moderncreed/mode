package com.example.mode.controller;

import com.example.mode.db.ClothData;
import com.example.mode.db.ModelData;
import com.example.mode.model.Cloth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/model")
public class ModelController {

    @Autowired
    ModelData modelData;
    @Autowired
    ClothData clothData;

    private static final Logger logger = LoggerFactory.getLogger(ModelController.class);

    @GetMapping
    public String index(Model model) {
        model.addAttribute("models", modelData.index());
        return "model/model";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("model", new com.example.mode.model.Model());
        model.addAttribute("clothes", clothData.index());
        return "model/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("model") com.example.mode.model.Model model,BindingResult bindingResult, @RequestParam("cloth") int cloth,  Authentication authentication) {
        model.setCloth(clothData.show(cloth));
        modelData.save(model);
        logger.info("Админ " + authentication.getName() + " добавил модель " + model.getName() + " материал " + clothData.show(cloth).getName());
        return "redirect:/model";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Authentication authentication) {
        com.example.mode.model.Model model = modelData.show(id);
        modelData.delete(id);
        logger.info("Админ " + authentication.getName() + " удалил модель " + model.getName());
        return "redirect:/model";
    }
}