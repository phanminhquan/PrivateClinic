<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/15/2023
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.

--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="container">
    <h1>DANH SÁCH CÁC PHIẾU KHÁM CHƯA THANH TOÁN</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã phiếu khán</th>
            <th scope="col">Họ tên bệnh nhân</th>
            <th scope="col">Ngày khám</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${listPK}">
            <tr>
                <th scope="row">${i[0]}</th>
                <td>${i[1]}</td>
                <td>${i[2]}</td>
                <td>
                    <a class="btn-info btn">Xem chi tiết</a>
                    <a href="/pay" class="btn-success btn">Thanh toán</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>
