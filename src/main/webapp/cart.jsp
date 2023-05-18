<%@page import="model.CombinGroupModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
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
	<% Map<String, Object> goodList = (Map<String, Object>) session.getAttribute("goods"); %>
	<% System.out.println(goodList); %>

	<!-- hero area -->
	<div class="hero-area hero-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 offset-lg-2 text-center">
					<div class="hero-text">
						<div class="hero-text-tablecell">
							<p class="subtitle"></p>

							<div class="hero-btns">
								<h3 style="color: white; margin-top: 6rem;">ตะกร้าสินค้า</h3>
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
			<div id="basketBody" class="cart-table-wrap mb-5 shadow-lg p-3 mb-5 bg-body rounded">
				
			</div>

			<div class="total-section shadow p-3 mb-5 bg-body rounded">
				<table class="total-table">
					<thead class="total-table-head">
						<tr class="table-total-row">
							<th>รายละเอียด</th>
							<th>จำนวนเงิน</th>
						</tr>
					</thead>
					<tbody>
						<tr class="total-data">
							<td><strong>จำนวนเงินรวม: </strong></td>
							<td id="monoeyTotal"></td>
						</tr>
					</tbody>
				</table>
				<div class="cart-buttons text-end">
					
					<a  name="pay" class="btn btn-success fs-4">ชำระเงิน</a>
				</div>
			</div>
		</div>
	</div>
	<!-- end features list section -->







	<%@ include file="/include/footer.jsp"%>
	<%@ include file="/include/js.jsp"%>
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("a[name='pay']").click(function(){
			const data = new URLSearchParams();
			$("input[type='number'").each(function(){
			    data.append("number",$(this).val());
			});
			 fetch('${pageContext.request.contextPath}/examinecart', {
				  method: 'POST',
				  body: data.toString(),
			        headers: { "Content-Type": "application/x-www-form-urlencoded"}
				})
				.then(response => response.json())
				.then(result => {
					var Path = "${pageContext.request.contextPath}"
					if(result === "success") {
						location.replace(Path+"/paymentconfirm.jsp")
					}else if(result === "cart" || result === "login") {
						location.replace(Path+"/"+result+".jsp")
					}else {
						console.log(result);
						openBasket();
						alertText("สินค้าเกินจำนวน",result)
					}
				})
				.catch(error => {
				  
			}); 
		});
	});
	openBasket();
	function basketDelete(id) {
		
		const data = new URLSearchParams();
		
		 data.append("id",id);
		fetch('${pageContext.request.contextPath}/deleteBasket', {
		  method: 'POST',
		  body: data.toString(),
	        headers: { "Content-Type": "application/x-www-form-urlencoded"}
		})
		.then(response => response.json())
		.then(result => {
			if(result === "success") {
				openBasket();
				alertSwal("success","ลบรายการสินค้าในตะกร้าเรียบร้อย")
				alertBasket("delete",1);
			}else {
				alertSwal("warning",result)
			}
		})
		.catch(error => {
		  
		});
	}
	
	function openBasket() {
		const body = document.querySelector("#basketBody");
		fetch('${pageContext.request.contextPath}/AddBasket')
		  .then(response => response.json())
		  .then(data => {
			  if (data != null) {
				  let bodyText = `<table class="cart-table">
					<thead class="cart-table-head">
					<tr class="table-head-row">
						<th class="product-remove"></th>
						<th class="product-image">รูปสินค้า</th>
						<th class="product-name">ชื่อสินค้า</th>
						<th class="product-price">ราคา</th>
						<th class="product-quantity">จำนวน</th>
						<th class="product-total">รวม</th>
					</tr>
				</thead>
				<tbody>` ;
				  let count = 0 ;
				  data.combingood.forEach(ele => {
					  
					   bodyText += `
						   <tr class="table-body-row">
							<td class="product-remove"><a href="#" onclick="basketDelete(\${ele.combinId})"><i
									class="far fa-window-close"></i></a></td>
							<td class="product-image"><img
								src="getImage.jsp?id=\${ele.good.goodId}" alt=""></td>
							<td class="product-name">\${ele.combinName != null ? ele.combinName:ele.good.goodName}</td>
							<td class="product-price">\${ele.combinPrice} ฿</td>
							<td class="product-quantity"><input type="number" name="inputGood\${ele.good.goodId}" id="inputGood\${ele.good.goodId}" onchange="myCal('inputGood\${ele.good.goodId}','input\${ele.good.goodId}',\${ele.combinPrice})" placeholder="0" value="\${data.goodNumber[count]}"></td>
							<td class="product-total" name="total" id="input\${ele.good.goodId}">\${data.goodNumber[count] * ele.combinPrice}</td>
						</tr>
					  `; 
					  count++;
				  })
				  bodyText += `</tbody>
						</table> ` ;
				  body.innerHTML = bodyText;
				  groupAmount() 
			  }else{
				  let bodyText = "" ;
				  body.innerHTML = bodyText;
			  }
		  })
	}
	function myCal(id,div,price) {
		  var x = document.getElementById(id);
		  var t = document.getElementById(div);
		  console.log(x.value)
		  var number = parseInt(x.value) * price  ;
		  t.innerHTML = number;
		  groupAmount() 
		}
	function groupAmount() {
		const body = document.querySelector("#monoeyTotal");
		let amount = 0 ;
		$("td[name='total'").each(function(){
			amount += parseFloat($(this).text());
		});
		body.innerHTML = amount+" ฿";
	}
	</script>
</body>
</html>