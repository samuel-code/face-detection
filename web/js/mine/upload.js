/**
 * Created by tanshijun-pc on 2017/11/5.
 */
$(function () {
    $(":button").click(function () {
        ajaxFileUpload();
    })
})
function ajaxFileUpload() {
    $.ajaxFileUpload
    (
        {
            url: '/api/filecenter/authen/upload?channel=web', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'file', //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
                //$("#img1").attr("src", data.imgurl);
                if (typeof (data.error) != 'undefined') {
                    if (data.error != '') {
                        alert(data.error);
                    } else {
                        alert(data.msg);
                    }
                }
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert(e);
            }
        }
    )
    return false;
}