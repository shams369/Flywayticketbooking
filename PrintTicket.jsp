<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.digitalbd.*,AllLayout.*" %>
<div class="ticket_print_section">
	<div class="rs_shadow single_ticket" style="background-image: url('images/ticket_bg.jpg');">
		<div class="ticket_header">
			<h2>Purchase Ticket</h2>
		</div>
		<div class="ticket_inner">
			<div class="customer_part">
				<h4>
					<strong>Name of passenger</strong>
					Md Raj <%= request.getAttribute("ticket_id") %>
				</h4>

				<div class="ticket_col_1">
					<table>
						<tr>
							<td>
								<strong>Flight Name</strong>
								<span>Emirates</span>
								<strong>From</strong>
								<span>Dubai</span>
								<strong>To</strong>
								<span>Bangalore</span>
							</td>
							<td class="wd_100px text_center">
								<strong>Flight No</strong>
								E134552
							</td>
							<td class="wd_100px text_center">
								<strong>Journey Date</strong>
								10/20/205
							</td>
							<td class="wd_100px text_center">
								<strong>Time</strong>
								20AM
							</td>
						</tr>
					</table>
					<table>
						<tr>
							<td>
								<strong>Class</strong>
								<span>Business</span>
							</td>
							<td  class="wd_100px text_center">
								<strong>Seat</strong>
								60
							</td>
							<td  class="text_center">
								<strong>Issue Date & Time</strong>
								10/20/205
							</td>
							<td  class="wd_100px text_center">
								<strong>Fare</strong>
								350 $
							</td>
							<td width="90"  class="text_center">
								<img class="qr_code" src="images/qr.png" alt="">
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="company_part">
				<h4>
					<strong>Name of passenger</strong>
					Md Rajesh
				</h4>
				<strong>Flight Name</strong>
				<span>Emiratees</span>
				<strong>Journey</strong>
				<span>Dubai To Bnagalore</span>
				<table>
					<tr>
						<td>
							<strong>Seat</strong>
							5
						</td>
						<td>
							<strong>Date</strong>
							1/25/25
						</td>
						<td>
							<strong>Time</strong>
							70:30AM
						</td>
					</tr>
					<tr>
						<td>
							<strong>Fare</strong>
							350$
						</td>
						<td>
							<strong>Issue Date</strong>
							1/25/25
						</td>
						
						<td>
						</td>
					</tr>
				</table>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="ticet_footer">
			<span>Have a nice journey.</span>
		</div>
	</div>
</div>