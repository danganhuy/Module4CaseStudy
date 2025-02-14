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
            window.location.href="index.html";
        },
        error: function (request, status, error) {
            // document.getElementById("error_message").innerText = "Incorrect username or password";
            alert("Incorrect username or password");
        }
    })
}

document.getElementById("buttonLogin").onclick = login;