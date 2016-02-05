package com.kh.coocon.lmsapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.kh.coocon.lmsapp.entities.Contract;

@Repository("contractDao")
public class ContractDaoImpl extends AbstractDao<Integer, Contract> implements ContractDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> listContract() {
		
		Criteria crit = getSession()
				.createCriteria(Contract.class,"c");
		
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("c.id"),"id")
				.add(Projections.property("c.contractName"),"contractName")
				);
		crit.addOrder(Order.asc("c.contractName"));
		
		crit.setResultTransformer(new AliasToBeanResultTransformer(Contract.class));
		
		return (List<Contract>)crit.list();
	}

}
