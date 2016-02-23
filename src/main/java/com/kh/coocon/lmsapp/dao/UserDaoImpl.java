package com.kh.coocon.lmsapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.stereotype.Repository;

import com.kh.coocon.lmsapp.entities.User;
 

 
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
 
    public User findById(int id) {
        return getByKey(id);
    }
 
    public User findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
    	/*Criteria crit = getSession()
    			.createCriteria(User.class,"u");
    	crit.setProjection(Projections.projectionList()
    			.add(Projections.property("u.ssoid"),"ssoId")
    			.add(Projections.property("u.password"),"password")
    			);*/
    	
        crit.add(Restrictions.eq("ssoId", sso));
        return (User) crit.uniqueResult();
    }

	public void save(User user) {
		 persist(user);
	}

	
	
	@SuppressWarnings("unchecked")
	public List<User> findByPosition() {
		Criteria crit = getSession()
				.createCriteria(User.class,"u");
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("u.id"),"id")
				.add(Projections.property("u.firstName"),"firstName")
				.add(Projections.property("u.lastName"), "lastName")
				.add(Projections.property("u.email"),"email")
				.add(Projections.property("u.position.name"),"position.name")
				);
		//crit.add(Restrictions.eq("u.position.name", "Manager"));
		
		// Convert to User Object
		crit.setResultTransformer(new AliasToBeanResultTransformer(User.class));
		
		return (List<User>)crit.list();
	}

	@Override
	public List<User> findAllUser() {
		Criteria crit = getSession()
				.createCriteria(User.class,"u");
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("u.id"),"id")
				);
		crit.setResultTransformer(new AliasToBeanResultTransformer(User.class));
		return (List<User>)crit.list();
	}
 
     
}
