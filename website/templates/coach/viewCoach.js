 $(document).ready(function () {
        // Lấy ID từ URL
        const urlParams = new URLSearchParams(window.location.search);
        const id = urlParams.get('id');

        if (id) {
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
                    // $('#coachType').text(member.salary.salary);
                    // $('#coachType').text(member.memberType);
                },
                error: function (xhr, status, error) {
                    console.error('Lỗi khi lấy dữ liệu huấn luyện viên:', error);
                    alert('Không thể tải dữ liệu huấn luyện viên.');
                }
            });
        } else {
            alert('Không tìm thấy ID huấn luyện viên.');
        }
    });

 $(document).ready(function () {
     // Hiển thị form khi nhấn nút
     $('#editCoachBtn').click(function () {
         $('#updateCoachContainer').fadeIn();
     });

     // Ẩn form khi nhấn nút đóng
     $('#closeFormBtn').click(function () {
         $('#updateCoachContainer').fadeOut();
     });

     // Lấy ID từ URL
     const urlParams = new URLSearchParams(window.location.search);
     const id = urlParams.get('id');

     if (id) {
         // Load dữ liệu huấn luyện viên vào form
         $.ajax({
             url: `http://localhost:8080/api/members/${id}`,
             type: 'GET',
             dataType: 'json',
             success: function (member) {
                 $('#fullName').val(member.fullName);
                 $('#dateOfBirth').val(member.dateOfBirth);
                 $('#nationality').val(member.nationality);
                 $('#hometown').val(member.hometown);
                 $('#memberType').val(member.memberType);
             },
             error: function (xhr, status, error) {
                 console.error('Lỗi khi lấy dữ liệu huấn luyện viên:', error);
                 alert('Không thể tải dữ liệu huấn luyện viên.');
             }
         });
     }

     // Xử lý sự kiện cập nhật
     $('#updateCoachForm').submit(function (event) {
         event.preventDefault();

         const updatedCoach = {
             fullName: $('#fullName').val(),
             dateOfBirth: $('#dateOfBirth').val(),
             nationality: $('#nationality').val(),
             hometown: $('#hometown').val(),
             memberType: $('#memberType').val()
         };

         $.ajax({
             url: `http://localhost:8080/api/members/${id}`,
             type: 'PUT',
             contentType: 'application/json',
             data: JSON.stringify(updatedCoach),
             success: function () {
                 alert('Cập nhật thành công!');
                 $('#updateCoachContainer').fadeOut();
                 window.location.href = 'coach.html'; // Chuyển về danh sách
             },
             error: function (xhr, status, error) {
                 console.error('Lỗi khi cập nhật huấn luyện viên:', error);
                 alert('Không thể cập nhật dữ liệu.');
             }
         });
     });
 });