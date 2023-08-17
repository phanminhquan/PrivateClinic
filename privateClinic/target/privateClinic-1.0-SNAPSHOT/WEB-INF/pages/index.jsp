<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="hasAnyAuthority('ADMIN')">
    <section class="container">
        <h1 class="text-center">THỐNG KÊ BÁO CÁO</h1>
        <form>
        </form>
        <div class="d-flex gap-5">
            <div id="chartContainer1" style="height: 370px; width: 50%;"></div>
            <div id="chartContainer" style="height: 370px; width: 50%;"></div>
        </div>
    </section>

    <script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</sec:authorize>
<sec:authorize access="hasAnyAuthority('DOCTOR', 'NURSE')">
    <h1 class="text-center">LỊCH TRỰC NHÂN VIÊN</h1>
    <div class="container py-9 py-lg-11 position-relative z-index-1">
        <div class="row">
            <div class="col-lg-5 mb-5 mb-lg-0">
                <div class="nav nav-pills flex-column aos-init aos-animate" id="myTab" role="tablist" data-aos="fade-up">
                    <button class="nav-link px-4 text-start active" id="d1-tab" data-bs-toggle="tab" data-bs-target="#day1" type="button" role="tab" aria-controls="day1" aria-selected="true">
                        <span class="d-block fs-5 fw-bold">Thứ hai</span>
                    </button>
                    <button class="nav-link px-4 text-start" id="d2-tab" data-bs-toggle="tab" data-bs-target="#day2" type="button" role="tab" aria-controls="day2" aria-selected="false" tabindex="-1">
                        <span class="d-block fs-5 fw-bold">Thứ ba</span>
                    </button>
                    <button class="nav-link px-4 text-start" id="d3-tab" data-bs-toggle="tab" data-bs-target="#day3" type="button" role="tab" aria-controls="day2" aria-selected="false" tabindex="-1">
                        <span class="d-block fs-5 fw-bold">Thứ tư</span>
                    </button>
                    <button class="nav-link px-4 text-start" id="d4-tab" data-bs-toggle="tab" data-bs-target="#day4" type="button" role="tab" aria-controls="day2" aria-selected="false" tabindex="-1">
                        <span class="d-block fs-5 fw-bold">Thứ năm</span>
                    </button>
                    <button class="nav-link px-4 text-start" id="d5-tab" data-bs-toggle="tab" data-bs-target="#day5" type="button" role="tab" aria-controls="day2" aria-selected="false" tabindex="-1">
                        <span class="d-block fs-5 fw-bold">Thứ sáu</span>
                    </button>
                    <button class="nav-link px-4 text-start" id="d6-tab" data-bs-toggle="tab" data-bs-target="#day6" type="button" role="tab" aria-controls="day2" aria-selected="false" tabindex="-1">
                        <span class="d-block fs-5 fw-bold">Thứ bảy</span>
                    </button>
                    <button class="nav-link px-4 text-start" id="d7-tab" data-bs-toggle="tab" data-bs-target="#day7" type="button" role="tab" aria-controls="day2" aria-selected="false" tabindex="-1">
                        <span class="d-block fs-5 fw-bold">Chủ nhật</span>
                    </button>
                </div>
            </div>

            <div class="col-lg-7 col-xl-6">
                <div data-aos="fade-up" class="tab-content aos-init aos-animate" id="myTabContent">
                    <div class="tab-pane fade active show" id="day1" role="tabpanel" aria-labelledby="d1-tab">
                        <ul class="pt-4 list-unstyled mb-0">
                            <c:forEach items="${date1}" var="d">
                                <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">
                                    ${d.gioTruc}h - ${d.gioKetThuc}
                                </span>
                                    <div class="flex-grow-1 ps-4 border-start border-3">
                                        <h4>Ca ${d.maCt}</h4>
                                    </div>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="tab-pane fade" id="day2" role="tabpanel" aria-labelledby="d2-tab">
                        <ul class="pt-4 list-unstyled mb-0">
                            <c:forEach items="${date2}" var="d">
                                <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">
                                    ${d.gioTruc}h - ${d.gioKetThuc}
                                </span>
                                    <div class="flex-grow-1 ps-4 border-start border-3">
                                        <h4>Chủ nhật</h4>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="tab-pane fade" id="day3" role="tabpanel" aria-labelledby="d2-tab">
                        <ul class="pt-4 list-unstyled mb-0">
                            <c:forEach items="${date3}" var="d">
                                <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">
                                    ${d.gioTruc}h - ${d.gioKetThuc}
                                </span>
                                    <div class="flex-grow-1 ps-4 border-start border-3">
                                        <h4>Chủ nhật</h4>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="tab-pane fade" id="day4" role="tabpanel" aria-labelledby="d2-tab">
                        <ul class="pt-4 list-unstyled mb-0">
                            <c:forEach items="${date4}" var="d">
                                <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">
                                    ${d.gioTruc}h - ${d.gioKetThuc}
                                </span>
                                    <div class="flex-grow-1 ps-4 border-start border-3">
                                        <h4>Chủ nhật</h4>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="tab-pane fade" id="day5" role="tabpanel" aria-labelledby="d2-tab">
                        <ul class="pt-4 list-unstyled mb-0">
                            <c:forEach items="${date5}" var="d">
                                <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">
                                    ${d.gioTruc}h - ${d.gioKetThuc}
                                </span>
                                    <div class="flex-grow-1 ps-4 border-start border-3">
                                        <h4>Chủ nhật</h4>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="tab-pane fade" id="day6" role="tabpanel" aria-labelledby="d2-tab">
                        <ul class="pt-4 list-unstyled mb-0">
                            <c:forEach items="${date6}" var="d">
                                <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">
                                    ${d.gioTruc}h - ${d.gioKetThuc}
                                </span>
                                    <div class="flex-grow-1 ps-4 border-start border-3">
                                        <h4>Chủ nhật</h4>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="tab-pane fade" id="day7" role="tabpanel" aria-labelledby="d2-tab">
                        <ul class="pt-4 list-unstyled mb-0">
                            <c:forEach items="${date7}" var="d">
                                <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">
                                    ${d.gioTruc}h - ${d.gioKetThuc}
                                </span>
                                    <div class="flex-grow-1 ps-4 border-start border-3">
                                        <h4>Chủ nhật</h4>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</sec:authorize>

