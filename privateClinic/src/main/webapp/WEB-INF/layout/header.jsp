<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/22/2023
  Time: 2:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="sb-topnav navbar navbar-expand navbar-dark text-bg-primary">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="index.html">Private Clinic</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
            class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4 me-auto">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
               aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li>
                    <hr class="dropdown-divider"/>
                </li>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li class="nav-item active">
                        <a class="nav-link text-danger" href="/admin/login">Đăng nhập</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-danger" href="/admin/register">Đăng xuất</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="nav-item active">
                        <a class="nav-link text-danger" href="/">${pageContext.request.userPrincipal.name}</a>
                    </li>
                    <li><a class="dropdown-item" href="<c:url value="/logout"/>">Logout</a></li>
                </c:if>


            </ul>
        </li>
    </ul>
</nav>


