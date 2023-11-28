$(document).ready(function () {
    // When the document is ready, bind a click event to the "Lưu thay đổi" button
    $("#save").on("click", function () {
        // Retrieve values from input fields
        var fullname = $("#fullname").val();
        var email = $("#email").val();

        // Perform AJAX request to update information using PUT method
        $.ajax({
            url: "/update-account-general",  // Replace with the actual endpoint for updating account general information
            method: "PUT", // Change method to PUT
            data: {
                fullname: fullname,
                email: email
            },
            success: function (response) {
                // Handle success, you can display a success message or perform additional actions
                console.log("Cap nhat thanh cong");
            },
            error: function (error) {
                // Handle error, you can display an error message or perform additional actions
                console.error("Cap nhat that bai", error);
            }
        });
    });
});
