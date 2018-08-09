<#list table.columnList as c>
    <#if c.isQuery?? && c.isQuery == "1">
			<li><label>${c.comments}：</label>
			<#if c.showType == "input" || c.showType == "textarea">
				<form:input path="${c.javaFieldId}" htmlEscape="false"<#if c.dataLength != "0"> maxlength="${c.dataLength}"</#if> class="input-medium"/>
            <#elseif c.showType == "select">
				<form:select path="${c.javaFieldId}" class="input-medium">
                    <form:option value="" label=""/>
                    <form:options items="${"$"}{fns:getDictList('${c.dictType}')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                </form:select>
            <#elseif c.showType == "checkbox">
				<form:checkboxes path="${c.javaFieldId}" items="${"$"}{fns:getDictList('${c.dictType}')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            <#elseif c.showType == "radiobox">
				<form:radiobuttons path="${c.javaFieldId}" items="${"$"}{fns:getDictList('${c.dictType}')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
            <#elseif c.showType == "dateselect" && c.queryType == "between">
				<input name="begin${c.simpleJavaField?cap_first}" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                       value="<fmt:formatDate value="${"$"}{${className}.begin${c.simpleJavaField?cap_first}}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> -
				<input name="end${c.simpleJavaField?cap_first}" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                       value="<fmt:formatDate value="${"$"}{${className}.end${c.simpleJavaField?cap_first}}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <#elseif c.showType == "dateselect">
				<input name="${c.javaFieldId}" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                       value="<fmt:formatDate value="${"$"}{${className}.${c.javaFieldId}}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
            <#elseif c.showType == "userselect">
				<sys:treeselect id="${c.simpleJavaField}" name="${c.javaFieldId}" value="${"$"}{${className}.${c.javaFieldId}}" labelName="${c.javaFieldName}" labelValue="${"$"}{${className}.${c.javaFieldName}}"
                                title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
            <#elseif c.showType == "officeselect">
				<sys:treeselect id="${c.simpleJavaField}" name="${c.javaFieldId}" value="${"$"}{${className}.${c.javaFieldId}}" labelName="${c.javaFieldName}" labelValue="${"$"}{${className}.${c.javaFieldName}}"
                                title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
            <#elseif c.showType == "areaselect">
				<sys:treeselect id="${c.simpleJavaField}" name="${c.javaFieldId}" value="${"$"}{${className}.${c.javaFieldId}}" labelName="${c.javaFieldName}" labelValue="${"$"}{${className}.${c.javaFieldName}}"
                                title="区域" url="/sys/area/treeData" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
            </#if>
            </li>
    </#if>
</#list>