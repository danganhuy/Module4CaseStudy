$(document).ready(function () {
    $.ajax({
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        url: `http://localhost:8080/player/matches`,
        type: "GET",
        success: function (data) {
            let s = "";

            for (let match of data) {
                s += `<tr>`
                s += `<td>${match.name}</td>`
                s += `<td>${match.date}</td>`
                s += `<td>${match.location}</td>`
                s += `<td>${match.performanceRating}</td>`
                s += `<td>${match.review}</td>`
                s += `</tr>`
            }

            $("#table-body").html(s);
        }
    });
})