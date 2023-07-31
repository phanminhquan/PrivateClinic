<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/25/2023
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Quản lý y tá</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="text" placeholder="Search">
                <button class="btn btn-primary" type="button">Search</button>
            </form>
        </div>
    </div>
</nav>
<section class="container">
    <table class="table table-hover" style="border-collapse: collapse">
        <thead>
        <tr style="margin-left: 10px">
            <th></th>
            <th>Mã y tá</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${yta}" var="b">
            <tr>
                <td>
                    <img src="${b.hinhAnh}" alt="${b.hoTen}" style="width: 50px">
                </td>
                <td>${b.maNv}</td>
                <td>${b.hoTen}</td>
                <td>${b.ngaySinh}</td>
                <td>${b.email}</td>
                <td>${b.dienThoai}</td>
                <td>${b.diaChi}</td>
                <td>
                    <c:url value="admin/yta/${b.maNv}" var="apiDel"/>
                    <a href="<c:url value="/admin/yta/${b.maNv}" />" class="btn btn-success">Sửa</a>
                    <button class="btn btn-danger" onclick="delPro('${apiDel}', ${b.maNv})">Xóa</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>