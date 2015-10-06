# Slot Booking Application #

------------------------------------------------------------------
       DEMO URL : [http://jbossews-maroy.rhcloud.com/SlottingApp/](http://jbossews-maroy.rhcloud.com/SlottingApp/)
------------------------------------------------------------------

---------------------------
    General Description
---------------------------
This is UI driven slot booking application POC. On the home screen user has to mention the order name, number of items in that order and order date. Based on these information application provides user with available slot for that date. User has to select the slots based on the number of items he has in the order and press book order. Another option is there to see order details for any order name selected from the drop down.

---------------------------
    Functional contraints
---------------------------
* A user cannot select more than the slots available for the day.
* The book slots button is not enable till the user is able to slot all items in his/her order.
* Each slot has predefined number of items. Based on the number of vehicles available in that slot. This should be part of configuration of the application which is not in this application due to constraints of time.
* Item count in a open slot has been externalized in a properties file on server side.
* An item is defined booked if it has reached its maximum item count limit. In this case 80.

---------------------------
    Technologies used
---------------------------

* Server side
	* Spring MVC for Rest based web services
	* Hibernate for persistence
	* HSQLDB for in memory database.
	
* Client Side
	* Angular JS for client side
	* Bootstrap CSS
