$(document).ready(function() {
    $.ajax({
        url: 'http://localhost:8080/api/members',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            let tableBody = '';
            let index = 1;
            data.forEach(function(member) {
                if (member.memberType === 'PLAYER') {
                    tableBody += `<tr>
                        <td>${index++}</td>
                        <td>${member.fullName}</td>
                        <td>${member.dateOfBirth}</td>
                        <td>${member.nationality}</td>
                        <td>${member.hometown}</td>
                        <td><button onclick="viewDetail(${member.id})">Chi tiết</button></td>
                    </tr>`;
                }
            });
            $('#playerTableBody').html(tableBody);
        },
        error: function(xhr, status, error) {
            console.error('Error fetching player:', error);
        }
    });
});

function viewDetail(id) {
    window.location.href = `view.html?id=${id}`;
}