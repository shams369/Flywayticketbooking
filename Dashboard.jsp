<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.digitalbd.Helper,com.digitalbd.*,java.sql.ResultSet,AllLayout.*" %>
<%@ page import="com.digitalbd.Destination"%>
<%@ include file="header.jsp" %>
<%
String userId = null;
if(session.getAttribute("user_id") != null){
	userId = (String) session.getAttribute("user_id");
}
User user = new User(userId);
%>
<div class="dashboard">
	<div class="box personal_info">
		<h2 class="box_title">Personal Information</h2>
		<table class="table table-bordered">
			<tr>
				<td><strong>Full Name</strong></td>
				<td><%= user.name %></td>
			</tr>
			<tr>
				<td><strong>Email Address</strong></td>
				<td><%= user.email %></td>
			</tr>
			<tr>
				<td><strong>Cell Phone Number</strong></td>
				<td><%= user.phone %></td>
			</tr>
			<tr>
				<td><strong>Address</strong></td>
				<td><%= user.address %></td>
			</tr>
		</table>
	</div>
	<div class="box successfully_purschase_ticket">
		<h2 class="box_title">Successful Purchase Information</h2>
		<table class="table table-bordered">
			<tr>
				<td>Flight Name</td>
				<td>Class</td>
				<td>Purchase Date</td>
				<td>Journey Date</td>
				<td>Airport From</td>
				<td>Airport To</td>
				<td>Total Seat</td>
				<td>Option</td>
			</tr>
			<%
			Booking booking = new Booking();
			ResultSet bookedTicket = booking.FindByUser(user.id);
			while(bookedTicket.next()){
				Destination tempDestination = new Destination(bookedTicket.getString("destination_id"));
				flights trnTemp = new flights(tempDestination.flight_id);
				Airport stationFromTemp = new Airports().getAirport(tempDestination.airport_from);
				Airport stationToTemp = new Airports().getAirport(tempDestination.airport_to);
				%>
				<tr>
					<td><%= trnTemp.name %></td>
					<td><%= trnTemp.type %></td>
					<td><%= bookedTicket.getString("booking_date") %></td>
					<td><%= bookedTicket.getString("journey_date") %></td>
					<td><%= stationFromTemp.name %></td>
					<td><%= stationToTemp.name %></td>
					<td><%= bookedTicket.getString("number_of_seat") %></td>
					<td><a class="btn btn-success btn-sm">Print</a></td>
					
				</tr>
				<%
			}
			%>
			
		</table>
	</div>
</div>
<%@ include file="footer.jsp" %>