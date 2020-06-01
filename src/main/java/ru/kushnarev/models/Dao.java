package ru.kushnarev.models;

import ru.kushnarev.entities.Product;
import ru.kushnarev.models.exceptions.DaoSystemException;
import ru.kushnarev.models.exceptions.NoSuchEntityException;

import java.util.List;

public interface Dao {
    boolean setProduct(Product product) throws DaoSystemException;
    Product getProduct(int id) throws NoSuchEntityException, DaoSystemException;
    List<Product> getAllProducts() throws DaoSystemException;
}
