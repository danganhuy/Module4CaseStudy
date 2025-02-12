function viewDetail(id) {
    $.ajax({
        url: `http://localhost:8080/api/members/${id}/details`,
        type: "GET",
        success: function (data) {
            $("#detailFullName").text(data.fullName);
            $("#detailDateOfBirth").text(data.dateOfBirth);
            $("#detailNationality").text(data.nationality);
            $("#detailHometown").text(data.hometown);
            $("#detailMemberType").text(data.memberType);

            if (data.memberType === "PLAYER" && data.height !== undefined) {
                $("#playerDetails").show();
                $("#detailHeight").text(data.height);
                $("#detailWeight").text(data.weight);
                $("#detailBmi").text(data.bmi);
                $("#detailRanking").text(data.ranking);
            } else {
                $("#playerDetails").hide();
            }

            $("#detailModal").show();
        },
        error: function () {
            alert("Không thể lấy thông tin chi tiết.");
        }
    });
}
