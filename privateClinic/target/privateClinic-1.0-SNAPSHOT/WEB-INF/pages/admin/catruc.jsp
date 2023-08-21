<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/4/2023
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <br>
    <h5 class="text-danger"> Chú thích</h5>
    <c:forEach items="${listCaTruc}" var="c">

        <div class="alert alert-primary d-flex" role="alert">
            <div>
                Ca ${c.maCt}: Bắt đầu từ ${c.gioTruc}h, kết thúc lúc ${c.gioKetThuc}h.
            </div>
                <%--            <div class="d-flex me-auto" style="flex:auto;flex-direction: row-reverse;">--%>
                <%--                <a class="btn btn-info" href="/admin/addcatruc/${c.maCt}">Sửa</a>--%>
                <%--                <a class="btn btn-danger" onclick="delCaTruc(${c.maCt})">Xóa</a>--%>
                <%--            </div>--%>
        </div>
    </c:forEach>
    <table class="table">
        <thead>
        <tr>
            <th style="width: 100px; text-align: center"></th>
            <th scope="col" style="width: 300px; text-align: center">Ngày làm việc</th>
            <th scope="col" style="text-align: center">Các ca trực</th>

        </tr>
        </thead>
        <tbody>
            <c:forEach items="${date}" var="d" varStatus="loop">
            <tr>
                <td style="text-align: center">
                    <a href="/catruc/edit/${d.id}" class="btn-info btn">Sửa</a>
                </td>
                <td style="text-align: center">${d.dateOfWeek}</td>
                <td style="text-align: center">
                    <c:forEach items="${list[loop.index]}" var="l">
                        <a href="/catruc/${d.id}/${l.maCt}" class="btn-success btn">Ca ${l.maCt}</a>
                    </c:forEach>
                </td>

            </tr>
        </c:forEach>


        </tbody>
    </table>
</section>
<script src="/resources/static/js/javscript.js"></script>

