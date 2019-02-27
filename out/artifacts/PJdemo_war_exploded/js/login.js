try {
    $(document).ready(function () {
        $("#login_in").click(function () {
            $.post("./login",
            $("#login_form").serialize(),
            function (data) {
                data = JSON.parse(data); // get js object
                if (data.existed === "TRUE") {
                    if (data.password === "TRUE") {
                        window.location.href = "../"; //回到首页
                    }
                    else {
                        alert("用户名和密码错误")
                    }
                }
                else {
                    alert("用户名和密码错误")
                }
            })
        })
    })
}
catch (e){
    alert(e.message());
}
