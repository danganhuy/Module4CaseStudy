$(document).ready(function() {
    // Lấy ID từ URL
    const urlParams = new URLSearchParams(window.location.search);
    const coachId = urlParams.get('id');

    if (coachId) {
        $.ajax({
            url: `/api/coaches/${coachId}`,
            type: 'GET',
            dataType: 'json',
            success: function(member) {
                $('#coachId').text(member.id);
                $('#coachName').text(member.fullName);
                $('#coachDob').text(member.dateOfBirth);
                $('#coachNationality').text(member.nationality);
                $('#coachHometown').text(member.hometown);
                $('#coachType').text(member.memberType);
                $('#coachType').text(member.salary.salary);
                $('#coachType').text(member.memberType);
            },
            error: function(xhr, status, error) {
                console.error('Lỗi khi lấy dữ liệu huấn luyện viên:', error);
                alert('Không thể tải dữ liệu huấn luyện viên.');
            }
        });
    } else {
        alert('Không tìm thấy ID huấn luyện viên.');
    }
});
