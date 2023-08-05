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
        <a class="navbar-brand" href="javascript:void(0)">Danh sách thuốc</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
            </ul>
            <c:url value="/admin/thuoc" var="action"></c:url>
            <form class="d-flex" action="${action}" >
                <input class="form-control me-2" type="text" name="kw" placeholder="Tìm tên thuốc...">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<section class="container">
    <table class="table table-hover" style="border-collapse: collapse">
        <thead>
        <tr style="margin-left: 10px">
            <th></th>
            <th>Mã thuốc</th>
            <th>Tên thuốc</th>
            <th>Mô tả</th>
            <th>Số lượng</th>
            <th>Giá bán</th>
            <th>Đơn vị</th>
            <th>Trạng thái</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${thuoc}" var="b">
            <tr>
                <td>
                    <img src="${b.hinhAnh}" alt="${b.tenThuoc}" style="width: 50px">
                </td>
                <td>${b.maThuoc}</td>
                <td>${b.tenThuoc}</td>
                <td>${b.moTa}</td>
                <td>${b.soLuong}</td>
                <td>${b.giaBan}</td>
                <td>${b.donVi}</td>
                <td>${b.isActive}</td>
                <td>
                    <c:url value="/api/thuoc/${b.maThuoc}" var="apiDel"/>
                    <a href="<c:url value="/admin/thuoc/${b.maThuoc}" />" class="btn btn-success">Sửa</a>
                    <button class="btn btn-danger" onclick="delPro('${apiDel}', ${b.maThuoc})">Xóa</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>
<c:if test="${counter > 1}">
    <ul class="pagination mt-1 justify-content-center">
        <li class="page-item"><a class="page-link" href="<c:url value="/admin/thuoc"/>">Tất cả</a></li>
        <c:forEach begin="1" end="${counter}" var="i">
            <c:url value="/admin/thuoc" var="pageUrl">
                <c:param name="page" value="${i}"></c:param>
            </c:url>
            <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
        </c:forEach>
    </ul>
</c:if>
<script src="/resources/static/js/javscript.js"></script>
