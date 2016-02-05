package com.kh.coocon.lmsapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.coocon.lmsapp.dao.PositionDao;
import com.kh.coocon.lmsapp.entities.Position;

@Service("positionService")
@Transactional
public class PositionServiceImpl implements PositionService{
	
	@Autowired
	private PositionDao positionDao;

	@Override
	public List<Position> listPosition() {
		return this.positionDao.listPosition();
	}

}