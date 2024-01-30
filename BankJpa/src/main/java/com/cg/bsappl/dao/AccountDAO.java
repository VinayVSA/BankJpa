package com.cg.bsappl.dao;

import java.sql.SQLException;

import com.cg.bsappl.entities.Account;
//import com.cg.bsappl.beans.Customer;
import com.cg.bsappl.exception.AccountException;

public interface AccountDAO {

	public Account getAccountById(int Id) throws SQLException;
	
	public void createAccount(Account account) throws SQLException;
	
	public void deleteAccount(int id) throws SQLException, AccountException;
	
	public void updateAccount(Account updateAccount) throws SQLException;
	
	public int getNumberofAccounts() throws SQLException;
}
