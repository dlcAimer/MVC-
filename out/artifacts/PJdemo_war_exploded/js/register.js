
// 异步请求demo
try {
    $(document).ready(function () {
        $("#register_up").click(function () {
            try {
                var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})/;
                var pattern_pass = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,}$/;
                var password = $("input[name=\"password\"]").val();
                var check_password = $("input[name=\"check_password\"]").val();
                var password_test = ((password === check_password) && pattern_pass.test(password));
                var email_test = pattern.test($("#email").val());
                if (password_test && email_test) {
                    $.post("./register", // path
                        $("#registerForm").serialize(), //data
                        function (data) {
                            data = JSON.parse(data); // get js object
                            if (data.result === "OK") {
                                window.location.href = "../";
                            }
                            else {
                                alert(data.error);
                            }
                        }
                    ).success(function (data) { // callback function
                        //for test
                    }).fail(function (jqXHR, textStatus, error) {
                        alert(textStatus + ": " + jqXHR);
                    });
                }
                else {
                    if (email_test) {
                        if (pattern_pass.test(password)) {
                            alert("两次密码不相同");
                        }
                        else {
                            alert("密码格式不正确，至少包含4位及以上数字和字母")
                        }
                    }
                    else {
                        alert("邮箱格式不正确");
                    }
                }

            } catch (e) {
                alert(e.message);
            }
        });
    });
} catch (e) {
    alert(e.message());
}