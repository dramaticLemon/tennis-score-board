package com.dch.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="players")
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;

	@Column(name = "name", unique=true)
	String name;

	public Player(String name) {
		this.name = name;
	}

	public Player() {
	}

	public String getName() {
		return this.name;
	}
}
