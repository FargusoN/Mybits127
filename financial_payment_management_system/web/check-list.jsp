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
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
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
            付款复核列表
        </div>
        <ol class="am-breadcrumb">
            <li class="am-active"><a style="color: #999999;">工作台</a></li>
            <li class="am-active">付款复核列表</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">凭证编号</span>
                                </span>
                            <input type="text" class="am-form-field" placeholder="&nbsp;&nbsp;请输入凭证编号"
                                   style="border: 1px solid #c2cad8;width: 77%;border-radius: 3px;"
                                   id="certificate-number-no">
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-form-group">
                            <span style="font-size: 14px;">收单企业</span>
                            <select data-am-selected="{btnSize: 'sm'}" id="openticketenterid">
                                <option value="">--请选择企业--</option>
                                <%--<option value="a">百度科技有限公司</option>--%>
                                <%--<option value="b">京东集团</option>--%>
                                <%--<option value="c">小米</option>--%>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-form-group">
                            <span style="font-size: 14px;">开单企业</span>
                            <select class="am-form-field" data-am-selected="{btnSize: 'sm'}" id="checkenterpriseid">
                                <option value="">--请选择企业--</option>
                                <%--                                <option value="a">公司腾讯科技有限</option>--%>
                                <%--                                <option value="b">隆基股份有限公司</option>--%>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">开单日期</span>
                                </span>
                            <input id="select-date" type="text" class="am-form-field" data-am-datepicker
                                   placeholder="&nbsp;&nbsp;请选择日期"
                                   style="border: 1px solid #c2cad8;width: 68%;border-radius: 3px;">
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-6 am-u-md-4">
                        <div class="am-input-group am-input-group-sm">
                                <span class="am-input-group-btn">
                                    <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">凭证金额</span>
                                </span>
                            <input id="amountMin" type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最低金额(万)"
                                   style="border: 1px solid #c2cad8;width: 23%;border-radius: 3px;">
                            <div class="am-form-field"
                                 style="width: 0%; border-radius: 3px;border: none;margin-left: 10px;">~
                            </div>
                            <input id="amountMax" type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最高金额(万)"
                                   style="border: 1px solid #c2cad8;width: 23%;border-radius: 3px;margin-left: 20px;">
                        </div>
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                <th class="table-title">凭证编号</th>
                                <th class="table-type">收单企业</th>
                                <th class="table-author am-hide-sm-only">凭证金额（元）</th>
                                <th class="table-date am-hide-sm-only">开单企业</th>
                                <th class="table-date am-hide-sm-only">金融机构</th>
                                <th class="table-date am-hide-sm-only">开单日期</th>
                                <th class="table-date am-hide-sm-only">到期日期</th>
                                <th class="table-date am-hide-sm-only">上链地址</th>
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody id="doc-modal-list">

                            </tbody>
                        </table>
                        <div class="am-cf">

                            <div class="am-fr">
                                <ul id='page-number-block' class="am-pagination tpl-pagination">
                                    <%--                                    <li class="am-disabled"><a href="#">«</a></li>--%>
                                    <%--                                    <li class="am-active"><a href="#">1</a></li>--%>
                                    <%--                                    <li><a href="#">2</a></li>--%>
                                    <%--                                    <li><a href="#">3</a></li>--%>
                                    <%--                                    <li><a href="#">4</a></li>--%>
                                    <%--                                    <li><a href="#">5</a></li>--%>
                                    <%--                                    <li><a href="#">»</a></li>--%>
                                </ul>
                            </div>
                        </div>
                        <hr>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>

