<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<head>
	<title>Smart Booking</title>

	<!-- Meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- Favicon -->
	<link rel="shortcut icon" href="../favicon.ico">

	<!-- Web Fonts -->
	<link rel="stylesheet" href="//fonts.b.com/css?family=Open+Sans:400,300,700&subset=cyrillic,latin">

	<!-- CSS Global Compulsory -->
	<link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/app.css">
	<link rel="stylesheet" href="assets/css/blocks.css">

	<!-- CSS Implementing Plugins -->
	<link rel="stylesheet" href="assets/plugins/animate.css">
	<link rel="stylesheet" href="assets/plugins/line-icons/line-icons.css">
	<link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/plugins/sky-forms-pro/skyforms/css/sky-forms.css">
	<link rel="stylesheet" href="assets/plugins/owl-carousel2/assets/owl.carousel.css">
	<link rel="stylesheet" href="assets/plugins/cube-portfolio/cubeportfolio/css/cubeportfolio.min.css">
	<link rel="stylesheet" href="assets/plugins/master-slider/masterslider/style/masterslider.css">
	<link rel="stylesheet" href="assets/plugins/master-slider/u-styles/testimonials-1.css">
	<link rel="stylesheet" href="assets/plugins/master-slider/u-styles/promo-1.css">

	<!-- CSS Theme -->
	<link rel="stylesheet" href="assets/css/travel.style.css">

	<!-- CSS Customization -->
	<link rel="stylesheet" href="assets/css/custom.css">
</head>

<!--
	The data-spy and data-target are part of the built-in Bootstrap scrollspy function.
