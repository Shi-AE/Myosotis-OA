$().ready(() => {
    $("#resetUserSubmit").click(() => {
        // console.log($("#resetUser").serialize());
        $.ajax({
            url: "../../reset/user/servlet",
            type: "POST",
            data: $("#resetUser").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if(res) {
                    window.alert("重置成功");
                } else {
                    window.alert("重置失败");
                }
            }
        });
    });

    $("#resetAdminSubmit").click(() => {
        // console.log($("#resetAdmin").serialize());
        $.ajax({
            url: "../../reset/admin/servlet",
            type: "POST",
            data: $("#resetAdmin").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if(res) {
                    window.alert("重置成功");
                } else {
                    window.alert("重置失败");
                }
            }
        });
    });

    $("#updateAdminSubmit").click(() => {
        $.ajax({
            url: "../../update/admin/servlet",
            type: "POST",
            data: $("#updateAdmin").serialize(),
            success: (res) => {
                res = JSON.parse(res);
                if(res) {
                    window.alert("添加成功");
                } else {
                    window.alert("添加失败");
                }
            }
        });
    });
})