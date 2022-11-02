$().ready(() => {
    $(".log").click(() => {
        location.href = "";
    })

    //退出系统关闭session
    $("header .exit").click(() => {
        $.ajax({
            url: "../../exit/servlet",
            type: "GET",
            success: () => {
                location.href = "../../common/exit.html";
            }
        })
    })
})