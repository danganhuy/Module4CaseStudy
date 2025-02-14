function login() {
    let name = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let user={
        "username":name,
        "password": password
    }
    $.ajax({
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        url: "http://localhost:8080/api/login",
        method: "POST",
        data: JSON.stringify(user),
        success: function (data) {
            let token = JSON.parse(JSON.stringify(data)).token;
            let username = JSON.parse(JSON.stringify(data)).username;
            let role = JSON.parse(JSON.stringify(data)).authorities[0].authority;
            localStorage.setItem("data", JSON.stringify(data))
            localStorage.setItem("token",token);
            localStorage.setItem("username",username);
            localStorage.setItem("role",role);
            switch (role) {
                case "ROLE_ADMIN":
                    window.location.href="../admin/index.html";
                    break;
                case "ROLE_COACH":
                    window.location.href="../coachaccount/index.html";
                    break;
                case "ROLE_PLAYER":
                    window.location.href="../playeraccount/index.html";
                    break;
            }
        },
        error: function (request, status, error) {
            alert("Incorrect username or password");
        }
    })
}

document.getElementById("buttonLogin").onclick = login;