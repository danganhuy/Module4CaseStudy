$(document).ready(function () {
    $.ajax({
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        url: `http://localhost:8080/coach/listMatches`,
        type: "GET",
        success: function (data) {
            let s = "";
            for (let match of data) {
                s += `<tr>`
                s += `<td>${match.name}</td>`
                s += `<td>${match.date}</td>`
                s += `<td>${match.location}</td>`
                s += `</tr>`
            }
            $("#table-body").html(s);
        }
    });
})