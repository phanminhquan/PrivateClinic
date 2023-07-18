<%-- 
    Document   : index
    Created on : Jul 12, 2023, 1:43:08 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chu ne</title>
    </head>
    <body>
        <h1>Hello World hahaha !</h1>
        <ul>
            <c:forEach items="${thuoc}" var="p">
                <li>${p.maThuoc} - ${p.tenThuoc} - ${p.donVi}</li>
            </c:forEach>
        </ul>


    </body>
</html>
