<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="thirdPage">
    Enter Employee Name : <input type="text" name="name" value = "${employeeName}"/>
    <br>
    Enter Employee Email Address1: <input type="text" name="address" value = "${employeeEmail1}">
    Enter Employee Email Address2: <input type="text" name="addressasdas" value = "${employeeEmail2}">
    Enter Employee Email Address3: <input type="text" name="employeeEmail3" value = "${employeeEmail3}">
    Enter Employee Email Address4: <input type="text" name="employeeEmail4" value = "${employeeEmail4}">
    Enter Employee Email Address5: <input type="text" name="employeeEmail5" value = "${employeeEmail5}">
    <br>
    <input type="submit" value="Submit">
</form>


<h4> ${employeeEmail1} </h4>
<h4> ${employeeEmail2} </h4>
<h4> ${employeeEmail3} </h4>
<h4> ${employeeEmail4} </h4>
<h4> ${employeeEmail5} </h4>
<h4> ${employeeEmail6} </h4>


</body>
</html>