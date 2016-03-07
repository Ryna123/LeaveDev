package com.kh.coocon.lmsapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.kh.coocon.lmsapp.entities.Position;

@Repository("positionDao")
public class PositionDaoImpl extends AbstractDao<Integer, Position> implements PositionDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Position> listPosition() {
		Criteria crit = getSession().createCriteria(Position.class,"p");
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("p.id"),"id")
				.add(Projections.property("p.name"),"name")
				.add(Projections.property("p.description"),"description"));
		crit.setResultTransformer(new AliasToBeanResultTransformer(Position.class));
		/*Criteria crit = createEntityCriteria();*/
		return (List<Position>)crit.list();
	}

	@Override
	public long countPositionRecord() {

		Criteria crit = getSession().createCriteria(Position.class,"p");
		crit.setProjection(Projections.projectionList()
				.add(Projections.rowCount()));		
		//crit.setResultTransformer(new AliasToBeanResultTransformer(Position.class));
		return (long) crit.uniqueResult();
	}

}
