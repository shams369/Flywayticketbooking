<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.digitalbd.Helper,com.digitalbd.flights,java.util.ArrayList,AllLayout.Flight,java.util.Iterator" %>   
<%@ include file="header.jsp" %>
<%

	flights trn = new flights();

	if(request.getParameter("delete") != null){
		String trnId = (String) request.getParameter("delete");
		trn.Delete(trnId);
	}

	ArrayList<Flight> flightlist = new ArrayList<Flight>();
	flightlist = trn.getAll();
	Iterator trnIt = flightlist.iterator();
%>
<div class="text-right">
	<a class="btn btn-success" href="Add.jsp">Create Flight</a>
</div>
<br>
<div class="box successfully_purschase_ticket">
	<h2 class="box_title">All Flight List</h2>
	<table class="table table-bordered">
		<tr>
			<td wide="50">Flight Code</td>
			<td>Type</td>
			<td>Flight Name</td>
			<td>Total Seat</td>
			<td>Actions</td>
		</tr>
		<%
		while(trnIt.hasNext()){
			Flight flit = (Flight) trnIt.next();
			
			%>
			<tr>
				<td><%= flit.code %></td>
				<td><%= flit.type %></td>
				<td><%= flit.name %></td>
				<td><%= flit.totalSeat %></td>
				<td><a href="?delete=<%= flit.id %>" class="btn btn-sm btn-danger">Delete</a></td>
			</tr>
			<%
		}
		%>
		
	</table>
</div>
<%@ include file="footer.jsp" %>