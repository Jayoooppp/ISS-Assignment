<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login & Registration Form</title>
  <!---Custom CSS File--->
  <link rel="stylesheet" href="style.css">
  <script>
  	

  	
  	const validateSignup = () => {
  		const name = document.querySelector('#name');
  		const email = document.querySelector('#email');
  		const password = document.querySelector('#password');
  		const cPassword = document.querySelector('#cPassword');
  		const emailPattern =  
  		    /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; 
  		const validEmail = emailPattern.test(email.value.trim());
  		console.log(validEmail);
  		
  		if (name.value.trim() === "" || email.value.trim() === "" || password.value.trim() === "" || cPassword.value.trim() === "") {
            alert("Please fill in all fields");
            return false;
        } else if(!validEmail){
        	alert("Please enter valid email id");
        	return false;
        }else if (password.value.length < 8) {
            alert("Password must be at least 8 characters");
            return false;
        } else if (password.value !== cPassword.value) {
            alert("Passwords do not match");
            return false;
        } else {
            return true;
        }
  		
  		return true;
  	}
  
  </script>
</head>
<body>
  <div class="container">
    <div class="form">
      <header>Signup</header>
      <form action="Signup" method="post" onsubmit="return validateSignup();">
      	<input id="name" name="name" type="text" placeholder="Enter your name">
        <input id="email"name="email" type="email" placeholder="Enter your email">
        <input id="password" name="password" type="password" placeholder="Create a password">
        <input id="cPassword" type="password" placeholder="Confirm your password">
        <input type="submit" class="button" value="Signup">
      </form>
      <div class="signup">
        <span class="signup">Already have an account?
         <a href="Login.jsp">Login</a>
        </span>
      </div>
    </div>
    	<%-- Error Message in case signup fails --%>
        <% String error = request.getParameter("error");
           if (error != null && error.equals("1")) { %>
            <p style="color: red; text-align: center;">Registration failed. Please try again.</p>
        <% } %>
  </div>
</body>
</html>