<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <% session.getAttribute("userlog");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
     <%@ include file="CSS/global.css"%>
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<header>
		
		<img id="logo" src="img/ims.png">
		<img id="logo2" src="img/face.png">

		<nav class="navbar navbar-dark bg-dark ">
			<a href="welcome.jsp">Home</a>
			<a href="Absence.jsp">Absence</a>
			<a href="LogoutServlet">Log Out</a> 
			<a href="contact.jsp">Contact</a>
		</nav>

	</header>

    
    
    <form action="absenceservlet" method="post">
    <p>choose branch:</p>
    <select name="filière"  id="fil" class="form-control form-control-lg">
        <option value="IMS1">IMS1</option>
        <option value="IMS2" selected>IMS2 </option>
        <option value="IMS3">IMS3</option>
    </select>
    <br>
    <p>choose module:</p>
    
    <select name="Module" id="Mod" class="form-control form-control-lg">
    <option value="JAVA">JAVA</option>
        <option value="PHYTON">PHYTON</option>
        <option value="C++" selected>C++ </option>
        <option value="C#">C#</option>
    </select>
    
    <br>
    <button class="btn btn-primary" type="submit">Add</button>
    </form>
    
   

</body>
</html>