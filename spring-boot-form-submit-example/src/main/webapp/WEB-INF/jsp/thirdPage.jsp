<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<H2>Thirrrrrrrrrrrrrrd PAge</H2>
<c:set var="stats1" value="${info2}" />
${stats1 }

<br>
<c:set var="stats" value="${info}" /> 
Name : ${ stats.get(0)} <br>
Address : ${ stats.get(1)} 

 
<%-- <form method="post" action="fourthPage">
    Enter Employee Name : <input type="text" name="name" value = "${employeeName}"/>
    <br>
    Enter Employee Email Address1: <input type="text" name="employeeEmail1" value = "${employeeEmail1}">
    Enter Employee Email Address2: <input type="text" name="employeeEmail2" value = "${employeeEmail2}">
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
 --%>
</body>
</html>