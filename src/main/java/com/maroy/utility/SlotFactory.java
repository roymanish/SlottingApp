/**
 * 
 */
package com.maroy.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.maroy.entity.Slot;

/**
 * @author MaRoy
 *
 */
public class SlotFactory {

	private static SlotFactory instance;
	private Properties prop;

	private SlotFactory(){

		prop = new Properties();

		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("slotting.properties");
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SlotFactory getInstance(){

		if(instance == null)
			instance = new SlotFactory();
		return instance;
	}

	public List<Slot> createSlotsForGivenDate(String slotDate){

		String[] slots = prop.getProperty("slots").split(",");

		List<Slot> slotList = new ArrayList<Slot>();
		for(String slotTime : slots){
			
			Slot slot = this.createSlot(slotDate, slotTime);
			slotList.add(slot);
		}
		return slotList;
	}

	public Slot createSlot(String slotDate,String slotTime){

		Slot slot = new Slot();
		slot.setItemCount(0);
		slot.setSlotDate(slotDate);
		slot.setSlotTime(slotTime);
		slot.setIsBooked(false);
		return slot;
	}
	
	public Slot validateSlot(Slot slot){
		
		if(slot.getItemCount() == Integer.parseInt(prop.getProperty("items.per.slot"))){
			slot.setIsBooked(true);
		}
		return slot;
	}
}
