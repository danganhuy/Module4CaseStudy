$(document).ready(function () {
    $.ajax({
        headers:{
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        url: `http://localhost:8080/player/details`,
        type: "GET",
        success: function (data) {
            $("#detailFullName").text(data.fullName);
            $("#detailDateOfBirth").text(data.dateOfBirth);
            $("#detailNationality").text(data.nationality);
            $("#detailHometown").text(data.hometown);
            $("#detailHeight").text(data.height);
            $("#detailWeight").text(data.weight);
            $("#detailBmi").text(data.bmi);
            $("#detailRanking").text(data.ranking);
        }
    });

    function calculateBMI() {
        let height = parseFloat($('#height').val());
        let weight = parseFloat($('#weight').val());
        if (height > 0 && weight > 0) {
            let bmi = (weight / (height * height)).toFixed(2);
            $('#bmi').val(bmi);
        }
    }
    $('#height, #weight').on('input', calculateBMI);
});