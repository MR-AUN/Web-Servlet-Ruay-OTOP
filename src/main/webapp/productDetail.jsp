<%@page import="dao.GoodOptionDAO"%>
<%@page import="model.GoodOptionModel"%>
<%@page import="dao.GoodGroupDAO"%>
<%@page import="model.GoodGroupModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GoodsListDAO"%>
<%@page import="model.AdminGoodsModel"%>
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
	<%@ include file="/include/header.jsp"%>
	<% String idGoodStr  =  request.getParameter("puk"); 
	   Integer idGood  = Integer.parseInt(idGoodStr);
		AdminGoodsModel good = new GoodsListDAO().searchGoodById(idGood);
	%>
	<!-- hero area -->
	<div class="hero-area hero-bg-de" style="background-image: url(getImage.jsp?id=<%=good.getGoodId()%>);">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="hero-text">
						<div class="hero-text-tablecell">
							<p class="subtitle"></p>
							<h3  style="color: white; margin-top: 6rem;">รายละเอียดผลิตภัณฑ์</h3>
							<div class="hero-btns">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end hero area -->
	<div class="container mt-5 fs-5	">
		<nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">OTOP</a></li>
		    <li class="breadcrumb-item " aria-current="page"><%= good.getCategorie().getCateName() %></li>
		    <%if(good.getSubCategorie() != null) { %>
		    	   <li class="breadcrumb-item " aria-current="page"><%= good.getSubCategorie().getSupCateName() %></li>
			<% } %>
		    <li class="breadcrumb-item active" aria-current="page"><%= good.getGoodName() %></li>
		  </ol>
		</nav>
	</div>
	
	<div class="single-product mt-5 mb-150">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="single-product-img">
						<img src="getImage.jsp?id=<%=good.getGoodId()%>" alt="">
					</div>
				</div>
				<div class="col-md-7">
					<div class="single-product-content">
						<h3><%= good.getGoodName() %></h3>
						<h4>ราคา ฿<%= good.getGoodPrice() %> </h4>
						<p><%= good.getGoodDescriptio() %></p>
						<p><strong>จังหวัด: </strong><%= good.getProvince().getProviceName() %></p>
						<p><strong>หมวดหมู่: </strong><%= good.getCategorie().getCateName() %></p>
						<input type="hidden" name="goodId" value="<%= good.getGoodId()%>">	
						<%if(good.getSubCategorie() != null) { %>
							<p><strong>หมวดหมู่ย่อย: </strong><%= good.getSubCategorie().getSupCateName()%></p>
						<% } %>
						<% 
							ArrayList<GoodGroupModel> goodGroup = new GoodGroupDAO().searchGroupByIdGoodnotGood(good.getGoodId());
							
						%>
						
						<div class="single-product-form">
							
								<% for(GoodGroupModel group : goodGroup) { %>
								 <div class="mb-4">
								 <% ArrayList<GoodOptionModel> goodOption = new GoodOptionDAO().searchOptionByIdNotGoodList(group.getGroupId()); 
									%>
									<p><%= goodOption != null ? group.getGroupName():"" %></p>
									<input type="hidden" name="groupId" value="<%= group.getGroupId()%>">
									
									<% for(GoodOptionModel option:goodOption){ %>
									<input type="radio" class="btn-check" name="options<%= group.getGroupId()%>" id="option<%=option.getOptionId() %>"  value="<%= option.getOptionId()%>"  autocomplete="off">
									<label class="btn btn-outline-primary" for="option<%= option.getOptionId()%>"><%= option.getOptionName() %></label>
									
									<%} %>
								</div> 
								<%} %>
								<input type="number" name="number" placeholder="0" min="0">
								<br>
								<a href="#" onclick="basketAdd()" class="cart-btn"><i class="fas fa-shopping-cart"></i> เพิ่มเข้าตะกร้า</a>
							
						</div>
						<!-- <h4>Share:</h4>
						<ul class="product-share">
							<li><a href=""><i class="fab fa-facebook-f"></i></a></li>
							<li><a href=""><i class="fab fa-twitter"></i></a></li>
							<li><a href=""><i class="fab fa-google-plus-g"></i></a></li>
							<li><a href=""><i class="fab fa-linkedin"></i></a></li>
						</ul> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="/include/footer.jsp"%>
	<%@ include file="/include/js.jsp"%>
	<script type="text/javascript">
	function basketAdd() {
		
		const data = new URLSearchParams();
		var group = [] ;
		$("input:hidden[name=groupId]").each(function(){
			group.push($(this).val());
		    data.append("groupId",$(this).val());
		});
		
		$("input:hidden[name=goodId]").each(function(){
		    data.append("goodId",$(this).val());
		});
		group.forEach(function(value) {
			   $("input:radio[name='options"+value+"']:checked").each(function(){
				    data.append("option",$(this).val());
				}); 
		});
		$("input[name='number'").each(function(){
		    data.append("number",$(this).val());
		});
		
		
		//console.log(data.getAll	("number"));
		fetch('${pageContext.request.contextPath}/AddBasket', {
		  method: 'POST',
		  body: data.toString(),
	        headers: { "Content-Type": "application/x-www-form-urlencoded"}
		})
		.then(response => response.json())
		.then(result => {
			console.log(result);
			if(result === "success") {
				alertSwal("success","เพิ่มเข้าตะกร้าสินค้าเรียบร้อย")
				alertBasket("add",1);
			}else {
				alertSwal("warning",result)
			}
		})
		.catch(error => {
		  
		}); 
	}
	</script>
</body>
</html>