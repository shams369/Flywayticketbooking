<%@page import="java.util.*,AllLayout.*,com.digitalbd.*,com.digitalbd.flights,com.digitalbd.Destination,AllLayout.*" %>

<%
ArrayList<HashMap<String,String>> flights = new ArrayList<HashMap<String,String>>();
flights flitObj = new flights();
String airportTo = (String) request.getParameter("to");
String airportFrom = (String) request.getParameter("from");
String sClass = (String) request.getParameter("Class");
String journey_date = (String) request.getParameter("journey_date");
Airport airportFromObj = new Airport();
Airport airportToObj = new Airport();
if(airportTo != null || airportFrom != null){
	flights = flitObj.SearchFlightFromTo(airportFrom, airportTo,sClass);
	Airports tempAirportsObj = new Airports();
	airportFromObj = tempAirportsObj.getAirport(airportFrom);
	airportToObj = tempAirportsObj.getAirport(airportTo);
}

%>

<%@ include file="header.jsp" %>
<form class="ticket_selecting_form" action="<%= Helper.baseUrl %>FindTicket.jsp">
	<h2 class="title">  <span>Flight Route Showing For ::</span> <%= airportFromObj.name %> to  <%= airportToObj.name %> <span>:: Journey Date -</span> <%= journey_date %> </h2>
	<table class="table rs_shadow">
		<tr>
			<th>Serial</th>
			<th>Flight No</th>
			<th>Flight Name</th>
			<th>Class</th>
			<th>Departure Time</th>
			<th>Unit Fare</th>
			<th>Number Of Seat</th>
			<th>Selection</th>
		</tr>
		<% for(int i =0; i<flights.size(); i++){ 
			HashMap<String,String> tempFlight= flights.get(i);
		
		%>
		<tr>
			<td><%= i+1 %></td>
			<td><%= tempFlight.get("code") %></td>
			<td><%= tempFlight.get("name") %></td>
			<td><%= tempFlight.get("class") %></td>
			<td><%= tempFlight.get("time") %></td>
			<td><%= tempFlight.get("fare")+" " +Helper.Currency %></td>
			<td>
				<select name="total_seat"  class="form-control total_seat_select">
					    <option value="1">01</option>
					    <option value="2">02</option>
					    <option value="3">03</option>
					    <option value="4">04</option>
				</select>
			</td>
			<td>
				<a href="javascript:;" class="btn btn-success rs_search_ticket" data-date="<%= journey_date %>" data-destination="<%= tempFlight.get("destination_id") %>">Search Ticket</a>
			</td>
		</tr>
		<% } %>
	</table>
</form>
<div id="rs_ticket_result">

</div>
<%@ include file='footer.jsp' %>