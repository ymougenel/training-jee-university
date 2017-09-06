<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach items="${users}" var="user">
		 	<tr>
		 		<td>${user.firstName}</td>
				<td>${user.getLastName()}</td>
				<td>${user.adresse == null ? "" : user.adresse.toString()}</td>	 		
          	</tr>
   		</c:forEach>
	</table>

</body>
</html>