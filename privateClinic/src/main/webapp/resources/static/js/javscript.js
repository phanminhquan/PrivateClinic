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

//  -=-=

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
        body: json,
      });

      if (response.status === 200) {
        console.log("ok");
      } else {
        isSomeFailed = true;
        console.log("fail");
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
