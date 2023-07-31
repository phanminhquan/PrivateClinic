<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/29/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<c:url value="/admin/yta" var="action"/>
<form:form modelAttribute="yta" action="${action}" method="post" enctype="multipart/form-data">
    <form:hidden path="maNv" />
    <form:hidden path="hinhAnh" />
    <div class="card-body">
        <div class="row">
            <div class="col-md-6" style="margin-top: 20px">
                <div class="form-group">
                    <label style="margin-left: 10px">Họ tên</label>
                    <form:input type="text" name="hoTen" class="form-control" placeholder="Nhập tên y tá" path="hoTen"/>
                </div>
            </div>

            <div class="col-md-6" style="margin-top: 20px">
                <div class="form-group">
                    <label style="margin-left: 10px">Email</label>
                    <form:input type="text" name="email" class="form-control" placeholder="Nhập Email" path="email"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6" style="margin-top: 20px">
                <div class="form-group">
                    <label style="margin-left: 10px">Ngày sinh</label>
<%--                    <fmt:formatDate value="${yta.ngaySinh}" pattern="dd/MM/yyyy" var="dateString"/>--%>
                    <form:input type="date" name="ngaySinh" class="form-control" path="ngaySinh"/>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group" style="margin-top: 20px">
                    <label style="margin-left: 10px">Số điện Thoại</label>
                    <form:input type="number" name="dienThoai" class="form-control" path="dienThoai"/>
                </div>
            </div>
        </div>

        <div class="form-group" style="margin-top: 20px">
            <label style="margin-left: 10px">Địa chỉ</label>
            <form:textarea name="diaChi" class="form-control" path="diaChi"/>
        </div>

        <div class="form-group" style="margin-top: 20px">
            <label style="margin-left: 10px">Avatar</label>
            <form:input type="file" class="form-control" id="upload" path="file"/>
        </div>
    </div>
    <div class="card-footer" style="margin-top: 20px">
        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${yta.maNv == null}">Thêm mới</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
