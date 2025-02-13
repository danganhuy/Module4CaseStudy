$(document).ready(function () {
    let urlParams = new URLSearchParams(window.location.search);
    let playerId = urlParams.get("id");

    if (playerId) {
        // Load chi tiết cầu thủ
        $.ajax({
            url: `http://localhost:8080/api/members/${playerId}/details`,
            type: "GET",
            success: function (data) {
                $("#detailFullName").text(data.fullName);
                $("#detailDateOfBirth").text(data.dateOfBirth);
                $("#detailNationality").text(data.nationality);
                $("#detailHometown").text(data.hometown);
                $("#detailMemberType").text(data.memberType);
                $("#detailHeight").text(data.height);
                $("#detailWeight").text(data.weight);
                $("#detailBmi").text(data.bmi);
                $("#detailRanking").text(data.ranking);
                if (data.fileName) {
                    $("#playerAvatar").attr("src", `http://localhost:8080/admin/files/${data.fileName}`);
                } else {
                    $("#playerAvatar").attr("src", "default-avatar.jpg"); // Ảnh mặc định
                }
            }
        });

        // Load dữ liệu cầu thủ vào form
        $.ajax({
            url: `http://localhost:8080/api/members/${playerId}/details`,
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                $('#fullName').val(data.fullName);
                $('#dateOfBirth').val(data.dateOfBirth);
                $('#nationality').val(data.nationality);
                $('#hometown').val(data.hometown);
                $("#memberType").val(data.memberType);
                if (data.memberType === 'PLAYER') {
                    $('#height').val(data.height);
                    $('#weight').val(data.weight);
                    $('#bmi').val(data.bmi);
                    $('#ranking').val(data.ranking);
                }
                if (data.fileName) {
                    $("#previewPlayerImage").attr("src", `http://localhost:8080/admin/files/${data.fileName}`);
                } else {
                    $("#previewPlayerImage").attr("src", "default-avatar.jpg"); // Ảnh mặc định
                }
            },
            error: function (xhr, status, error) {
                console.error('Lỗi khi lấy dữ liệu cầu thủ:', error);
                alert('Không thể tải dữ liệu cầu thủ.');
            }
        });
    }

    // Hiển thị form khi nhấn nút
    $('#editPlayerBtn').click(function () {
        $('#updatePlayerContainer').fadeIn();
    });

    // Ẩn form khi nhấn nút đóng
    $('#closeFormBtn').click(function () {
        $('#updatePlayerContainer').fadeOut();
    });

    // Tự động tính BMI khi thay đổi chiều cao hoặc cân nặng
    function calculateBMI() {
        let height = parseFloat($('#height').val())/100;
        let weight = parseFloat($('#weight').val());
        if (height > 0 && weight > 0) {
            let bmi = (weight / (height * height)).toFixed(2);
            $('#bmi').val(bmi);
        }
    }

    $('#height, #weight').on('input', calculateBMI);

    // Xem trước ảnh khi chọn file mới
    $("#playerImage").change(function (event) {
        let reader = new FileReader();
        reader.onload = function (e) {
            $("#previewPlayerImage").attr("src", e.target.result);
        };
        reader.readAsDataURL(event.target.files[0]);
    });

    // Xử lý sự kiện cập nhật
    $('#updatePlayerForm').submit(function (event) {
        event.preventDefault();

        calculateBMI();

        let formData = new FormData();
        formData.append("fullName", $('#fullName').val());
        formData.append("dateOfBirth", $('#dateOfBirth').val());
        formData.append("nationality", $('#nationality').val());
        formData.append("hometown", $('#hometown').val());
        formData.append("height", $('#height').val());
        formData.append("weight", $('#weight').val());
        formData.append("bmi", $('#bmi').val());
        formData.append("ranking", $('#ranking').val());

        let imageFile = $("#playerImage")[0].files[0];
        if (imageFile) {
            formData.append("avatar", imageFile);
        }


        $.ajax({
            url: `http://localhost:8080/api/members/${playerId}/update`,
            type: 'POST',
            contentType: false,
            processData: false,
            data: formData,
            success: function () {
                alert('Cập nhật thành công!');
                $('#updatePlayerContainer').fadeOut();
                location.reload();
            },
            error: function (xhr, status, error) {
                console.error('Lỗi khi cập nhật cầu thủ:', error);
                alert('Không thể cập nhật dữ liệu.');
            }
        });
    });
});