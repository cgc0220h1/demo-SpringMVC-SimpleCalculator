<%--
  Created by IntelliJ IDEA.
  User: kimhi
  Date: 30/05/2020
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Simple Calculator</title>
    <style>
        button {
            width: 100px;
        }

        .text-input {
            width: 200px;
            height: 100px;
        }
    </style>
</head>
<body>
<h1>Calculator</h1>
<form method="post">
    <div class="text-input">
        <label for="operand1">Operand 1</label>
        <input type="number" id="operand1" name="operand">
        <label for="operand2">Operand 2</label>
        <input type="number" id="operand2" name="operand">
    </div>
    <div class="bullet-button">
        <button type="submit" value="add" name="operator">Add (+)</button>
        <button type="submit" value="subtract" name="operator">Subtract (-)</button>
        <button type="submit" value="multiply" name="operator">Multiply (*)</button>
        <button type="submit" value="divide" name="operator">Divide (/)</button>
    </div>
</form>
<c:if test="${result != null}">
    Result: ${result}
</c:if>
</body>
</html>
