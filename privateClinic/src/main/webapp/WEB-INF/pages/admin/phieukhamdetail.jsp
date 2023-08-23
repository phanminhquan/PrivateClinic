<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/16/2023
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="${benhNhan.avatar}" alt="avatar"
                             class="rounded-circle img-fluid" style="width: 70px; height: 70px">
                        <h5 class="my-3">${benhNhan.hoTen}</h5>
                    </div>
                </div>
                <div class="card mb-4 mb-lg-0">
                    <div class="card-body p-0">
                        <ul class="list-group list-group-flush rounded-3">
                            <li class="list-group-item d-flex gap-5 align-items-center p-3">
                                <h5>Triệu chứng</h5>
                                <p class="mb-0">${phieuKham.trieuChung}</p>
                            </li>
                            <li class="list-group-item d-flex gap-5 align-items-center p-3">
                                <h5>Chuẩn đoán</h5>
                                <p class="mb-0">${phieuKham.chuanDoan}</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Mã bệnh nhân</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${benhNhan.maBn}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Họ tên bệnh nhân</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${benhNhan.hoTen}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">email</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${benhNhan.email}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Ngày Sinh</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${benhNhan.ngaySinh}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Giới tính</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${benhNhan.gioiTinh}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Địa chỉ</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${benhNhan.diaChi}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <h2>Thuốc được kê đơn</h2>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Mã thuốc</th>
                            <th scope="col">Tên thuốc</th>
                            <th scope="col">Số lượng</th>
                            <th scope="col">Cách dùng</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${thuoc}" var="t">
                            <tr>
                                <th scope="row">${t[0]}</th>
                                <td>${t[1]}</td>
                                <td>${t[2]}</td>
                                <td>${t[3]}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div>
            <button class="btn btn-success" onclick="pay(${phieuKham.maPk})">Thanh toán</button>
        </div>
    </div>

</section>
