package com.cg.bsappl.dao;


import java.sql.SQLException;

import java.util.List;

import com.cg.bsappl.entities.Transaction;
import com.cg.bsappl.util.JPAUtil;

public class TransactionDAOImpl implements TransactionDAO {

	 @Override
	    public void addTransaction(Transaction transaction) throws SQLException {
		 JPAUtil.createTransaction(transaction);
	    }

	    @Override
	    public List<Transaction> getTransactionsByAccountId(int accId) throws SQLException {
	        return JPAUtil.getTransactionsByAccountId(accId);
	    }
}
