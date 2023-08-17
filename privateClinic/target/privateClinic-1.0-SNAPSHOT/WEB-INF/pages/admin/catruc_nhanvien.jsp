<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/17/2023
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container py-9 py-lg-11 position-relative z-index-1">
  <div class="row">
    <div class="col-lg-5 mb-5 mb-lg-0">
      <h5 class="mb-4 text-info aos-init aos-animate" data-aos="fade-up">Schedule and Agenda</h5>
      <div class="nav nav-pills flex-column aos-init aos-animate" id="myTab" role="tablist" data-aos="fade-up">
        <button class="nav-link px-4 text-start mb-3 active" id="d1-tab" data-bs-toggle="tab" data-bs-target="#day1" type="button" role="tab" aria-controls="day1" aria-selected="true">
          <span class="d-block fs-5 fw-bold">Day 1</span>
          <span class="small">Mon, Jan 2, 2023</span>
        </button>

        <button class="nav-link px-4 text-start" id="d2-tab" data-bs-toggle="tab" data-bs-target="#day2" type="button" role="tab" aria-controls="day2" aria-selected="false" tabindex="-1">
          <span class="d-block fs-5 fw-bold">Day 2</span>
          <span class="small">Tue, Jan 3, 2023</span>
        </button>
      </div>
    </div>

    <div class="col-lg-7 col-xl-6">
      <div data-aos="fade-up" class="tab-content aos-init aos-animate" id="myTabContent">
        <div class="tab-pane fade active show" id="day1" role="tabpanel" aria-labelledby="d1-tab">
          <ul class="pt-4 list-unstyled mb-0">
            <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">9:00
                                    AM - 10:00 AM</span>
              <div class="flex-grow-1 ps-4 border-start border-3">
                <h4>Registration and Coffee</h4>
                <p class="mb-0">
                  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  officia deserunt mollit anim id est laborum.
                </p>
              </div>
            </li>
            <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">10:00
                                    AM - 11:00 AM</span>
              <div class="flex-grow-1 ps-4 border-start border-3">
                <h4>Culpa qui officia deserunt</h4>
                <p class="mb-0">
                  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  officia deserunt mollit anim id est laborum.
                </p>
              </div>
            </li>
            <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">11:00
                                    AM - 12:30 PM</span>
              <div class="flex-grow-1 ps-4 border-start border-3">
                <h4>Excepteur sint occaecat cupidatat</h4>
                <p class="mb-0">
                  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  officia deserunt mollit anim id est laborum.
                </p>
              </div>
            </li>
            <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">12:30
                                    PM - 1:30 PM</span>
              <div class="flex-grow-1 ps-4 border-start border-3">
                <h4>Lunch break</h4>
                <p class="mb-0">
                  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  officia deserunt mollit anim id est laborum.
                </p>
              </div>
            </li>
          </ul>
        </div>
        <div class="tab-pane fade" id="day2" role="tabpanel" aria-labelledby="d2-tab">
          <ul class="pt-4 list-unstyled mb-0">
            <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">9:00
                                    AM - 10:00 AM</span>
              <div class="flex-grow-1 ps-4 border-start border-3">
                <h4>Excepteur sint occaecat</h4>
                <p class="mb-0">
                  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  officia deserunt mollit anim id est laborum.
                </p>
              </div>
            </li>
            <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">10:00
                                    AM - 11:00 AM</span>
              <div class="flex-grow-1 ps-4 border-start border-3">
                <h4>Culpa qui officia deserunt</h4>
                <p class="mb-0">
                  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  officia deserunt mollit anim id est laborum.
                </p>
              </div>
            </li>
            <li class="d-flex flex-column flex-md-row py-4">
                                <span class="flex-shrink-0 width-13x me-md-4 d-block mb-3 mb-md-0 small text-muted">11:00
                                    AM - 12:30 PM</span>
              <div class="flex-grow-1 ps-4 border-start border-3">
                <h4>Excepteur sint occaecat cupidatat</h4>
                <p class="mb-0">
                  Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
                  officia deserunt mollit anim id est laborum.
                </p>
              </div>
            </li>

          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
