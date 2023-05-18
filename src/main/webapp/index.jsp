<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="model.AdminGoodsModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GoodsListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/include/css.jsp"%>
</style>
<title>Shop OTOP</title>
</head>
<body>

	<% ArrayList<AdminGoodsModel> goodList = new GoodsListDAO().viewGoodsLimit(); %>
	<!--PreLoader-->
	<!-- <div class="loader">
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div> -->
	<!--PreLoader Ends-->

	<%@ include file="/include/header.jsp"%>

	<!-- hero area -->
	<div class="hero-area hero-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="hero-text">
						<div class="hero-text-tablecell">
							<p class="subtitle"></p>
							<h3 style="color: white; margin-top: 6rem;">ผลิตภัณฑ์ OTOP
								ทั่วไทย</h3>
							<div class="hero-btns">

								<a href="product.jsp?search=อาหาร" class="bordered-btn"> <i class="fa-solid fa-utensils"></i>
									<br> <span class="text-center">อาหาร</span>
								</a> <a class="bordered-btn" href="product.jsp?search=เครื่องดื่ม"> <i class="fa-solid fa-mug-saucer"></i>
									<br> <span class="text-center">เครื่องดื่ม</span>
								</a> <a class="bordered-btn" href="product.jsp?search=เครื่องแต่งกาย"> <i class="fa-solid fa-shirt"></i>
									<br> <span class="text-center">เครื่องแต่งกาย</span>
								</a> <a class="bordered-btn" href="product.jsp?search=ของใช้"> <i
									class="fa-solid fa-basket-shopping"></i> <br> <span
									class="text-center">ของใช้</span>
								</a> <a class="bordered-btn" href="product.jsp?search=สมุนไพร"> <i class="fa-solid fa-seedling"></i>
									<br> <span class="text-center">สมุนไพร</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end hero area -->

	<!-- features list section -->
	<div class="list-section p-4">
		<div class="container">
			<div class="row">
				<div class="col-8 "
					style="display: flex; flex-wrap: wrap; align-content: center;">
					<div class="carousel slide" data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="contents/assets/image/a1.png" class="d-block w-advert"
									alt="...">
							</div>
							<div class="carousel-item">
								<img src="contents/assets/image/a2.jpg" class="d-block w-advert"
									alt="...">
							</div>
							<div class="carousel-item">
								<img src="contents/assets/image/c2.jpg" class="d-block w-advert"
									alt="...">
							</div>
						</div>
					</div>
				</div>
				<div class="col-4 row">
					<div class="col-12">
						<div class="carousel slide" data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="contents/assets/image/b1.png" class="d-block w-100"
										alt="...">
								</div>

							</div>
						</div>
					</div>
					<div class="col-12 mt-3">
						<div class="carousel slide" data-bs-ride="carousel">
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img src="contents/assets/image/c1.jpg" class="d-block w-100"
										alt="...">
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end features list section -->

	<!-- product section -->
	<div class="product-section mt-5 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="section-title">
						<h3>
							ผลิตภัณฑ์ <span class="orange-text">ยอดนิยม</span>
						</h3>
					</div>
				</div>
			</div>

			<div class="row">
				<% for(AdminGoodsModel good : goodList) { 
					
				%>
					<div class="col-lg-4 col-md-6 text-center">
						<div class="single-product-item">
							<div class="product-image">
								<a href="productDetail.jsp?puk=<%=good.getGoodId()%>"> 
								<div class="con">
									<img src="getImage.jsp?id=<%=good.getGoodId()%>"alt="">
									<div class="centered"><h5>รายละเอียดเพิ่มเติม</h5></div>
								</div>
								
									
								</a>
								<div id="box-img-product"></div>
							</div>
							<h3><%= good.getGoodName() %></h3>
							<p class="product-price">
								<span>ราคา</span> <%= good.getGoodPrice() %> ฿
							</p>
						</div>
					</div>
				<% } %>
			</div>
		</div>
	</div>
	<!-- end product section -->

	

	
	<%@ include file="/include/footer.jsp"%>
	
	<%@ include file="/include/js.jsp"%>
</body>
</html>