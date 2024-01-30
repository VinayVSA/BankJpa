package com.cg.bsappl.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.cg.bsappl.entities.Transaction;

public interface TransactionService {
	
	public void addTransaction(Transaction transaction)throws SQLException;

	public List<Transaction> getTransactionsByAccountId(int accId)throws SQLException;
	
	public List<Transaction> getTransactionByDate(Date startdate,Date enddate)throws SQLException;
	
}
