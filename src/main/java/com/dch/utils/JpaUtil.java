package com.dch.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("tennisPU");
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}
}
