package com.cg.bsappl.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.bsappl.entities.Transaction;

public interface TransactionDAO {
	
	
public void addTransaction(Transaction transaction) throws SQLException;

public List<Transaction> getTransactionsByAccountId(int accId) throws SQLException;
	
	
}
