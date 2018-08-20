<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<!DOCTYPE html>
<head th:include="include :: header"></head>
<link th:href="@{/hplus/css/plugins/datapicker/datepicker3.css}" rel="stylesheet">
<link th:href="@{/hplus/css/plugins/chosen/chosen.css}" rel="stylesheet">
<link th:href="@{/hplus/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css}" rel="stylesheet">
<style>
    .form-group{
        padding: 7px 0;
    }
    .chosen-container{
        width: 100%!important;
    }
    .chosen-container-single .chosen-single{
        background: none!important;
        border-radius: 1px;
        border: 1px solid #CBD5DD;
        line-height: 30px;
    }
</style>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight" style="padding-top: 0;">
    <div class="row" style="background: #fff;">
        <div class="box-header" style="border-bottom: 1px #cccccc solid;">
            <div class="box-title" style="height: 50px;margin-left: 30px;line-height: 50px;font-size: 20px;letter-spacing: 5px;"></div>
        </div>
        <form id="form" action="#">
            <div class="col-sm-6" style="margin-top: 20px;">
<#list table.cols as c>
    <#if c.isEdit?? && c.isEdit == "1" && (c.isNotBaseField || c.simpleJavaField == 'remarks')>
        <#if c.showType == "input">
            <div class="col-sm-12">
                    <div class="form-group">
                        <label>${c.comments}</label>
                        <input name="${c.javaFieldId}" id="${c.javaFieldId}" type="text" class="form-control">
                    </div>
                </div>
        <#elseif c.showType == "select">
            <div class="col-sm-12">
             <div class="form-group">
                 <label>单选 *</label>
                 <select data-placeholder="选择模板..." class="chosen-select" tabindex="2" name="category">
                     <option value="1" hassubinfo="true" selected>单表/主子表</option>
                     <option value="2" hassubinfo="true">树表/树结构表</option>
                     <option value="3" hassubinfo="true">业务层和持久层</option>
                     <option value="4" hassubinfo="true">仅持久层</option>
                 </select>
             </div>
         </div>
        <#elseif c.showType == "mutlselect">
            <div class="col-sm-12">
     <div class="form-group">
         <label>复选 *</label>
         <select data-placeholder="选择省份" class="chosen-select" multiple tabindex="4">
             <option value="">请选择省份</option>
             <option value="110000" hassubinfo="true">北京</option>
             <option value="120000" hassubinfo="true">天津</option>
             <option value="130000" hassubinfo="true">河北省</option>
             <option value="140000" hassubinfo="true">山西省</option>
         </select>
     </div>
 </div>
        <#elseif c.showType == "checkbox">
            <div class="col-sm-12">
     <div class="form-group">
         <label>复选 *</label>
         <div class="checkbox checkbox-inline" style="margin-left: 15px;">
             <input type="checkbox" id="inlineCheckbox1" value="option1">
             <label for="inlineCheckbox1"> 选项01 </label>
         </div>
         <div class="checkbox  checkbox-inline">
             <input type="checkbox" id="inlineCheckbox2" value="option1" checked="">
             <label for="inlineCheckbox2"> 选项02 </label>
         </div>
         <div class="checkbox checkbox-inline">
             <input type="checkbox" id="inlineCheckbox3" value="option1">
             <label for="inlineCheckbox3"> 选项03 </label>
         </div>
     </div>
 </div>
        <#elseif c.showType == "radiobox">
            <div class="col-sm-12">
     <div class="form-group">
         <label>单选 *</label>
         <div class="radio radio-inline" style="margin-left: 15px;">
             <input type="radio" id="inlineRadio1" value="option1" name="radioInline" checked="">
             <label for="inlineRadio1"> 选项 01 </label>
         </div>
         <div class="radio radio-inline">
             <input type="radio" id="inlineRadio2" value="option2" name="radioInline">
             <label for="inlineRadio2"> 选项 02 </label>
         </div>
     </div>
 </div>
        <#elseif c.showType == "dateselect">
            <div class="col-sm-12">
            <div class="form-group">
                <label class="">日期选择：</label>
                <input id="dataCheck" name="moduleName" type="text" class="form-control selectDate">
            </div>
        </div>
        <#elseif c.showType == "fileselect">
            <div class="col-sm-12">
                <div class="form-group">
                    <div id="file-pretty">
                        <div class="form-group">
                            <label class="font-noraml">文件选择（单选）</label>
                            <input type="file" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        <#elseif c.showType == "hidden">
            <div class="col-sm-12">
                <div class="form-group">
                    <label>表说明 *</label>
                    <input  id="hideInput" name="admin_name" type="text" class="form-control">
                </div>
            </div>
        <#elseif c.showType == "userselect">
        <#elseif c.showType == "officeselect">
        <#elseif c.showType == "areaselect">
        <#elseif c.showType == "textarea">
        </#if>

    </#if>
</#list>
            </div>
            <div class="col-sm-offset-5 col-sm-12" style="padding-bottom: 20px;">
                <button class="btn btn-sm btn-primary btnSave"><i class="fa fa-check"></i>保存</button>
                <button class="btn btn-sm btn-default"><i class="fa fa-reply-all"></i>关闭</button>
            </div>
        </form>
    </div>
</div>

