<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>财务支付管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
</head>

<body data-type="generalComponents">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">${user.name}</span><span
                        class="tpl-header-list-user-ico"> <img
                        src="assets/img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="login.jsp"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>
<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list ">
                        <i class="am-icon-table"></i>
                        <span>付款管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li>
                            <a href="ticket-open.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>开具付款凭证</span>
                            </a>
                            <a href="open-list.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>付款列表</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list" active>
                        <i class="am-icon-wpforms"></i>
                        <span>工作台</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <a href="check-list.jsp" class="active">
                                <i class="am-icon-angle-right"></i>
                                <span>付款复核</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            付款复核
        </div>
        <ol class="am-breadcrumb">
            <li class="am-active"><a style="color: #999999;">工作台</a></li>
            <li class="am-active">付款复核</li>
            <li class="am-active">付款复核详情</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    凭证基本信息
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block ">
                <div class="am-g tpl-amazeui-form">
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <%--@declare id="user-name"--%><label for="user-name" class="am-u-sm-3 am-form-label">凭证编号</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    <%-- N20220328000001--%>
                                    ${ticketInfoviewUitlity.no}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">处理状态</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.status} <span id="review-the-information"
                                                                          style="font-size: 12px;color: #999;margin-left: 5px;"> 内部复核中</span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">开单企业</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.openename}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">统一社会信用代码</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.openesuc}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">收单企业</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.receiptename}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">统一社会信用代码</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.receiptesuc}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">凭证金额</label>
                                <div class="am-u-sm-9" style="font-size: 19px;color: red;font-weight: 500;">
                                    ${ticketInfoviewUitlity.amount}元
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">金融机构</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.institutyname}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">开单日期</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.createTime}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">到期日期</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.expriyTime} <span id="dete-diference"
                                                                              style="font-size: 12px;color: #999"></span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">付息方式</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.paymentInterestItype}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">备注</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    ${ticketInfoviewUitlity.ticketRemark}
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                    </div>
                </div>
            </div>
        </div>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    复核备注
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block ">
                <div class="am-g tpl-amazeui-form">
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label for="user-name" class="am-u-sm-3 am-form-label">备注</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                    <textarea class="" rows="4" id="reject-apply-text" placeholder="驳回必填"></textarea>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div style="text-align: center;margin-top:40px">
                    <a id="reject-apply-button" class="am-btn am-btn-default" href="check-list.jsp">驳&nbsp;&nbsp;&nbsp;&nbsp;
                        回</a>
                    <a id="agree-apply-button" class="am-btn am-btn-primary" href="check-list.jsp"
                       style="margin-left:20px">复核通过</a>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script>
    $(document).ready(function (){

    })
    $("#reject-apply-button").click(function () {
        var rejectapplytext = $("#reject-apply-text").val();
        if (rejectapplytext == undefined || rejectapplytext == null || rejectapplytext == "") {
            judge();
        } else {
            var ticketId = "${ticketInfoviewUitlity.ticket_id}";
            var createtime = "${ticketInfoviewUitlity.createTime}";
            var statusofaudit = "审核未通过";
            var reviewcecordremark = $("[id='reject-apply-text']").val();
            $.get("reviewrecordservlet", "reviewrecordservletstate=1" +
                "&ticket_open_id=" + ticketId +
                "&creator_id=${user.id}" +
                "&review_status=" + statusofaudit +
                "&remark=" + reviewcecordremark +
                "&create_time=" + createtime
                , function (returnnn) {
                    if (returnnn != null || returnnn != undefined) {
                        window.location.replace("check-list.jsp");
                    }
                });
            $.get("ticketopentservlet","ticketopentservletstate=8" +
                "&ticketopenstatus=复核未通过" +
                "&ticketopenid=${ticketInfoviewUitlity.ticket_id}",function (panduan) {
                if (panduan != null || panduan != undefined) {
                    alert("审核未通过")
                }
            })
        }
    })

    $("#agree-apply-button").click(function () {
        var ticketId = "${ticketInfoviewUitlity.ticket_id}";
        var createtime = "${ticketInfoviewUitlity.createTime}";
        var statusofaudit = "审核通过";
        var reviewcecordremark = $("[id='reject-apply-text']").val();
        $.get("reviewrecordservlet", "reviewrecordservletstate=1" +
            "&ticket_open_id=" + ticketId +
            "&creator_id=${user.id}" +
            "&review_status=" + statusofaudit +
            "&remark=" + reviewcecordremark +
            "&create_time=" + createtime
            , function (returnnn) {
                if (returnnn != null || returnnn != undefined) {
                    window.location.replace("check-list.jsp");
                }
            });
        $.get("ticketopentservlet","ticketopentservletstate=8" +
            "&ticketopenstatus=成功" +
            "&ticketopenid=${ticketInfoviewUitlity.ticket_id}",function (panduan) {
            if (panduan != null || panduan != undefined) {
                alert("审核通过")
            }
        })

    })

    function judge() {
        window.confirm("驳回请添加备注");

    }

    $(document).ready(function () {

        var auditstatus = "${ticketInfoviewUitlity.status}";
        if (auditstatus == "成功") {
            $("#review-the-information").html("审核完毕")
        }
        if (auditstatus == "开单中") {
            $("#review-the-information").html("审核中")
        }
        if (auditstatus == "已撤销") {
            $("#review-the-information").html("未审核")
        }
        if (auditstatus == "复核未通过") {
            $("#review-the-information").html("已驳回")
        }

        var createtime = "${ticketInfoviewUitlity.createTime}";
        var expriytime = "${ticketInfoviewUitlity.expriyTime}";
        var diferdate = ((new Date(expriytime)) - (new Date(createtime))) / (24 * 3600 * 1000)
        $("#dete-diference").html("剩余" + diferdate + "天");

    })

</script>
</html>