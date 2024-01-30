package com.cg.bsappl.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.cg.bsappl.dao.TransactionDAO;
import com.cg.bsappl.entities.Transaction;

public class TransactionServiceImpl implements TransactionService{

	private TransactionDAO transdao;
	
	public TransactionServiceImpl(TransactionDAO transdao)
	{
		this.transdao=transdao;
	}
	@Override
	public void addTransaction(Transaction transaction) throws SQLException {
		
		transdao.addTransaction(transaction);
	}

	@Override
	public List<Transaction> getTransactionsByAccountId(int accId) throws SQLException {
		
		return transdao.getTransactionsByAccountId(accId);
	}

	@Override
	public List<Transaction> getTransactionByDate(Date startdate, Date enddate) {
		
		return null;
	}

}
