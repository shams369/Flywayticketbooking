package com.digitalbd;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import AllLayout.Flight;

public class flights {
	public String name,id,code,type="Businessclass",total_seat="";
	public int totalSeat;
	String table = "flights";
	Database db;
	public flights(){
		this.total_seat=this.name=this.id=this.code = "";
		db = new Database();
		this.totalSeat = 0;
	}
	public flights(String trnId) {
		db = new Database();
		String sql = "SELECT * FROM "+this.table+" WHERE id='"+trnId+"'";
		try {
			ResultSet result = this.db.statement.executeQuery(sql);
			while(result.next()) {
				this.name = result.getString("name");
				this.id = result.getString("id");
				this.type = result.getString("type");
				this.code = result.getString("code");
				this.total_seat = result.getString("total_seat");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Flight> getAll() {
		ArrayList<Flight> flights = new ArrayList<Flight>();
		String sqlQuery = "SELECT * FROM " + this.table;
		try {
			ResultSet result = db.statement.executeQuery(sqlQuery);
			while(result.next()) {
				Flight temp = new Flight();
				temp.id = result.getString("id");
				temp.name = result.getString("name");
				temp.code = result.getString("code");
				temp.type = result.getString("type");
				temp.totalSeat = Integer.parseInt(result.getString("total_seat"));
				flights.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flights;
	}
	public void Save() {
		if(this.id.equals("")) {
			this.CreateNew();
		}else {
			this.CreateNew();
		}
		
	}
	public void Delete (String trnId) {
		String sql = "DELETE FROM "+this.table+" WHERE id = '"+trnId+"'";
		try {
			this.db.statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*Search Destinations trains*/
	
	public ArrayList<HashMap<String,String>> SearchFlightFromTo(String from,String to,String coach){
		ArrayList<HashMap<String,String>> flights = new ArrayList<HashMap<String,String>>();
		String sql = null;
		if(coach != null && !coach.equals("any")) {
			 sql = "SELECT destinations.*flight.type as Class,flights.id as flightId,flights.name,flights.code,trains.type FROM flights"
					+ " INNER JOIN destinations ON "
					+ " trains.id = destinations.flight_id"
					+ " WHERE destinations.station_from = '"+from+"'"
					+ " AND destinations.station_to = '"+to+"'"
					+ " AND trains.type = '"+coach+"'"
					+ " ORDER BY name ASC";
		}else {
			 sql = "SELECT destinations.*,flights.type as coach,flights.id as flightId,flights.name,trains.code,flights.type FROM flights"
					+ " INNER JOIN destinations ON "
					+ " flights.id = destinations.flight_id"
					+ " WHERE destinations.airport_from = '"+from+"'"
					+ " AND destinations.airport_to = '"+to+"'"
					+ " ORDER BY name ASC";
		}
		
		try {
			ResultSet result = this.db.statement.executeQuery(sql);
			while(result.next()) {
				HashMap<String,String> tempFlight = new HashMap<String,String>();
				tempFlight.put("name", result.getString("name"));
				tempFlight.put("destination_id", result.getString("id"));
				tempFlight.put("class", result.getString("class"));
				tempFlight.put("flight_id", result.getString("trainId"));
				tempFlight.put("code", result.getString("code"));
				tempFlight.put("time", result.getString("time"));
				tempFlight.put("code", result.getString("code"));
				tempFlight.put("fare", result.getString("fare"));
				flights.add(tempFlight);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flights;
	}
	
	private int CreateNew() {
		String sqlQquery = "";
		sqlQquery = "INSERT INTO "+this.table+"(name,code,total_seat,type)"
				+ " VALUES('"+this.name+"','"+this.code+"','"+Integer.toString(this.totalSeat)+"','"+this.type+"')";
					
		try {
			return  this.db.statement.executeUpdate(sqlQquery,Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
}