<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 16-08-2017
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spring boot form submit example</title>
</head>
<body>
<h1>spring boot form submit example</h1>
<h2> Details as submitted successfully </h2>
<h4> ${employeeName} </h4>

<form method="post" action="secondPage">
    Enter Employee Name : <input type="text" name="employeeName" value = " ${employeeName} ">
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


</body>
</html>
