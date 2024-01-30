package com.cg.bsappl.service;

import java.sql.SQLException;

import com.cg.bsappl.dao.CustomerDAO;
import com.cg.bsappl.entities.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerdao;
	
	public CustomerServiceImpl(CustomerDAO customerdao)
	{
		this.customerdao=customerdao;
	}
	@Override
	public Customer getCustomerdetailsById(int id) throws SQLException {

		return customerdao.getCustomerdetailsById(id);
	}

	@Override
	public void addCustomer(Customer customer) throws SQLException {

		customerdao.addCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) throws SQLException {

		customerdao.deleteCustomer(id);
		
	}

	@Override
	public void updateCustomer(Customer customer) throws SQLException {
		customerdao.updateCustomer(customer);
		
	}

}
