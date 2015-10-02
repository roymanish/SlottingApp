/**
 * 
 */
package com.maroy.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maroy.entity.Slot;

/**
 * @author MaRoy
 *
 */
@Repository
public class SlottingDaoImpl implements SlottingDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Slot> getAllSlotsForDate(String date) {
		
		return sessionFactory.getCurrentSession().createQuery("from Slot where slotDate='"+date+"'").list();
	}

	@Override
	public void createSlots(List<Slot> slots) {

		for(Slot slot : slots){
			sessionFactory.getCurrentSession().save(slot);
		}
	}

	@Override
	public void updateSlot(Slot slot) {
		
		sessionFactory.getCurrentSession().update(slot);
	}
	
	@Override
	public List<String> getAllOrderNames() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("select distinct orderName from Slot where orderName is not null").list();
	}
	
	@Override
	public List<Slot> getAllSlotsForOrderName(String orderName) {
		
		return sessionFactory.getCurrentSession().createQuery("from Slot where orderName='"+orderName+"'").list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

}
