<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form name="userRegForm" method="POST">
		<center>
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><input type="text" name="userAge"></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><select name="userGender"><option value="Male">Male</option>
							<option value="Female">Female</option></select></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="userEmail"></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="userAddr"></td>
				</tr>
				<tr>
					<td></td>
					<td>
					<input type="radio" name="insertType" value="Insert" checked>Insert
					<input type="radio" name="insertType" value="StoredProcedure">Stored Procedure
					
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" name="saveButton" value="Register"
						style="background-color: blue;" onclick="saveUserRec()"></td>
				</tr>
			</table>
		</center>
	</form>

	<script>
		function saveUserRec() {
			document.userRegForm.action = "./saveUserDetails";
			document.userRegForm.submit();
		}
	</script>
</body>
</html>