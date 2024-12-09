package org.example.cqrsdemo.query.controller;


import org.example.cqrsdemo.command.api.CreateProductCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.cqrsdemo.query.repository.ProductViewRepository;
@Controller
public class ProductQueryController {
    private static final Logger logger = LoggerFactory.getLogger(ProductQueryController.class);

    private final ProductViewRepository repository;

    public ProductQueryController(ProductViewRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String redirectToProducts() {
        logger.info("Redirecting to /products");
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        logger.info("Querying all products");
        var products = repository.findAll();
        logger.info("Found {} products", products.size());
        model.addAttribute("products", products);
        model.addAttribute("command", new CreateProductCommand());
        return "products";
    }
}

