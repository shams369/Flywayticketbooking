package com.digitalbd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import TicketSystemInterface.DatabaseModel;

public class Destination implements DatabaseModel {
	private String table_name = "destinations";
	public String id,airport_from,airport_to,flight_id,time,status,fare,last_activity,last_modify_by,total_seat,seat_range,type;
	public Database db;
	public Destination() {
		id=airport_from=airport_to=flight_id=time=status=fare=last_activity=last_modify_by=total_seat=seat_range=type = "";
		db = new Database();
	}

	public Destination(String argId) {
		db = new Database();
		String sql = "SELECT * FROM "+this.GetTableName()+" WHERE id = '"+argId+"'";
		try {
			ResultSet result = this.db.statement.executeQuery(sql);
			if(result.next()) {
				this.id = result.getString("id");
				this.airport_from = result.getString("Airport_from");
				this.airport_to = result.getString("Airport_to");
				this.flight_id = result.getString("flight_id");
				this.time = result.getString("time");
				this.status = result.getString("status");
				this.fare = result.getString("fare");
				this.last_activity = result.getString("last_activity");
				this.last_modify_by = result.getString("last_modify_by");
				this.total_seat = result.getString("total_seat");
				this.seat_range = result.getString("seat_range");
				this.type = result.getString("type");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<HashMap<String,String>> getAll(String airportFrom ,String flightID){
		 ArrayList<HashMap<String,String>> list = new  ArrayList<HashMap<String,String>>();
		 String queryString = null;
		 if(flightID == null) {
			 queryString = "SELECT * FROM "+this.GetTableName() + " WHERE airport_from ='"+airportFrom+"'"; 
		 }else {
			 queryString = "SELECT * FROM "+this.GetTableName() + " WHERE airport_from ='"+airportFrom+"' AND flight_id = '"+flightID+"'";
		 }
		 
		 try {
			ResultSet result = this.db.statement.executeQuery(queryString);
			
			while(result.next()) {
				HashMap<String,String> tempData = new HashMap<String,String>();
				tempData.put("airport_from", result.getString("airport_from"));
				tempData.put("id", result.getString("id"));
				tempData.put("airport_to", result.getString("airport_to"));
				tempData.put("flight_id", result.getString("flight_id"));
				tempData.put("time", result.getString("time"));
				tempData.put("status", result.getString("status"));
				tempData.put("fare", result.getString("fare"));
				tempData.put("last_activity", result.getString("last_activity"));
				tempData.put("last_modify_by", result.getString("last_modify_by"));
				tempData.put("total_seat", result.getString("total_seat"));
				tempData.put("seat_range", result.getString("seat_range"));
				tempData.put("type", result.getString("type"));
				list.add(tempData);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	}
	public ArrayList<HashMap<String,String>> getAll(String airportFrom){
		return this.getAll(airportFrom,null);
	}
	@Override
	public int Save() {
		int destinationId = 0;
		destinationId = this.InsertNew();
		return 0;
	}

	@Override
	public int Update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Delete() {
		String querySting = "DELETE FROM "+this.GetTableName()+ " WHERE id='"+this.id+"'";
		System.out.println(this.id);
		try {
			db.statement.executeUpdate(querySting);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String GetTableName() {
		// TODO Auto-generated method stub
		return this.table_name;
	}
	
	private int InsertNew() {
		String sqlQury = "INSERT INTO "+this.GetTableName()+" (airport_from,airport_to,flight_id,time,status,fare,last_activity,last_modify_by,total_seat,seat_range,type) "
				+ " VALUES('"+this.airport_from+"','"+this.airport_to+"','"+this.flight_id+"','"+time+"','"+status+"','"+fare+"','"+last_activity+"','"+last_modify_by+"','"+total_seat+"','"+seat_range+"','"+type+"')";
		try {
			return this.db.statement.executeUpdate(sqlQury,Statement.NO_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
