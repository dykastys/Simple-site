package ru.kushnarev.entities;

import ru.kushnarev.models.exceptions.NoValidDataException;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy   /   HH:mm:ss");

    private String name;
    private String password;
    private String phone;
    private Integer age;

    private final Map<Product,String> addedProducts = new LinkedHashMap<>();

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Map<Product,String> getAddedProducts() {
        return addedProducts;
    }

    public void addProductInAddedProduct(Product product) {
        String date = format.format(Calendar.getInstance().getTime());
        addedProducts.put(product, date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) throws NoValidDataException {
        if(age < 5 || age > 105) {
            throw new NoValidDataException("user age isn't correct");
        }
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws NoValidDataException {
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        if(matcher.find()) {
            this.phone = phone;
        }else{
            throw new NoValidDataException("phone number isn't valid");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(format, user.format) &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(format, name, password, phone, age);
    }
}

//TODO: change phone on email and check it by sending a message
