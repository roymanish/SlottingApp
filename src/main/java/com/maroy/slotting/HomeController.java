package com.maroy.slotting;

import java.util.List;
import java.util.Locale;

import javax.xml.ws.RespectBinding;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maroy.entity.Slot;
import com.maroy.service.SlottingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SlottingService slottingService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "index";
	}
	
	@RequestMapping(value = "/getAllSlotsForDate", method = RequestMethod.POST)
	public @ResponseBody List<Slot> getAllSlotsForDate(@RequestBody String date){
		
		List<Slot> slotList = slottingService.getAllSlotsForDate(date);
		if(slotList == null || slotList.isEmpty()){
			slotList = slottingService.createSlots(date);
		}
		return slotList;
	}
	
	@RequestMapping(value = "/bookslot", method = RequestMethod.POST)
	public @ResponseBody String bookSlot(@RequestBody String jsonSlots){
		ObjectMapper mapper = new ObjectMapper();
		List<Slot> slotList = null;
		try{
		slotList = mapper.readValue(jsonSlots, 
				TypeFactory.collectionType(List.class, Slot.class));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		for(Slot slot : slotList){
			
			slottingService.updateSlot(slot);
		}
		return "SUCCESS";
	}
	
	@RequestMapping(value = "/getAllSlotsForOrderName", method = RequestMethod.POST)
	public @ResponseBody List<Slot> getAllSlotsForOrderName(@RequestBody String orderName){
		
		return slottingService.getAllSlotsForOrderName(orderName);
	}
	
	@RequestMapping(value = "/getAllOrderNames", method = RequestMethod.GET)
	public @ResponseBody List<String> getAllOrderNames(){
		
		return slottingService.getAllOrderNames();
	}
	
}
