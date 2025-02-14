document.getElementById('avatar').addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('avatarPreview').src = e.target.result;
            document.getElementById('avatarPreview').style.display = 'block';
        };
        reader.readAsDataURL(file);
    }
});
document.getElementById("memberType").addEventListener("change", function () {
    let playerFields = document.getElementById("playerFields");
    if (this.value === "PLAYER") {
        playerFields.style.display = "block";
    } else {
        playerFields.style.display = "none";
    }
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

$(document).ready(function () {
    $('#createForm').submit(function (event) {
        event.preventDefault();

        calculateBMI(); // Tính toán BMI trước khi lấy dữ liệu

        let memberData = {  // 🔥 Khai báo memberData trước khi sử dụng
            fullName: $('#fullName').val(),
            dateOfBirth: $('#dateOfBirth').val(),
            nationality: $('#nationality').val(),
            hometown: $('#hometown').val(),
            height: $('#height').val(),
            weight: $('#weight').val(),
            bmi: $('#bmi').val(),
            ranking: $('#ranking').val()
        };

        let formData = new FormData();
        formData.append("member", new Blob([JSON.stringify(memberData)], { type: "application/json" }));

        let imageFile = $("#avatar")[0].files[0];
        if (imageFile) {
            formData.append("avatar", imageFile);
        }

        $.ajax({
            url: `http://localhost:8080/api/members`,
            type: 'POST',
            contentType: false,
            processData: false,
            data: formData,
            success: function () {
                alert('Them moi thành công!');
                $('#updatePlayerContainer').fadeOut();
                location.reload();
            },
            error: function (xhr, status, error) {
                console.error('Lỗi khi them moi cầu thủ:', error);
                alert('them moi dữ liệu thanh cong.');
            }
        });
    });
});
