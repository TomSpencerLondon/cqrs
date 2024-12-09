package org.example.cqrsdemo.command.handler;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import org.example.cqrsdemo.command.api.CreateProductCommand;
import org.example.cqrsdemo.events.ProductCreatedEvent;

@Service
public class ProductCommandHandler {
    private static final Logger logger = LoggerFactory.getLogger(ProductCommandHandler.class);

    private final ApplicationEventPublisher eventPublisher;

    public ProductCommandHandler(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void handle(CreateProductCommand command) {
        logger.info("Received command to create product: name={}, price={}", command.getName(), command.getPrice());
        if (command.getName() == null || command.getName().isBlank()) {
            logger.warn("Invalid product name");
            throw new IllegalArgumentException("Product name is required");
        }
        if (command.getPrice() <= 0) {
            logger.warn("Invalid product price");
            throw new IllegalArgumentException("Product price must be > 0");
        }

        String productId = UUID.randomUUID().toString();
        logger.info("Generated product ID: {}", productId);

        ProductCreatedEvent event = new ProductCreatedEvent(productId, command.getName(), command.getPrice());
        logger.info("Publishing event: {}", event);
        eventPublisher.publishEvent(event);
    }
}

