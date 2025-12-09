package com.pluralsight.NorthwindTradersAPI2.controllers;


import com.pluralsight.NorthwindTradersAPI2.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> products;

    public ProductsController() {
        products = new ArrayList<>();
        products.add(new Product(1,"pickles", 1, 5.99));
        products.add(new Product(2,"tomatoes", 1, 2.99));
        products.add(new Product(3,"beans", 2, 1.99));
        products.add(new Product(4,"chickpeas", 2, 1.99));
        products.add(new Product(5,"mushrooms", 3, 4.99));
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return products;
    }
    @RequestMapping(path ="/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId) {
        for (Product product : products) {
            if(product.getProductId() == productId) {
                return product;
            }

        }
        return null;
    }
}
