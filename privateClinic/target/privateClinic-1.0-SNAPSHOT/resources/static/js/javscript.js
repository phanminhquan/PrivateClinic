window.onload = () => {
  //Chart 1
  fetch("/api/ctdskham/havenotaccepted", {
    method: "get",
  })
    .then((res) => res.json())
    .then((data) => {
      document.getElementById("counter").innerText = data["count"];
    });
  //chart 1
  fechchart1();

  //Chart 2
  fecthPieChart();

  //Chart 3
  loadchar();

  //Chart 4
  fecthDaonhThuTheoThang();

  //
  fectSLTheoThang();

  //chart 5
  loadchar2();
};

function loadChartSLTheoThang() {
  var chart = new CanvasJS.Chart("chartContainer4", {
    animationEnabled: true,
    theme: "light2", // "light1", "light2", "dark1", "dark2"
    title: {
      text: "THỐNG KÊ SỐ LƯỢNG BỆNH NHÂN THEO THÁNG",
    },
    axisY: {
      title: "Số bệnh nhân",
    },
    data: [
      {
        type: "column",
        showInLegend: true,
        legendMarkerColor: "grey",
        legendText: "",
        dataPoints: dataSLTheoThang,
      },
    ],
  });
  chart.render();
}

function fectSLTheoThang() {
  const year = document.getElementById("year").value;
  fetch("/admin/chartsoluong/thang", {
    method: "post",
    body: JSON.stringify({
      year: year + "",
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      dataSLTheoThang = [];
      for (var i = 1; i < 12; i++) {
        dataSLTheoThang.push({ y: parseFloat(data["Tháng " + i]), label: "Tháng " + i });
      }
      loadChartSLTheoThang();
    });
}

function fectCharQuy() {
  fechchart1();
  fecthPieChart();
  fecthDaonhThuTheoThang();
  fectSLTheoThang();
}
var dataDoanhThu = [];
var dataBenhNhanTheoQuy = [];
var dataDoanhThuTheoThang = [];
var dataSLTheoThang = [];

function loadchar1() {
  var chart = new CanvasJS.Chart("chartContainer1", {
    theme: "light2", // "light1", "light2", "dark1", "dark2"
    exportEnabled: true,
    animationEnabled: true,
    title: {
      text: "THỐNG KÊ SỐ LƯỢNG BỆNH NHÂN THEO QUÝ",
    },
    data: [
      {
        type: "pie",
        startAngle: 25,
        toolTipContent: "<b>{label}</b>: {y}",
        showInLegend: "true",
        legendText: "{label}",
        indexLabelFontSize: 16,
        indexLabel: "{label} - {y}",
        dataPoints: dataBenhNhanTheoQuy,
      },
    ],
  });
  chart.render();
}
function fechchart1() {
  const year = document.getElementById("year").value;
  fetch("/admin/chartbenhnhan/quy", {
    method: "post",
    body: JSON.stringify({
      year: year + "",
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      dataBenhNhanTheoQuy = [];
      console.log(data["quy1"]);
      dataBenhNhanTheoQuy.push({ y: parseFloat(data["Quý 1"]), label: "Quý 1" });
      dataBenhNhanTheoQuy.push({ y: parseFloat(data["Quý 2"]), label: "Quý 2" });
      dataBenhNhanTheoQuy.push({ y: parseFloat(data["Quý 3"]), label: "Quý 3" });
      dataBenhNhanTheoQuy.push({ y: parseFloat(data["Quý 4"]), label: "Quý 4" });
      loadchar1();
    });
}

function fecthPieChart() {
  const year = document.getElementById("year").value;
  fetch("/admin/chartdoanhthu/quy", {
    method: "post",
    body: JSON.stringify({
      year: year + "",
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      dataDoanhThu = [];
      dataDoanhThu.push({ y: parseFloat(data["Quý 1"]), label: "Quý 1" });
      dataDoanhThu.push({ y: parseFloat(data["Quý 2"]), label: "Quý 2" });
      dataDoanhThu.push({ y: parseFloat(data["Quý 3"]), label: "Quý 3" });
      dataDoanhThu.push({ y: parseFloat(data["Quý 4"]), label: "Quý 4" });
      loadPieChar();
    });
}
function fecthDaonhThuTheoThang() {
  const year = document.getElementById("year").value;
  fetch("/admin/chartdoanhthu/thang", {
    method: "post",
    body: JSON.stringify({
      year: year + "",
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      dataDoanhThuTheoThang = [];
      for (var i = 1; i < 12; i++) {
        dataDoanhThuTheoThang.push({ y: parseFloat(data["Tháng " + i]), label: "Tháng " + i });
      }
      loadChart4();
    });
}
function loadChart4() {
  var chart = new CanvasJS.Chart("chartContainer3", {
    animationEnabled: true,

    title: {
      text: "THỐNG KÊ DOANH THU THEO THÁNG",
    },
    axisX: {
      interval: 1,
    },
    axisY2: {
      interlacedColor: "rgba(1,77,101,.2)",
      gridColor: "rgba(1,77,101,.1)",
      title: "Doanh thu (VNĐ)",
    },
    data: [
      {
        type: "bar",
        name: "companies",
        axisYType: "secondary",
        color: "#014D65",
        dataPoints: dataDoanhThuTheoThang,
      },
    ],
  });
  chart.render();
}
function loadPieChar() {
  var chart = new CanvasJS.Chart("chartContainer", {
    animationEnabled: true,
    exportEnabled: true,
    theme: "light2",
    title: {
      text: "THỐNG KÊ DOANH THU THEO QUÝ",
    },
    data: [
      {
        type: "line",
        indexLabelFontSize: 16,
        dataPoints: dataDoanhThu,
      },
    ],
  });
  chart.render();
}

function delPro(path, id) {
  if (confirm("Bạn chắc chắn xóa không?") === true) {
    fetch(path, {
      method: "delete",
    }).then((res) => {
      if (res.status === 204) location.reload();
      else alert("Something wrong!!!");
    });
  }
}

function delCaTruc(id) {
  if (confirm("Bạn chắc chắn xóa không?") === true) {
    fetch(`/api/delcatruc/${id}`, {
      method: "delete",
    }).then((res) => {
      if (res.status === 204) location.reload();
      else alert("Something wrong!!!");
    });
  }
}

function delStaffFromShift(id) {
  if (confirm("Bạn chắc chắn xóa không?") === true) {
    fetch(`/api/catruc/${id}`, {
      method: "delete",
    }).then((res) => {
      location.reload();
    });
  }
}

function delCaTrucTRongTuan(idCaTruc, idNgay) {
  fetch("/api/catructrongtuan", {
    method: "delete",
    body: JSON.stringify({
      idCaTruc: idCaTruc,
      idNgay: idNgay,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  }).then((res) => {
    location.reload();
  });
}

function addToCaTruc(idnhanvien, idCatruc) {
  fetch("/api/catruc/add", {
    method: "post",
    body: JSON.stringify({
      idCaTruc: idCatruc,
      idNhanVien: idnhanvien,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      if (confirm(data["message"]) === true) {
        location.reload();
      }
    });
}

function setMaBN(id) {
  document.getElementById("maBn").value = id;
}

function setMaPK(id) {
  document.getElementById("maPk").value = id;
}

function setMaThuoc(id) {
  document.getElementById("maThuoc").value = id;
}

function addToCaTruc(idnhanvien, idCatruc) {
  fetch("/api/catruc/add", {
    method: "post",
    body: JSON.stringify({
      idCaTruc: idCatruc,
      idNhanVien: idnhanvien,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      if (confirm(data["message"]) === true) {
        location.reload();
      }
    });
}

function acceptOrDenny(id, status) {
  fetch("/api/lichkham/acceptOrDenny", {
    method: "post",
    body: JSON.stringify({
      id: id,
      status: status,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      if (confirm(data["res"]) === true) {
        if (status === 2) {
          fetch("/mail", {
            method: "post",
            body: JSON.stringify({
              username: data["username"],
              email: data["email"],
              id: data["id"],
            }),
            headers: {
              "Content-Type": "application/json",
            },
          }).then((r) => location.reload());
        }
        location.reload();
      }
    });
}

function pay(id) {
  fetch("/pay", {
    method: "post",
    body: JSON.stringify({
      idPK: id,
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((res) => res.json())
    .then((data) => {
      location.replace(data["payUrl"]);
    });
}

(() => {
  const thuocList = [];
  $("#themthuocSubmitBtn").on("click", () => {
    const $maPk = $("[name=maPk]");
    const $maThuoc = $("[name=maThuoc]");
    const $soLuong = $("[name=soLuong]");
    const $cachDung = $("[name=cachDung]");

    const obj = {
      maPk: $maPk.val(),
      maThuoc: $maThuoc.val(),
      soLuong: $soLuong.val(),
      cachDung: $cachDung.val(),
    };

    thuocList.push(obj);

    addToDom(obj);
  });

  $("#themthuocToDbSubmitBtn").on("click", () => {
    if (thuocList.length == 0) return;

    submit();
  });

  async function submit() {
    const url = location.origin + "/api/phieuthuoc";

    let isSomeFailed = false;

    for await (const thuoc of thuocList) {
      const json = JSON.stringify(thuoc);

      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: json
      });

      if (response.status === 200) {
        alert("Thêm phiếu khám thành công");
      } else {
        isSomeFailed = true;
        alert("Thêm phiếu khám thất bại");
      }
    }

    if (!isSomeFailed) location.reload();
  }

  function addToDom(thuoc) {
    const $tbody = $("#themthuocTBody");

    var $tr = $(`
        <tr>
            <td style="text-align: center">${thuoc.maThuoc}</td>
            <td style="text-align: center">${thuoc.soLuong}</td>
            <td style="text-align: center">${thuoc.cachDung}</td>
            <td style="text-align: center">${thuoc.maPk}</td>
            <td style="text-align: center"><a href="" class="btn" style="background-color: lightgray">Sửa</a></td>
        </tr>
          `);

    $tbody.append($tr);
  }
})();
