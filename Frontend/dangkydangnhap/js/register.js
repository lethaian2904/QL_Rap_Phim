// ĐĂNG KÝ 

function validation() {
    if(document.Formfill.Username.value=="") {
        document.getElementById("result").innerHTML = "Nhập tài khoản*";
        return false;
    }
    else if (document.Formfill.Username.value.length<6) {
        document.getElementById("result").innerHTML = "Tài khoản ít nhất 6 chữ số*";
        return false;
    }
    else if (document.Formfill.Email.value=="") {
        document.getElementById("result").innerHTML = "Nhập email*";
        return false;
    }
    else if (document.Formfill.Password.value=="") {
        document.getElementById("result").innerHTML = "Nhập mật khẩu*";
        return false;
    }
    else if (document.Formfill.Password.value.length<6) {
        document.getElementById("result").innerHTML = "Mật khẩu nên ít nhất 6 chữ số*";
        return false;
    }
    else if (document.Formfill.CPassword.value=="") {
        document.getElementById("result").innerHTML = "Nhập xác nhận mật khẩu*";
        return false;
    }
    else if (document.Formfill.CPassword.value !== document.Formfill.Password.value) {
        document.getElementById("result").innerHTML = "Mật khẩu không khớp*";
        return false;
    }
    else if (document.Formfill.Password.value == document.Formfill.CPassword.value) {
        popup.classList.add("open-slide")
        return false;
    }

}

var popup=document.getElementById('popup');
function closeSlide() {
    popup.classList.remove("open-slide")
}