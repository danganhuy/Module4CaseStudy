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
                    if (member.fileName) {
                        $("#coachAvatar").attr("src", `http://localhost:8080/admin/files/${member.fileName}`);
                    } else {
                        $("#coachAvatar").attr("src", "default-avatar.jpg"); // Ảnh mặc định
                    }
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
                 if (member.fileName) {
                     $("#previewCoachImage").attr("src", `http://localhost:8080/admin/files/${member.fileName}`);
                 } else {
                     $("#previewCoachImage").attr("src", "default-avatar.jpg"); // Ảnh mặc định
                 }
             },
             error: function (xhr, status, error) {
                 console.error('Lỗi khi lấy dữ liệu huấn luyện viên:', error);
                 alert('Không thể tải dữ liệu huấn luyện viên.');
             }
         });
     }

     // Xem trước ảnh khi chọn file mới
     $("#coachImage").change(function (event) {
         let reader = new FileReader();
         reader.onload = function (e) {
             $("#previewCoachImage").attr("src", e.target.result);
         };
         reader.readAsDataURL(event.target.files[0]);
     });

     // Xử lý sự kiện cập nhật
     $('#updateCoachForm').submit(function (event) {
         event.preventDefault();

         let formData = new FormData();
         formData.append("fullName", $('#fullName').val());
         formData.append("dateOfBirth", $('#dateOfBirth').val());
         formData.append("nationality", $('#nationality').val());
         formData.append("hometown", $('#hometown').val());
         formData.append("memberType", $('#memberType').val());

         let imageFile = $("#coachImage")[0].files[0];
         if (imageFile) {
             formData.append("avatar", imageFile);
         }

         $.ajax({
             url: `http://localhost:8080/api/members/${id}/update`,
             type: "POST",
             processData: false,
             contentType: false,
             data: formData,
             success: function (response) {
                 alert('Cập nhật thành công!');
                 $('#updateCoachContainer').fadeOut();
                 location.reload();
             },
             error: function (xhr, status, error) {
                 console.error("Lỗi cập nhật:", error);
                 alert("Không thể cập nhật dữ liệu.");
             }
         });
     });

 });