<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-sm navbar-dark " style="background-color: #e9ecef">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">Danh sách lịch khám</a>

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
    <div class="input-group" style="margin-top: 30px">
        <form class="d-flex">
            <div class="form-outline">
                <input name="hoTen" type="search" id="form1" class="form-control" placeholder="Họ tên bệnh nhân"/>
            </div>
            <button type="submit" class="btn btn-primary">
                <i class="fas fa-search"></i>
            </button>
        </form>

    </div>
    <table class="table">
        <thead>
        <tr>
            <th style="text-align: center" scope="col">Mã phiếu khám</th>
            <th style="text-align: center" scope="col">Bệnh nhân</th>
            <th style="text-align: center" scope="col">Thời gian</th>
            <th style="text-align: center" scope="col">Ngày khám</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dsToday}" var="d">
            <tr>
                <th style="text-align: center" scope="row">${d[0]}</th>
                <td style="text-align: center">${d[1]}</td>
                <td style="text-align: center">${d[2]}</td>
                <td style="text-align: center">${d[3]}</td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>
