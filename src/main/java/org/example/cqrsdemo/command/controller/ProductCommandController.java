package org.example.cqrsdemo.command.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.example.cqrsdemo.command.api.CreateProductCommand;
import org.example.cqrsdemo.command.handler.ProductCommandHandler;

@Controller
public class ProductCommandController {

    private final ProductCommandHandler commandHandler;

    public ProductCommandController(ProductCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping("/products")
    public String createProduct(@ModelAttribute CreateProductCommand command, Model model) {
        try {
            commandHandler.handle(command);
            model.addAttribute("message", "Product created successfully!");
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "redirect:/products";
    }
}

