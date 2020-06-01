package ru.kushnarev.models.impl;

import ru.kushnarev.entities.Product;
import ru.kushnarev.models.Dao;
import ru.kushnarev.models.exceptions.NoSuchEntityException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DaoModel implements Dao {
    public final Map<String, Product> db = new ConcurrentHashMap<>();
    private static final DaoModel instance = new DaoModel();

    private DaoModel(){}

    public static DaoModel getInstance() {
        /*instance.setProduct(new Product("Bread",2.54));
        instance.setProduct(new Product("Beer",5.45));
        instance.setProduct(new Product("Kit",345.534));*/
        return instance;
    }

    @Override
    public boolean setProduct(Product product) {
        if(product == null || db.containsKey(String.format("http://localhost:8080/eshop/product?id=%s", product.getId()))) {
            return false;
        }
        db.put(String.format("http://localhost:8080/eshop/product?id=%s", product.getId()), product);
        return true;
    }

    @Override
    public Product getProduct(int id) throws NoSuchEntityException {
        for(Product product: db.values()) {
            if(product.getId() == id) {
                return product;
            }
        }
        throw new NoSuchEntityException(String.format("DB doesn't contain product for %s id", id));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(db.values());
    }
}
