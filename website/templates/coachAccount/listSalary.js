$(document).ready(function () {
    $.ajax({
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        url: `http://localhost:8080/coach/listSalary`,
        type: "GET",
        success: function (data) {
            let s = "";
            for (let salary of data) {
                s += `<tr>`
                s += `<td>${salary.id.month}</td>`
                s += `<td>${salary.id.year}</td>`
                s += `<td>${salary.salary}</td>`
                s += `<td>${salary.incentive}</td>`
                s += `</tr>`
            }
            $("#table-body").html(s);
        }
    });
})