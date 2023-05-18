<%@page import="model.CombinGroupModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="model.CustomerModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% CustomerModel customer = (CustomerModel) session.getAttribute("customer") ; %>
<!-- header -->
	<div id="loader">
		<div class="loader" >
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div> 
	</div>
	
	<div class="top-header-area" id="sticker">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-sm-12 text-center">
					<div class="main-menu-wrap">
						<!-- logo -->
						<div class="site-logo">
							<a href="${pageContext.request.contextPath}"> <img
								src="contents/assets/image/logo.png" alt="">
							</a>
						</div>
						<!-- logo -->

						<!-- menu start -->
						<nav class="main-menu">
							<ul class="">
								<!-- menu -->
								<!-- <li class="current-list-item item-menu"><a href="#">Home</a>
									<ul class="sub-menu">
										<li><a href="index.html">Static Home</a></li>
										<li><a href="index_2.html">Slider Home</a></li>
									</ul></li>
								<li class="item-menu"><a href="about.html">About</a></li>
								<li class="item-menu"><a href="#">Pages</a>
									<ul class="sub-menu">
										<li><a href="404.html">404 page</a></li>
										<li><a href="about.html">About</a></li>
										<li><a href="cart.html">Cart</a></li>
										<li><a href="checkout.html">Check Out</a></li>
										<li><a href="contact.html">Contact</a></li>
										<li><a href="news.html">News</a></li>
										<li><a href="shop.html">Shop</a></li>
									</ul></li>
								<li class="item-menu"><a href="news.html">News</a>
									<ul class="sub-menu">
										<li><a href="news.html">News</a></li>
										<li><a href="single-news.html">Single News</a></li>
									</ul></li>
								<li class="item-menu"><a href="contact.html">Contact</a></li>
								<li class="item-menu"><a href="shop.html">Shop</a>
									<ul class="sub-menu">
										<li><a href="shop.html">Shop</a></li>
										<li><a href="checkout.html">Check Out</a></li>
										<li><a href="single-product.html">Single Product</a></li>
										<li><a href="cart.html">Cart</a></li>
									</ul></li>  -->
								<li>
								<div class="header-icons">
										<a class="shopping-cart position-relative" href="cart.jsp">
										<i class="fas fa-shopping-cart "></i>
											<% Map<String, Object> goodcount = (Map<String, Object>) session.getAttribute("goods"); 
											ArrayList<CombinGroupModel> combinCount = null ;
											%>
											<% if(goodcount != null) 
											{
												combinCount = (ArrayList<CombinGroupModel>)goodcount.get("combingood");
												}%>
											
											<span id="alertBasket" class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger" style="margin-top: 15px;  margin-left: -9px;"><%= combinCount != null? combinCount.size():0 %> </span>
											</a> 
											<a class="mobile-hide search-bar-icon" href="#">
											<i class="fas fa-search"></i></a> <label><div class="topbar-divider  d-sm-block"></div></label>
										<div style="display: inline; position: relative;"
											class="box-profile">
								<% if(customer == null) { System.out.println("customer != null > login");%>
									<a href="login.jsp">เข้าสู่ระบบ / สมัครสมาชิก</a>
									<%} else { System.out.println("customer != null");%>
											
											<a> <span class="text-white"><%= customer.getCusName() + " " + customer.getCusLast() %></span> <img
												class="img-profile rounded-circle"
												src="contents/assets/image/profile.png">
											</a>
											<ul class="sub-menu">
												<li><a href="address.jsp">ที่อยู่</a></li>
												<li><div class="topbar-divider-l  d-sm-block"></div></li>
												<li><a href="logoutCustomer">ออกจากระบบ</a></li>
											</ul>
										
									<%} %>
									</div>

									</div>
								</li>


							</ul>
						</nav>
						<a class="mobile-show search-bar-icon" href="#"><i
							class="fas fa-search"></i></a>
						<div class="mobile-menu"></div>
						<!-- menu end -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end header -->

	<!-- search area -->
	<div class="search-area">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<span class="close-btn fs-1"><i class="fas fa-window-close"></i></span>
					<div class="search-bar">
						<div class="search-bar-tablecell">
							<form action="product.jsp?" method="get">
								<h3>ค้นหา ผลิตภัณฑ์:</h3>
								<input type="text" name="search" placeholder="คีย์เวิร์ด">
								<button type="submit">
									ค้นหา <i class="fas fa-search"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end search area -->
	
