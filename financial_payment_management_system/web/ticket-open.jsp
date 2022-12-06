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
    <style>
        .star::before {
            content: '*';
            color: #F56C6C;
            margin-right: 0.020833rem;
        }

        .am-selected {
            width: 100%
        }

        .am-selected-status {
            font-size: 13px;
            color: #999;
        }
    </style>
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
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>付款管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <a href="ticket-open.jsp" class="active">
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
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-wpforms"></i>
                        <span>工作台</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li>
                            <a href="check-list.jsp">
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
            开具付款凭证
        </div>
        <ol class="am-breadcrumb">
            <li class="am-active"><a style="color: #999999;">付款管理</a></li>
            <li class="am-active">开具付款凭证</li>
        </ol>
        <div class="tpl-portlet-components">
            <!-- 表单填写页面 -->
            <div class="tpl-block" id="showDiv">
                <div class="">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            凭证信息
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
                                        <label for="user-name" class="am-u-sm-3 am-form-label star"> 开单企业</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <input disabled type="text" id="enterprise1-name"
                                                   value=""
                                                   placeholder="请输入开单企业">

                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">统一社会信用代码</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <input disabled type="text" id="open-suc"
                                                   value=""
                                                   placeholder="请输入统一社会信用代码">
                                            <%--                                            ${enterparesbysesson.socialUniformCcode}--%>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label star"> 收单企业</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <select data-am-selected id="order-receiving-enterprise">
                                                <option value="">请选择收单企业</option>
                                                <%--                                                <option value="a">百度科技有限公司</option>--%>
                                                <%--                                                <option value="b">京东集团</option>--%>
                                                <%--                                                <option value="c">小米</option>--%>
                                            </select>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">统一社会信用代码</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;"
                                             id="reci-enterpeise-esuc-div">
                                            <input id='inputtt' disabled type='text' value='' placeholder='请输入统一社会信用代码'>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label star"> 凭证金额</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <input type="text" id="amount-voucher" placeholder="请输入凭证金额">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label star"> 金融机构</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <select data-am-selected id="bank-options">
                                                <option value="">请选择金融机构</option>
                                                <%--                                                <option value="a">兴业银行</option>--%>
                                                <%--                                                <option value="b">工商银行</option>--%>
                                                <%--                                                <option value="c">中国银行</option>--%>
                                            </select>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label star"> 开单日期</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <input disabled type="text" class="am-form-field" data-am-datepicker
                                                   id="current-time" value="" placeholder="&nbsp;&nbsp;请选择日期"
                                                   style="border: 1px solid #c2cad8;width: 100%;border-radius: 3px;">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label star"> 到期日期</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <input id="expiry-time" type="text" class="am-form-field" data-am-datepicker
                                                   placeholder="&nbsp;&nbsp;请选择日期"
                                                   style="border: 1px solid #c2cad8;width: 100%;border-radius: 3px;">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label star"> 付息方式</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                            <select id="pay-money-model" placeholder="请选择付息方式" data-am-selected>
                                                <option value="a">融资方付息</option>
                                                <option value="b">核心企业付息</option>
                                            </select>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <%--@declare id="user-name"--%><label for="user-name" class="am-u-sm-3 am-form-label">备注</label>
                                        <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                                <textarea id="ticket-remark" class="" rows="4" id="user-intro"
                                                          placeholder="请输入备注"></textarea>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                            </div>
                        </div>
                        <div style="text-align: center;margin-top:40px">
                            <a class="am-btn am-btn-default" href="open-list.jsp">取&nbsp;&nbsp;&nbsp;&nbsp; 消</a>
                            <a id="submitBtn" class="am-btn am-btn-primary"
                               style="margin-left:20px">提&nbsp;&nbsp;&nbsp;&nbsp; 交</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 提交成功页面 -->
            <div class="tpl-block " id="resultDiv" hidden>
                <div class="am-g tpl-amazeui-form">
                    <div class="am-u-sm-12 am-u-md-12">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <div class="am-u-sm-12" style="margin-top: 4px;text-align: center;margin-bottom: 20px;">
                                    <img src="assets/img/u105.png" alt="" style="width: 120px;">
                                </div>
                                <div class="am-u-sm-12"
                                     style="margin-top: 4px;font-size: 20px;text-align: center;font-weight: bold;margin-bottom: 20px;">
                                    提交申请成功
                                </div>
                                <div class="am-u-sm-12" style="color: #999;font-size:14px;text-align: center;">
                                    已通知审核人员尽快审核，最终结果将以站内信的方式告知您。
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div style="text-align: center;margin-top:40px">
                    <a class="am-btn am-btn-primary" href="open-list.jsp">返回列表</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script>
    // location.reload();
    // 提交按钮


    var myDate = new Date;

    var year = myDate.getFullYear();//获取当前年
    var yue = myDate.getMonth() + 1;//获取当前月
    var date = myDate.getDate();//获取当前日
    var h = myDate.getHours();//获取当前小时数(0-23)
    var m = myDate.getMinutes();//获取当前分钟数(0-59)
    var s = myDate.getSeconds();//获取当前秒


    $(document).ready(function () {
        $(function () {

            var DateStr = year + "-" + yue + "-" + date;
            $("#current-time").val(DateStr);
        })

        $.get("enterpriseservlet","enterpriseservletstate=2&entrtpriseid=${user.enterPriseId}", function (asd0) {
            eval("var enterprisebyid=" + asd0);
            $("#enterprise1-name").val(enterprisebyid["name"]);
            $("#open-suc").val(enterprisebyid["socialUniformCcode"]);
        })

       $.get("enterpriseservlet","enterpriseservletstate=1", function (asd1) {
           //开单企业下拉框
           eval("var list1=" + asd1);      /*将字符串转成对象格式*/
           for (var i = 0; i < list1.length; i++) {
               var obj = "<option value='" + list1[i].id + "'>" + list1[i].name + "</option>";
               $(obj).appendTo($("[id='order-receiving-enterprise']"));
           }
       });
        $.get("instiutyservlet","instiutyservletstate=1", function (asd3) {
            //银行下拉框
            eval("var list3=" + asd3);      /*将字符串转成对象格式*/
            for (var i = 0; i < list3.length; i++) {
                var obj = "<option value='" + list3[i].id + "'>" + list3[i].name + "</option>";
                $(obj).appendTo($("[id='bank-options']"));
            }
        });

        $("[id='order-receiving-enterprise']").change(function () {
            var reciveID = $(this).val();
            $.get("enterpriseservlet","enterpriseservletstate=2&entrtpriseid=" + reciveID, function (asd2) {
                eval("var list2=" + asd2);
                $("#inputtt").val(list2["socialUniformCcode"])
            });

        })



        $("#submitBtn").click(function () {

            var recenterpeiseID = $("[id='order-receiving-enterprise']").val();//收单企业Id
            var amountofvoucher = $("[id='amount-voucher']").val();//凭证金额
            var bankId = $("[id='bank-options']").val();//银行Id
            var createtime = $("[id='current-time']").val();//创建日期
            var expirytime = $("[id='expiry-time']").val();//到期金额
            var paymentmed = $("[id='pay-money-model']").val();//付息方式
            var ticketmark = $("[id='ticket-remark']").val();//开单备注
            $.get("ticketopentservlet","ticketopentservletstate=6&" +
                "&enterprise_id=${user.enterPriseId}" +
                "&acquirer_enterprise_id=" + recenterpeiseID +
                "&amount=" + amountofvoucher +
                "&instituty_id=" + bankId +
                "&create_time=" + createtime +
                "&expiry_time=" + expirytime +
                "&payment_interest_type=" + paymentmed +
                "&status=2" +

                "&ticket_remark="+ticketmark +
                "&creator_id=${user.id}" +
                "&review_status=未审核", function (trueorfalse) {
                if (trueorfalse != null || trueorfalse != undefined) {
                    $('#showDiv').hide();
                    $('#resultDiv').show();
                }
            });

        })

    });
</script>
</body>
</html>