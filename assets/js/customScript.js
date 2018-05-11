$(document).ready(function(){
	$(".view-review-btn").on('click', function() {
		console.log("in Tes");
		var productName = $(this).attr("hname");
		$("#viewReveiewModal tbody tr").hide();
		$("#viewReveiewModal tbody").find("."+productName).show();
		
		$("#viewReveiewModal").modal('show');
	});
	$(".review-btn").on('click', function() {
		console.log("in Tes");
		var productName = $(this).attr("hname");
		var userid = $(this).attr("userid");
		var cityName = $(this).attr("cityName");
		var rating = $(this).attr("rating");
		$("#writeReveiewModal").find("#hotelName").text(productName);
		$("#writeReveiewModal").find(".hotelName").val(productName);
		$("#writeReveiewModal").find("#hotelType").text(rating);
		$("#writeReveiewModal").find(".hotelType").val(rating);
		$("#writeReveiewModal").find("#cityName").text(cityName);
		$("#writeReveiewModal").find(".cityName").val(cityName);
		$("#writeReveiewModal").find("#userID").text(userid);
		$("#writeReveiewModal").find(".userId").val(userid);
		$("#writeReveiewModal").find("#reviewDate").text(Date());
		$("#writeReveiewModal").find(".reviewDate").val(Date());
		
		$("#writeReveiewModal").modal('show');
	});
	
});