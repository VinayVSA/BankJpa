

	package com.cg.bsappl.dao;

	import com.cg.bsappl.entities.*;
import com.cg.bsappl.exception.AccountException;
	import com.cg.bsappl.util.JPAUtil;

	import java.sql.SQLException;

	public class AccountDAOImpl implements AccountDAO {

	    @Override
	    public Account getAccountById(int id) throws SQLException {
	        return JPAUtil.getAccountById(id);
	    }

	    @Override
	    public void createAccount(Account account) throws SQLException {
	        JPAUtil.createAccount(account);
	    }

	    @Override
	    public int getNumberofAccounts() throws SQLException {
	        return JPAUtil.getNumberofAccounts();
	    }

	    @Override
	    public void updateAccount(Account updateAccount) throws SQLException {
	        JPAUtil.updateAccount(updateAccount);
	    }

	    @Override
	    public void deleteAccount(int id) throws AccountException, SQLException {
	        JPAUtil.deleteAccount(id);
	    }
	}

