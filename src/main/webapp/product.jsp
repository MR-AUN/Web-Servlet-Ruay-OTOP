<%@page import="dao.SupCategorieDAO"%>
<%@page import="model.SupCategorieModel"%>
<%@page import="dao.CategoriesDAO"%>
<%@page import="model.CategoriesModel"%>
<%@page import="com.mysql.cj.x.protobuf.MysqlxDatatypes.Array"%>
<%@page import="dao.ProvinceDAO"%>
<%@page import="model.ProvinceModel"%>
<%@page import="dao.GoodsListDAO"%>
<%@page import="model.AdminGoodsModel"%>
<%@page import="java.util.ArrayList"%>
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
	<!--PreLoader-->
	<!-- <div class="loader">
        <div class="loader-inner">
            <div class="circle"></div>
        </div>
    </div> -->
	<!--PreLoader Ends-->

	<%@ include file="/include/header.jsp"%>

	<%
	String search = request.getParameter("search");
	%>
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
							<!-- <div class="hero-btns">

								<a href="product.jsp?search=อาหาร" class="bordered-btn"> <i
									class="fa-solid fa-utensils"></i> <br> <span
									class="text-center">อาหาร</span>
								</a> <a class="bordered-btn" href="product.jsp?search=เครื่องดื่ม">
									<i class="fa-solid fa-mug-saucer"></i> <br> <span
									class="text-center">เครื่องดื่ม</span>
								</a> <a class="bordered-btn"
									href="product.jsp?search=เครื่องแต่งกาย"> <i
									class="fa-solid fa-shirt"></i> <br> <span
									class="text-center">เครื่องแต่งกาย</span>
								</a> <a class="bordered-btn" href="product.jsp?search=ของใช้"> <i
									class="fa-solid fa-basket-shopping"></i> <br> <span
									class="text-center">ของใช้</span>
								</a> <a class="bordered-btn" href="product.jsp?search=สมุนไพร">
									<i class="fa-solid fa-seedling"></i> <br> <span
									class="text-center">สมุนไพร</span>
								</a>
							</div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end hero area -->
	<div class="container">
		<div class="m-4">
			<%
			ArrayList<AdminGoodsModel> goodList = null;
			ArrayList<ProvinceModel> province = new ProvinceDAO().viewProvince();
			if (search != null) {
				search = search.trim();
				goodList = new GoodsListDAO().viewGoodsSearch(search);
			%>
			<h3>
				ค้นหา:
				<button id="searchBtn" type="button" class="btn btn-lg btn-primary" disabled><%=search.equals("") ? "ทั้งหมด" : search%></button>
			</h3>
			<%
			} else {
			goodList = new ArrayList<AdminGoodsModel>();
			}
			%>
		</div>
	</div>

	<!-- features list section -->
	<div class="list-section p-4">
		<div class=" row">
			<div class="card col-2 me-3">
				<div class="p-3 text-center">
					<label class="me-2"><i class="fa-solid fa-list-ul"></i></label><label><h6>หมวดหมู่ทั้งหมด</h6></label>
				</div>
				<hr>
				<div class="card">
					<% ArrayList<CategoriesModel> cateList = new CategoriesDAO().viewCategories() ;
					   ArrayList<SupCategorieModel> supcateList = new SupCategorieDAO().ViewSupCategorie();
					%>
					<ul class="list-group">
						<% for(CategoriesModel cate : cateList) { %>
							<li class="list-group-item "><a name="categorie" data="<%= cate.getCateId() %>"><%= cate.getCateName() %></a></li>
						<%} %>
						<% for (SupCategorieModel sup : supcateList) {%>
							<li class="list-group-item "><a name="supcategorie" data="<%= sup.getSupCateId() %>"><%= sup.getCategorie().getCateName()+" "+sup.getSupCateName()	   %></a></li>
						<%} %>
					</ul>
				</div>
			</div>
			<div class="card col">
				<div class="list-section p-3 m-4" style="display: flex;">
					<span class="me-3">ตัวกรอง: </span>
					<!-- <button type="button" class="btn btn-warning me-3">ยอดนิยม</button>
					<button type="button" class="btn btn-warning me-3">ล่าสุด</button> -->
					<div class="text-end">
						<select class="form-select" id="province"	 aria-label="Default select example"  onchange="myFunction()">
							<option selected>จังหวัด</option>
							<%
							for (ProvinceModel pro : province) {
							%>
							<option value="<%=pro.getProviceId()%>">
								<%=pro.getProviceName()%></option>
							<%
							}
							%>
						</select>
					</div>
				</div>
				<div class=" m-4">
					<div class="row" id="showProduct">
						<%
						if (search == null) {
							ArrayList<AdminGoodsModel> goodAll = new GoodsListDAO().viewGoods();
						%>
						<%
						for (AdminGoodsModel good : goodAll) {
						%>
						<div class="col-lg-4 col-md-6 text-center">
							<div class="single-product-item">
								<div class="product-image">
									<a href="productDetail.jsp?puk=<%=good.getGoodId()%>">
										<div class="con">
											<img src="getImage.jsp?id=<%=good.getGoodId()%>" alt="">
											<div class="centered">
												<h5>รายละเอียดเพิ่มเติม</h5>
											</div>
										</div>


									</a>
									<div id="box-img-product"></div>
								</div>
								<h3><%=good.getGoodName()%></h3>
								<p class="product-price">
									<span>ราคา</span>
									<%=good.getGoodPrice()%>
									฿
								</p>
							</div>
						</div>
						<%
						}
						%>
						<%
						} else if (goodList != null && !goodList.isEmpty()) {
						%>
						<%
						System.out.println(goodList);
						for (AdminGoodsModel good : goodList) {
						%>
						<div class="col-lg-4 col-md-6 text-center">
							<div class="single-product-item">
								<div class="product-image">
									<a href="productDetail.jsp?puk=<%=good.getGoodId()%>">
										<div class="con">
											<img src="getImage.jsp?id=<%=good.getGoodId()%>" alt="">
											<div class="centered">
												<h5>รายละเอียดเพิ่มเติม</h5>
											</div>
										</div>


									</a>
									<div id="box-img-product"></div>
								</div>
								<h3><%=good.getGoodName()%></h3>
								<p class="product-price">
									<span>ราคา</span>
									<%=good.getGoodPrice()%>
									฿
								</p>
							</div>
						</div>
						<%
						}
						%>
						<%
						} else {
						%>
						<div class="text-center">
							<h3>ไม่พบสินค้าที่ค้นหา</h3>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end features list section -->


	<%@ include file="/include/footer.jsp"%>
	<%@ include file="/include/js.jsp"%>
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("a[name=categorie]").click(function(){
			var text = $(this).attr('data');
			const body = document.querySelector("#searchBtn");
			  body.innerHTML = $(this).text();
			const data = new URLSearchParams();
			 data.append("categorie",text);
			 fetch('${pageContext.request.contextPath}/searchproduct', {
				  method: 'POST',
				  body: data.toString(),
			        headers: { "Content-Type": "application/x-www-form-urlencoded"}
				})
				.then(response => response.json())
				.then(result => {
					if(result.length != 0) {
						reProduct(result);
					}else {
						const body = document.querySelector("#showProduct");
						body.innerHTML = `<div class="text-center">
							<h3>ไม่พบสินค้าที่ค้นหา</h3>
							</div>`;
					}
					
				})
				.catch(error => {
				  
				}); 
		});
		$("a[name=supcategorie]").click(function(){
			var text = $(this).attr('data');
			const body = document.querySelector("#searchBtn");
			  body.innerHTML = $(this).text();
			const data = new URLSearchParams();
			 data.append("supcategorie",text);
			 fetch('${pageContext.request.contextPath}/searchproduct', {
				  method: 'POST',
				  body: data.toString(),
			        headers: { "Content-Type": "application/x-www-form-urlencoded"}
				})
				.then(response => response.json())
				.then(result => {
					if(result.length != 0) {
						reProduct(result);
					}else {
						const body = document.querySelector("#showProduct");
						body.innerHTML = `<div class="text-center">
							<h3>ไม่พบสินค้าที่ค้นหา</h3>
							</div>`;
					}
				})
				.catch(error => {
				  
				}); 
		});
		
		
	});
	function myFunction() {
		  var x = document.getElementById("province").value;
		  const body = document.querySelector("#searchBtn");
		  var select = document.getElementById('province');
		  var text = select.options[select.selectedIndex].text;
		  body.innerHTML = text;
		  const data = new URLSearchParams();
		  data.append("province",x);
		  fetch('${pageContext.request.contextPath}/searchproduct', {
			  method: 'POST',
			  body: data.toString(),
		        headers: { "Content-Type": "application/x-www-form-urlencoded"}
			})
			.then(response => response.json())
			.then(result => {
				if(result.length != 0) {
					reProduct(result);
				}else {
					const body = document.querySelector("#showProduct");
					body.innerHTML = `<div class="text-center">
						<h3>ไม่พบสินค้าที่ค้นหา</h3>
						</div>`;
				}
			})
			.catch(error => {
			  
			}); 
	}
	function reProduct(data) {
		const body = document.querySelector("#showProduct");
		let bodyText ="" ;
		 data.forEach(ele => {
			  
			   bodyText += `
				   <div class="col-lg-4 col-md-6 text-center">
					<div class="single-product-item">
						<div class="product-image">
							<a href="productDetail.jsp?puk=\${ele.goodId}">
								<div class="con">
									<img src="getImage.jsp?id=\${ele.goodId}" alt="">
									<div class="centered">
										<h5>รายละเอียดเพิ่มเติม</h5>
									</div>
								</div>


							</a>
							<div id="box-img-product"></div>
						</div>
						<h3>\${ele.goodName}</h3>
						<p class="product-price">
							<span>ราคา</span>
							\${ele.goodPrice}
							฿
						</p>
					</div>
				</div>
			  `; 
		  }) 
		  body.innerHTML = bodyText;
	}
	</script>
</body>
</html>