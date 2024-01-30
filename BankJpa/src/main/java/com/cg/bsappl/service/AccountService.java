package com.cg.bsappl.service;


import java.sql.SQLException;

import com.cg.bsappl.entities.Account;
import com.cg.bsappl.exception.AccountException;

public interface AccountService {

	public void deposit(int accNum,double dAmount)throws AccountException, SQLException;
	
	public void withdraw(int accNum,double wAmount )throws AccountException, SQLException;
	
	public void transfer(int fromaccNum,int toaccNum,double transAmount )throws AccountException, SQLException;

	public Account getAccountById(int accNum) throws SQLException;
	
	public void createAccount(Account account)throws SQLException;
	
	public void deleteAccount(int id)throws SQLException, AccountException;
	
	public  void updateAccount(Account updateAccount)throws SQLException;
	
	public int getNumberofAccount()throws SQLException;
	
}
