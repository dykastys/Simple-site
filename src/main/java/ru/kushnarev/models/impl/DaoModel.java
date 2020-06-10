package ru.kushnarev.models.impl;

import ru.kushnarev.entities.Product;
import ru.kushnarev.entities.User;
import ru.kushnarev.models.Dao;
import ru.kushnarev.models.exceptions.NoSuchEntityException;

import java.util.*;

public class DaoModel implements Dao {
    private static final DaoModel instance = new DaoModel();

    private final Set<Product> products = new LinkedHashSet<>();
    private final Set<User> users = new HashSet<>();

    private DaoModel(){}

    public static DaoModel getInstance() {
        return instance;
    }

    @Override
    public synchronized void putProduct(Product product) {
        products.add(product);
    }

    @Override
    public synchronized Product getProduct(int id) throws NoSuchEntityException {
        for(Product product: products) {
            if(product.getId() == id) {
                return product;
            }
        }
        throw new NoSuchEntityException(String.format("DB doesn't contain product for %s id", id));
    }

    @Override
    public synchronized Set<Product> getProductDB() {
        return products;
    }

    @Override
    public synchronized void putUser(User user) {
        users.add(user);
    }

    @Override
    public synchronized User getUser(String name) throws NoSuchEntityException {
        for (User user: users) {
            if(user.getName().equals(name)) {
                return user;
            }
        }
        throw new NoSuchEntityException(String.format("DB doesn't contain account for %s name", name));
    }

    @Override
    public synchronized Set<User> getAllUsers() {
        return users;
    }
}
