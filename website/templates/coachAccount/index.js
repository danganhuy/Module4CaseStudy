$(document).ready(function () {
    $.ajax({
        headers:{
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        url: `http://localhost:8080/coach/details`,
        type: 'GET',
        dataType: 'json',
        success: function (member) {
            $('#coachId').text(member.id);
            $('#coachName').text(member.fullName);
            $('#coachDob').text(member.dateOfBirth);
            $('#coachNationality').text(member.nationality);
            $('#coachHometown').text(member.hometown);
        },
        error: function (xhr, status, error) {
            alert('Không thể tải dữ liệu huấn luyện viên.');
        }
    });
    $.ajax({
        headers:{
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        url: `http://localhost:8080/coach/team`,
        type: 'GET',
        dataType: 'json',
        success: function (team) {
            $('#coachTeam').text(team.name);
            $('#coachPlayerCount').text(team.playerCount);
        },
        error: function (xhr, status, error) {
            alert('Không thể tải dữ liệu đội bóng của huấn luyện viên.');
        }
    });
});