package com.kh.coocon.lmsapp.dao;

import java.util.List;

import com.kh.coocon.lmsapp.entities.Position;

public interface PositionDao {
	public List<Position> listPosition();
	
	public long countPositionRecord();
}
