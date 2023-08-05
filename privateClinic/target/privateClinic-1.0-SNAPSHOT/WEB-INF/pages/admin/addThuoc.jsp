<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7/29/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)">Quản lý thuốc</a>

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
<c:url value="/admin/thuoc" var="action"/>
<form:form modelAttribute="thuoc" action="${action}" method="post" enctype="multipart/form-data">
    <form:hidden path="maThuoc"/>
    <form:hidden path="hinhAnh"/>
    <div class="card-body">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Tên Thuốc</label>
                    <form:input type="text" name="tenThuoc" class="form-control" placeholder="Nhập tên thuốc"
                                path="tenThuoc"/>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label>Số lượng</label>
                    <form:input type="number" name="soLuong" class="form-control" placeholder="Nhập số lượng"
                                path="soLuong"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Giá bán</label>
                    <form:input type="number" name="giaBan" class="form-control" path="giaBan"/>
                </div>
            </div>

            <div class="col-md-6">
                <div class="form-group">
                    <label>Đơn vị</label>
                    <form:input type="text" name="donVi" class="form-control" path="donVi"/>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label>Mô Tả </label>
            <form:textarea name="moTa" class="form-control" path="moTa"/>
        </div>

        <div class="form-group">
            <label>Ảnh Sản Phẩm</label>
            <form:input type="file" class="form-control" id="upload" path="file"/>
        </div>
        <div class="form-group">
            <label>Kích hoạt </label>
            <form:select class="form-select" id="thuoc" name="isActive" path="isActive">
                <option value="1" selected>True</option>
                <option value="0">False</option>
            </form:select>
        </div>

    </div>

    <div class="card-footer" style="margin-top: 20px">
        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${thuoc.maThuoc == null}">Thêm mới</c:when>
                <c:otherwise>Cập nhật</c:otherwise>
            </c:choose>
        </button>
    </div>
</form:form>
