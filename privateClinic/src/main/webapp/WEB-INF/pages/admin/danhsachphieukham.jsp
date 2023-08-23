    <%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/14/2023
  Time: 6:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="container">
    <h1>Danh sách lịch khám</h1>
    <div class="input-group">
        <form>
            <div class="form-outline">
                <input name="hoTen" type="search" id="form1" class="form-control" placeholder="Họ tên bệnh nhân" />
            </div>
            <div class="form-outline">
                <input name="date" type="date" id="form2" class="form-control" />
            </div>
            <button type="submit" class="btn btn-primary">
                <i class="fas fa-search"></i>
            </button>
        </form>

    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Mã phiếu khám</th>
            <th scope="col">Bệnh nhân</th>
            <th scope="col">Thời gian</th>
            <th scope="col">Ngày khám</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ds}" var="d">
            <tr>
                <th scope="row">${d[0]}</th>
                <td>${d[1]}</td>
                <td>${d[2]}</td>
                <td>${d[3]}</td>
                <td>
                    <button class="btn btn-info" onclick="acceptOrDenny(${d[0]},2)" >Xác nhận</button>
                    <button class="btn btn-danger" onclick="acceptOrDenny(${d[0]},3)">Từ chối</button>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>

