package com.kh.coocon.lmsapp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
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
	@Autowired
	private DataSource dataSource;

	@Override
	public List<Position> listPosition() {
		return this.positionDao.listPosition();
	}

	@Override
	public int addPosition(Position pos) {
		// TODO Auto-generated method stub
		String sql="insert into lms_positions(position_id,name,description) values(nextval('posSequence'),?,?)";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setString(1,pos.getName());
			preparedStatement.setString(2, pos.getDescription());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		return 0;
	}

	@Override
	public int deletePosition(int id) {
		String sql="delete from lms_positions where position_id = ?";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int EditPosition(Position pos) {
		String sql="update lms_positions set name=?,description=? where position_id=?";
		try {
			Connection cnn = dataSource.getConnection();
			PreparedStatement preparedStatement = cnn.prepareStatement(sql);
			preparedStatement.setString(1, pos.getName());
			preparedStatement.setString(2, pos.getDescription());
			preparedStatement.setInt(3, pos.getId());
			return preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

}
