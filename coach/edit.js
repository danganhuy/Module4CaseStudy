function editMember(id) {
    $.ajax({
        url: `http://localhost:8080/api/members/${id}/details`,
        type: "GET",
        success: function (data) {
            $("#editId").val(data.id);
            $("#editFullName").val(data.fullName);
            $("#editDateOfBirth").val(data.dateOfBirth);
            $("#editNationality").val(data.nationality);
            $("#editHometown").val(data.hometown);
            $("#editMemberType").val(data.memberType);

            if (data.memberType === "PLAYER" && data.height !== undefined) {
                $("#playerEditFields").show();
                $("#editHeight").val(data.height);
                $("#editWeight").val(data.weight);
                $("#editBmi").val(data.bmi);
                $("#editRanking").val(data.ranking);
            } else {
                $("#playerEditFields").hide();
            }

            $("#editForm").show();
        },
        error: function () {
            alert("Không thể lấy thông tin chỉnh sửa.");
        }
    });
}
