<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/6/2023
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-sm navbar-dark " style="background-color: #e9ecef">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">ĐĂNG KÝ TÀI KHOẢN</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
            </ul>
        </div>
    </div>
</nav>
<section class="container" >
    <div class="container" >

        <div class=" text-black">
            <div class="align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
                <c:if test="${error != null}">
                    <div class="alert alert-danger">
                            ${error}
                    </div>
                </c:if>
                <c:if test="${duplicateErro != null}">
                    <div class="alert alert-danger">
                            ${duplicateErro}
                    </div>
                </c:if>
                <c:url value="/admin/register" var="action"></c:url>
                <form:form cssStyle="margin-left: 20%; width: 50%" modelAttribute="dangki" method="post" action="${action}" enctype="multipart/form-data">
                    <form:hidden path="id"/>
                    <form:hidden path="avatar"/>
                    <div class="form-group">
                        <labe for="name"> Họ và tên</labe>
                        <form:input type="text" id="name" name="name" class="form-control" path="name"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="username"> Tên đăng nhập</labe>
                        <form:input type="text" id="username" name="username" class="form-control" path="username"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="password"> Mật khẩu</labe>
                        <form:input type="password" id="password" name="password" class="form-control" path="password"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="confirmPassword"> Nhập lại mật khẩu</labe>
                        <form:input type="password" id="confirmPassword" name="confirmPassword" class="form-control"
                                    path="confirmPassword"/>
                    </div>
                    <div class="form-group" style="margin-top: 20px">
                        <label >Avatar</label>
                        <form:input type="file" class="form-control" id="upload" path="file"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <label>Quyền đăng nhập </label>
                        <form:select class="form-select" id="userRole" name="userRole" path="userRole">
                            <option value="DOCTOR">Bác sĩ</option>
                            <option value="NURSE">Y tá</option>
                            <option value="STAFF">Bệnh nhân</option>
                        </form:select>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <label>Trạng thái </label>
                        <form:select class="form-select" id="isActive" name="isActive" path="isActive">
                            <option value="true">Bật</option>
                            <option value="false">Tắt</option>
                        </form:select>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="username"> Mã nhân viên</labe>
                        <form:input type="text" placeholder="Nhập mã nhân viên muốn liên kết" class="form-control"
                                    path="maNv"/>
                    </div>
                    <div class="pt-1 mb-2" style="margin-top: 15px">
                        <button class="btn btn-info btn-block" type="submit">Đăng ký</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>


</section>

