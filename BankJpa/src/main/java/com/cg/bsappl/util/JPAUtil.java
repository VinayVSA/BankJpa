package com.cg.bsappl.util;

import java.util.List;

//import javax.persistence.PersistenceContext;

import com.cg.bsappl.entities.Account;
import com.cg.bsappl.entities.Customer;
import com.cg.bsappl.entities.Transaction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

	static EntityManagerFactory ef = Persistence.createEntityManagerFactory("Bank-server");;
	static EntityManager em = ef.createEntityManager();

	public static Account getAccountById(int id) {
		// EntityManager em=JPAUtil.getEntityManager();
		return em.find(Account.class, id);
	}

	public static void createAccount(Account account) {
		// EntityManager em= JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();

	}

	public static int getNumberofAccounts() {

		// EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT COUNT(a) FROM Account a", Long.class).getSingleResult().intValue();
	}

	public static void updateAccount(Account updateAccount) {
		// EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(updateAccount);
		em.getTransaction().commit();

	}

	public static void deleteAccount(int id) {
		// EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Account account = em.find(Account.class, id);
		if (account != null) {
			em.remove(account);
		}
		em.getTransaction().commit();

	}

	public static Customer getCustomerById(int id) {
		// EntityManager em = JPAUtil.getEntityManager();
		return em.find(Customer.class, id);

	}

	public static void createCustomer(Customer customer) {
		// EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(customer);
		em.getTransaction().commit();

	}

	public static void deleteCustomerById(int id) {
		// EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		Customer customer = em.find(Customer.class, id);
		if (customer != null) {
			em.remove(customer);
		}
		em.getTransaction().commit();

	}

	public static void updateCustomer(Customer customer) {
		// EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(customer);
		em.getTransaction().commit();

	}

	public static void createTransaction(Transaction transaction) {
		// EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();

	}

	public static List<Transaction> getTransactionsByAccountId(int accId) {
		// EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT t FROM Transaction t WHERE t.account.id = :accountId", Transaction.class)
				.setParameter("accountId", accId).getResultList();
	}

}
