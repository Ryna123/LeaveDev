package com.kh.coocon.lmsapp.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kh.coocon.lmsapp.entities.UserProfile;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao{

	@SuppressWarnings("unchecked")
	public List<UserProfile> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("name"));
		
		return (List<UserProfile>)crit.list();		
	}

	public UserProfile findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", type));
		
		return (UserProfile) crit.uniqueResult();
	}

	public UserProfile findById(int id) {
		return getByKey(id);
	}

}
