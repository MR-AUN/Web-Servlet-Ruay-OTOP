
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- jquery -->
	<script src="contents/assets/js/jquery-1.11.3.min.js"></script>
	<!-- bootstrap -->
	<script src="contents/styles/bootstrap.min.js"></script>
	<!-- count down -->
	<script src="contents/assets/js/jquery.countdown.js"></script>
	<!-- isotope -->
	<script src="contents/assets/js/jquery.isotope-3.0.6.min.js"></script>
	<!-- waypoints -->
	<script src="contents/assets/js/waypoints.js"></script>
	<!-- owl carousel -->
	<script src="contents/assets/js/owl.carousel.min.js"></script>
	<!-- magnific popup -->
	<script src="contents/assets/js/jquery.magnific-popup.min.js"></script>
	<!-- mean menu -->
	<script src="contents/assets/js/jquery.meanmenu.min.js"></script>
	<!-- sticker js -->
	<script src="contents/assets/js/sticker.js"></script>
	<!-- main js -->
	<script src="contents/assets/js/main.js"></script>
	
	<!-- sweetalert -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script type="text/javascript">
	function alertSwal(type,text) {
		Swal.fire({
			  icon: type,
			  title: text,
			  showConfirmButton: false,
			  timer: 1500
			})
	}
	
	function alertText(titles,texts) {
		Swal.fire({
			  title: titles,
			  text: texts
			})
	}
	
	function alertBasket(option,number) {
		number = parseInt(number)
		const basket = document.querySelector("#alertBasket");
		let num = parseInt(basket.innerHTML);
		basket.innerHTML = option != "delete" ?num + number:num-number;
	}
	
	
	</script>