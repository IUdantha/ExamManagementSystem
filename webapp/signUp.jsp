<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
    <link href="home.css" rel="stylesheet" type="text/css" />
	<link href="login.css" rel="stylesheet" type="text/css" />
    <title>SignUp</title>
    

</head>

  <body onload="startTime()">
    <header>
      <div class="upnav">
        <div class="logo">
          <a href="#">
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
            <button id="loginbtn">Log-in | Sign Up</button>
          </div>
        </div>
      </div>
      
    </header>
    
	<br><br><br>
   <div class="login-box">
        <div class="heading">SIGN UP</div>
        <form name="formal" method="post" action="insert" autocomplete="off">
           <div class="form-input">
            	<label for="Name">Full Name</label>
           		<div>
                	<input type="text" id="name" name="name" placeholder="Enter your Full Name" required/>
            	</div>
           </div>
           <div class="form-input">
            	<label for="NIC">NIC Number</label>
            	<div>
                	<input type="text" id="NIC" name="NIC" placeholder="Enter your NIC number" required/>
            	</div>
           </div>
           <div class="form-input">
            	<label for="phoneNo">Phone Number</label>
            	<div>
                	<input type="tel" id="phone" name="phone" placeholder="Enter your phone number"/>
            	</div>
           </div>
            <div class="form-input">
            	<label for="email">Email</label>
            	<div>
                	<input type="email" id="email" name="email" placeholder="Enter your Email"/>
            	</div>
           </div>
           <div class="form-input">
            	
            	<label for="username">Username (ID Number)</label>
            	<span id="username-error" style="color: red;"></span>
            		<div>
                		<input type="text" id="username" name="uid" placeholder="Enter your Username" pattern="[A-Za-z]{2}[0-9]{8}" required/>
            		</div>
        	</div>
        <div class="form-input">
            <label for="password">Password</label>
            <div>
                <input type="password" id="password" name="psw" placeholder="Enter your password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" required/>
            </div>
        </div>
        <div class="form-input">
            <label for="Select">User Type</label><br>

            <select name="userType" class="userType">
                <option hidden disable>Select One</option>
                <option value="std">Student</option>
                <option value="lec">Lecturer</option>
                <option value="examDep">Exam Department</option>
                
            </select>

        </div>
        <div class="row" id="remember-forget">
            <div>
                <input type="checkbox" name="remember-me" id="remember-me">
                <label for="remember-me">Remember me</label>
            </div>
         
        </div>
        <div id="register" hidden>
            <div class="form-input">
                <label for="confirm-password">Confirm Password</label>
                <div>
                    <input type="password" id="confirm-password" placeholder="Enter your password"/>
                </div>
            </div>
            <div class="form-errors">
                <ul id="error-list">
                </ul>
            </div>
        </div>
        <button name="submit" id="login-btn">SIGN UP</button>
        
        <a href="signUp.jsp" hidden><button id="show-register-form-btn">CREATE NEW ACCOUNT</button></a>
       
        </form>
         <a href="login.jsp"><button id="show-login-form-btn">Already have and Account? LOGIN</button></a>

    </div>
    
  </body>

</html>