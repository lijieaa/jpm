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
                    <h5>所有表单元素 <small>包括自定义样式的复选和单选按钮</small></h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_basic.html#">选项1</a>
                            </li>
                            <li><a href="form_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form  class="form-horizontal">
                        <#list table.cols as c>
    <#if c.isEdit?? && c.isEdit == "1" && (c.isNotBaseField || c.simpleJavaField == 'remarks')>
        <#if c.showType == "input">
                <div class="form-group">
                    <label class="col-sm-2 control-label">${c.comments}</label>
            <#list c.validator as vv>
                <#if vv?? && vv!= "">
<div>${v[vv]["reg"]}</div>
                </#if>
            </#list>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="${c.javaFieldId}" id="${c.javaFieldId}">
                    </div>
                </div>
        <#elseif c.showType == "textarea">

        <#elseif c.showType == "select">
                <div class="form-group">
                    <label class="col-sm-2 control-label">${c.comments}</label>

                    <div class="col-sm-10">
                        <select class="form-control m-b" name="account">
                            <option>选项 1</option>
                            <option>选项 2</option>
                            <option>选项 3</option>
                            <option>选项 4</option>
                        </select>

                        <div class="col-sm-4 m-l-n">
                            <select class="form-control" multiple="">
                                <option>选项 1</option>
                                <option>选项 2</option>
                                <option>选项 3</option>
                                <option>选项 4</option>
                            </select>
                        </div>
                    </div>
                </div>
        <#elseif c.showType == "checkbox">
                <div class="form-group">
                    <label class="col-sm-2 control-label">${c.comments}</label>

                    <div class="col-sm-10">
                        <label class="checkbox-inline">
                            <input type="checkbox" value="option1" id="inlineCheckbox1">a</label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="option2" id="inlineCheckbox2">b</label>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="option3" id="inlineCheckbox3">c</label>
                    </div>
                </div>
        <#elseif c.showType == "radiobox">
				<div class="form-group">
                    <label class="col-sm-2 control-label">${c.comments}</label>

                    <div class="col-sm-10">
                        <div class="checkbox i-checks">
                            <label>
                                <div class="icheckbox_square-green" style="position: relative;"><input type="checkbox" value="" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项1</label>
                        </div>
                        <div class="checkbox i-checks">
                            <label class="">
                                <div class="icheckbox_square-green checked" style="position: relative;"><input type="checkbox" value="" checked="" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项2（选中）</label>
                        </div>
                        <div class="checkbox i-checks">
                            <label>
                                <div class="icheckbox_square-green checked disabled" style="position: relative;"><input type="checkbox" value="" disabled="" checked="" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项3（选中并禁用）</label>
                        </div>
                        <div class="checkbox i-checks">
                            <label>
                                <div class="icheckbox_square-green disabled" style="position: relative;"><input type="checkbox" value="" disabled="" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项4（禁用）</label>
                        </div>
                        <div class="radio i-checks">
                            <label>
                                <div class="iradio_square-green" style="position: relative;"><input type="radio" value="option1" name="a" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项1</label>
                        </div>
                        <div class="radio i-checks">
                            <label>
                                <div class="iradio_square-green checked" style="position: relative;"><input type="radio" checked="" value="option2" name="a" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项2（选中）</label>
                        </div>
                        <div class="radio i-checks">
                            <label>
                                <div class="iradio_square-green checked disabled" style="position: relative;"><input type="radio" disabled="" checked="" value="option2" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项3（选中并禁用）</label>
                        </div>
                        <div class="radio i-checks">
                            <label>
                                <div class="iradio_square-green disabled" style="position: relative;"><input type="radio" disabled="" name="a" style="position: absolute; opacity: 0;"><ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins></div> <i></i> 选项4（禁用）</label>
                        </div>
                    </div>
                </div>
        <#elseif c.showType == "dateselect">

        <#elseif c.showType == "userselect">

        <#elseif c.showType == "officeselect">
        <#elseif c.showType == "areaselect">
        <#elseif c.showType == "fileselect">
        </#if>
    </#if>
</#list>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div th:include="include :: footer"></div>



<script th:inline="javascript">

</script>


</body>

</html>




