<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>MFCWL Demo App</h2>
		</div>
	</div>
	<div id="container">
		<h3>Add a New Student</h3>
		
		<form action="StudentControllerServlet" method="POST"><br/>
		
			<table>
				<tbody>
					<tr>
						<td>First Name:</td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Add Student" /></td>
					</tr>
				</tbody>
			</table>
			
		</form>
		
		<p>
			<a href="StudentControllerServlet">Back to List</a>
		</p>
	
	</div>

</body>
</html>