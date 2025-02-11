function login() {
    // lay du lieu
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
        success: function (data){
            let token = JSON.parse(JSON.stringify(data)).token;
            localStorage.setItem("token",token);
            window.location.href="index.html";
        }
    })
}

document.getElementById("buttonLogin").onclick = login;