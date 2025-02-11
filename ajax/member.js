$(document).ready(function () {
    function loadMembers(filterType = "") {
        $.ajax({
            url: "http://localhost:8080/api/members",
            type: "GET",
            success: function (data) {
                let tableBody = $("#memberTableBody");
                tableBody.empty();

                data.forEach(member => {
                    if (filterType === "" || member.memberType === filterType) {
                        let row = `
                            <tr>
                                <td>${member.id}</td>
                                <td>${member.fullName}</td>
                                <td>${member.dateOfBirth}</td>
                                <td>${member.nationality}</td>
                                <td>${member.hometown}</td>
                                <td>${member.memberType}</td>
                            </tr>
                        `;
                        tableBody.append(row);
                    }
                });
            },
            error: function () {
                alert("Không thể tải danh sách thành viên.");
            }
        });
    }

    // Load toàn bộ thành viên khi trang được tải
    loadMembers();

    // Bắt sự kiện khi chọn dropdown để lọc danh sách
    $("#filterMemberType").change(function () {
        let selectedType = $(this).val();
        loadMembers(selectedType);
    });
});

// $(document).ready(function () {
//     function loadMembers() {
//         $.ajax({
//             url: "http://localhost:8080/api/members",
//             type: "GET",
//             success: function (data) {
//                 let tableBody = $("#memberTableBody");
//                 tableBody.empty();
//
//                 data.forEach(member => {
//                     let row = `
//                         <tr>
//                             <td>${member.id}</td>
//                             <td>${member.fullName}</td>
//                             <td>${member.dateOfBirth}</td>
//                             <td>${member.nationality}</td>
//                             <td>${member.hometown}</td>
//                             <td>${member.memberType}</td>
//                             <td><button onclick="viewDetail(${member.id})">Chi tiết</button></td>
//                             <td><button onclick="editMember(${member.id})">Sửa</button></td>
//                             <td><button onclick="deleteMember(${member.id})">Xóa</button></td>
//                         </tr>
//                     `;
//                     tableBody.append(row);
//                 });
//             }
//         });
//     }
//
//     loadMembers();
// });
//
// // Hiển thị chi tiết
// function viewDetail(id) {
//     $.ajax({
//         url: `http://localhost:8080/api/members/${id}`,
//         type: "GET",
//         success: function (data) {
//             $("#detailFullName").text(data.fullName);
//             $("#detailDateOfBirth").text(data.dateOfBirth);
//             $("#detailNationality").text(data.nationality);
//             $("#detailHometown").text(data.hometown);
//             $("#detailMemberType").text(data.memberType);
//
//             if (data.memberType === "PLAYER") {
//                 $("#playerDetails").show();
//                 $("#detailHeight").text(data.player.height);
//                 $("#detailWeight").text(data.player.weight);
//                 $("#detailBmi").text(data.player.bmi);
//                 $("#detailRanking").text(data.player.ranking);
//             } else {
//                 $("#playerDetails").hide();
//             }
//
//             $("#detailModal").show();
//         }
//     });
// }
//
// function closeDetailModal() {
//     $("#detailModal").hide();
// }
//
// // Chỉnh sửa
// function editMember(id) {
//     $.ajax({
//         url: `http://localhost:8080/api/members/${id}`,
//         type: "GET",
//         success: function (data) {
//             $("#editId").val(data.id);
//             $("#editFullName").val(data.fullName);
//             $("#editDateOfBirth").val(data.dateOfBirth);
//             $("#editNationality").val(data.nationality);
//             $("#editHometown").val(data.hometown);
//             $("#editMemberType").val(data.memberType);
//
//             if (data.memberType === "PLAYER") {
//                 $("#playerEditFields").show();
//                 $("#editHeight").val(data.player.height);
//                 $("#editWeight").val(data.player.weight);
//                 $("#editBmi").val(data.player.bmi);
//                 $("#editRanking").val(data.player.ranking);
//             } else {
//                 $("#playerEditFields").hide();
//             }
//
//             $("#editForm").show();
//         }
//     });
// }
//
// function closeEditForm() {
//     $("#editForm").hide();
// }
//
// // Cập nhật dữ liệu
// function updateMember() {
//     let id = $("#editId").val();
//     let member = {
//         fullName: $("#editFullName").val(),
//         dateOfBirth: $("#editDateOfBirth").val(),
//         nationality: $("#editNationality").val(),
//         hometown: $("#editHometown").val(),
//         memberType: $("#editMemberType").val()
//     };
//
//     if (member.memberType === "PLAYER") {
//         member.player = {
//             height: $("#editHeight").val(),
//             weight: $("#editWeight").val(),
//             bmi: $("#editBmi").val(),
//             ranking: $("#editRanking").val()
//         };
//     }
//
//     $.ajax({
//         url: `http://localhost:8080/api/members/${id}`,
//         type: "PUT",
//         contentType: "application/json",
//         data: JSON.stringify(member),
//         success: function () {
//             alert("Cập nhật thành công!");
//             $("#editForm").hide();
//             loadMembers();
//         }
//     });
// }
//
// // Xóa dữ liệu
// function deleteMember(id) {
//     if (confirm("Bạn có chắc chắn muốn xóa?")) {
//         $.ajax({
//             url: `http://localhost:8080/api/members/${id}`,
//             type: "DELETE",
//             success: function () {
//                 alert("Xóa thành công!");
//                 loadMembers();
//             }
//         });
//     }
// }

