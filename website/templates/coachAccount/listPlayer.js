$(document).ready(function () {
    $.ajax({
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        url: `http://localhost:8080/coach/listPlayer`,
        type: "GET",
        success: function (data) {
            let s = "";
            for (let player of data) {
                s += `<tr>`
                s += `<td>${player.fullName}</td>`
                s += `<td>${player.dateOfBirth}</td>`
                s += `<td>${player.nationality}</td>`
                s += `<td>${player.hometown}</td>`
                s += `<td>${player.ranking}</td>`
                s += `<td>${player.status}</td>`
                s += `</tr>`
            }
            $("#table-body").html(s);
        }
    });
})