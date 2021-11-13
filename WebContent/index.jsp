<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join us</title>




	<!--Custom styles-->
	<style>
     <%@ include file="CSS/style.css"%>
     
</style>
<script ><%@ include file="javascript/style.js"%></script>
	

</head>
<body>
  <div class="overlay">
<!-- LOGN IN FORM  -->
<form action="LoginServlet" method="post">
   <!--   con = Container  for items in the form-->
   <div class="con">
   <!--     Start  header Content  -->
   <header class="head-form">
      <h2>Log In</h2>
      <!--     A welcome message or an explanation of the login form -->
      <p>login here using your username and password</p>
   </header>
   <!--     End  header Content  -->
   <br>
   <div class="field-set">
     
      <!--   user name -->
         <span class="input-item">
           <i class="fa fa-user-circle"></i>
         </span>
        <!--   user name Input-->
         <input class="form-input" id="txt-input" type="text" placeholder="@UserName" name="name" required>
     
      <br>
     
           <!--   Password -->
     
      <span class="input-item">
        <i class="fa fa-key"></i>
       </span>
      <!--   Password Input-->
      <input class="form-input" type="password" placeholder="Password" id="pwd"  name="password" required>
     

     
     
      <br>
<!--        buttons -->
<!--      button LogIn -->
      <button type="submit" class="log-in"> Log In </button>
   </div>
  
<!--   other buttons -->
   <div class="other">
<!--      Forgot Password button-->
      <a href="ForgetPassWord.jsp" >Forgot Password</a>
<!--     Sign Up button -->
      <a href="Registration.jsp" >Sign Up 
<!--         Sign Up font icon -->
      
      </a>
<!--      End Other the Division -->
   </div>
     
<!--   End Conrainer  -->
  </div>
  
  <!-- End Form -->
</form>
</div>
</body>
</html>