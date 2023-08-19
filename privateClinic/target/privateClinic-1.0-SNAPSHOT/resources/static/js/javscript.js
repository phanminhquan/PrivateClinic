
window.onload = () =>{
    fetch("/api/ctdskham/havenotaccepted",{
        method:"get"
    }).then((res) => res.json()).then((data) => {
        document.getElementById("counter").innerText = data["count"]
    })
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


}

function loadChartSLTheoThang(){
    var chart = new CanvasJS.Chart("chartContainer4", {
        animationEnabled: true,
        theme: "light2", // "light1", "light2", "dark1", "dark2"
        title:{
            text: "THỐNG KÊ SỐ LƯỢNG BỆNH NHÂN THEO THÁNG"
        },
        axisX:{
            minimum: 5,
            maximum: 95
        },
        data: [{
            type: "column",
            dataPoints: [
                { x: 10, y: 71 },
                { x: 20, y: 55 },
                { x: 30, y: 50 },
                { x: 40, y: 65 },
                { x: 50, y: 95 },
                { x: 60, y: 68 },
                { x: 70, y: 28 },
                { x: 80, y: 34 },
                { x: 90, y: 14 }
            ]
        }]
    });
    chart.render();
}

    function searchDataPoint() {
        var dps = chart.data[0].dataPoints;
        for(var i = 0; i < dps.length; i++ ) {
            if( (xValue >= dps[i].x - xSnapDistance && xValue <= dps[i].x + xSnapDistance) && (yValue >= dps[i].y - ySnapDistance && yValue <= dps[i].y + ySnapDistance) )
            {
                if(mouseDown) {
                    selected = i;
                    break;
                } else {
                    changeCursor = true;
                    break;
                }
            } else {
                selected = null;
                changeCursor = false;
            }
        }
    }

    jQuery("#chartContainer1 > .canvasjs-chart-container").on({
        mousedown: function(e) {
            mouseDown = true;
            getPosition(e);
            searchDataPoint();
        },
        mousemove: function(e) {
            getPosition(e);
            if(mouseDown) {
                clearTimeout(timerId);
                timerId = setTimeout(function(){
                    if(selected != null) {
                        chart.data[0].dataPoints[selected].y = yValue;
                        chart.render();
                    }
                }, 0);
            }
            else {
                searchDataPoint();
                if(changeCursor) {
                    chart.data[0].set("cursor", "n-resize");
                } else {
                    chart.data[0].set("cursor", "default");
                }
            }
        },
        mouseup: function(e) {
            if(selected != null) {
                chart.data[0].dataPoints[selected].y = yValue;
                chart.render();
                mouseDown = false;
            }
        }

function fectCharQuy(){
    fechchart1();
    fecthPieChart();
    fecthDaonhThuTheoThang()
    fectSLTheoThang();
}
var dataDoanhThu = []
var dataBenhNhanTheoQuy =[]
var dataDoanhThuTheoThang = []
var dataSLTheoThang =[]

function loadchar1(){
    var chart = new CanvasJS.Chart("chartContainer1", {
        theme: "light2", // "light1", "light2", "dark1", "dark2"
        exportEnabled: true,
        animationEnabled: true,
        title: {
            text: "THỐNG KÊ SỐ LƯỢNG BỆNH NHÂN THEO QUÝ"
        },
        data: [{
            type: "pie",
            startAngle: 25,
            toolTipContent: "<b>{label}</b>: {y}",
            showInLegend: "true",
            legendText: "{label}",
            indexLabelFontSize: 16,
            indexLabel: "{label} - {y}%",
            dataPoints: [
                { y: 51.08, label: "Chrome" },
                { y: 27.34, label: "Internet Explorer" },
                { y: 10.62, label: "Firefox" },
                { y: 5.02, label: "Microsoft Edge" },
                { y: 4.07, label: "Safari" },
                { y: 1.22, label: "Opera" },
                { y: 0.44, label: "Others" }
            ]
        }]
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
            "idCaTruc": idCatruc,
            "idNhanVien": idnhanvien
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => res.json()).then((data) => {
        if (confirm(data["message"]) === true) {
            location.reload()
        }
    })
}

function acceptOrDenny(id, status) {
    fetch("/api/lichkham/acceptOrDenny", {
        method: "post",
        body: JSON.stringify({
            "id": id,
            "status": status
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => res.json()).then((data) => {
        if (confirm(data["res"]) === true) {
            if (status === 2) {
                fetch("/mail", {
                    method: "post",
                    body: JSON.stringify({
                        "username": data["username"],
                        "email": data["email"],
                        "id": data["id"]
                    }),
                    headers: {
                        "Content-Type": "application/json"
                    }
                }).then(r => (location.reload()))
            }
            location.reload()
        }
    })
}

function pay(id) {
    fetch("/pay", {
        method: "post",
        body: JSON.stringify({
            "idPK": id,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then((res) => res.json()).then((data) => {
        location.replace(data["payUrl"]);
    })
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
                body: json,
            });

            if (response.status === 200) {
                alert("Thêm phiếu khám thành công")
            } else {
                isSomeFailed = true;
                alert("Thêm phiếu khám thất bại")
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
