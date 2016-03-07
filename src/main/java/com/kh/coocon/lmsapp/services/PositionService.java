package com.kh.coocon.lmsapp.services;

import java.util.List;

import com.kh.coocon.lmsapp.entities.Position;

public interface PositionService {
	
	public List<Position> listPosition();
	public int addPosition(Position pos);
	public int deletePosition(int id);
	public int EditPosition(Position pos);

}
