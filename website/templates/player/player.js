$(document).ready(function() {

    let members = [];
    let currentPage = 1;
    let pageSize = 5; // Số lượng thành viên hiển thị trên mỗi trang

    window.loadMembers = function (filterType = "", searchQuery = "") {
        $.ajax({
            url: 'http://localhost:8080/api/members',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                members = data.filter(member => member.memberType === 'PLAYER');
                renderTable(filterType, searchQuery);
            },
            error: function (xhr, status, error) {
                console.error('Error fetching members:', error);
            }
        });
    };

    function renderTable(filterType = "", searchQuery = "") {
        let start = (currentPage - 1) * pageSize;
        let end = start + pageSize;
        let tableBody = '';
        let index = start + 1;

        let filteredData = members.filter(member => {
            let nameMatch = searchQuery === "" || member.fullName.toLowerCase().includes(searchQuery.toLowerCase());
            let typeMatch = filterType === "" || member.memberType === filterType;
            return nameMatch && typeMatch;
        });

        if (filteredData.length === 0) {
            tableBody = "<tr><td colspan='7' style='text-align: center;'>Không tìm thấy kết quả</td></tr>";
        } else {
            let paginatedData = filteredData.slice(start, end);
            paginatedData.forEach(function(member) {
                tableBody += `<tr>
                    <td>${index++}</td>
                    <td><img src="http://localhost:8080/admin/files/${member.fileName}" alt="Avatar" style="width: 200px; height: 200px; object-fit: cover; border-radius: 10px;"></td>
                    <td>${member.fullName}</td>
                    <td>${member.dateOfBirth}</td>
                    <td>${member.nationality}</td>
                    <td>${member.hometown}</td>
                    <td><button onclick="viewDetail(${member.id})">Chi tiết</button></td>
                </tr>`;
            });
        }

        $('#playerTableBody').html(tableBody);
        updatePaginationButtons(filteredData.length);
    }

    function updatePaginationButtons(totalItems) {
        let totalPages = Math.ceil(totalItems / pageSize);
        $('#paginationInfo').text(`Trang ${currentPage} / ${totalPages}`);

        $('#prevPage').prop('disabled', currentPage === 1);
        $('#nextPage').prop('disabled', currentPage >= totalPages);
    }

    $.ajax({
        url: 'http://localhost:8080/api/members',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            members = data.filter(member => member.memberType === 'PLAYER');
            renderTable();
        },
        error: function(xhr, status, error) {
            console.error('Error fetching player:', error);
        }
    });

    $('#prevPage').click(function() {
        if (currentPage > 1) {
            currentPage--;
            renderTable();
        }
    });

    $('#nextPage').click(function() {
        let totalPages = Math.ceil(members.length / pageSize);
        if (currentPage < totalPages) {
            currentPage++;
            renderTable();
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
    window.location.href = `viewPlayer.html?id=${id}`;
}
