<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="container">
    <h1>Danh sách lịch khám</h1>
    <div class="input-group">
        <form>
            <div class="form-outline">
                <input name="hoTen" type="search" id="form1" class="form-control" placeholder="Họ tên bệnh nhân" />
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

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dsToday}" var="d">
            <tr>
                <th scope="row">${d[0]}</th>
                <td>${d[1]}</td>
                <td>${d[2]}</td>
                <td>${d[3]}</td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>
