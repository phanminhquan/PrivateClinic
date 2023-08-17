<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/4/2023
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1 class="text-center">Ca trực nhân viên</h1>

<section class="container">
    <h3 class="text-danger"> Chú thích</h3>
    <br>
    <a href="/admin/addcatruc" class="btn-success btn">Thêm ca trực</a>
    <br>
    <c:forEach items="${listCaTruc}" var="c">

        <div class="alert alert-primary d-flex" role="alert">
            <div>
                Ca ${c.maCt}: Bắt đầu từ  ${c.gioTruc}h, kết thúc lúc ${c.gioKetThuc}h.
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
            <th></th>
            <th scope="col">Ngày làm việc</th>
            <th scope="col" >Các ca trực</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${date}" var="d" varStatus="loop">
            <tr>
                <td>
                    <a href="/catruc/edit/${d.id}" class="btn-info btn">Sửa</a>
                </td>
                <td>${d.dateOfWeek}</td>
                <td>
                    <c:forEach items="${list[loop.index]}" var="l">
                        <a href="/catruc/${l.maCt}" class="btn-success btn">Ca ${l.maCt}</a>
                    </c:forEach>
                </td>

            </tr>
        </c:forEach>


        </tbody>
    </table>
</section>
<script src="/resources/static/js/javscript.js"></script>

