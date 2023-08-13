<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/8/2023
  Time: 2:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
  function submitForm(){
    const map = new Map();
    <c:forEach items="${list}" var="catruc">
    if (document.getElementById("${catruc.maCt}").checked)
      map.set("${catruc.maCt}","true");
    </c:forEach>
    map.set("id", "${dateOfWeek.id}")
    const obj = Object.fromEntries(map);
    fetch("/admin/addCaTrucVaoNgay",{
      method:"post",
      body: JSON.stringify(obj),
      headers:{
        "Content-Type" : "application/json"
      }
    }).then(res => {
      if (res.status == 200)
        location.reload();
      if(res.status == 204)
        alert("Có ca trực đã có sẵn trong ngày, hãy kiểm tra lại!!")
    })
  }
</script>

<section class="container">
  <h1>${dateOfWeek.dateOfWeek}</h1>

  <c:if test="${listErro != null}">
    <div class="alert alert-danger" role="alert">
        ${listErro}
    </div
  </c:if>
  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
    Thêm ca trực
  </button>

  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form id="form-submit" action="/admin/addCaTrucVaoNgay" method="post">
            <c:forEach items="${list}" var="l">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="${l.maCt}" id="${l.maCt}">
                <label class="form-check-label" for="${l.maCt}">
                  Ca ${l.maCt}
                </label>
              </div>
            </c:forEach>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
          <button type="button" class="btn btn-primary" onclick="submitForm()" >Thêm</button>
        </div>
      </div>
    </div>
  </div>
  <table class="table">
    <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Ca</th>
      <th scope="col">Giờ bắt đầu</th>
      <th scope="col">Giờ kết thúc</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allCaTruc}" var="c">
      <tr>
        <td>
          <button class="btn btn-danger" onclick="delCaTrucTRongTuan(${c.maCt},${dateOfWeek.id})">X</button>
        </td>
        <th scope="row">${c.maCt}</th>
        <td>${c.gioTruc}h</td>
        <td>${c.gioKetThuc}h</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</section>
<script src="/resources/static/js/javscript.js"></script>
