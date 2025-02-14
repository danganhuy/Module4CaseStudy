document.getElementById("memberType").addEventListener("change", function() {
    let playerFields = document.getElementById("playerFields");
    if (this.value === "PLAYER") {
        playerFields.style.display = "block";
    } else {
        playerFields.style.display = "none";
    }
});

document.getElementById("memberForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const memberData = {
        fullName: document.getElementById("fullName").value,
        dateOfBirth: document.getElementById("dateOfBirth").value,
        nationality: document.getElementById("nationality").value,
        hometown: document.getElementById("hometown").value,
        memberType: document.getElementById("memberType").value,
    };

    if (memberData.memberType === "PLAYER") {
        memberData.height = document.getElementById("height").value;
        memberData.weight = document.getElementById("weight").value;
        memberData.bmi = document.getElementById("bmi").value;
        memberData.ranking = document.getElementById("ranking").value;
        // memberData.team = document.getElementById("team").value;
        // memberData.position = document.getElementById("position").value;
    }

    fetch("http://localhost:8080/api/members", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(memberData)
    })
        .then(response => response.text())
        .then(data => alert(data))
        .catch(error => console.error("Lỗi:", error));
});