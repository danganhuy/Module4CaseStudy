$(document).ready(function() {
    let coaches = [];
    let currentPageCoach = 1;
    let pageSizeCoach = 5; // Số lượng huấn luyện viên hiển thị trên mỗi trang

    function renderCoachTable() {
        let start = (currentPageCoach - 1) * pageSizeCoach;
        let end = start + pageSizeCoach;
        let tableBody = '';
        let index = start + 1;

        let paginatedData = coaches.slice(start, end);
        paginatedData.forEach(function(coach) {
            tableBody += `<tr>
                <td>${index++}</td>
                <td><img src="http://localhost:8080/admin/files/${coach.fileName}" alt="Avatar" style="width: 200px; height: 200px; object-fit: cover; border-radius: 10px;"></td>
                <td>${coach.fullName}</td>
                <td>${coach.dateOfBirth}</td>
                <td>${coach.nationality}</td>
                <td>${coach.hometown}</td>
                <td><button onclick="viewDetail(${coach.id})">Chi tiết</button></td>
                <td><button onclick="deleteCoach(${coach.id})">Xoa</button></td>
            </tr>`;
        });


        $('#coachTableBody').html(tableBody);
        updateCoachPaginationButtons();
    }

    function updateCoachPaginationButtons() {
        let totalPages = Math.ceil(coaches.length / pageSizeCoach);
        $('#paginationInfoCoach').text(`Trang ${currentPageCoach} / ${totalPages}`);

        $('#prevPageCoach').prop('disabled', currentPageCoach === 1);
        $('#nextPageCoach').prop('disabled', currentPageCoach >= totalPages);
    }

    $.ajax({
        url: 'http://localhost:8080/api/members',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            coaches = data.filter(member => member.memberType === 'COACH');
            renderCoachTable();
        },
        error: function(xhr, status, error) {
            console.error('Error fetching coaches:', error);
        }
    });

    $('#prevPageCoach').click(function() {
        if (currentPageCoach > 1) {
            currentPageCoach--;
            renderCoachTable();
        }
    });

    $('#nextPageCoach').click(function() {
        let totalPages = Math.ceil(coaches.length / pageSizeCoach);
        if (currentPageCoach < totalPages) {
            currentPageCoach++;
            renderCoachTable();
        }
    });
});

function viewDetail(id) {
    window.location.href = `view.html?id=${id}`;
}

function deleteCoach(id) {
    if (confirm("Bạn có chắc chắn muốn xóa huấn luyện viên này không?")) {
        $.ajax({
            url: `http://localhost:8080/api/members/${id}`,
            type: 'DELETE',
            success: function() {
                alert("Xóa thành công!");
                location.reload(); // Làm mới trang để cập nhật danh sách
            },
            error: function(xhr, status, error) {
                console.error("Lỗi khi xóa huấn luyện viên:", error);
                alert("Không thể xóa huấn luyện viên.");
            }
        });
    }
}