package com.example.repository;

import java.util.List;

public interface Repository<T>
{
	List<T> findAll();

	T findById(int id);

	T create(T element);

	T update(T element);

	void delete(int id);
}