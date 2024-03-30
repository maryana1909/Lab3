package com.company.dao;

import com.company.entity.Customer;
import lombok.NonNull;

import java.util.List;

public interface CustomerDAO {
    Customer add(@NonNull Customer customer);
    Customer get(long id);
    void remove(@NonNull Customer customer);
    void removeById(@NonNull long id);
    List<Customer> getAll();
}
