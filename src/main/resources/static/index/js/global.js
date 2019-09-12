//导航栏鼠标经过事件
$(function () {
    //首页搜索栏聚焦事件
    $("#search-input").focus(function () {
        $(".search-s").addClass("search-on");  //改变边框和icon的颜色
        $(".search-icon").addClass("icon-on");
    });

    //首页搜索栏失去焦点事件
    $("#search-input").blur(function () {
        $(".search-s").removeClass("search-on"); //恢复边框和icon的颜色
        $(".search-icon").removeClass("icon-on");
    });

    //首页搜索栏聚焦事件
    $("#search-input-m").focus(function () {
        $(".search-s").addClass("search-on");  //改变边框和icon的颜色
        $(".search-icon").addClass("icon-on");
    });

    //首页搜索栏失去焦点事件
    $("#search-input-m").blur(function () {
        $(".search-s").removeClass("search-on"); //恢复边框和icon的颜色
        $(".search-icon").removeClass("icon-on");
    });

    $(".a-login").hover(
        function () {   //鼠标移入显示下拉栏
            $(this).next(".nav-ul-m").stop(true, false).toggle();

        }, function () {    //鼠标移出隐藏下拉栏
            $(this).next(".nav-ul-m").stop(true, false).toggle();

        }
    );

    $(".nav-li-m").hover(
        function () {   //鼠标移入下拉栏显示下拉栏，并改变下拉栏背景色和字体色
            $(this).parent(".nav-ul-m").stop(true, false).toggle();
        }, function () {    //鼠标移出下拉栏隐藏下拉栏
            $(this).parent(".nav-ul-m").stop(true, false).toggle();

        }
    );

    $(".nb-a").hover(
        function () {   //鼠标移入显示下拉栏
            $(this).addClass('nb-a-hover');
        }, function () {    //鼠标移出隐藏下拉栏
            $(this).removeClass('nb-a-hover');
        }
    );
});

//隐藏/显示移动端侧边栏
function show_nav() {
    let dis = $("#nav-m-list").css('display');
    if (dis === 'none') {
        $("#nav-m-list").show(300);
    } else {
        $("#nav-m-list").hide(300);
    }
}