-->
<body id="body" data-spy="scroll" data-target=".one-page-header" class="demo-lightbox-gallery">
<main class="wrapper">
	<!--=== Header ===-->
	<nav class="one-page-header navbar navbar-default" data-role="navigation">
		<div class="container">
			<div class="menu-container page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/SmartBooking" style="padding-top:20px;color:#000;">
					SmartBooking
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<div class="menu-container">
					<ul class="nav navbar-nav">
						<c:if test = "${sessionScope.userid!=null}">
						<li class="page-scroll">
							<a href="#" class="color-black"><span  class="color-black" data-hover="Welcome ${sessionScope.firstName}!">Welcome ${sessionScope.firstName} !</span></a>
						</li>
						</c:if>
						<li class="page-scroll">
							<a href="#Our-Tours" class="color-black"><span data-hover="Our Packages" class="color-black">Our Packages</span></a>
						</li>
						<li class="page-scroll">
							<a id="hotelSearch" href="#Our-Hotels" class="color-black"><span class="color-black" data-hover="Popular Hotels">Search Hotels</span></a>
						</li>
						<li class="page-scroll">
							<a href="#Gallery" class="color-black"><span data-hover="Gallery" class="color-black">Gallery</span></a>
						</li>
						<li class="page-scroll">
							<a href="#Contact" class="color-black"><span data-hover="Contact" class="color-black">Contact</span></a>
						</li>
						<c:if test = "${sessionScope.userid==null}">
						<li class="page-scroll">
							<a href="Login.html" class="color-black"><span  class="color-black" data-hover="Login">Login</span></a>
					<!--		<c:out value="${sessionScope.userid}" />-->
						</li>
						<li class="page-scroll">
							<a href="SignUp.html" class="color-black"><span  class="color-black" data-hover="SignUp">SignUp</span></a>
						</li>	
						</c:if>
						<c:if test = "${sessionScope.userid!=null}">
						<li class="page-scroll">
							<a href="LogoutServlet" class="color-black"><span  class="color-black" data-hover="LogOut">LogOut</span></a>
						</li>
						</c:if>
						<c:if test = "${not empty sessionScope.cartSize}">
						<li class="page-scroll">
							<a href="CartServlet" class="color-black"><span class="glyphicon glyphicon-shopping-cart"></span>
							<span data-hover="My Cart" class="color-black">Cart(${sessionScope.cartSize})</span></a>
						</li>
						</c:if>

					</ul>
				</div>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!--=== End Header ===-->

	<!-- Promo Section -->
	<!-- End Promo Section -->

	<!-- Search Hotels Section -->
	<div class="search-tours g-heading-v8" id="Our-Hotels">
		<div class="container">
			<div class="row">
				<c:if test="${empty cart}">
					<h2>Nothing in the Cart</h2>
				</c:if>
				<c:if test="${not empty cart}">
					<h2>Cart Details</h2>
					<div class="col-md-10 search-tours-col-bg-default">
						<div class="row">
							<c:forEach var="item" items="${cart.items}">
								<div class="col-xs-12">
									<div class="our-tours-list-item col-xs-12" id="${item.id}">
										<div class="img-wrapper img-wrapper--shadow text-center">
											<img src="${item.image}" alt="ALT" class="img-reponsive" style="max-width: 500px;">
										</div>
										<h3>${item.name}</h3>
										<ul class="list-inline star-vote">
											<li><i class="g-color-default fa fa-star"></i></li>
											<li><i class="g-color-default fa fa-star"></i></li>
											<li><i class="g-color-default fa fa-star"></i></li>
			
											<c:if test="${item.ratings == '3.0'}">
												<li><i class="g-color-default fa fa-star-o"></i></li>
												<li><i class="g-color-default fa fa-star-o"></i></li>
											</c:if>
											<c:if test="${item.ratings == '3.5'}">
												<li><i class="g-color-default fa fa-star-half-o"></i></li>
												<li><i class="g-color-default fa fa-star-o"></i></li>
											</c:if>
			
											<c:if test="${item.ratings == '4.0'}">
												<li><i class="g-color-default fa fa-star"></i></li>
												<li><i class="g-color-default fa fa-star-o"></i></li>
											</c:if>
											<c:if test="${item.ratings == '4.5'}">
												<li><i class="g-color-default fa fa-star"></i></li>
												<li><i class="g-color-default fa fa-star-half-o"></i></li>
											</c:if>
											<c:if test="${item.ratings == '5.0'}">
												<li><i class="g-color-default fa fa-star"></i></li>
												<li><i class="g-color-default fa fa-star"></i></li>
											</c:if>
										</ul>
										<p>$${item.price}</p>
									</div>
									<label>From:</label><span>${item.start}</span><br>
									<label>To:</label><span>${item.end}</span>
								</div>
								<hr>
							</c:forEach>
						</div>
					</div>
					<div class="col-md-2 black search-tours-col-bg-default">
						<a href="CheckOut.html"><button type="submit" class="btn-u btn-u-lg btn-u-upper">Checkout</button></a>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<!-- End Search Tours Section -->

	<!-- Our Tours Section -->
	<div class="our-tours text-center g-heading-v8 g-pt-85 g-pb-100" id="Our-Tours">
		<div class="container-fluid">
			<h2 class="h2"><em class="block-name">Our Packages</em><br> <strong>We can</strong> offer</h2>
			<div class="our-tours-list-wrapper">
				<div class="our-tours-list text-left">
				<c:forEach var="entry" items="${packages}">
					
				
					<!-- Item 1 -->
					<div class="our-tours-list-item" id="${entry.value[0]}">
						<div class="img-wrapper img-wrapper--shadow"><img src="assets/img-temp/offers/${entry.value[2]}" alt="ALT" class="img-reposnsive"></div>
						<h3>${entry.value[1]}</h3>
						<ul class="list-inline star-vote">
							<li><i class="g-color-default fa fa-star"></i></li>
							<li><i class="g-color-default fa fa-star"></i></li>
							<li><i class="g-color-default fa fa-star"></i></li>
							
							
							<c:if test = "${entry.value[5] == '3.0'}">
								<li><i class="g-color-default fa fa-star-o"></i></li>
								<li><i class="g-color-default fa fa-star-o"></i></li>
							</c:if>
							<c:if test = "${entry.value[5] == '3.5'}">
								<li><i class="g-color-default fa fa-star-half-o"></i></li>
								<li><i class="g-color-default fa fa-star-o"></i></li>
							</c:if>
							
							<c:if test = "${entry.value[5] == '4.0'}">
								<li><i class="g-color-default fa fa-star"></i></li>
								<li><i class="g-color-default fa fa-star-o"></i></li>
							</c:if>
							<c:if test = "${entry.value[5] == '4.5'}">
								<li><i class="g-color-default fa fa-star"></i></li>
								<li><i class="g-color-default fa fa-star-half-o"></i></li>
							</c:if>
							<c:if test = "${entry.value[5] == '5.0'}">
								<li><i class="g-color-default fa fa-star"></i></li>
								<li><i class="g-color-default fa fa-star"></i></li>
							</c:if>
							
						</ul>
						<p>${entry.value[3]}</p>
						<div class="our-tours-price">$${entry.value[4]}.00</div>
						<a href="#" class="our-tours-list-item__more">More</a>
					</div>
					<!-- End Item 1 -->
				</c:forEach>
					
				</div>
			</div>
		</div>
	</div>
	<!-- End Our Tours Section -->





	<!-- Contact Section -->
	<div class="contact-section text-center g-heading-v8" id="Contact">
		<div class="container-fluid">
			<div class="row">
				<!-- Map -->
				<div class="col-md-4 contact-section-col">
					<div id="map" class=" contact-section-map"></div>
				</div>
				<!-- End Map -->

				<!-- Contacts -->
				<div class="col-md-4 col-sm-6 contact-section-col contact-section-content g-bg-default-color">
					<h2 class="h2"><em class="block-name">Contact Us</em><br> <strong>Get In</strong> Touch</h2>
					<p class="contact-section-info">Aliquam dapibus quis sapien id pharetra. Vivamus iaculis est vitae libero tempus, in sollicitudin est consectetur porttitor iaculis pretium</p>

					<ul class="list-unstyled address">
						<li>email: <strong><a href="mailto:customerSupport@smartboking.com">customerSupport@smartboking.com</a></strong></li>
						<li>phone number: <strong>+48 555 2566 112</strong></li>
						<li>address: <strong>In sed lectus tincidunt</strong></li>
					</ul>

					<ul class="g-social-icons-v2 margin-bottom-30">
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
					</ul>
				</div>
				<!-- End Contacts -->

				<!-- Ask Block -->
				<div class="col-md-4 col-sm-6 contact-section-col contact-section-content">
					<h3 class="h3"><strong>Have A </strong> Questions?</h3>
					<form action="#" class="sky-form" method="post" id="sky-form3">
						<fieldset>
							<label class="input g-mb-10">
								<input type="text" placeholder="Your name" name="name" id="name">
							</label>
							<label class="input g-mb-10">
								<input type="text" placeholder="Your phone" name="phone" id="phone">
							</label>
							<label class="input g-mb-10">
								<input type="text" placeholder="Subject" name="subject" id="subject">
							</label>
							<label class="textarea textarea-expandable g-mb-40">
								<textarea rows="3" placeholder="Message" name="message" id="message"></textarea>
							</label>
							<button class="btn-u btn-u-lg btn-u-red btn-u-upper" type="submit">Send Message</button>
						</fieldset>

						<!-- Success Message -->
				        <div class="message">
				            <i class="rounded-x fa fa-check"></i>
				            <p>Your message was successfully sent!</p>
				        </div>
					</form>
				</div>
				<!-- End Ask Block -->
			</div>
		</div>
	</div>
	<!-- End Contact Section -->

	<!-- Footer Section -->
	<div class="footer g-pt-40 g-pb-40">
		<div class="container">
			<div class="g-display-table">
				<div class="g-display-td g-text-middle page-scroll"><a href="#body" class="footer-logo">SmartBooking</a></div>
				<div class="g-display-td g-text-middle text-right g-pt-10">&copy; 2017 All right reserved. Deelopment by <a href="#">Team #08</a></div>
			</div>
		</div>
	</div>
	<!-- End Footer Section -->
