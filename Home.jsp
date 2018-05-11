<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	<link rel="stylesheet" href="assets/plugins/jquery/jquery-ui.min.css">

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
	<nav class="one-page-header navbar navbar-default navbar-fixed-top one-page-nav-scrolling one-page-nav__fixed" data-role="navigation">
		<div class="container">
			<div class="menu-container page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#body" style="padding-top:20px;color:white;">
					SmartBooking
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<div class="menu-container">
					<ul class="nav navbar-nav">
						<c:if test = "${sessionScope.userid!=null}">
						<li class="page-scroll">
							<a href="#"><span data-hover="Welcome ${sessionScope.firstName}!">Welcome ${sessionScope.firstName} !</span></a>
						</li>
						</c:if>
						<li class="page-scroll">
							<a href="#Our-Tours"><span data-hover="Our Packages">Our Packages</span></a>
						</li>
						<li class="page-scroll">
							<a href="TrendingServlet"><span data-hover="Trending">Trending</span></a>
						</li>

						<li class="page-scroll">
							<a href="#Gallery"><span data-hover="Gallery">Gallery</span></a>
						</li>
						<li class="page-scroll">
							<a href="#Contact"><span data-hover="Contact">Contact</span></a>
						</li>
						<c:if test = "${sessionScope.userid==null}">
						<li class="page-scroll">
							<a href="Login.html"><span data-hover="Login">Login</span></a>
					<!--		<c:out value="${sessionScope.userid}" />-->
						</li>
						<li class="page-scroll">
							<a href="SignUp.html"><span data-hover="SignUp">SignUp</span></a>
						</li>
						</c:if>
						<c:if test = "${sessionScope.userid!=null}">
						<li class="page-scroll">
							<a href="LogoutServlet"><span data-hover="LogOut">LogOut</span></a>
						</li>
						</c:if>
						<c:if test = "${sessionScope.userid!=null}">
						<li class="page-scroll">
							<a href="OrderServlet"><span data-hover="My Orders">Orders</span></a>
						</li>
						</c:if>
						<c:if test = "${not empty sessionScope.cartSize}">
						<li class="page-scroll">
							<a href="CartServlet?param=view"><span class="glyphicon glyphicon-shopping-cart"></span>
							<span data-hover="My Cart">Cart(${sessionScope.cartSize})</span></a>
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
	<div class="promo-section master-slider ms-promo-1" id="masterslider-promo">

		<!-- Slide 1 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/picjumbo.com_vranov-czech-republic.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$150.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Karlovy Vary, Czech
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non, blandit finibus ante. Nunc venenatis risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Karlovy Vary, Czech</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/picjumbo.com_vranov-czech-republic.jpg" alt="ALT">
		</div>
		<!-- End Slide 1 -->

		<!-- Slide 2 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/photo-1420655710207-b092e1b8abe3.jpg" alt="ALT"/>
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$550.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				London, Great Britain
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to London, Great Britain</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/photo-1420655710207-b092e1b8abe3.jpg" alt="thumb">
		</div>
		<!-- End Slide 2 -->

		<!-- Slide 3 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/greece-2.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$360.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Crete, Greece
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="10" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non, blandit finibus ante. Nunc venenatis risus in finibus dapibus. </p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Crete, Greece</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/greece-2.jpg" alt="thumb">
		</div>
		<!-- End Slide 3 -->

		<!-- Slide 4 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/picjumbo.com_HNCK8248.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$1300.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Langkawi, Malaysia
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Blandit finibus ante. Nunc venenatis risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Langkawi, Malaysia</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/picjumbo.com_HNCK8248.jpg" alt="thumb">
		</div>
		<!-- End Slide 4 -->

		<!-- Slide 5 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/picjumbo.com_HNCK4183.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$1300.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Bavaria, Germany
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non, blandit finibus ante. Nunc venenatis risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Bavaria, Germany</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/picjumbo.com_HNCK4183.jpg" alt="thumb">
		</div>
		<!-- End Slide 5 -->

		<!-- Slide 6 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/photo-1431274172761-fca41d930114.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$610.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Paris, France
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non, blandit finibus ante. Nunc venenatis risus in.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Paris, France</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/photo-1431274172761-fca41d930114.jpg" alt="thumb">
		</div>
		<!-- End Slide 6 -->

		<!-- Slide 7 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/picjumbo.com_IMG_6358.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$340.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Hong Kong
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat u ante. Nunc venenatis risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Hong Kong</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/picjumbo.com_IMG_6358.jpg" alt="thumb">
		</div>
		<!-- End Slide 7 -->

		<!-- Slide 8 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/picjumbo.com_HNCK8182.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$2400.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Venice, Italy
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non, blandit finibus ante. Nunc venenatis risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Venice, Italy</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/picjumbo.com_HNCK8182.jpg" alt="thumb">
		</div>
		<!-- Slide 8 -->

		<!-- Slide 9 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/picjumbo.com_HNCK8242.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$540.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Madrid, Spain
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non, blandit finibus ante. Nunc venenatis risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to Madrid, Spain</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/picjumbo.com_HNCK8242.jpg" alt="thumb">
		</div>
		<!-- End Slide 9 -->

		<!-- Slide 10 -->
		<div class="ms-slide">
			<img src="assets/plugins/master-slider/masterslider/style/blank.gif" data-src="assets/img-temp/promo/photo-1422226256160-9b266e308ea6.jpg" alt="ALT">
			<div class="ms-layer ms-promo-travel-price hidden-xs" style="left: 15px; top: 182px; opacity: 1;" data-type="text" data-delay="10" data-effect="skewleft(50,340)" data-ease="easeOutExpo" data-duration="2200">
				Only From <strong>$5240.00</strong>
			</div>
			<h3 class="ms-layer ms-promo-travel-place hidden-3xs" style="left: 11px; top: 256px;" data-type="text" data-delay="10" data-effect="skewright(50,340)" data-ease="easeOutExpo" data-duration="2200">
				New York, USA
			</h3>
			<div class="ms-layer ms-promo-travel-description" style="left: 15px; top: 324px;" data-type="text" data-delay="30" data-effect="rotate3dbottom(100,0,0,70)" data-ease="easeOutExpo" data-duration="2300">
				<p class="g-mb-20 hidden-sm hidden-xs">Donec erat urna, tincidunt at leo non, blandit finibus ante. Nunc venenatis risus in finibus dapibus. Ut ac massa sodales, mattis enim id, efficitur tortor.</p>
				<p><a href="#" class="btn-u btn-u-lg btn-u-red btn-u-upper">Book Hotel<span class="visible-3xs"> to New York, USA</span></a></p>
			</div>
			<img class="ms-thumb" src="assets/img-temp/promo/thumbs/photo-1422226256160-9b266e308ea6.jpg" alt="thumb">
		</div>
		<!-- Slide 10 -->

	</div>
	<!-- End Promo Section -->

	<!-- Search Tours Section -->
	<div class="search-tours g-heading-v8">
		<div class="container">
			<div class="row">
				<div class="col-md-3 search-tours-title-wrapper">
					<div class="container">
						<h2><em class="block-name">Book Information</em><br> Hotel search</h2>
					</div>
				</div>
				<div class="col-md-9 search-tours-col-bg-default">
					<div class="container">
						<form action="FilterServlet" class="sky-form clearfix">
							<div class="col-md-12">

								<!--<label class="select">
									<select name="city">
										<option value="0" selected="">New York</option>
										<option value="1">Greece</option>
										<option value="2">Venice</option>
										<option value="3">Paris</option>
										<option value="4">Rome</option>
										<option value="5">London</option>
									</select>
									<i></i>
								</label>-->
								<label class="label">Enter City</label>
								<label class="input">

									<input type="text" name="city" id="autoCity" placeholder="City">
								</label>
							</div>
							<div class="col col-3">
								<label class="label">Room's</label>
								<label class="select">
									<select name="rooms">
										<c:forEach var="item" items="${rooms}">
								        	<option value="${item}">${item}</option>
								    	</c:forEach>
									</select>
									<i></i>
								</label>
							</div>

							<div class="col col-3">
								<label class="label">Check-in</label>
								<label class="input">
									<span class="icon-append fa fa-calendar"></span>
									<input type="text" name="start" id="start" placeholder="DD/MM/YYY">
								</label>
							</div>

							<div class="col col-3">
								<label class="label">Check-out</label>
								<label class="input">
									<span class="icon-append fa fa-calendar"></span>
									<input type="text" name="finish" id="finish" placeholder="DD/MM/YYY">
								</label>
							</div>

							<div class="col col-3">
								<label class="label">Persons</label>
								<label class="input">
									<span class="icon-append fa fa-users"></span>
									<input type="text" name="person" placeholder="Number of persons">
								</label>
							</div>

							<div class="col col-3">
								<button type="submit" class="btn-u btn-u-lg btn-u-upper">Search</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Search Tours Section -->

	<!-- Our Tours Section -->
	<br>
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


	<!-- Tweets Section -->
	<br>
	<div class="our-tours text-center g-heading-v8 g-pt-85 g-pb-100" id="Tweets">
		<div class="container-fluid">
				<h2 class="h2"><em class="block-name">Tweets !</em></h2>
						<c:forEach var="window" items="${tweets}">
							<p><a href="#"><c:out value="${window}"/> </a></p>
						</c:forEach>
			<div class="our-tours-list-wrapper">
				<div class="our-tours-list text-left">
					<c:forEach var="entry" items="${hotels}">
						
						
					<!-- Item 1 -->
					<div class="our-tours-list-item" id="${entry.value[0]}">
						<div class="img-wrapper img-wrapper--shadow"><img src="${entry.value[2]}" alt="ALT" class="img-reposnsive"></div>
						<h3>${entry.value[1]}</h3>
						<ul class="list-inline star-vote">
							<li><i class="g-color-default fa fa-star"></i></li>
							<li><i class="g-color-default fa fa-star"></i></li>
							<li><i class="g-color-default fa fa-star"></i></li>


							<c:if test = "${entry.value[10] == '3.0'}">
								<li><i class="g-color-default fa fa-star-o"></i></li>
								<li><i class="g-color-default fa fa-star-o"></i></li>
							</c:if>
							<c:if test = "${entry.value[10] == '3.5'}">
								<li><i class="g-color-default fa fa-star-half-o"></i></li>
								<li><i class="g-color-default fa fa-star-o"></i></li>
							</c:if>

							<c:if test = "${entry.value[10] == '4.0'}">
								<li><i class="g-color-default fa fa-star"></i></li>
								<li><i class="g-color-default fa fa-star-o"></i></li>
							</c:if>
							<c:if test = "${entry.value[10] == '4.5'}">
								<li><i class="g-color-default fa fa-star"></i></li>
								<li><i class="g-color-default fa fa-star-half-o"></i></li>
							</c:if>
							<c:if test = "${entry.value[10] == '5.0'}">
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
	<!-- End Our Tweets Section -->


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
<script src="assets/plugins/jquery/jquery-ui.min.js"></script>
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
$( function() {
    var availableTags = [
      "New York",
	  "Chicago"
    ];
	var test = "<%=request.getAttribute("cities")%>";
	var city = test.split("***");
	console.log(city);
    $( "#autoCity" ).autocomplete({
      source: city
    });
  } );
</script>

<!--[if lt IE 10]>
	<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.placeholder.min.js"></script>
<![endif]-->
</body>
</html>
