package com.example.repository;

import java.util.List;

import com.example.model.Unit;

public interface UnitRepository
{
	List<Unit> findAllUnits();

	Unit findUnit(String unitId);

	void create(Unit unit);

	Unit update(Unit unit);

	void delete(String unitId);
}