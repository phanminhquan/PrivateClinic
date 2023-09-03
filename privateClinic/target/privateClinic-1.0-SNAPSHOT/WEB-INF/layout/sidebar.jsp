<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/23/2023
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="hasAnyAuthority('ADMIN')">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
            <div class="sb-sidenav-menu" style="background-color: #e9ecef">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link" href="/">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Trang chủ
                    </a>
                    <a class="nav-link" href="/catruc">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-calendar-days"></i></div>
                        Ca trực nhân viên
                    </a>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount1"
                       aria-expanded="false" aria-controls="collapseAccount1">
                        <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                        Tài khoản
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseAccount1" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/admin/register">Quản lý tài khoản</a>
                            <a class="nav-link" href="/admin/taikhoan">Danh sách tài khoản</a>
                        </nav>
                    </div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount3"
                       aria-expanded="false" aria-controls="collapseAccount">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-user-doctor"></i></div>
                        Bác sĩ
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseAccount3" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/admin/add_bacsi">Quản lý bác sĩ</a>
                            <a class="nav-link" href="/admin/bacsi">Danh sách bác sĩ</a>
                        </nav>
                    </div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount4"
                       aria-expanded="false" aria-controls="collapseAccount">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-user-nurse"></i></div>
                        Y tá
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseAccount4" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/admin/add_yta">Quản lý y tá</a>
                            <a class="nav-link" href="/admin/yta">Danh sách y tá</a>
                        </nav>
                    </div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount5"
                       aria-expanded="false" aria-controls="collapseAccount">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-tablets"></i></div>
                        Thuốc
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseAccount5" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/admin/add_thuoc">Quản lý thuốc</a>
                            <a class="nav-link" href="/admin/thuoc">Danh sách thuốc</a>
                        </nav>
                    </div>

                        <%--        <a class="nav-link" href="#">--%>
                        <%--          <div class="sb-nav-link-icon"><i class="fa-solid fa-tablets"></i></div>--%>
                        <%--          Thuốc--%>
                        <%--        </a>--%>
                </div>
            </div>
        </nav>
    </div>
</sec:authorize>
<sec:authorize access="hasAnyAuthority('NURSE')">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion1">
            <div class="sb-sidenav-menu" style="background-color: #e9ecef">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link" href="/">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Trang chủ
                    </a>
                    <a class="nav-link" href="/admin/dskham">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Xác nhận lịch khám <span class="badge bg-danger cart-counter" id="counter">0</span>
                    </a>
                    <a class="nav-link" href="/admin/dskhamhomnay">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Xem lịch khám ngày hôm nay
                    </a>
                    <a class="nav-link" href="/admin/pay">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Thanh toán
                    </a>
                        <%--                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount6"--%>
                        <%--                       aria-expanded="false" aria-controls="collapseAccount">--%>
                        <%--                        <div class="sb-nav-link-icon"><i class="fa-solid fa-calendar-days"></i></div>--%>
                        <%--                        Appointment--%>
                        <%--                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>--%>
                        <%--                    </a>--%>
                        <%--                    <div class="collapse" id="collapseAccount6" aria-labelledby="headingOne"--%>
                        <%--                         data-bs-parent="#sidenavAccordion">--%>
                        <%--                        <nav class="sb-sidenav-menu-nested nav">--%>
                        <%--                            <a class="nav-link" href="#">Ca trực bác sĩ</a>--%>
                        <%--                            <a class="nav-link" href="#">Lịch khám</a>--%>
                        <%--                        </nav>--%>
                        <%--                    </div>--%>
                </div>
            </div>
        </nav>
    </div>
</sec:authorize>
<sec:authorize access="hasAnyAuthority('DOCTOR')">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion2">
            <div class="sb-sidenav-menu" style="background-color: #e9ecef">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link" href="/">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Trang chủ
                    </a>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount7"
                       aria-expanded="false" aria-controls="collapseAccount">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-calendar-days"></i></div>
                        Doctor Service
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseAccount7" aria-labelledby="headingOne"
                         data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="/phieukham">Lập phiếu khám</a>
                            <a class="nav-link" href="/lichsukham">Lịch sử khám</a>
                        </nav>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</sec:authorize>