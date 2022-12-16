<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

 <head>
  		<meta charset="ISO-8859-1" />
  		<link href="home.css" rel="stylesheet" type="text/css" />
		
  		<script type="module"
  			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js">
  		</script>
  		<script nomodule
  			src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js">
  		</script>
 		    
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

    </script>
	<style>
			body{
			background-image: url('imgs/bg.jpg');
			background-repeat: no-repeat;
			background-attachment: fixed;
			background-size: cover;
		}
		
		.col-2 h1{
			align-items: center;
			
		}
		img {
		  border-radius: 50%;
		}
		.button {
			  border: 2px;
			  color: white;
			  padding: 16px 32px;
			  text-align: center;
			  text-decoration: none;
			  display: inline-block;
			  font-size: 16px;
			  margin: 8px 10px 6px 160px;
			  transition-duration: 0.4s;
			  cursor: pointer;
			  background-color: var(--theme-blue);
			  width: 45%;
			  border-radius: 10px;
		}
		.button1:hover {
		  background-color: #4CAF50;
		  color: white;
		}
		
	
		.form-input {
		  margin: 2rem 0 2rem 2rem;
		}
		.form-input input {
		  padding: 0.5rem;
		  width: 95%;
		  border-radius: 8px;
		}
		.form-input label {
		  line-height: 1rem;
		}
	</style>

	<script type="text/javascript" src="my.js"></script>
	
  		<title>Update User</title>
</head>


  <body onload="startTime() ; visibility();">
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
          <div class="bi">
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
            padding: 0 20px 0 20px;
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
 	<!-- We use this to write a java code inside a .jsp file -->
	<!-- Get(capture) the data from Profile.jsp -->

	<%
		String id = request.getParameter("id"); //This should be the name given in url param 
		String name = request.getParameter("name");
		String NIC = request.getParameter("NIC");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		
	
	%>

    
    
 	<div style=" border-radius: 10px; padding:20px; margin: 100px 0px 100px 250px;  width:60% ; background:#87CEE; box-shadow: 4px 2px 20px;">
 	<form action="update" method="post" >
		 	  <div class="form-input">	
		 	  				
		 	  			ID    : <br><input type="text" name="id" value="<%=id%>" readonly><br><br>	
						Name  : <input type="text" name="name" value="<%=name%>"><br><br>
						NIC Number    : <input type="text" name="NIC" value="<%=NIC%>"><br><br>
						Phone Number  : <input type="tel" name="phone" value="<%=phone%>"><br><br>
						Email Address : <input type="email" name="email" value="<%=email%>"><br><br>
						UserName      : <input type="text" name="username" value="<%=username%>" readonly><br><br>
						 <input type="text" name="password" value="<%=password%>" hidden>
						User Type     : <input type="text" name="userType" value="<%=userType%>" readonly><br><br>
					
						<button  id="button1"  class="button button1" >Submit</button>
			</div>
					
	</form>
		 
 	</div>

    
  </body>
</html>
