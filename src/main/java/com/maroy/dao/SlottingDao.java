/**
 * 
 */
package com.maroy.dao;

import java.util.Date;
import java.util.List;

import com.maroy.entity.Slot;

/**
 * @author MaRoy
 *
 */
public interface SlottingDao {

	public List<Slot> getAllSlotsForDate(String date);
	public void createSlots(List<Slot> slots);
	public void updateSlot(Slot slot);
	public List<Slot> getAllSlotsForOrderName(String orderName);
	public List<String> getAllOrderNames();
}
