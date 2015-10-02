package com.maroy.service;

import java.util.List;

import com.maroy.entity.Slot;

public interface SlottingService {

	public List<Slot> getAllSlotsForDate(String date);
	public List<Slot> createSlots(String date);
	public void updateSlot(Slot slot);
	public List<Slot> getAllSlotsForOrderName(String orderName);
	public List<String> getAllOrderNames();
}
