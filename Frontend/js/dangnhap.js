$(document).ready(function () {

    $("#btn-signin").click(function () {

        var username = $("#username").val()
        var password = $("#password").val()

        if (!username || !password) {
            alert("Dien thieu thong tin");
            return;
        }

        $.ajax({
            method: "POST",
            url: "http://localhost:8080/api/auth/signin",
            data: { username: username, password: password }
        })
            .done(function (msg) {
                if (msg.data) {
                    window.location.href = "./index.html"
                } else {
                    alert("Dang nhap that bai");
                }

            });
    })

})