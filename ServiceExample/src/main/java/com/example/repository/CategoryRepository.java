package com.example.repository;

import java.util.List;

import com.example.model.Category;

public interface CategoryRepository
{

	List<Category> findAllCategories();

}
