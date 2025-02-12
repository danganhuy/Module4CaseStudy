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
        let height = parseFloat($('#height').val());
        let weight = parseFloat($('#weight').val());
        if (height > 0 && weight > 0) {
            let bmi = (weight / (height * height)).toFixed(2);
            $('#bmi').val(bmi);
        }
    }

    $('#height, #weight').on('input', calculateBMI);

    // Xử lý sự kiện cập nhật
    $('#updatePlayerForm').submit(function (event) {
        event.preventDefault();

        const updatedPlayer = {
            fullName: $('#fullName').val(),
            dateOfBirth: $('#dateOfBirth').val(),
            nationality: $('#nationality').val(),
            hometown: $('#hometown').val(),
            height: $('#height').val(),
            weight: $('#weight').val(),
            bmi: $('#bmi').val(),
            ranking: $('#ranking').val()
        };

        $.ajax({
            url: `http://localhost:8080/api/members/${playerId}`,
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(updatedPlayer),
            success: function () {
                alert('Cập nhật thành công!');
                $('#updatePlayerContainer').fadeOut();
                window.location.href = 'playerlist.html'; // Chuyển về danh sách cầu thủ
            },
            error: function (xhr, status, error) {
                console.error('Lỗi khi cập nhật cầu thủ:', error);
                alert('Không thể cập nhật dữ liệu.');
            }
        });
    });
});
