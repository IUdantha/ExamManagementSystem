<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
    <link href="home.css" rel="stylesheet" type="text/css" />
	<link href="login.css" rel="stylesheet" type="text/css" />
    <title>View Seat</title>
    <style>
		.year{
			width:100%;
			height: 30px;
		}
		.fac{
			width:100%;
			height: 30px;
		}
		
		.button {
			  border: 2px;
			  color: white;
			  padding: 10px 10px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 14px;
			  margin: 10px 16px;
			  transition-duration: 0.4s;
			  cursor: pointer;
			  background-color:var(--theme-blue);
			  width: 13%;
			 
		}
		.button1:hover {
		  background-color: #4CAF50;
		  color: white;
		}
		
		.button2:hover {
		  background-color: #f44336;
		  color: white;
		}
	</style>
	<!-- <script src="my.js"></script>-->
	
    
    <script>
    function Function1() {
		 var user = '${userType}';
		 
		 if(user == "std"){
			 window.open("viewQuestion.jsp","_self");
		 }
		 
		 else if(user == "lec"){
			 window.open("ExamLec.jsp","_self");
		 }
		 
		 else if(user == "examDep"){
			 window.open("ExamLec.jsp","_self");
		 }
		 
	}
	
function Function2() {
	 var user = '${userType}';
	 
	 if(user == "std"){
		 window.open("viewQuestion.jsp","_self");
	 }
	 
	 else if(user == "lec"){
		 window.open("ExamLec.jsp","_self");
	 }
	 
	 else if(user == "examDep"){
		 window.open("ExamLec.jsp","_self");
	 }
}
function Function3() {
		 var user = '${userType}';
		 
		 if(user == "std"){
			 window.open("uploadInquiry.jsp","_self");
		 }
		 
		 else if(user == "lec"){
			 window.open("viewInquiry.jsp","_self");
		 }
		 
		 else if(user == "examDep"){
			 window.open("viewInquiry.jsp","_self");
		 }
		 
}

	//Function for button visibility
	function visibility() {
			 var user = '${userType}';
			 
			 if(user == "std"){
				  document.getElementById('button1').style.visibility = 'hidden';
				  document.getElementById('button2').style.visibility = 'hidden';
			 }
			 
			 else if(user == "lec"){
				 document.getElementById('button1').style.visibility = 'hidden';
				 document.getElementById('button2').style.visibility = 'hidden';
			 }
			 
			 else if(user == "examDep"){
				 document.getElementById('button1').style.visibility = 'visible';
				 document.getElementById('button2').style.visibility = 'visible';
			 }
			 
	}

 		</script>
</head>

  <body onload="startTime(); visibility();">
    <header>
      <div class="upnav">
        <div class="logo">
          <a href="Home.jsp">
            <h1 id="lgo">WEBEXAM</h1>
          </a>
        </div>

        <div class="searchLogin">
          <div class="search-container">
            <input type="search" placeholder="Search" id="searchbox" />
          </div>
          <div class="bi bi-bell">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="45"
              height="45"
              fill="currentColor"
              class="bi bi-bell"
              viewBox="0 0 16 16"
            >
              <path
                d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"
              />
            </svg>
          </div>
          <div class="lgn">
             <a href="Profile.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
              </svg></a>
          </div>
          <div class="lgn-out">
             <a href="login.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="45" height="45" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
              </svg></a>
          </div>
        </div>
      </div>
      <nav>
        <div>
          <ul class="menu">
            <li><a href="Home.jsp">Dashboard</a></li>
            <li><a href="javascript:Function1();">Examinations</a></li>
            <li><a href="javascript:Function2();">Practice test</a></li>
            <li><a href="javascript:Function3();">Inquiries</a></li>
          </ul>
        </div>
   		<div  style="color:white; float:right; margin-left:400px ; font-family: Arial, sans-serif;" >
        	<h3>${uid}</h3>
        </div>
        <div
          id="time"
          class="hbl"
          style="
            background-color: #7995ca;
            float: right;
            padding: 0 10px 0 10px;
          "
        >
          <a
            id="timetxt"
            style="font-weight: 100; font-size: 20px; color: #fff"
          >
          </a>
          <script>
            function startTime() {
              const today = new Date();
              let h = today.getHours();
              let m = today.getMinutes();
              let s = today.getSeconds();
              m = checkTime(m);
              s = checkTime(s);
              document.getElementById("timetxt").innerHTML =
                h + ":" + m + ":" + s;
              setTimeout(startTime, 1000);
            }
            function checkTime(i) {
              if (i < 10) {
                i = "0" + i;
              } // add zero in front of numbers < 10
              return i;
            }
          </script>
        </div>
      </nav>
    </header>
    
	<br><br><br>
	
	<!-- Timetable -->
	
   <div class="login-box">
        <div class="heading">View Seats</div>
        <form name="formal" method="post" action="Viewsa" autocomplete="off">

        <div class="form-input">
            <label for="Select">Faculty</label><br>

            <select name="faculty" class="fac">
                <option hidden disable>Select One</option>
                <option value="Computing">Computing</option>
                <option value="Business">Business</option>
                <option value="Engineering">Engineering</option>
                
            </select>

        </div>
        
     <div class="form-input">
            <label for="Select">Year</label><br>

            <select name="year" class="year">
                <option hidden disable>Select One</option>
                <option value="Year1">Year 1</option>
                <option value="Year2">Year 2</option>
                <option value="Year3">Year 3</option>
                <option value="Year4">Year 4</option>
                
            </select>

        </div>
       
        <button id="sbt-btn">Submit</button>
      
       
        </form>

    </div>

	<c:forEach var="seat" items="${seatDetails}"> 
	
	
	
		 	<!-- Assign data to variables -->
			<c:set var="id" value="${seat.saID}"/>
			<c:set var="faculty" value="${seat.faculty}"/>
			<c:set var="year" value="${seat.year}"/>
			<c:set var="filename" value="${seat.filename}"/>
			
			
			<!-- Give the page name we need to redirect the data into -->
			<c:url value="updateSeat.jsp" var = "seatUpdate">
			
			<!-- Pass the data through the url -->
				<c:param name="id" value="${id}"/> <!-- Give the variable name -->
				<c:param name="faculty" value="${faculty}"/>
				<c:param name="year" value="${year}"/>
				<c:param name="filename" value="${filename}"/>

				
			</c:url>
			<!-- Give the above variable name -->
		
			
			<c:url value="deleteSeat.jsp" var = "seatDelete">
			
			<!-- Pass the data through the url -->
				<c:param name="id" value="${id}"/> <!-- Give the variable name -->
				<c:param name="faculty" value="${faculty}"/>
				<c:param name="year" value="${year}"/>
				<c:param name="filename" value="${filename}"/>
				
				
			</c:url>
		
	<!-- The name given in set attribute in servlet file -->
			<center><a href="${seatUpdate}">
				<button  id="button1"  class="button button1" >EDIT</button>
			</a>
			<a href="${seatDelete}">
				<button  id="button2" class="button button2">DELETE</button>
			</a></center>
			
		<h3>Faculty   :  ${seat.faculty} <br/><!-- It calls the getters -->
		Year      :  ${seat.year} <br/></h3>
		<br><br>
		<h3>Seat Arrangements :</h3>
		<iframe src="seat/${seat.filename}" width="100%" height="600px">
   		</iframe>
	
			
		
	</c:forEach> 
    
  </body>

</html>