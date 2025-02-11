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
