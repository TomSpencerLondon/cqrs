package org.example.cqrsdemo.query.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.cqrsdemo.events.ProductCreatedEvent;
import org.example.cqrsdemo.query.ProductView;
import org.example.cqrsdemo.query.repository.ProductViewRepository;

@Service
public class ProductEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(ProductEventHandler.class);

    private final ProductViewRepository repository;

    public ProductEventHandler(ProductViewRepository repository) {
        this.repository = repository;
    }

    @EventListener
    @Transactional
    public void on(ProductCreatedEvent event) {
        logger.info("Received event: ProductCreatedEvent for ID={}", event.getProductId());
        ProductView view = new ProductView(event.getProductId(), event.getName(), event.getPrice());
        repository.save(view);
        logger.info("Updated read model with new product: {}", view);
    }
}

