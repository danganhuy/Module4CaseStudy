
function showAllMatches() {
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/admin/matches",
        success: function (data) {
            let content = "";
            for (let i = 0; i<data.length; i++){
                content+=`<tr>
                <td>${data[i].name}</td>  
                <td>${data[i].date}</td>   
                <td>${data[i].teamId}</td>   
                <td>${data[i].coachId}</td>   
                <td>${data[i].location}</td>
                </tr>`
            }
            document.getElementById("content").innerHTML=content;
        }
    })
}
showAllMatches();