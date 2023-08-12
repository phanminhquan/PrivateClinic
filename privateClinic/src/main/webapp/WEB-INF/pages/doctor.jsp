<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/25/2023
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark " style="background-color: #e9ecef">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">Danh Sách Bác Sĩ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
            </ul>
            <c:url value="/admin/bacsi" var="action"></c:url>
            <form class="d-flex" action="${action}" style="margin-top: 10px">
                <input class="form-control me-2" type="text" name="kw" placeholder="Tìm tên bác sĩ ..">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<section class="container" style="margin-top: 15px">
    <table class="table table-hover" style="border-collapse: collapse;border: 1px solid lightgray">
        <thead>
        <tr style="margin-left: 10px">
            <th style="width: 70px; text-align: center"></th>
            <th style="width: 70px; text-align: center">Mã số</th>
            <th style="width: 150px; text-align: center">Họ và tên</th>
            <th style="width: 120px; text-align: center">Ngày sinh</th>
            <th style="width: 150px; text-align: center">Email</th>
            <th style="width: 100px; text-align: center">Số điện thoại</th>
            <th style="width: 250px; text-align: center">Địa chỉ</th>
            <th style="width: 110px; text-align: center"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${doctor}" var="b">
            <tr>
                <td>
                    <img src="${b.hinhAnh}" alt="${b.hoTen}" style="width: 60px; height: 60px">
                </td>
                <td style="text-align: center">${b.maNv}</td>
                <td style="text-align: center">${b.hoTen}</td>
                <td style="text-align: center">${b.ngaySinh}</td>
                <td style="text-align: center">${b.email}</td>
                <td style="text-align: center">${b.dienThoai}</td>
                <td style="text-align: center">${b.diaChi}</td>
                <td >
                    <c:url value="/api/nhanvien/${b.maNv}" var="apiDel"/>
                    <a href="<c:url value="/admin/bacsi/${b.maNv}" />" class="btn" style="background-color: lightgray">Sửa</a>
                    <button class="btn btn-danger" onclick="delPro('${apiDel}', ${b.maNv})">Xóa</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>
<c:if test="${counter > 1}">
    <ul class="pagination mt-1 justify-content-center">
        <li class="page-item"><a class="page-link" href="<c:url value="/admin/bacsi"/>">Tất cả</a></li>
        <c:forEach begin="1" end="${counter}" var="i">
            <c:url value="/admin/bacsi" var="pageUrl">
                <c:param name="page" value="${i}"></c:param>
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
        </c:forEach>
    </ul>
</c:if>
<script src="/resources/static/js/javscript.js"></script>