<script type="text/javascript">


    function selectticketview(ticketlist) {
        $("[id='doc-modal-list']").empty();
        eval("var ticketopentservletlist=" + ticketlist);
        /*将字符串转成对象格式*/
        var obj;
        for (var i = 0; i < ticketopentservletlist.pageList.length; i++) {
                obj = "<tr data-id='2' >" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].no + "</td>" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].enp2name + "</td>" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].amount + "</td>" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].enp1name + "</td>" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].insname + "</td>" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].createTime + "</td>" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].expiryTime + "</td>" +
                    "<td class='am-hide-sm-only'>" + ticketopentservletlist.pageList[i].uplink_address + "</td>" +
                    "<td >" +
                    "<div class='am-btn-toolbar'>" +
                    "<div class='am-btn-group am-btn-group-xs' id='buttonbystatus'>" +
                    "<a href='ticketopentservlet?ticketopentservletstate=7&no=" + ticketopentservletlist.pageList[i].no + "'>" +
                    "<span class='am-text-secondary' style='cursor:pointer'>" +
                    "<span></span>复核</span></a>" +
                    "</div></div>" +
                    "</td>";
                $(obj).appendTo($("[id='doc-modal-list']"));
        }
    }

    function submitvalues(index) {
        var nooooo0 = $("[id='certificate-number-no']").val();
        var checkenter0 = $("[id='checkenterpriseid']").val();
        var openticketenter0 = $("[id='openticketenterid']").val();
        var dates0 = $("[id='select-date']").val();
        var amountMin0 = $("[id='amountMin']").val();
        var amountMax0 = $("[id='amountMax']").val();
        $.get("ticketopentservlet", "ticketopentservletstate=3" +
            "&index=" + index +
            "&no=" + nooooo0 +
            "&enterPriseId=" + openticketenter0 +
            "&acquirerEnterPriseId=" + checkenter0 +
            "&createtime=" + dates0 +
            "&amountMax=" + amountMax0 +
            "&amountMin=" + amountMin0, function (asd0) {
            selectticketview(asd0)
        });
    }

    function pagenumber(ticketlist) {

        eval("var ticketopentservletlist=" + ticketlist);
        var obj = "<li class='am-disabled'><a >«</a></li>";
        for (var i = 1; i <= ticketopentservletlist.totalPage; i++) {
            if (i == ticketopentservletlist.index) {
                obj = obj + "<li class='am-active'><a id='page'   value='" + i + "' >" + i + "</a></li>"
            } else {
                obj = obj + "<li><a id='page' value='" + i + "' >" + i + "</a></li>";
            }
        }
        obj = obj + "<li><a >»</a></li>"
        $(obj).appendTo($("[id='page-number-block']"));
    }

    $(document).ready(function () {
        $.get("ticketopentservlet", "ticketopentservletstate=3", function (list) {
            selectticketview(list);
            pagenumber(list);
        });

        //1.窗体内容加载后，向后端服务器发送请求；
        $.get("enterpriseservlet", "enterpriseservletstate=1", function (asd0) {
            //开单企业下拉框
            eval("var list1=" + asd0);      /*将字符串转成对象格式*/
            for (var i = 0; i < list1.length; i++) {
                var obj = "<option value='" + list1[i].id + "'>" + list1[i].name + "</option>";
                $(obj).appendTo($("[id='checkenterpriseid']"));
            }
        });

        $.get("enterpriseservlet", "enterpriseservletstate=1", function (asd1) {
            //收单企业下拉框
            eval("var list2=" + asd1);      /*将字符串转成对象格式*/
            for (var i = 0; i < list2.length; i++) {
                var obj = "<option value='" + list2[i].id + "'>" + list2[i].name + "</option>";
                $(obj).appendTo($("[id='openticketenterid']"));
            }
        });

        $("[id='openticketenterid']").change(function () {
            submitvalues()
        });

        $("[id='checkenterpriseid']").change(function () {
            submitvalues()
        });
        $("[id='certificate-number-no']").blur(function () {       //文本框失去焦点后
            submitvalues()
        });
        $("[id='select-date']").blur(function () {       //文本框失去焦点后

            submitvalues()
        });
        $("[id='amountMin']").blur(function () {       //文本框失去焦点后
            submitvalues()
        });
        $("[id='amountMax']").blur(function () {       //文本框失去焦点后
            submitvalues()
        });
        $(document).on("click", "[id='page']", function () {
            var index = $(this).html()
            submitvalues(index)
        });
    });
</script>
</body>

</html>