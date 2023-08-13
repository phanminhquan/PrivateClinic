
function delPro(path, id) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}

function delCaTruc(id){
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(`/api/delcatruc/${id}`, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Something wrong!!!");
        });
    }
}

function delStaffFromShift(id) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(`/api/catruc/${id}` , {
            method: "delete"
        }).then(res => {
            location.reload();
        });
    }
}

function delCaTrucTRongTuan(idCaTruc,idNgay){
    fetch("/api/catructrongtuan",{
        method:"delete",
        body: JSON.stringify({
            "idCaTruc":idCaTruc,
            "idNgay":idNgay,
        }),
        headers:{
            "Content-Type" : "application/json"
        }
    }).then(res => {
        location.reload();
    })
}

function addToCaTruc(idnhanvien, idCatruc){
    fetch("/api/catruc/add",{
        method: "post",
        body: JSON.stringify({
            "idCaTruc": idCatruc,
            "idNhanVien" :idnhanvien,
        }),
        headers: {
            "Content-Type" : "application/json"
        }
    }).then((res) => res.json()).then((data) =>{
        if(confirm(data["message"]) === true){
            location.reload()
        }
    })
}


