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
                <td>${coach.fullName}</td>
                <td>${coach.dateOfBirth}</td>
                <td>${coach.nationality}</td>
                <td>${coach.hometown}</td>
                <td><button onclick="viewDetail(${coach.id})">Chi tiết</button></td>
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
    window.location.href = `viewCoach.html?id=${id}`;
}
