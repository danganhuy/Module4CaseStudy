$(document).ready(function () {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');

    if (!id) {
        alert('Không tìm thấy ID huấn luyện viên.');
        return;
    }

    // Load dữ liệu huấn luyện viên
    $.ajax({
        url: `http://localhost:8080/api/members/${id}`,
        type: 'GET',
        dataType: 'json',
        success: function (member) {
            $('#coachId').text(member.id);
            $('#coachName').text(member.fullName);
            $('#coachDob').text(member.dateOfBirth);
            $('#coachNationality').text(member.nationality);
            $('#coachHometown').text(member.hometown);
            $('#coachType').text(member.memberType);

            $('#fullName').val(member.fullName);
            $('#dateOfBirth').val(member.dateOfBirth);
            $('#nationality').val(member.nationality);
            $('#hometown').val(member.hometown);
            $('#memberType').val(member.memberType);

            let avatarSrc = member.fileName ?
                `http://localhost:8080/admin/files/${member.fileName}` :
                "default-avatar.jpg";

            $("#coachAvatar").attr("src", avatarSrc);
            $("#previewCoachImage").attr("src", avatarSrc);
        },
        error: function (xhr, status, error) {
            console.error('Lỗi khi lấy dữ liệu huấn luyện viên:', error);
            alert('Không thể tải dữ liệu huấn luyện viên.');
        }
    });
    // Hiển thị form chỉnh sửa
    $('#editCoachBtn').click(function () {
        $('#updateCoachContainer').fadeIn();
    });

// Đóng form
    $('#closeFormBtn').click(function () {
        $('#updateCoachContainer').fadeOut();
    });
    // Xử lý cập nhật thông tin & ảnh
    $('#updateCoachForm').submit(function (event) {
        event.preventDefault();

        let formData = new FormData();
        formData.append("fullName", $('#fullName').val());
        formData.append("dateOfBirth", $('#dateOfBirth').val());
        formData.append("nationality", $('#nationality').val());
        formData.append("hometown", $('#hometown').val());
        formData.append("memberType", $('#memberType').val());

        let fileInput = $('#coachImage')[0];
        if (fileInput && fileInput.files.length > 0) {
            formData.append("image", fileInput.files[0]);
        }

        $.ajax({
            url: `http://localhost:8080/api/members/${id}`,
            type: 'PUT',
            data: formData,
            processData: false,
            contentType: false,
            success: function () {
                alert('Cập nhật thành công!');
                $('#updateCoachContainer').fadeOut();
                window.location.href = 'coach.html';
            },
            error: function (xhr, status, error) {
                console.error('Lỗi khi cập nhật huấn luyện viên:', error);
                alert('Không thể cập nhật dữ liệu.');
            }
        });
    });
});