<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/5/2023
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
  $(function () {
    let maNv = [];
    <c:forEach items="${allMaNv}" var="maNv" >
    maNv.push(${maNv}+"")
    </c:forEach>
    $("#maNV").autocomplete({
      source: maNv
    });
  });
  $(function () {
    let nameList = [];
    <c:forEach items="${allName}" var="name" >
    nameList.push("${name}")
    </c:forEach>
    $("#name").autocomplete({
      source: nameList
    });
  });



</script>
<section class="container">
  <h1>Ca Trực</h1>


  <form autocomplete="off">
    <div class="mb-3">
      <label for="maNV" class="form-label">Mã nhân viên</label>
      <input style="position: relative" type="text" class="form-control" id="maNV" name="maNv">
    </div>
    <div class="mb-3">
      <label for="name" class="form-label">Tên nhân viên</label>
      <input type="text" class="form-control" id="name" name="tenNv">
    </div>

    <button type="submit" class="btn btn-primary">Tìm</button>
  </form>

  <h2>Danh sách tìm kiếm</h2>

  <table class="table table-hover" style="border-collapse: collapse">
    <thead>
    <tr style="margin-left: 10px">
      <th>Mã nhân viên</th>
      <th>Họ và tên</th>
      <th>Ngày sinh</th>
      <th>Email</th>
      <th>Số điện thoại</th>
      <th>Địa chỉ</th>
      <th>Chức vụ</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allSearchlistNV}" var="b">
      <tr>
        <td>${b[0]}</td>
        <td>${b[1]}</td>
        <td>${b[2]}</td>
        <td>${b[3]}</td>
        <td>${b[4]}</td>
        <td>${b[5]}</td>
        <td>${b[6]}</td>
        <td>
          <button class="btn btn-success"onclick="addToCaTruc(${b[0]},${idCaTruc})" >Thêm</button>
        </td>
      </tr>
    </c:forEach>

    </tbody>
  </table>
  <br><br>
  <h2>Danh sách nhân viên trong ca</h2>
  <table class="table">
    <thead>
    <tr>
      <th></th>
      <th scope="col">Mã nhân viên</th>
      <th scope="col">Họ và tên nhân viên</th>
      <th scope="col">Số điện thoại</th>
      <th scope="col">Email</th>
      <th scope="col">Chức vụ</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${listNhanVien}" var="l">
      <tr>
        <th scope="row">
          <button class="btn-danger btn" onclick="delStaffFromShift('${l[5]}')">X</button>
        </th>
        <td>${l[0]}</td>
        <td>${l[1]}</td>
        <td>${l[2]}</td>
        <td>${l[3]}</td>
        <td>${l[4]}</td>
      </tr>
    </c:forEach>



    </tbody>
  </table>
</section>
<script src="/resources/static/js/javscript.js"></script>


