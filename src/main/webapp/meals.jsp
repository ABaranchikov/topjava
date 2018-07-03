<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Meals list</title>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a></h3>
    <table cellpadding="8" cellspacing="1">
        <caption><h2>Список еды</h2></caption>
        <tr>
            <th>Дата</th>
            <th>Описание</th>
            <th>Калории</th>
        </tr>
        <jsp:useBean id="mealList" scope="request" type="java.util.List"/>
        <c:forEach var="meal" items="${mealList}">
            ${meal.isExceed()?  ' <tr class="exceeded">': '<tr class="notExceeded">'}
                <td>${TimeUtil.dateToString(meal.getDateTime())}</td>
                <td>${meal.getDescription()}</td>
                <td>${meal.getCalories()}</td>
        </c:forEach>
    </table>
</section>
</body>
</html>