package com.digitalbd;

import java.util.HashMap;

public class Helper {
	public static String baseUrl = "http://localhost:8080/Train_Ticket_System/";
	public static String TestName="T ruon";
	public static String Currency = "USD";
	public static HashMap<String,String> FlightClass(){
		HashMap<String,String> Class = new HashMap<String,String>();
		Class.put("First Class", "First Class");
		Class.put("Business Class", "Business Class");
		Class.put("Economy", "Economy");
		Class.put("Disabled", "Disabled");
		return Class;
	}
}
