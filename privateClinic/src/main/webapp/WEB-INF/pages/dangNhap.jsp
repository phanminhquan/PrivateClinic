<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/8/2023
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
            integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
            crossorigin="anonymous"></script>
    <script src="/resources/static/js/main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/static/css/login.css">
</head>
<body>
<section style="background-color:aliceblue; height: 100% " >
    <div class="container" style="background-color:aliceblue">

        <div class=" text-black">
            <div class="align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
                <c:url value="/admin/login" var="action"></c:url>
                <form style="width: 30rem;margin-left: 25%;margin-top: 10%;" method="post" action="${action}">

                    <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px; text-align: center">ĐĂNG NHẬP ADMIN</h3>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form2Example18">Tài khoản</label>
                        <input type="text" id="form2Example18" name="username" class="form-control form-control-lg"/>

                    </div>

                    <div class="form-outline mb-4">
                        <label class="form-label" for="form2Example28">Mật khẩu</label>
                        <input type="password" id="form2Example28" name="password"
                               class="form-control form-control-lg"/>
                    </div>

                    <div class="pt-1 mb-4">
                        <button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
                    </div>
                    <c:if test="${param.error != null}">
                        <div class="alert alert-danger">
                            Sai tài khoản hoặc mật khẩu
                        </div>
                    </c:if>
                    <c:if test="${param.accessDenied != null}">
                        <div class="alert alert-danger">
                            Bạn không có quyền truy cập
                        </div>
                    </c:if>
                </form>

            </div>

        </div>
    </div>
</section>
</body>
</html>
