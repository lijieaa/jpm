<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<!DOCTYPE html>
<head th:include="include :: header"></head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>生成配置管理</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link ">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <form role="form" class="form-inline" id="search-form">
                        <#list table.cols as c>
                            <#if c.isQuery?? && c.isQuery == "1">
                                <div class="form-group">
                                    <label for="${c.simpleJavaField}" class="sr-only">${c.comments}</label>
                                    <input type="text" placeholder="${c.comments}" id="${c.simpleJavaField}" name="${c.simpleJavaField}"
                                           class="form-control">
                                </div>
                            </#if>
                        </#list>
                            <button class="btn btn-w-m btn-success" type="button" id="search">查询</button>
                            <button class="btn btn-w-m btn-success" type="button" id="reset">重置</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <div class="ibox-tools">
                        <a th:href="@{/cms/cms_link/form}" class="btn btn-w-m btn-success">新增</a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="jqGrid_wrapper">
                            <table id="table"></table>
                            <div id="pager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div th:include="include :: footer"></div>


<script th:inline="javascript">
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $("#table").jqGrid({
        url: ctx + "api/${moduleName}/${class_name}/jggrid",
        datatype: "json",
        jsonReader: {
            root: "rslt.rows",
            page: "rslt.page",//当前页
            total: "rslt.total",//总页数
            records: "rslt.records" //总记录数

        },
        multiSort: true,//多列排序
        height: "auto",
        rownumbers: true,
        mtype: "GET",
        colNames: [
            <#list table.cols as c>
                <#if c.isList?? && c.isList == "1">
                    "${c.comments}",
                </#if>
            </#list>
            '操作'
        ],
        colModel: [
            <#list table.cols as c>
                <#if c.isList?? && c.isList == "1">
            {
                name: "${c.simpleJavaField}",
                align: "left",
                index: "${c.simpleJavaField}"
            },
                </#if>
            </#list>
            {
                name: '',
                index: '',
                align: "left",
                sortable: false,
                formatter: function (data, option, rowObject) {
                    var html = "<a class='btn btn-white btn-bitbucket' title='编辑生成配置' id='edit-deploy'><i class='fa fa-pencil'></i></a>" +
                            "<a class='btn btn-white btn-bitbucket' title='删除生成配置'  id='delete-deploy'><i class='fa fa-trash-o'></i></a>" +
                            "<a class='btn btn-white btn-bitbucket' title='生成代码' id='make-deploy'><i class='fa fa-bug'></i></a>";
                    return html;
                }

            }
        ],
        caption: null,
        altRows: true,
        pager: '#pager',
        rowNum: 10,//一页显示多少条
        rowList: [10, 20, 30],//可供用户选择一页显示多少条
        viewrecords: true,
        loadComplete: function () {
            $("#table").setGridWidth($(window).width() * 0.95);
        }
    }).navGrid("#pager", {refresh: true, edit: false, search: false, add: false, view: false, del: false});

    // 根据查询条件刷新表格
    function RefreshTable() {
        var formData = $("#search-form").serializeObject();
        refreshTable(formData);
    }

    //点击查询查找指定搜索内容
    $(document).on("click", "#search", function () {
        RefreshTable();
    });
    //点击重置操作
    $(document).on("click", "#reset", function () {
        $("#search-form input").val("");
        RefreshTable();
    });

    //表格刷新
    function refreshTable(dataType) {
        $("#table").jqGrid('setGridParam', {
            postData: dataType,
            page: 1,
            datatype: 'json'
        }).trigger('reloadGrid');
    }

    //当窗口改变时设置表自动适应
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table').setGridWidth(width);
    });
</script>


</body>

</html>