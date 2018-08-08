<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.${moduleName}.dao.${ClassName}Dao">

    <sql id="Base_Column_List">
        <#assign columnField>
            <#list table.cols as c>
                a.${c.name} AS "${c.javaFieldId}",
            </#list>
        </#assign>
    ${columnField?substring(0, columnField?last_index_of(","))}
    </sql>


    <select id="select" resultType="${packageName}.${moduleName}.entity.${ClassName}Entity">
            SELECT
            <include refid="Base_Column_List" />
            FROM ${table.name} a
            WHERE a.id = ${"#"}{id}
    </select>


    <select id="selectAll" resultType="${packageName}.${moduleName}.entity.${ClassName}Entity">

        SELECT
        <include refid="Base_Column_List" />
        FROM ${table.name} a
        <where>
			<#list table.cols as c>
                <#if (c.isQuery?? && c.isQuery == "1")>
                    <#if c.queryType ?? && c.queryType == 'between'>
			<if test="begin${c.simpleJavaField?cap_first} != null and end${c.simpleJavaField?cap_first} != null <#if c.simpleJavaField != c.javaFieldId>and begin${c.javaFieldId?cap_first} != null and end${c.javaFieldId?cap_first} != null </#if>and begin${c.javaFieldId?cap_first} != '' and end${c.javaFieldId?cap_first} != ''">
                    <#else>
			<if test="${c.simpleJavaField} != null<#if c.simpleJavaField != c.javaFieldId> and ${c.javaFieldId} != null</#if> and ${c.javaFieldId} != ''">
                    </#if>
                    <#if c.queryType ?? && c.queryType == 'between'>
				AND a.${c.name} BETWEEN ${"#"}{begin${c.simpleJavaField?cap_first}} AND ${"#"}{end${c.simpleJavaField?cap_first}}
                    <#elseif c.queryType ?? && c.queryType == 'like'>
				AND a.${c.name} LIKE
					<if test="_databaseId == 'oracle'">'%'||${"#"}{${c.javaFieldId}}||'%'</if>
					<if test="_databaseId == 'mssql'">'%'+${"#"}{${c.javaFieldId}}+'%'</if>
					<if test="_databaseId == 'mysql'">concat('%',${"#"}{${c.javaFieldId}},'%')</if>
                    <#elseif c.queryType ?? && c.queryType == 'left_like'>
				AND a.${c.name} LIKE
					<if test="_databaseId == 'oracle'">'%'||${"#"}{${c.javaFieldId}}</if>
					<if test="_databaseId == 'mssql'">'%'+${"#"}{${c.javaFieldId}}</if>
					<if test="_databaseId == 'mysql'">concat('%',${"#"}{${c.javaFieldId}})</if>
                    <#elseif c.queryType ?? && c.queryType == 'right_like'>
				AND a.${c.name} LIKE
					<if test="_databaseId == 'oracle'">${"#"}{${c.javaFieldId}}||'%'</if>
					<if test="_databaseId == 'mssql'">${"#"}{${c.javaFieldId}}+'%'</if>
					<if test="_databaseId == 'mysql'">concat(${"#"}{${c.javaFieldId}},'%')</if>
                    <#else>
				AND a.${c.name} ${c.queryType} ${"#"}{${c.javaFieldId}}
                    </#if>
			</if>
                </#if>
            </#list>
        </where>

    </select>



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