</main>

<!-- JS Global Compulsory -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<script src="assets/plugins/jquery/jquery-migrate.min.js"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>

<!-- JS Implementing Plugins -->
<script src="assets/plugins/smoothScroll.js"></script>
<script src="assets/plugins/jquery.easing.min.js"></script>
<script src="assets/plugins/owl-carousel2/owl.carousel.min.js"></script>
<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.form.min.js"></script>
<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.maskedinput.min.js"></script>
<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery-ui.min.js"></script>
<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>
<script src="assets/plugins/cube-portfolio/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?signed_in=true&amp;callback=initMap" async defer></script><script src="assets/js/plugins/gmaps-ini.js"></script>
<script src="assets/plugins/master-slider/masterslider/masterslider.min.js"></script>

<!-- JS Page Level -->
<script src="assets/js/one.app.js"></script>
<script src="assets/js/plugins/owl-carousel2.js"></script>
<script src="assets/js/plugins/datepicker.js"></script>
<script src="assets/js/plugins/promo.js"></script>
<script src="assets/js/plugins/testimonials.js"></script>
<script src="assets/js/plugins/gallery.js"></script>
<script src="assets/js/forms/contact.js"></script>

<script>
$(function() {
	App.init();
	OwlCarousel.initOwlCarousel();
	Datepicker.initDatepicker();
	ContactForm.initContactForm();
});
</script>
<script>
$( document ).ready(function() {
	$( "#hotelSearch a" ).trigger("click");
$( function() {
	var low = $("#priceLow").val();
	var high = $("#priceHigh").val();
    $( "#slider-range" ).slider({
      range: true,
      min: 0,
      max: 1500,
      values: [ low, high ],
      slide: function( event, ui ) {
        $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
        $( "#priceLow" ).val(ui.values[0]);
        $( "#priceHigh" ).val(ui.values[1]);
      },
      change: function(event, ui) {  //<---add this to submit the form.
          $('[name="filterForm"]').submit();
      }
    });
    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
      " - $" + $( "#slider-range" ).slider( "values", 1 ) );
  } );
  $( "#hotelSearch" ).click();
});
</script>
<!--[if lt IE 10]>
	<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.placeholder.min.js"></script>
<![endif]-->
</body>
</html>
