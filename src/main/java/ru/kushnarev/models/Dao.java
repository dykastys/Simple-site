package ru.kushnarev.models;

import ru.kushnarev.entities.Product;
import ru.kushnarev.entities.User;
import ru.kushnarev.models.exceptions.DaoSystemException;
import ru.kushnarev.models.exceptions.NoSuchEntityException;

import java.util.Set;

public interface Dao {
    void putProduct(Product product);
    Product getProduct(int id) throws NoSuchEntityException, DaoSystemException;
    Set<Product> getProductDB() throws DaoSystemException;
    void putUser(User user);
    User getUser(String name) throws NoSuchEntityException;
    Set<User> getAllUsers() throws DaoSystemException;
}
