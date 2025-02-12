function loadMembers(filterType = "") {
    let url = "http://localhost:8080/api/members";
    if (filterType) {
        url += `?memberType=${filterType}`;
    }

    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            let tableBody = $("#memberTableBody");
            tableBody.empty();

            data.forEach(member => {
                let row = `
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.fullName}</td>
                        <td>${member.dateOfBirth}</td>
                        <td>${member.nationality}</td>
                        <td>${member.hometown}</td>
                        <td>${member.memberType}</td>
                        <td>
                            <button onclick="viewDetail(${member.id})">Chi tiết</button>
                        </td>
                        <td>
                            <button onclick="editMember(${member.id})">Sửa</button>
                        </td>
                        <td>
                            <button onclick="deleteMember(${member.id})">Xóa</button>
                        </td>
                    </tr>
                `;
                tableBody.append(row);
            });
        },
        error: function () {
            alert("Không thể tải danh sách thành viên.");
        }
    });
}
loadMembers();

function deleteMember(id) {
    if (confirm("Bạn có chắc chắn muốn xóa?")) {
        $.ajax({
            url: `http://localhost:8080/api/members/${id}`,
            type: "DELETE",
            success: function () {
                alert("Xóa thành công!");
                loadMembers();
            },
            error: function () {
                alert("Xóa thất bại, có thể do lỗi hệ thống hoặc ràng buộc dữ liệu.");
            }
        });
    }
}
