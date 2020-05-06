<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.Nurse"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nurse Details</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/nurse.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">

<div class="bgded overlay" style="background-image:url('images/demo/backgrounds/ccc.jpeg');"> 
 
  <div class="wrapper row1">
    <header id="header" class="hoc clear"> 
      
      <div id="logo" class="fl_left">
        <h1><a href="home.html">Health Care</a></h1>
      </div>
   
      <nav id="mainav" class="fl_right">
        <ul class="clear">
          <li class="active"><a href="home.html">Home</a></li>
          <li><a class="#" href="#">Patient</a>
          <li><a href="#">Doctor</a></li>
          <li><a href="nurse.jsp">Nurse</a></li>
          <li><a href="#">Channeling</a></li>
          <li><a href="#">Payment</a></li>
          <li><a href="#">Stock</a></li>
          <li><a href="logn.html">LogIn</a></li>
		<li><a href="sgnup.html">Registration</a></li>
          </ul>
          </li>
        </ul>
      </nav>
      </body>
    </header>
</div>
</body>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Nurse Details</h1>
				<p>Please fill in this form to Nurse details.</p>
				<form id="formNurse" name="formNurse" style="font-weight: bold">
					Nurse Name: <input id="nurse_name" name="nurse_name" type="text"
						placeholder="Enter Nurse Name"
						class="form-control form-control-sm"> 
						<br>Nurse Age:
					<input id="nurse_age" name="nurse_age" type="text"
						placeholder="Enter Nurse Age" class="form-control form-control-sm">
					<br> Nurse Telephone: 
					<input id="nurse_tele" name="nurse_tele"
						type="text" placeholder="Enter valid Telephone"
						class="form-control form-control-sm"> 
						<br> Nurse Email: 
					<input id="nurse_email" name="nurse_email" type="text"
						placeholder="Enter valid Email"
						class="form-control form-control-sm">
						 <br> Nurse Ward: 
						 <input id="nurse_ward" name="nurse_ward" type="text"
						placeholder="Enter Ward Number"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save"
						class="btn btn-primary"> <input type="hidden"
						id="hidnurse_idSave" name="hidnurse_idSave" value="">
				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divNurseGrid">
					<%
						Nurse nurseObj = new Nurse();
					out.print(nurseObj.readNurse());
					%>
				</div>
			</div>
		</div>
	</div>

<div class="wrapper row4 bgded overlay" style="background-image:url('images/demo/backgrounds/footer.jpeg');">
  <footer id="footer" class="hoc clear"> 
  
    <div class="one_quarter first">
      <h6 class="heading">ABOUT US</h6>
      <p>We believe that every person has the right to be treated with utmost respect and consideration. We care about our patients We care about their families who are anxious and concerned. We care about our colleagues and how we as a team provide the best care to our patients. Because we care, we will be sincere, compassionate and sensitive to make a difference in the lives we touch!.</p>
      
    </div>
    <div class="one_quarter">
      <h6 class="heading">Contact Us</h6>
      <ul class="nospace linklist contact">
        <li><i class="fa fa-map-marker"></i>
          <address>
         SLIIT Malabe SriLanka
          </address>
        </li>
        <li><i class="fa fa-phone"></i> +94 712312365<br>
          +94 771234567</li>
        <li><i class="fa fa-fax"></i> +94 752369852</li>
        <li><i class="fa fa-envelope-o"></i> it18055122@my.sliit.lk</li>
      </ul>
    </div>
    <div class="one_quarter">
      <h6 class="heading">QUICK ACCESS</h6>
      <ul class="nospace linklist">
		<li class="active"><a href="home.html">Home</a></li>
        <li><a href="#">Doctor</a></li>
		 <li><a href="#">Patient</a></li>
		 <li><a href="nurse.jsp">Nurse</a></li>
        <li><a href="#">Channeling</a></li>
		<li><a href="#">Payment</a></li>
		
      </ul>
    </div>
  </footer>
</div>
<div class="wrapper row5">
  <div id="copyright" class="hoc clear"> 
    <p class="fl_left">Copyright &copy; 2020 - All Rights Reserved - <a href="#">Gayan Jayasekara</a></p>
   
  </div>
</div>
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="layout/scripts/jquery.min.js"></script>
<script src="layout/scripts/jquery.backtotop.js"></script>
<script src="layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>