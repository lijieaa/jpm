<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.dao.${ClassName}Dao">
    <sql id="Base_Column_List">
        <#assign columnField>
            <#list table.cols as c>
                a.${c.name} AS "${c.javaFieldId}",
            </#list>
        </#assign>
    ${columnField?substring(0, columnField?last_index_of(","))}
    </sql>


    <insert id="insert">
        INSERT INTO ${table.name}(
		<#assign insertField>
            <#list table.cols as c>
                <#if c.isInsert?? && c.isInsert == "1">
                    ${c.name},
                </#if>
            </#list>
        </#assign>
    ${insertField?substring(0, insertField?last_index_of(","))}
        ) VALUES (
		<#assign insertJavaField>
            <#list table.cols as c>
                <#if c.isInsert?? && c.isInsert == "1">
                    ${"#"}{${c.javaFieldId}},
                </#if>
            </#list>
        </#assign>
    ${insertJavaField?substring(0, insertJavaField?last_index_of(","))}
        )
    </insert>

    <update id="update">
        UPDATE ${table.name} SET
			<#assign updateField>
                <#list table.cols as c>
                    <#if c.isEdit?? && c.isEdit == "1">
                        ${c.name} = ${"#"}{${c.javaFieldId}},
                    </#if>
                </#list>
            </#assign>
    ${updateField?substring(0, updateField?last_index_of(","))}
        WHERE id = ${"#"}{id}
    </update>


    <delete id="delete" parameterType="java.util.ArrayList">
        delete from ${table.name}
        where id in
        <foreach collection="array" index="index" item="item" open="(" separator="," close=")">
        ${"#"}{item}
        </foreach>
    </delete>
</mapper>