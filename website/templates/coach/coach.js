$(document).ready(function() {
    // Định nghĩa hàm loadMembers() trong phạm vi toàn cục
    window.loadMembers = function (filterType = "", searchQuery = "") {
        $.ajax({
            url: 'http://localhost:8080/api/members',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                coaches = data.filter(member => member.memberType === 'COACH');
                renderCoachTable(filterType, searchQuery);
            },
            error: function (xhr, status, error) {
                console.error('Error fetching members:', error);
            }
        });
    };

    let coaches = [];
    let currentPageCoach = 1;
    let pageSizeCoach = 5; // Số lượng huấn luyện viên hiển thị trên mỗi trang

    function renderCoachTable(filterType = "", searchQuery = "") {
        let start = (currentPageCoach - 1) * pageSizeCoach;
        let end = start + pageSizeCoach;
        let tableBody = '';
        let index = start + 1;

        let filteredData = coaches.filter(member => {
            let nameMatch = searchQuery === "" || member.fullName.toLowerCase().includes(searchQuery.toLowerCase());
            let typeMatch = filterType === "" || member.memberType === filterType;
            return nameMatch && typeMatch;
        });

        if (filteredData.length === 0) {
            tableBody = "<tr><td colspan='8' style='text-align: center;'>Không tìm thấy kết quả</td></tr>";
        } else {
            let paginatedData = filteredData.slice(start, end);
            paginatedData.forEach(function (coach) {
                tableBody += `<tr>
                <td>${index++}</td>
                <td><img src="http://localhost:8080/admin/files/${coach.fileName}" alt="Avatar" style="width: 200px; height: 200px; object-fit: cover; border-radius: 10px;"></td>
                <td>${coach.fullName}</td>
                <td>${coach.dateOfBirth}</td>
                <td>${coach.nationality}</td>
                <td>${coach.hometown}</td>
                <td><button onclick="viewDetail(${coach.id})">Chi tiết</button></td>
            </tr>`;
            });
        }

        $('#coachTableBody').html(tableBody);
        updateCoachPaginationButtons(filteredData.length);
    }

    function updateCoachPaginationButtons(totalItems) {
        let totalPages = Math.ceil(totalItems / pageSizeCoach);
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

    // Bắt sự kiện khi nhấn nút tìm kiếm
    $("#btnSearchMember").click(function () {
        let searchQuery = $("#searchMember").val().trim();
        let selectedType = $("#filterMemberType").val();
        loadMembers(selectedType, searchQuery);
    });

    // Bắt sự kiện khi chọn loại thành viên
    $("#filterMemberType").change(function () {
        let selectedType = $(this).val();
        let searchQuery = $("#searchMember").val().trim();
        loadMembers(selectedType, searchQuery);
    });
});

function viewDetail(id) {
    window.location.href = `viewCoach.html?id=${id}`;
}

function create() {
    window.location.href = '../admin/create.html';
}

