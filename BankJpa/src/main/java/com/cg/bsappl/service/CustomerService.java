package com.cg.bsappl.service;


import java.sql.SQLException;

import com.cg.bsappl.entities.Customer;



public interface CustomerService {

public Customer getCustomerdetailsById(int id)throws SQLException;

public void addCustomer(Customer customer)throws SQLException;

public void deleteCustomer(int id)throws SQLException;

public void updateCustomer(Customer customer)throws SQLException;
	
}
