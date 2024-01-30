// CustomerDAOImpl.java
package com.cg.bsappl.dao;


import java.sql.SQLException;

import com.cg.bsappl.entities.Customer;
import com.cg.bsappl.util.JPAUtil;

public class CustomerDAOImpl implements CustomerDAO {

	 @Override
	    public Customer getCustomerdetailsById(int id) throws SQLException {
	        return JPAUtil.getCustomerById(id);
	    }

	    @Override
	    public void addCustomer(Customer customer) throws SQLException {
	    	JPAUtil.createCustomer(customer);
	    }

	    @Override
	    public void deleteCustomer(int id) throws SQLException {
	    	JPAUtil.deleteCustomerById(id);
	    }

	    @Override
	    public void updateCustomer(Customer customer) throws SQLException {
	    	JPAUtil.updateCustomer(customer);
	    }
}
