package ${packageName}.entity;

<#list table.importList as i>
import ${i};
</#list>
import com.jpm.common.entity.DataEntity;
/**
 * ${functionName}Entity
 * @author ${functionAuthor}
 * @version ${functionVersion}
 */
public class ${ClassName} extends DataEntity<${ClassName},String> {

	private static final long serialVersionUID = 1L;
<#-- 生成字段属性 -->
<#list table.cols as c>
<#-- 如果不是基类属性 -->
    <#if c.isNotBaseField>
	private ${c.simpleJavaType} ${c.simpleJavaField};        <#if c.comments??>// ${c.comments}</#if>
    </#if>
</#list>
<#-- 构造方法 -->
	public ${ClassName}() {
		super();
	}

	public ${ClassName}(String id){
		super(id);
	}

<#-- 生成get和set方法 -->
<#list table.cols as c>
<#-- 如果不是基类属性 -->
    <#if c.isNotBaseField>
        <#list c.simpleAnnotationList as a>
		@${a}
        </#list>
	public ${c.simpleJavaType} get${c.simpleJavaField?cap_first}() {
		return ${c.simpleJavaField};
	}

	public void set${c.simpleJavaField?cap_first}(${c.simpleJavaType} ${c.simpleJavaField}) {
		this.${c.simpleJavaField} = ${c.simpleJavaField};
	}
	</#if>
</#list>
}