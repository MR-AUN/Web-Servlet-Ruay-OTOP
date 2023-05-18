	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/include/css.jsp"%>
<title>Login Shop OTOP</title>
</head>
<body>

<%
	if (session.getAttribute("customer") != null) {
		response.sendRedirect(request.getContextPath());
	}
	%>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section"></h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-5">
					<div class="login-wrap p-4 p-md-5">
						
						<div class="row mt-3 mb-3">
							<div class="col-12 mb-3 icon d-flex align-items-center justify-content-center">
								<div class="site-logo">
								<a href=""> <img
									src="contents/assets/image/logo.png" alt="">
								</a>
							</div>
							</div>
							<div class="col-6 text-center">
								<a class="boxed-btn btn-login"> <span class="text-center text-black">เข้าระบบ</span></a>
							</div>
							<div class="col-6 text-center">
								<a class="bordered-btn btn-re"> <span class="text-center text-black">สมัครสมาชิก</span> </a>
							</div>
						</div>
						<div class="login-form"  >
							<form action="loginCustomer" method="POST">
								<p>
									<input type="text" placeholder="ผู้ใช้" name="name" id="name" style="width: 100%; text-align: center;">
								</p>
								<p>
									<input type="password" placeholder="รหัสผ่าน" name="pass" id="pass" style="width: 100%; text-align: center;">
								</p>
								
								<div class="form-group text-center">
									<button type="submit"
										class="btn btn-primary rounded submit p-3 px-5">เข้าสู่ระบบ</button>
								</div>
							</form>
						</div>
						<div class="re-form" style="display: none;">
							<form action="AddCustomer" class="login-form" method="POST">
								<p>
									<input type="text" placeholder="ชื่อต้น" name="name" id="name" class="me-2">
									<input type="text" placeholder="นามสกุล" name="lastname" id="lastname" class="me-2">
								</p>
								<p>
									<input type="text" placeholder="ชื่อผู้ใช้" name="username" id="nickname" class="me-2">
									<input type="password" placeholder="รหัสผ่าน" name="pass" id="pass" class="me-2">
								</p>
								<p>
									<input type="tel" placeholder="เบอร์โทร" name="phone" id="phone"  style="width: 95%">
								</p>
								<p>
									<input type="email" placeholder="อีเมล์" name="email" id="email" style="width: 95%">
								</p>
								<textarea name="message" id="message" cols="45" rows="3" placeholder="ที่อยู่"></textarea>
								
								<div class="form-group text-center">
									<button type="submit"
										class="btn btn-success rounded submit p-3 px-5">สมัครสมาชิก</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/include/js.jsp"%>
	
	<script >
		var btnLogin = document.getElementsByClassName('btn-login');
		var btnRe = document.getElementsByClassName('btn-re');
		var Login = document.getElementsByClassName('login-form')[0];
		var Re = document.getElementsByClassName('re-form')[0];
		
		btnLogin[0].addEventListener("click", function() {
			  Login.style.display = "block" ;
			  Re.style.display = "none" ;
			  btnRe[0].classList.remove('boxed-btn');
			  btnLogin[0].classList.remove('bordered-btn');
			  btnRe[0].classList.add('bordered-btn');
			  btnLogin[0].classList.add('boxed-btn');
		});
		
		btnRe[0].addEventListener("click", function()  {
			  Re.style.display = "block" ;
			  Login.style.display = "none" ;
			  btnLogin[0].classList.remove('boxed-btn');
			  btnRe[0].classList.remove('bordered-btn');
			  btnLogin[0].classList.add('bordered-btn');
			  btnRe[0].classList.add('boxed-btn');
		}); 
	</script>
</body>
</html>