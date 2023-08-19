<%-- Created by IntelliJ IDEA. User: user Date: 7/29/2023 Time: 1:38 PM To change this template use File | Settings | File Templates. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #e9ecef">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">Tạo phiếu khám</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto"></ul>
        </div>
    </div>
</nav>
<%--
<section class="container">
  --%>
<div class="container">
    <div class="row">
        <div class="col-md-6" style="margin-top: 20px">
            <div class="form-group">
                <c:url value="/admin/phieukham" var="action"></c:url>
                <form:form cssStyle=" width: 100%" method="post" modelAttribute="phieukham" action="${action}"
                           enctype="multipart/form-data">
                    <form:errors path="*" element="div" cssClass="text-bg-danger"/>
                    <div class="row">
                        <div class="form-group col-md-6">
                            <labe for="date"> Ngày khám</labe>
                            <form:input type="date" id="ngayKham" name="ngayKham" class="form-control" path="ngayKham"/>
                        </div>
                        <div class="form-group col-md-6">
                            <labe for="maBn"> Mã bệnh nhân</labe>
                            <form:input type="text" id="maBn" name="maBn" class="form-control" path="maBn"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-6" style="margin-top: 15px">
                            <label>Xác Nhận</label>
                            <form:select class="form-select" id="xacnhan" name="xacnhan" path="xacnhan">
                                <option value="1">True</option>
                                <option value="0">False</option>
                            </form:select>
                        </div>

                        <div class="form-group col-md-6" style="margin-top: 15px">
                            <labe for="username"> Mã bác sĩ</labe>
                            <form:input type="text" class="form-control" path="maBS"/>
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="trieuChung"> Triệu chứng</labe>
                        <form:input type="text" id="trieuChung" name="trieuChung" class="form-control"
                                    path="trieuChung"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="chuanDoan"> Chuẩn đoán</labe>
                        <form:input type="text" id="chuanDoan" name="chuanDoan" class="form-control" path="chuanDoan"/>
                    </div>

                    <div class="pt-1 mb-2" style="margin-top: 15px">
                        <button class="btn btn-info btn-block" type="submit">Thêm phiếu</button>
                    </div>
                </form:form>
            </div>
        </div>

        <div class="col-md-6" style="margin-top: 20px">
            <form class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="Tìm tên bệnh nhân..."/>
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
            <table class="table table-hover" style="border-collapse: collapse; border: 1px solid lightgray">
                <thead>
                <tr style="margin-left: 10px">
                    <th style="width: 70px; text-align: center">Mã số</th>
                    <th style="width: 150px; text-align: center">Họ và tên</th>
                    <th style="width: 120px; text-align: center">Giới Tính</th>
                    <th style="width: 110px; text-align: center"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${benhnhan}" var="b">
                    <tr>
                        <td style="text-align: center">${b.maBn}</td>
                        <td style="text-align: center">${b.hoTen}</td>
                        <td style="text-align: center">${b.gioiTinh}</td>
                        <td>
                                <%-- <c:url value="/api/nhanvien/${b.maNv}" var="apiDel" />--%>
                            <a class="btn" onclick="setMaBN(${b.maBn})" id="${b.maBn}"
                               style="background-color: lightgray">thêm</a>
                                <%-- <button class="btn btn-danger" onclick="delPro('${apiDel}', ${b.maNv})">Xóa</button>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #e9ecef">
    <div class="container-fluid">
        <a class="navbar-brand" href="javascript:void(0)" style="color: black; font-weight: 500">Thêm thuốc vào phiếu
            thuốc</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar1">
            <ul class="navbar-nav me-auto"></ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-6" style="margin-top: 20px">
            <div class="form-group">
                <c:url value="/admin/phieukham" var="action"></c:url>
                <form:form cssStyle=" width: 100%" modelAttribute="phieuthuoc" method="post" action="${action}"
                           enctype="multipart/form-data">
                    <div class="form-group">
                        <labe for="date"> Mã phiếu khám</labe>
                        <form:input type="text" id="maPk" name="maPk" class="form-control" path="maPk"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="trieuChung"> Mã thuốc</labe>
                        <form:input type="text" id="maThuoc" name="maThuoc" class="form-control" path="maThuoc"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="chuanDoan"> Số lượng</labe>
                        <form:input type="text" id="soLuong" name="soLuong" class="form-control" path="soLuong"/>
                    </div>
                    <div class="form-group" style="margin-top: 15px">
                        <labe for="maBn"> Cách dùng</labe>
                        <form:input type="text" id="cachDung" name="cachDung" class="form-control" path="cachDung"/>
                    </div>
                    <div class="pt-1 mb-2" style="margin-top: 15px">
                        <button id="themthuocSubmitBtn" class="btn btn-info btn-block" type="button">Thêm thuốc</button>
                    </div>
                </form:form>
            </div>
        </div>

        <div class="col-md-6" style="margin-top: 20px">
            <table class="table table-hover" style="border-collapse: collapse; border: 1px solid lightgray">
                <thead>
                <tr style="margin-left: 10px">
                    <th style="width: 70px; text-align: center">Mã số</th>
                    <th style="width: 200px; text-align: center">Bệnh nhân</th>
                    <th style="width: 250px; text-align: center">Ngày khám</th>
                    <th style="width: 100px; text-align: center">Triệu chứng</th>
                    <th style="width: 100px; text-align: center">Chuẩn đoán</th>
                    <th style="width: 110px; text-align: center"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${phieukhambenh}" var="b" varStatus="c">
                    <tr>
                        <td style="text-align: center">${b.maPk}</td>
                        <td style="text-align: center">${listTen[c.index]}</td>
                        <td style="text-align: center">${b.ngayKham}</td>
                        <td style="text-align: center">${b.trieuChung}</td>
                        <td style="text-align: center">${b.chuanDoan}</td>
                        <td>
                                <%-- <c:url value="/api/thuoc/${b.maThuoc}" var="apiDel" />--%>
                            <a class="btn" onclick="setMaPK(${b.maPk})" id="${b.maPk}"
                               style="background-color: lightgray">thêm</a>
                                <%-- <button class="btn btn-danger" onclick="delPro('${apiDel}', ${b.maThuoc})">Xóa</button>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form class="d-flex">
                <input class="form-control me-2" type="text" name="kw" placeholder="Tìm tên thuốc..."/>
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
            <table class="table table-hover" style="border-collapse: collapse; border: 1px solid lightgray">
                <thead>
                <tr style="margin-left: 10px">
                    <th style="width: 70px; text-align: center">Mã số</th>
                    <th style="width: 200px; text-align: center">Tên thuốc</th>
                    <th style="width: 250px; text-align: center">Mô tả</th>
                    <th style="width: 100px; text-align: center">Trạng thái</th>
                    <th style="width: 110px; text-align: center"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${thuoc}" var="b">
                    <tr>
                        <td style="text-align: center">${b.maThuoc}</td>
                        <td style="text-align: center">${b.tenThuoc}</td>
                        <td style="text-align: center">${b.moTa}</td>
                        <td style="text-align: center">${b.isActive}</td>
                        <td>
                                <%-- <c:url value="/api/thuoc/${b.maThuoc}" var="apiDel" />--%>
                            <a class="btn" onclick="setMaThuoc(${b.maThuoc})" id="${b.maThuoc}"
                               style="background-color: lightgray">thêm</a>
                                <%-- <button class="btn btn-danger" onclick="delPro('${apiDel}', ${b.maThuoc})">Xóa</button>--%>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<section class="container" style="margin-top: 15px">
    <div class="row">
        <div class="col-md-6" style="margin-top: 20px">
            <table class="table table-hover" style="border-collapse: collapse; border: 1px solid lightgray">
                <thead>
                <tr style="margin-left: 10px">
                    <th style="width: 150px; text-align: center">Tên Thuốc</th>
                    <th style="width: 100px; text-align: center">Số lượng</th>
                    <th style="width: 200px; text-align: center">Cách dùng</th>
                    <th style="width: 100px; text-align: center">Mã phiếu</th>
                    <th style="width: 60px; text-align: center"></th>
                </tr>
                </thead>
                <tbody id="themthuocTBody">
                <%--        <c:forEach items="${listphieuthuoc}" var="b" varStatus="d">--%>
                <%--          <tr>--%>
                <%--            <td style="text-align: center">${b.maPkThuoc}</td>--%>
                <%--            <td style="text-align: center">${listTenThuoc[d.index]}</td>--%>
                <%--            <td style="text-align: center">${b.soLuong}</td>--%>
                <%--            <td style="text-align: center">${b.cachDung}</td>--%>
                <%--            <td style="text-align: center">${b.maPk}</td>--%>
                <%--        <td>--%>
                <%--            &lt;%&ndash; <c:url value="/api/thuoc/${b.maThuoc}" var="apiDel" />&ndash;%&gt;--%>
                <%--            <a href="" class="btn" style="background-color: lightgray">Sửa</a>--%>
                <%--            &lt;%&ndash; <button class="btn btn-danger" onclick="delPro('${apiDel}', ${b.maThuoc})">Xóa</button>&ndash;%&gt;--%>
                <%--        </td>--%>
                <%--          </tr>--%>
                <%--        </c:forEach>--%>
                </tbody>
            </table>
            <div class="pt-1 mb-2" style="margin-top: 15px">
                <button id="themthuocToDbSubmitBtn" class="btn btn-info btn-block" type="submit">Lưu phiếu thuốc
                </button>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6" style="margin-top: 20px">
        </div>
    </div>
    <a class="btn btn-danger" href="/admin/pdf">In phiếu thuốc</a>
</section>

<%--<script src="/resources/static/js/javscript.js"></script>--%>

<script></script>
</section>
