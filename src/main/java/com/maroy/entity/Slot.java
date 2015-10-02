/**
 * 
 */
package com.maroy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MaRoy
 *
 */
@Entity
@Table(name="SLOT")
public class Slot {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="ITEM_COUNT")
	private Integer itemCount;
	
	@Column(name="SLOT_DATE")
	private String slotDate;
	
	@Column(name="SLOT_TIME")
	private String slotTime;
	
	@Column(name="IS_BOOKED")
	private Boolean isBooked;
	
	@Column(name="ORDER_NAME")
	private String orderName;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the itemCount
	 */
	public Integer getItemCount() {
		return itemCount;
	}

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * @return the slotDate
	 */
	public String getSlotDate() {
		return slotDate;
	}

	/**
	 * @param slotDate the slotDate to set
	 */
	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}

	/**
	 * @return the slotTime
	 */
	public String getSlotTime() {
		return slotTime;
	}

	/**
	 * @param slotTime the slotTime to set
	 */
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}

	/**
	 * @return the isBooked
	 */
	public Boolean getIsBooked() {
		return isBooked;
	}

	/**
	 * @param isBooked the isBooked to set
	 */
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

}
