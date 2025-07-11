package com.dch.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = buildEntityManagerFactory();
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY_SQL = buildEntityManagerFactorySQL();
		
	private static EntityManagerFactory buildEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("tennisPU");
	}
	public static EntityManagerFactory getTennisEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY;
	}
	public static EntityManagerFactory getArchiveEntityManagerFactory() {
		return ENTITY_MANAGER_FACTORY_SQL;
	}
	private static EntityManagerFactory buildEntityManagerFactorySQL() {
		return Persistence.createEntityManagerFactory("arhive-pg");
	}
}