<div th:include="include :: footer"></div>
<script th:src="@{/hplus/js/plugins/chosen/chosen.jquery.js}"></script>

<script th:src="@{/hplus/js/plugins/datapicker/bootstrap-datepicker.js}"></script>
<script th:src="@{/hplus/js/plugins/validate/jquery.validate.min.js}"></script>
<script th:src="@{/hplus/js/plugins/validate/messages_zh.min.js}"></script>
<script th:src="@{/hplus/js/Jpm-validator.js}" ></script>

<script th:inline="javascript">
    var id=[[${"$"}{${"#"}request.getParameter('id')}]];
    //validate验证
    $(document).ready(function(){

        if(id){
            $.ajax({
                url: ctx + "api/${moduleName}/${class_name}/"+id,
                method: "get",
                contentType: "application/json",
                dataType: "json",
                success: function (data) {
                    if(data.errcode==0){

<#list table.cols as c>
    <#if c.isEdit?? && c.isEdit == "1" && (c.isNotBaseField || c.simpleJavaField == 'remarks')>
                        $("${"#"}${c.javaFieldId}").val(data.rslt.${c.javaFieldId});
    </#if>

</#list>

                    }else{
                        alert("加载数据出错！");
                    }
                },
                error: function () {
                    console.log("error");
                }
            })
        }


        $("#form").validate({
            rules:{
<#list table.cols as c>
    <#if c.isEdit?? && c.isEdit == "1" && (c.isNotBaseField || c.simpleJavaField == 'remarks')>
        ${c.javaFieldId}:{
        <#if c.isNull?? && c.isNull == "1">
            required:true,
        </#if>
             <#list c.validator as vv>
                 <#if vv?? && vv!= "">
                     <#if vv == "email">
                         checkEmail:true,
                     <#elseif vv == "url">
                             checkUrl:true,
                     <#elseif vv == "date">
                      checkDate:true,
                     <#elseif vv == "number">
                      checkNumber:true,
                     <#elseif vv == "integer">
                        checkInteger:true,
                     <#elseif vv == "digits">
                      checkDigits:true,
                     <#elseif vv == "userName">
                      checkUserName:true,
                     <#elseif vv == "realName">
                      checkRealName:true,
                     <#elseif vv == "abc">
                        checkAbc:true,
                     <#elseif vv == "simplePhone">
                        checkSimplePhone:true,
                     <#elseif vv == "phone">
                        checkPhone:true,
                     <#elseif vv == "zipCode">
                        checkZipCode:true,
                     <#elseif vv == "ipv4">
                        checkIPv4:true,
                     <#elseif vv == "ipv6">
                        checkIPv6:true,
                     <#elseif vv == "qq">
                        checkQQ:true,
                     <#elseif vv == "idcard">
                        checkIdcard:true,
                     </#if>
                 </#if>
             </#list>
                },
    </#if>
</#list>
            },
            //是否在获取焦点时验证
            //onfocusout:false,
            //是否在敲击键盘时验证
            //onkeyup:false,
            //提交表单后，（第一个）未通过验证的表单获得焦点
            focusInvalid:true,
            //当未通过验证的元素获得焦点时，移除错误提示
            focusCleanup:true,

            submitHandler: function (form) {

            if(id){
                var data = $(form).serializeObject();
                data.id=id;
                $.ajax({
                    url: ctx + "api/${moduleName}/${class_name}/",
                    method: "put",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (data) {
                        location.href="list";
                    },
                    error: function () {
                        console.log("error");
                    }
                })
            }else{
                var data = $(form).serializeObject();
                $.ajax({
                    url: ctx + "api/${moduleName}/${class_name}/",
                    method: "post",
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    dataType: "json",
                    success: function (data) {
                        location.href="list";
                    },
                    error: function () {
                        console.log("error");
                    }
                })
            }


        },
        invalidHandler: function (form) {

        }

        });


        //datepicker调用
        $(".selectDate").datepicker({
            autoclose: true, //自动关闭
            //beforeShowDay: $.noop,    //在显示日期之前调用的函数
            calendarWeeks: false,     //是否显示今年是第几周
            clearBtn: false,          //显示清除按钮
            daysOfWeekDisabled: [],   //星期几不可选
            endDate: Infinity,        //日历结束日期
            forceParse: true,         //是否强制转换不符合格式的字符串
            format: 'yyyy-mm-dd',     //日期格式
            keyboardNavigation: true, //是否显示箭头导航
            language: 'cn',           //语言
            minViewMode: 0,
            orientation: "auto",      //方向
            rtl: false,
            startDate: -Infinity,     //日历开始日期
            startView: 0,             //开始显示
            todayBtn: false,          //今天按钮
            todayHighlight: true,    //今天高亮
            weekStart: 0
        });
        //下拉框复选框初始化
        var config = {
            '.chosen-select': {},
            '.chosen-select-deselect': {
                allow_single_deselect: true
            },
            '.chosen-select-no-single': {
                disable_search_threshold: 10
            },
            '.chosen-select-no-results': {
                no_results_text: 'Oops, nothing found!'
            },
            '.chosen-select-width': {
                width: "95%"
            }
        };

        $('.chosen-select').chosen();
    });
</script>





</body>

</html>



