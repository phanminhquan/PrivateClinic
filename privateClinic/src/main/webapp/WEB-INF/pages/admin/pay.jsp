<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/15/2023
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.

--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark " style="background-color: #e9ecef">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">Danh sách phiếu khám
            chưa thanh toán</a>

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
    <form style="margin-top: 30px">
        <div class="d-flex gap-3">
            <input class="form-control" type="text" name="maPK" placeholder="Mã phiếu khám">
            <input class="form-control" type="text" name="hoTen" placeholder="Tên bệnh nhân">
            <input class="form-control" type="date" name="date">
            <button class="btn btn-primary" type="submit">Tìm</button>
        </div>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th style="text-align: center" scope="col">Mã phiếu khán</th>
            <th style="text-align: center" scope="col">Họ tên bệnh nhân</th>
            <th style="text-align: center" scope="col">Ngày khám</th>
            <th style="text-align: center" scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${listPK}">
            <tr>
                <th style="text-align: center" scope="row">${i[0]}</th>
                <td style="text-align: center">${i[1]}</td>
                <td style="text-align: center">${i[2]}</td>
                <td style="text-align: center">
                    <a href="/admin/pheiukham/${i[0]}" class="btn-info btn">Xem chi tiết</a>
                    <a onclick="pay(${i[0]})" class="btn-success btn">Thanh toán</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>
