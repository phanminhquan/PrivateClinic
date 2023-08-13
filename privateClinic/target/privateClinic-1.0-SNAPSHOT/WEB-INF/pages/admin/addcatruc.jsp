<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/13/2023
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/9/2023
  Time: 8:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container">
    <c:if test="${catruc.maCt != null}">
        <h1>Cập nhật ca ca trực</h1>
    </c:if>

    <c:if test="${erroWhileAdding != null}">
        <div class="alert alert-danger">
            <strong>Danger!</strong> ${erroWhileAdding}
        </div>
    </c:if>

    <c:url value="/admin/catruc/addct" var="action"/>

    <form:form modelAttribute="catruc" action="${action}" method="post" enctype="multipart/form-data">
        <form:hidden path="maCt"/>
        <div class="cs-form">
            <label for="start">Giờ bắt đầu</label>
            <form:input type="time" class="form-control" id="start"  path="gioTruc"/>
        </div>
        <div class="cs-form">
            <label for="end">Giờ kết thúc</label>
            <form:input type="time" class="form-control" id="end"  path="gioKetThuc"/>
        </div>
        <button type="submit" class="btn-success btn">Thêm</button>

    </form:form>
</section>
