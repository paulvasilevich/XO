<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: white
  Date: 02.10.17
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cross(X) * Null(O)</title>
</head>
<body>

<form action="/step" name="step" method="post">
    <table class="gameField">
        <tr>
            <td>
                <c:choose>
                    <c:when test="${not empty value0}">
                        <c:out value="${value0}"/>
                    </c:when>
                    <c:otherwise>
                        <input type="text" name="0">
                    </c:otherwise>
                </c:choose>
            </td>
            <td><c:choose>
                <c:when test="${not empty value1}">
                    <c:out value="${value1}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="1">
                </c:otherwise>
            </c:choose>
            </td>
            <td><c:choose>
                <c:when test="${not empty value2}">
                    <c:out value="${value2}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="2">
                </c:otherwise>
            </c:choose>
            </td>
        </tr>
        <tr>
            <td><c:choose>
                <c:when test="${not empty value3}">
                    <c:out value="${value3}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="3">
                </c:otherwise>
            </c:choose>
            </td>
            <td><c:choose>
                <c:when test="${not empty value4}">
                    <c:out value="${value4}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="4">
                </c:otherwise>
            </c:choose>
            </td>
            <td><c:choose>
                <c:when test="${not empty value5}">
                    <c:out value="${value5}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="5">
                </c:otherwise>
            </c:choose>
            </td>
        </tr>
        <tr>
            <td><c:choose>
                <c:when test="${not empty value6}">
                    <c:out value="${value6}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="6">
                </c:otherwise>
            </c:choose>
            </td>
            <td><c:choose>
                <c:when test="${not empty value7}">
                    <c:out value="${value7}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="7">
                </c:otherwise>
            </c:choose>
            </td>
            <td><c:choose>
                <c:when test="${not empty value8}">
                    <c:out value="${value8}"/>
                </c:when>
                <c:otherwise>
                    <input type="text" name="8">
                </c:otherwise>
            </c:choose>
            </td>
        </tr>
    </table>
    <input type="submit" value="go">
</form>
<form action="/" method="get">
    <input type="submit" value="Next Game" name="next">
</form>

</body>
</html>
