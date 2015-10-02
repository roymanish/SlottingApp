/**
 * 
 */
package com.maroy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maroy.dao.SlottingDao;
import com.maroy.entity.Slot;
import com.maroy.utility.SlotFactory;

/**
 * @author MaRoy
 *
 */
@Service
public class SlottingServiceImpl implements SlottingService{

	@Autowired
	private SlottingDao slottingDao;
	
	@Override
	@Transactional
	public List<Slot> getAllSlotsForDate(String date) {
		// TODO Auto-generated method stub
		return slottingDao.getAllSlotsForDate(date);
	}

	@Override
	@Transactional
	public List<Slot> createSlots(String date) {

		List<Slot> slotList = SlotFactory.getInstance().createSlotsForGivenDate(date);
		slottingDao.createSlots(slotList);
		return slotList;
	}

	@Override
	@Transactional
	public void updateSlot(Slot slot) {
		
		Slot validSlot = SlotFactory.getInstance().validateSlot(slot);
		slottingDao.updateSlot(validSlot);
	}

	@Override
	@Transactional
	public List<Slot> getAllSlotsForOrderName(String orderName){
		
		return slottingDao.getAllSlotsForOrderName(orderName);
	}
	
	@Override
	@Transactional
	public List<String> getAllOrderNames() {
		
		return slottingDao.getAllOrderNames();
	}
	
	public void setSlottingDao(SlottingDao slottingDao){
		this.slottingDao = slottingDao;
	}

}
