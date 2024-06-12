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
  	
  	const validateLogin = () => {
  		const email = document.querySelector('#email');
        const password = document.querySelector('#password');
        if (email.value.trim() === "" || password.value.trim() === "") {
            alert("Please fill in all fields")
            return false;
        } else {
        	return true;
        }
  	}
  
  
  </script>
</head>
<body>
  <div class="container">
    <div class="login form">
      <header>Login</header>
      <form action="Login" method="post" onsubmit="return  validateLogin();">
        <input id="email" name="email" type="email" placeholder="Enter your email">
        <input id="password" name="password" type="password" placeholder="Enter your password">
        <input type="submit" class="button" value="Login">
      </form>
      <div class="signup">	
        <span class="signup">Don't have an account?
         <a href="Signup.jsp">Signup</a>
        </span>
      </div>
    </div>
    	<%-- Error Message in case login fails --%>
        <% String error = request.getParameter("error");
            if (error != null && error.equals("1")) { %>
                <p style="color: red; text-align: center;">Invalid email or password. Please try again.</p>
        <% } %>
        
        <%-- Success Message after registration--%>
         <% String rs = request.getParameter("signup");
            if (rs != null && rs.equals("success")) { %>
                <p style="color: green;  text-align: center;">Your Registration is Successful. Please Login.</p>
        <% } %>
  </div>
</body>
</html>