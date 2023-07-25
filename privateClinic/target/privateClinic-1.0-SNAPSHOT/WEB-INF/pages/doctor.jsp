<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/23/2023
  Time: 2:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Quản lý bác sĩ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <c:forEach items="${chuyenmon}" var="c">
                    <li class="nav-item">
                        <a class="nav-link" href="javascript:void(0)">${c}</a>
                    </li>
                </c:forEach>


            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-primary" type="button">Search</button>
            </form>
        </div>
    </div>
</nav>


<section class="container">
    <br>
    <a class="btn btn-info">Thêm</a>
    <br><br>
    <h2 class="text-center">DANH SÁCH BÁC SĨ</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th></th>
            <th>Mã bác sĩ</th>
            <th>Họ và tên</th>
            <th>Chuyên môn</th>
            <th>Chứng chỉ</th>
            <th>Ngày sinh</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach items="${bacsi}" var="b">
                <td>
                    <img src="${b[8]}" alt="${b[3]}" style="width: 50px">
                </td>
                <td>${b[0]}</td>
                <td>${b[3]}</td>
                <td>${b[2]}</td>
                <td>${b[1]}</td>
                <td>${b[5]}</td>
                <td>${b[4]}</td>
                <td>${b[7]}</td>
                <td>${b[6]}</td>
                <td>
                    <a class="btn btn-success">Sửa</a>
                    <a class="btn btn-danger">Xóa</a>
                </td>
            </c:forEach>

            
        </tr>
        </tbody>
    </table>
</section>
