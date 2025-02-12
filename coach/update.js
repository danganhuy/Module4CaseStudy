function updateMember() {
    let id = $("#editId").val();
    let member = {
        fullName: $("#editFullName").val(),
        dateOfBirth: $("#editDateOfBirth").val(),
        nationality: $("#editNationality").val(),
        hometown: $("#editHometown").val(),
        memberType: $("#editMemberType").val()
    };

    if (member.memberType === "PLAYER") {
        member.height = $("#editHeight").val();
        member.weight = $("#editWeight").val();
        member.bmi = $("#editBmi").val();
        member.ranking = $("#editRanking").val();
    }

    $.ajax({
        url: `http://localhost:8080/api/members/${id}`,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(member),
        success: function () {
            alert("Cập nhật thành công!");
            $("#editForm").hide();
            loadMembers();
        },
        error: function () {
            alert("Cập nhật thất bại.");
        }
    });
}
