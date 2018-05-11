<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix ="fn" %>

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
				<a class="navbar-brand" href="#body" style="padding-top:20px;color:#000;">
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
							<a href="TrendingServlet" class="color-black"><span data-hover="Trending">Trending</span></a>
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
						<c:if test = "${sessionScope.userid!=null}">
						<li class="page-scroll">
							<a href="OrderServlet" class="color-black"><span  class="color-black" data-hover="My Orders">Orders</span></a>
						</li>
						</c:if>
						<c:if test = "${not empty sessionScope.cartSize}">
						<li class="page-scroll">
							<a href="CartServlet?param=view" class="color-black"><span class="glyphicon glyphicon-shopping-cart"></span>
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
				<div class="col-md-3 search-tours-title-wrapper">
					<form action="FilterServlet" class="sky-form clearfix" name="filterForm">
						<!-- <div class="container"> -->
						<h2><em class="block-name">Book Information</em><br> Hotel search</h2>
						<br><label class="label">Enter City</label>
							<label class="select">
								<select id="city" name="city" onchange="this.form.submit()">
									<c:forEach var="item" items="${hotelBB.cities}">
								        <option value="${item}" ${item == hotelBB.city ? 'selected="selected"' : ''}>${item}</option>
								    </c:forEach>
								</select>
								<i></i>
							</label>

							<br><label class="label">Room's</label>
							<label class="select">
								<select id="rooms" name="rooms" onchange="this.form.submit()">
									<c:forEach var="item" items="${hotelBB.rooms}">
								        <option value="${item}" ${item == hotelBB.roomType ? 'selected="selected"' : ''}>${item}</option>
								    </c:forEach>
								</select>
								<i></i>
							</label>

							<br><label class="label">Check-in</label>
							<label class="input">
								<span class="icon-append fa fa-calendar"></span>
								<input type="text" name="start" id="start" value="${hotelBB.startDate}" placeholder="DD/MM/YYY" onchange="this.form.submit()">
							</label>

							<br><label class="label">Check-out</label>
							<label class="input">
								<span class="icon-append fa fa-calendar"></span>
								<input type="text" name="finish" id="finish" value="${hotelBB.endDate}" placeholder="DD/MM/YYY" onchange="this.form.submit()">
							</label>

							<br><label class="label">Persons</label>
							<label class="select">
								<select onchange="this.form.submit()" id="person" name="person">
									<c:forEach var="item" items="${hotelBB.noOfPersons}">
								        <option value="${item}" ${item == hotelBB.noOfPerson ? 'selected="selected"' : ''}>${item}</option>
								    </c:forEach>
								</select>
								<i></i>
							</label>

							<br><label class="label">Price</label>
							<div class="input">
								<input type="text" id="amount" name="amount" readonly style="border:0; font-weight:bold;" onchange="this.form.submit()">
								<input type="hidden" id="priceLow" name="priceLow" value="${hotelBB.priceLow}">
								<input type="hidden" id="priceHigh" name="priceHigh" value="${hotelBB.priceHigh}">
								<div id="slider-range"></div>
							</div>
							<!--</div> -->
						</form>
					</div>
					<c:if test="${empty hotelBB.hotels}">
						<h2>No Hotels match this search criteria</h2>
					</c:if>
					<c:if test="${not empty hotelBB.hotels}">
						<div class="col-md-9 search-tours-col-bg-default">
						<div class="row">

								<c:forEach var="entry" items="${hotelBB.hotels}">
								<div class="col-xs-12">
									<div class="our-tours-list-item col-xs-12" id="${entry.key}">
										<div class="img-wrapper img-wrapper--shadow text-center">
											<img src="${entry.value.image}" alt="ALT" class="img-reponsive" style="max-width: 700px;">
										</div>
										<h3>${entry.value.hotelName}</h3>
										<c:set var="hName" scope="request" value="${entry.value.hotelName}"/>
										<c:set var="city" scope="request" value="${entry.value.city}"/>
										<ul class="list-inline star-vote">
											<li><i class="g-color-default fa fa-star"></i></li>
											<li><i class="g-color-default fa fa-star"></i></li>
											<li><i class="g-color-default fa fa-star"></i></li>

											<c:if test="${entry.value.ratings == '3.0'}">
												<li><i class="g-color-default fa fa-star-o"></i></li>
												<li><i class="g-color-default fa fa-star-o"></i></li>
											</c:if>
											<c:if test="${entry.value.ratings == '3.5'}">
												<li><i class="g-color-default fa fa-star-half-o"></i></li>
												<li><i class="g-color-default fa fa-star-o"></i></li>
											</c:if>

											<c:if test="${entry.value.ratings == '4.0'}">
												<li><i class="g-color-default fa fa-star"></i></li>
												<li><i class="g-color-default fa fa-star-o"></i></li>
											</c:if>
											<c:if test="${entry.value.ratings == '4.5'}">
												<li><i class="g-color-default fa fa-star"></i></li>
												<li><i class="g-color-default fa fa-star-half-o"></i></li>
											</c:if>
											<c:if test="${entry.value.ratings == '5.0'}">
												<li><i class="g-color-default fa fa-star"></i></li>
												<li><i class="g-color-default fa fa-star"></i></li>
											</c:if>
										</ul>
										<p>${entry.value.roomType}</p>
										<div class="our-tours-price col-xs-10">
											<p>$${entry.value.price}.00</p>
											<h4><a href="HotelServlet?param=details&hotelId=${entry.key}">View Room Details</a></h4>
											<div class="row">
												<div class="col-xs-6">
													<c:set var="string1" value ="${entry.value.hotelName}" />
													<c:set var="string2" value="${fn:replace(string1,' ', '')}" />
													<a href="#" class="btn btn-warning view-review-btn" hname="${string2}">View Reviews</a>

													<c:if test = "${sessionScope.userid!=null}">
														<a href="#" class="btn btn-warning review-btn" rating="${entry.value.ratings}" cityName="${entry.value.city}" userid="${sessionScope.userid}"  hname="${entry.value.hotelName}">Write Review</a>

													</c:if>
												</div>
												<form action="CartServlet">
													<input type='hidden' name='startD' class='startD' value=''/>
                          							<input type='hidden' name='wish' value='false'/>
													<input type='hidden' name='endD' class='endD' value=''/>
													<input type='hidden' name="cType" value='hotel'/>
													<input type='hidden' name="chotelId" id='chotelId' value='${entry.key}'/>
													<div class="col-xs-3 text-right">
														<button type='submit' class='btn btn-primary save-order' onclick="return verify();">Add to Cart</button>
													</div>
  												<c:if test = "${sessionScope.userid!=null}">
  													<div class="col-xs-3 text-right">
  														<button type='submit' class="btn btn-success" onclick="$('#wish').val('wish');return verify();">Add to WishList</button>
  													</div>
  												</c:if>
                        </form>
											</div>
										</div>
									</div>
									</div>
									<div class="clear-both col-xs-12"></div>
									<hr>
								</c:forEach>
						</div>
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

