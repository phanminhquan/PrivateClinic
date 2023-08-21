<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/5/2023
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    $(function () {
        let maNv = [];
        <c:forEach items="${allMaNv}" var="maNv" >
        maNv.push(${maNv}+"")
        </c:forEach>
        $("#maNV").autocomplete({
            source: maNv
        });
    });
    $(function () {
        let nameList = [];
        <c:forEach items="${allName}" var="name" >
        nameList.push("${name}")
        </c:forEach>
        $("#name").autocomplete({
            source: nameList
        });
    });


</script>
<nav class="navbar navbar-expand-sm navbar-dark " style="background-color: #e9ecef">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">Ca trực nhân viên</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
            </ul>
        </div>
    </div>
</nav>
<section class="container">
    <form autocomplete="off" class="d-flex">
        <div class="mb-3">
            <label for="maNV" class="form-label">Mã nhân viên</label>
            <input style="position: relative; width: 400px" type="text" class="form-control" id="maNV" name="maNv">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Tên nhân viên</label>
            <input style="width: 400px; margin-left: 30px" type="text" class="form-control" id="name" name="tenNv">
        </div>

        <button type="submit" class="btn btn-primary" style="height: 10%; margin-top: 30px;margin-left: 20px">Tìm
        </button>
    </form>

    <table class="table table-hover" style="border-collapse: collapse">
        <thead>
        <tr style="margin-left: 10px">
            <th style="text-align: center">Mã</th>
            <th style="text-align: center">Họ và tên</th>
            <th style="text-align: center">Ngày sinh</th>
            <th style="text-align: center">Email</th>
            <th style="text-align: center">Số điện thoại</th>
            <th style="text-align: center">Địa chỉ</th>
            <th style="text-align: center">Chức vụ</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allSearchlistNV}" var="b">
            <tr>
                <td style="text-align: center">${b[0]}</td>
                <td style="text-align: center">${b[1]}</td>
                <td style="text-align: center">${b[2]}</td>
                <td style="text-align: center">${b[3]}</td>
                <td style="text-align: center">${b[4]}</td>
                <td style="text-align: center">${b[5]}</td>
                <td style="text-align: center">${b[6]}</td>
                <td style="text-align: center">
                    <button class="btn btn-success" onclick="addToCaTruc(${b[0]},${idCaTruc})">Thêm</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <br>
    <nav class="navbar navbar-expand-sm navbar-dark " style="background-color: #e9ecef">
        <div class="container-fluid">
            <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">Danh sách nhân viên
                trong ca trực</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar2">
                <ul class="navbar-nav me-auto">
                </ul>
            </div>
        </div>
    </nav>
    <table class="table">
        <thead>
        <tr>
            <th></th>
            <th style="text-align: center" scope="col">Mã nhân viên</th>
            <th style="text-align: center" scope="col">Họ và tên nhân viên</th>
            <th style="text-align: center" scope="col">Số điện thoại</th>
            <th style="text-align: center" scope="col">Email</th>
            <th style="text-align: center" scope="col">Chức vụ</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${listNhanVien}" var="l">
            <tr>
                <th scope="row">
                    <button class="btn-danger btn" onclick="delStaffFromShift('${l[5]}')">X</button>
                </th>
                <td style="text-align: center">${l[0]}</td>
                <td style="text-align: center">${l[1]}</td>
                <td style="text-align: center">${l[2]}</td>
                <td style="text-align: center">${l[3]}</td>
                <td style="text-align: center">${l[4]}</td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
</section>
<script src="/resources/static/js/javscript.js"></script>


