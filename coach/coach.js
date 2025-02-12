$(document).ready(function() {
    $.ajax({
        url: 'http://localhost:8080/api/members',
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            let tableBody = '';
            let index = 1;
            data.forEach(function(member) {
                if (member.memberType === 'COACH') {
                    tableBody += `<tr>
                        <td>${index++}</td>
                        <td>${member.fullName}</td>
                        <td>${member.dateOfBirth}</td>
                        <td>${member.nationality}</td>
                        <td>${member.hometown}</td>
                    </tr>`;
                }
            });
            $('#coachTableBody').html(tableBody);
        },
        error: function(xhr, status, error) {
            console.error('Error fetching coaches:', error);
        }
    });
});
