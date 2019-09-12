$(document).ready(function () {
    $(".form").slideDown(500);

    //切换至注册窗口
    $("#registered").click(function () {
        toRegis();
    });

    //切换至登录窗口
    $("#landing").click(function () {
        toLogin();
    });

    //回车事件
    $(document).keyup(function (event) {
        if (event.keyCode === 13) {
            if ($("#landing-content").css('display') !== 'none') {
                $("#login").click();
            } else {
                $("#register").click();
            }
        }
    });
});

//切换至登录窗口
function toLogin() {
    $("#registered").removeClass("on");
    $("#registered").addClass("not-on");
    $("#landing").addClass("on");
    $("#landing-content").show(500);
    $("#registered-content").hide(500);
}

//切换至注册窗口
function toRegis() {
    $("#landing").removeClass("on");
    $("#landing").addClass("not-on");
    $("#landing-content").hide(500);
    $("#registered").addClass("on");
    $("#registered-content").show(500);
}



