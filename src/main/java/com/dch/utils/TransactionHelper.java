package com.dch.utils;

import java.util.function.Consumer;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TransactionHelper {
	private final EntityManagerFactory emf;

	public TransactionHelper (EntityManagerFactory emf) {
		this.emf = emf;
	}

	 public void executeInTransaction(Consumer<EntityManager> action) {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            action.accept(em);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackEx) {
                    System.err.println(rollbackEx.getMessage());
                }
            }
            throw e;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public <T> T executeInTransaction(Function<EntityManager, T> action) {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();

            T result = action.apply(em);

            transaction.commit();
            return result;

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackEx) {
                    System.err.println(rollbackEx.getMessage());
                }
            }
            throw e;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
	
}
