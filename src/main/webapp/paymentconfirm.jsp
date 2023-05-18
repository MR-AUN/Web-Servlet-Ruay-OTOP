<%@page import="dao.OptionpayDAO"%>
<%@page import="model.OptionpayModel"%>
<%@page import="dao.TransportDAO"%>
<%@page import="model.TransportModel"%>
<%@page import="dao.AddressDAO"%>
<%@page import="model.addressModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop OTOP</title>
<!-- Mobile Specific Metas -->
<!-- datepicker -->
<link rel="stylesheet" type="text/css"
	href="contents/step/css/jquery-ui.min.css">
<!-- Main Style Css -->
<link rel="stylesheet" href="contents/step/css/style.css" />
<%@ include file="/include/css.jsp"%>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	
	<% Map<String, Object> goodcheck = (Map<String, Object>) session.getAttribute("goods"); 
	ArrayList<CombinGroupModel> combins = null ;
	if(goodcheck != null) {
		 combins =  (ArrayList<CombinGroupModel>)goodcheck.get("combingood"); ;
	}
	ArrayList<addressModel> addressList = null ;
	ArrayList<TransportModel> transportList = null ;
	ArrayList<OptionpayModel> optionpayList = null ;

	 if (customer == null) {
		System.out.print("customer = null");
		RequestDispatcher dd = request.getRequestDispatcher("login.jsp");
		dd.forward(request, response);
	}else if(combins.size() == 0 || combins == null) {
		System.out.print("not a product");
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}else {
		System.out.print("i have product");
		addressList = new AddressDAO().viewAddressByCustomer(customer.getCusId());
		transportList = new TransportDAO().viewTransport();
		optionpayList = new OptionpayDAO().viewOptionpay();
	}
	System.out.println("Run");%>
	<!-- hero area -->
	<div class="hero-area hero-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="hero-text">
						<div class="hero-text-tablecell">
							<p class="subtitle"></p>

							<div class="hero-btns">
								<h3 style="color: white; margin-top: 6rem;">ยืนยันการชำระ</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="page-content">
		<div class="wizard-v4-content">
			<div class="wizard-form">
				<div class="wizard-header">
					<h3 class="heading">กรอกข้อมูลการสั่งซื้อ</h3>
				</div>
				<form class="form-register" id="buy" action="SaveReceipt" method="POST">
					<div id="form-total">
						<!-- SECTION 1 -->	
						<h2>
							<span class="step-icon"><i
								class="fa-solid fa-truck-moving"></i></span> <span class="step-text">จัดส่ง</span>
						</h2>
						<section>
							<div class="inner">
								<h3>ข้อมูลการจัดส่งสินค้า:</h3>
								<div class="card mb-3 p-2">
									<h4>ชื่อ-นามสกุล: <%= customer.getCusName() + " " + customer.getCusLast()  %></h4>
								</div>
								<p class="fs-5">เลือกที่อยู่</p>
								<% if(addressList != null) { %>
								<div class="card mb-3 p-4 overflow-auto"
									style="display: -webkit-box;">
									<% int counts = 1 ; %>
									<% for(addressModel address: addressList) { %>
									<div class="single-product ">
										<div class="container">
										<input class="btn-check" type="radio" name="address" autocomplete="off" id="flex<%= counts %>" value="<%= address.getAddressId() %>">
												<label  class="btn btn-outline-secondary" for="flex<%= counts%>">
												<h4>#<%=counts %></h4>
												<label>ที่อยู่:</label>
												<label name="flex<%= counts %>"> <%= address.getAddressDetail() %></label>
												</label>
										</div>
									</div>
									<% counts++ ;} %>
								</div>
								<%} %>

								<p class="fs-5">เลือกวิธีจัดส่ง</p>
								<div class="card p-4 ">
								<% if (transportList != null ) {
									int counts = 1 ;%>
									<% for(TransportModel transport : transportList) { %>
									<div class="form-check">
										<input class="form-check-input" type="radio"
											name="transport" id="flexRadioDefault<%= counts %>" value="<%= transport.getTransportId() %>"> <label
											class="form-check-label" name="flexRadioDefault<%= counts %>" for="flexRadioDefault<%= counts %>">
											<%= transport.getTransportName() %> </label> ฿<span name="flexRadioDefault<%= counts %>" ><%= transport.getTransportPrice() %> </span>
									</div>
									<% counts++; } %>
								<%} %>
								</div>
							</div>
						</section>
						<!-- SECTION 2 -->
						<h2>
							<span class="step-icon"><i class="fa-solid fa-money-check"></i></span>
							<span class="step-text">การชำระ</span>
						</h2>
						<section>
							<div class="inner">
								<h3>คุณต้องการชำระเงินรูปแบบใด?</h3>
								<div class="card p-2 mt-3 mb-3 ">
									<% if (optionpayList != null) { 
										int counts = 1 ;%>
										<% for(OptionpayModel optionpay : optionpayList) { %>
										<div class="form-check">
										  <input class="form-check-input" type="radio" name="optionpay" value="<%= optionpay.getOptionpayId() %>" id="flexRadio<%= counts%>">
										  <label class="form-check-label" for="flexRadioDefault1" name="flexRadio<%= counts%>">
										   	<%= optionpay.getOptionpayName() %>
										  </label>
										</div>
										
										<%} %>
									<% counts++;} %>
								</div>
							</div>
						</section>

						<!-- SECTION 4 -->
						<h2>
							<span class="step-icon"><i class="fa-solid fa-receipt"></i></span>
							<span class="step-text">ตรวจสอบ</span>
						</h2>
						<section>
							<div class="inner">
								<h3>ตรวจสอบ & ยืนยันสลิปโอนเงิน / จ่ายเงิน</h3>
								<div class="card mb-3 p-2">
									<h4>ชื่อ-นามสกุล: <%= customer.getCusName() + " " + customer.getCusLast()  %></h4>
								</div>
								<div class="card mb-3 p-2">
									<h5>ที่อยู่: </h5> <p id="showaddress"></p>
								</div>
								<div class="row mb-3 p-2">
									<div class="card p-2 me-3 col"> วิธีการจัดส่ง: <span id="showtransport">กรุณาเลือกการจัดส่ง</span></div>
									<div class="card p-2 me-3 col"> รูปแบบการชำระ: <span id="showoptionpay">กรุณาเลือกการชำระเงิน</span></div>
								</div>
								<div class="card mb-3 p-2">
									<span class="text-center">ราคารวม: <span id="amountGoods" data="${productAmount} ">${productAmount} </span>฿</span> 
								</div>
							</div>
						</section>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/include/footer.jsp"%>
	<script src="contents/step/js/jquery-3.3.1.min.js"></script>
	<script src="contents/step/js/jquery.steps.js"></script>
	<script src="contents/step/js/jquery-ui.min.js"></script>
	<script src="contents/step/js/main.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("a[href='#finish']").click(function(){
				document.getElementById('buy').submit();
			});
		$("input[type=radio][name=address]").change(function(){
			if ($(this).is(':checked')) {
			    // Do stuff
			    var input = $(this).attr("id");
			    var data = $("label[name="+input+"]").text();
			    var show = $("p[id=showaddress]") ;
			    show.text(data);
			  }
		});
		
		$("input[type=radio][name=transport]").change(function(){
			if ($(this).is(':checked')) {
			    // Do stuff
			    var input = $(this).attr("id");
			    var data = $("label[name="+input+"]").text();
			    var price = $("span[name="+input+"]").text();
			    var show = $("span[id=showtransport]") ;
			    var amount = $("span[id=amountGoods]") ;
			    var total = amount.attr("data");
			    show.text(data);
			    amount.text(parseFloat(price) + parseFloat(total)  );
			  }
		});
		
		$("input[type=radio][name=optionpay]").change(function(){
			if ($(this).is(':checked')) {
			    // Do stuff
			    var input = $(this).attr("id");
			    var data = $("label[name="+input+"]").text();
			    var show = $("span[id=showoptionpay]") ;
			    show.text(data);
			  }
		});
		
		});
	
		const myTimeout = setTimeout(myGreeting, 2000);
	
		function myGreeting() {
		  document.getElementById("loader").innerHTML ="" ;
		  myStopFunction();
		}
	
		function myStopFunction() {
		  clearTimeout(myTimeout);
		}
		
	</script>
	
</body>
</html>