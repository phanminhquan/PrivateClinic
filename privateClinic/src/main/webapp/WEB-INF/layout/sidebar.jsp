<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 7/23/2023
  Time: 3:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="layoutSidenav_nav">
  <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
    <div class="sb-sidenav-menu">
      <div class="nav">
        <div class="sb-sidenav-menu-heading">Core</div>
        <a class="nav-link" href="/">
          <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
          Trang chủ
        </a>
        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount"
           aria-expanded="false" aria-controls="collapseAccount">
          <div class="sb-nav-link-icon"><i class="fa-solid fa-calendar-days"></i></div>
          Appointment
          <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
        </a>
        <div class="collapse" id="collapseAccount" aria-labelledby="headingOne"
             data-bs-parent="#sidenavAccordion">
          <nav class="sb-sidenav-menu-nested nav">
            <a class="nav-link" href="#">Ca trực bác sĩ</a>
            <a class="nav-link" href="#">Lịch khám</a>
          </nav>
        </div>

        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseAccount1"
           aria-expanded="false" aria-controls="collapseAccount1">
          <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
          Account
          <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
        </a>
        <div class="collapse" id="collapseAccount1" aria-labelledby="headingOne"
             data-bs-parent="#sidenavAccordion">
          <nav class="sb-sidenav-menu-nested nav">
            <a class="nav-link" href="#">User account</a>
            <a class="nav-link" href="#">Admin account</a>
          </nav>
        </div>

        <a class="nav-link" href="/admin/bacsi">
          <div class="sb-nav-link-icon"><i class="fa-solid fa-user-doctor"></i></div>
          Bác sĩ
        </a>
        <a class="nav-link" href="/Admin/Home/Index">
          <div class="sb-nav-link-icon"><i class="fa-solid fa-user-nurse"></i></div>
          Y tá
        </a>
        <a class="nav-link" href="#">
          <div class="sb-nav-link-icon"><i class="fa-solid fa-user"></i></div>
          Bệnh nhân
        </a>
        <a class="nav-link" href="#">
          <div class="sb-nav-link-icon"><i class="fa-solid fa-money-bill"></i></div>
          Hóa dơn
        </a>
        <a class="nav-link" href="#">
          <div class="sb-nav-link-icon"><i class="fa-solid fa-tablets"></i></div>
          Thuốc
        </a>
      </div>
    </div>
  </nav>
</div>
