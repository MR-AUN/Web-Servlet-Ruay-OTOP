<%@page import="model.addressModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/include/css.jsp"%>
<title>Shop OTOP</title>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<%
	ArrayList<addressModel> addressList = null ;
	if (session.getAttribute("customer") != null) {
		 addressList = new AddressDAO().viewAddressByCustomer(customer.getCusId());
		
	}else {
	%>
	<% 
	addressList = new ArrayList<addressModel>();
	response.sendRedirect(request.getContextPath());
	} %>
	
	<!-- hero area -->
	<div class="hero-area hero-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="hero-text">
						<div class="hero-text-tablecell">
							<p class="subtitle"></p>
							<h3  style="color: white; margin-top: 6rem;">รายละเอียดที่อยู่จัดส่ง	ผู้ใช้</h3>
							<div class="hero-btns">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end hero area -->
	<div  style="display: inline-flex;">
	<%
	int count = 1 ;
	for(addressModel address: addressList) {
		%>
		<div class="single-product mt-150 mb-150">
			<div class="container">
				<div class="card  p-3" style="width: 20rem; height: 15rem;  ">
					<h4>#<%=count %></h4>
					<p>ที่อยู่: <%= address.getAddressDetail() %></p>
				</div>
			</div>
		</div>
		
	<% count++;
	}
	%>
		<div class="single-product mt-150 mb-150">
			<div class="container">
				<div class="card con " style="width: 20rem; height: 15rem;  ">
					 <a class="ho-card" href="#" data-bs-toggle="modal" data-bs-target="#exampleModal">
					 	<div style="width: 20rem; height: 15rem;  ">
						 	<div class="text-center" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">
							 	<p>เพิ่มที่อยู่</p>
							 	<i class="fs-1 fa-solid fa-plus"></i>
							 </div>
						 </div>
					 </a>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">เพิ่มที่อยู่</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
     <form action="Address" method="post">
     	 <div class="modal-body">
     	 	<div class="input-group">
			  <span class="input-group-text">กรอกข้อมูลที่อยู่</span>
			  <textarea class="form-control" name="address" aria-label="With textarea"></textarea>
			</div>
	      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">ยกเลิก</button>
        <button type="submit" class="btn btn-primary">บันทึก</button>
      </div>
     </form>
    </div>
  </div>
</div>
	
	<%@ include file="/include/footer.jsp"%>
	<%@ include file="/include/js.jsp"%>
</body>
</html>