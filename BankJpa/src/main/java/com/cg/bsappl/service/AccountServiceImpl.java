package com.cg.bsappl.service;

import java.sql.SQLException;
import java.time.LocalDate;

import com.cg.bsappl.exception.AccountException;
import com.cg.bsappl.dao.*;
import com.cg.bsappl.entities.Account;
import com.cg.bsappl.entities.Transaction;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountdao;
	private TransactionService transactionService;
	
	public AccountServiceImpl(AccountDAO accountdao,TransactionService transactionService)
	{
		this.accountdao=accountdao;
		this.transactionService=transactionService;
	}
	
	@Override
	public void deposit(int accNum, double dAmount) throws AccountException, SQLException {
		Account account =accountdao.getAccountById(accNum);
        if (account == null) {
            System.out.println("Account not found for account number: " + accNum);
        }
        else 
        {
        account.setBalance(account.getBalance() + dAmount);
        accountdao.updateAccount(account);
        Transaction depositTransaction = new Transaction( dAmount, "deposit",LocalDate.now(),account);
        transactionService.addTransaction(depositTransaction);
        System.out.println("The amount"+dAmount+"is deposited into the accountno: "+account.getAccountNum());
        }
	}

	@Override
	public void withdraw(int accNum, double wAmount) throws AccountException, SQLException {
		Account account =accountdao.getAccountById(accNum);
		if (account == null) {
			System.out.println("Account not found for account number: " + accNum);
        }
		else if (account.getBalance() < wAmount) 
        {
        	System.out.println("Insufficient balance for withdrawal from account number: " + accNum);
        }
        else 
        {
        account.setBalance(account.getBalance() - wAmount);
        accountdao.updateAccount(account);
        Transaction withdrawTransaction = new Transaction( wAmount,"withdraw",LocalDate.now(),account);
        transactionService.addTransaction(withdrawTransaction);
        System.out.println("The amount "+wAmount+" is withdrawn from accountNo "+account.getAccountNum());
        }
	}

	@Override
	public void transfer(int fromaccNum, int toaccNum, double transAmount) throws AccountException, SQLException {
		Account account1=accountdao.getAccountById(fromaccNum);
		Account account2=accountdao.getAccountById(toaccNum);
		if(account1.getBalance()>=transAmount)
		{
			System.out.println("The current balance of account number "+account1.getAccountNum()+" is:"+account1.getBalance());
			System.out.println("The current balance of account number "+account2.getAccountNum()+" is:"+account2.getBalance());
			account1.setBalance(account1.getBalance()-transAmount);
			 accountdao.updateAccount(account1);
			Transaction transferOutTransaction = new Transaction(transAmount, "transfer_out",LocalDate.now(),account1);
			transactionService.addTransaction(transferOutTransaction);
			System.out.println("Balance of account "+account1.getAccountNum() +"After transfer of amount="+transAmount+"from account number:"+account1.getAccountNum()+" is:"+account1.getBalance());
			account2.setBalance(account2.getBalance()+transAmount);
			 accountdao.updateAccount(account2);
			Transaction transferInTransaction = new Transaction(transAmount, "transfer_in",LocalDate.now(),account2);
			transactionService.addTransaction(transferInTransaction);
			System.out.println("Balance of account "+account2.getAccountNum() +"After transfer of amount="+transAmount+"to account number:"+account2.getAccountNum()+" is:"+account2.getBalance());
		}
		else
		{
			System.out.println("Not sufficient amount to tranfer from account number"+account1.getAccountNum()+"to account number"+account2.getAccountNum());
		}
		
		
	}

	@Override
	public Account getAccountById(int accNum) throws SQLException {
		 return accountdao.getAccountById(accNum);
	}

	@Override
	public void createAccount(Account account) throws SQLException {
		accountdao.createAccount(account);
		
	}

	@Override
	public int getNumberofAccount() throws SQLException {
		
		return accountdao.getNumberofAccounts();
	}

	@Override
	public void updateAccount(Account updateAccount) throws SQLException {
		accountdao.updateAccount(updateAccount);
		
	}

	@Override
	public void deleteAccount(int id) throws SQLException, AccountException {
		accountdao.deleteAccount(id);
		
	}

	 

}