<!--Modal Start-->
		<div class='modal fade' id='viewReveiewModal' tabindex='-1' role='dialog'>
		  <div class='modal-dialog' role='document' style="width: 80%;">
			<div class='modal-content'>
			  <div class='modal-header'>
				<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
				<h4 class='modal-title'>View Review</h4>
			  </div>
			  <div class='modal-body'>
				<table class='table table-striped table-hover '>
				  <thead>
					<tr>
					  <th class="text-center">No:</th>
					  <th class="text-center">Hotel Name</th>
					  <th class="text-center">Hotel Type</th>
					  <th class="text-center">City</th>
					  <th class="text-center">City Zip</th>
					  <th class="text-center">Offer Available</th>
					  <th class="text-center">User Age</th>
					  <th class="text-center">Gender</th>
					  <th class="text-center">User Occupation</th>
					  <th class="text-center">Review Rating</th>
					  <th class="text-center">Review Date</th>
					  <th class="text-center">Review Text</th>
					</tr>
				  </thead>
				  <tbody>
				  <c:forEach var="entry" items="${viewReviews}" varStatus="loop">


					<!-- Item 1 -->
					<c:set var="string3" value ="${entry.value[0]}" />
					<c:set var="string4" value="${fn:replace(string3,' ', '')}" />
						<tr class='${string4}' style='display:none'>
						  <td>${loop.index}</td>
						  <td>${entry.value[0]}</td>
						  <td>${entry.value[1]}</td>
						  <td>${entry.value[2]}</td>
						  <td>${entry.value[3]}</td>
						  <td>${entry.value[4]}</td>
						  <td>${entry.value[5]}</td>
						  <td>${entry.value[6]}</td>
						  <td>${entry.value[7]}</td>
						  <td>${entry.value[8]}</td>
						  <td>${entry.value[9]}</td>
						  <td>${entry.value[10]}</td>

						</tr>
				</c:forEach>


				</tbody>
			</table>
			  </div>


			</div>
		  </div>
		</div>
	<!--Modal End-->


	<!-- Write review Start> -->
		<div class='modal fade' id='writeReveiewModal' tabindex='-1' role='dialog'>
		  <div class='modal-dialog' role='document'>
			<div class='modal-content'>
			  <div class='modal-header'>
				<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>
				<h4 class='modal-title'>Write Review</h4>
			  </div>
			  <div class='modal-body'>
				<fieldset>
			<div class='row'>
			<form action='WriteReviewsServlet' method='post'>
				<div class='form-group col-md-6'>
					<label for='hotelName'>Hotel Name:</label>
					<p type='text' name='hotelName' id='hotelName'></p>
				</div>
				<div class='form-group col-md-6'>
					<label for='hotelType'>Hotel Type:</label>
					<p type='text' name='hotelType' id='hotelType'></p>
				</div>
				<div class='form-group col-md-6'>
					<label for='cityName'>City Name:</label>
					<p type='text' name='cityName' id='cityName'></p>
				</div>
				<div class='form-group col-md-6'>
					<label for='cityZip'>City Zip:</label>
					<input type='text' class='form-control' name='cityZip' id='cityZip' placeholder='60616' pattern='[0-9]{5}' title='5 Number Zip Code' min='00000' />
				</div>
				<div class='form-group col-md-6'>
					<label for='offers'>Offers:</label>
					<select id='offers' name='offers'>
						<option value='Yes'>Yes</option>
						<option value='No'>No</option>
					</select>
				</div>
				<div class='form-group col-md-6'>
					<label for='userID'>User ID:</label>
					<p type='text' name='userID' id='userID'></p>
				</div>
				<div class='form-group col-md-6'>
					<label for='userAge'>User Age:</label>
					<input type='text' class='form-control' name='userAge' id='userAge' placeholder='24'>
				</div>
				<div class='form-group col-md-6'>
					<label for='userGender'>User Gender:</label>
					<select id='userGender' name='userGender'>");
						<option value='Male'>Male</option>
						<option value='Female'>Female</option>
					</select>
				</div>
				<div class='form-group col-md-6'>
					<label for='userOccupation'>User Occupation:</label>
					<input type='text' class='form-control' name='userOccupation' id='userOccupation' placeholder='Student'>
				</div>
				<div class='form-group col-md-6'>
					<label for='reviewRating'>Review Rating:</label>
					<select id='reviewRating' name='reviewRating'>
						<option value='1'>1</option>
						<option value='2'>2</option>
						<option value='3'>3</option>
						<option value='4'>4</option>
						<option value='5'>5</option>
					</select>
				</div>
				<div class='form-group col-md-6'>
					<label for='reviewDate'>Review Date:</label>
					<p type='text' name='reviewDate' id='reviewDate'></p>
				</div>
				<div class='form-group col-md-12'>
					<label for='reviewText'>Review Text:</label>
					<textarea rows='4' cols='50' id="reviewText" name='review'></textarea>
				</div>
				<input type='hidden' name='hotelName' class='hotelName' value=''>
				<input type='hidden' name='hotelType' class='hotelType' value=''>
				<input type='hidden' name='cityName' class='cityName' value=''>
				<input type='hidden' name='userID' class='userId' value=''>
				<input type='hidden' name='reviewDate' class='reviewDate' value=''>
				<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>
				<button type='submit' class='btn btn-primary save-order'>Submit Review</button>

				</form>
				</div>
				</fieldset>
			  </div>


			</div>
		  </div>
		</div>
	<!-- Write review End> -->


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
<script src="assets/js/customScript.js"></script>
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
verify = function() {
	if( $("#start").val() == "" || $("#finish").val() == "") {
		alert("Please enter start and end dates");
    	return false;
	} else {
		$('.startD').val($("#start").val());
		$('.endD').val($("#finish").val());
		return true;
	}
}
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
  $().on("click", ".view-review-modal", function() {

  });
});
</script>
<!--[if lt IE 10]>
	<script src="assets/plugins/sky-forms-pro/skyforms/js/jquery.placeholder.min.js"></script>
<![endif]-->
</body>
</html>