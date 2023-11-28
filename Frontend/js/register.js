$(document).ready(function () {

    $("#btn-signup").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();


        // Validate inputs (you may want to add more validation)
        if (!username || !password) {
            alert("Dien thieu thong tin");
            return;
        }

        var role = 1;

        // Send registration request
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/api/auth/signup",
            contentType: "application/json",  // Set content type to JSON
            data: JSON.stringify({
                username: username,
                password: password,
                role: role
            })
        })
            .done(function (msg) {
                if (msg.data) {
                    alert("Danh ky thanh cong")
                } else {
                    alert("Dang ky that bai");
                }

            });
    });
});
