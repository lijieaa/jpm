package com.jpm.gen.utils;

import com.google.common.collect.Maps;
import com.jpm.common.utils.DateUtils;
import com.jpm.common.utils.StringUtils;
import com.jpm.gen.entity.GenScheme;
import com.jpm.gen.entity.GenTable;
import com.jpm.gen.entity.GenTableColumn;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * @description: 代码生成工具
 * @author: 李杰
 * @create: 2018-08-01 11:26
 **/
public class GenUtils {
    private static Logger logger = LoggerFactory.getLogger(GenUtils.class);

    /**
     * 初始化列属性字段
     * @param genTable
     */
    public static void initColumnField(GenTable genTable){
        for (GenTableColumn column : genTable.getCols()){

            // 如果是不是新增列，则跳过。
            if (StringUtils.isNotBlank((String)column.getId())){
                continue;
            }

            // 设置字段说明
            if (StringUtils.isBlank(column.getComments())){
                column.setComments(column.getName());
            }

            // 设置java类型
            if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "CHAR")
                    || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "VARCHAR")
                    || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NARCHAR")
                    ||StringUtils.startsWithIgnoreCase(column.getJdbcType(), "TEXT")){
                column.setJavaType("String");
            }else if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATETIME")
                    || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "DATE")
                    || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "TIMESTAMP")){
                column.setJavaType("java.util.Date");
                column.setShowType("dateselect");
            }else if (StringUtils.startsWithIgnoreCase(column.getJdbcType(), "BIGINT")
                    || StringUtils.startsWithIgnoreCase(column.getJdbcType(), "NUMBER")
                    ||StringUtils.startsWithIgnoreCase(column.getJdbcType(), "INT")){
                // 如果是浮点型
                String[] ss = StringUtils.split(StringUtils.substringBetween(column.getJdbcType(), "(", ")"), ",");
                if (ss != null && ss.length == 2 && Integer.parseInt(ss[1])>0){
                    column.setJavaType("Double");
                }
                // 如果是整形
                else if (ss != null && ss.length == 1 && Integer.parseInt(ss[0])<=10){
                    column.setJavaType("Integer");
                }
                // 长整形
                else{
                    column.setJavaType("Long");
                }
            }

            // 设置java字段名
            column.setJavaField(StringUtils.toCamelCase(column.getName()));

            // 是否是主键
            column.setIsPk(genTable.getPks().contains(column.getName())?"1":"0");

            // 插入字段
            column.setIsInsert("1");

            // 编辑字段
            if (!StringUtils.equalsIgnoreCase(column.getName(), "id")
                    && !StringUtils.equalsIgnoreCase(column.getName(), "create_by")
                    && !StringUtils.equalsIgnoreCase(column.getName(), "create_date")
                    && !StringUtils.equalsIgnoreCase(column.getName(), "del_flag")){
                column.setIsEdit("1");
            }

            // 列表字段
            if (StringUtils.equalsIgnoreCase(column.getName(), "name")
                    || StringUtils.equalsIgnoreCase(column.getName(), "title")
                    || StringUtils.equalsIgnoreCase(column.getName(), "remarks")
                    || StringUtils.equalsIgnoreCase(column.getName(), "update_date")){
                column.setIsList("1");
            }

            // 查询字段
            if (StringUtils.equalsIgnoreCase(column.getName(), "name")
                    || StringUtils.equalsIgnoreCase(column.getName(), "title")){
                column.setIsQuery("1");
            }

            // 查询字段类型
            if (StringUtils.equalsIgnoreCase(column.getName(), "name")
                    || StringUtils.equalsIgnoreCase(column.getName(), "title")){
                column.setQueryType("like");
            }

            // 设置特定类型和字段名

            // 用户
           /* if (StringUtils.startsWithIgnoreCase(column.getName(), "user_id")){
                column.setJavaType(UserEntity.class.getName());
                column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
                column.setShowType("userselect");
            }
            // 部门
            else if (StringUtils.startsWithIgnoreCase(column.getName(), "office_id")){
                column.setJavaType(Office.class.getName());
                column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
                column.setShowType("officeselect");
            }
            // 区域
            else if (StringUtils.startsWithIgnoreCase(column.getName(), "area_id")){
                column.setJavaType(Area.class.getName());
                column.setJavaField(column.getJavaField().replaceAll("Id", ".id|name"));
                column.setShowType("areaselect");
            }
            // 创建者、更新者
            else if (StringUtils.startsWithIgnoreCase(column.getName(), "create_by")
                    || StringUtils.startsWithIgnoreCase(column.getName(), "update_by")){
                column.setJavaType(UserEntity.class.getName());
                column.setJavaField(column.getJavaField() + ".id");
            }*/
            // 创建时间、更新时间
            if (StringUtils.startsWithIgnoreCase(column.getName(), "create_date")
                    || StringUtils.startsWithIgnoreCase(column.getName(), "update_date")){
                column.setShowType("dateselect");
            }
            // 备注、内容
            if (StringUtils.equalsIgnoreCase(column.getName(), "remarks")
                    || StringUtils.equalsIgnoreCase(column.getName(), "content")){
                column.setShowType("textarea");
            }
            // 父级ID
            if (StringUtils.equalsIgnoreCase(column.getName(), "parent_id")){
                column.setJavaType("This");
                column.setJavaField("parent.id|name");
                column.setShowType("treeselect");
            }
            // 所有父级ID
            if (StringUtils.equalsIgnoreCase(column.getName(), "parent_ids")){
                column.setQueryType("like");
            }
            // 删除标记
            if (StringUtils.equalsIgnoreCase(column.getName(), "del_flag")){
                column.setShowType("radiobox");
                column.setDictType("del_flag");
            }
        }
    }



    /**
     * 获取数据模型
     * @param genScheme
     * @return
     */
    public static Map<String, Object> getDataModel(GenScheme genScheme){
        Map<String, Object> model = Maps.newHashMap();

        model.put("packageName", StringUtils.lowerCase(genScheme.getPackageName()));
        model.put("lastPackageName", StringUtils.substringAfterLast((String)model.get("packageName"),"."));
        model.put("moduleName", StringUtils.lowerCase(genScheme.getModuleName()));
        model.put("subModuleName", StringUtils.lowerCase(genScheme.getSubModuleName()));
        model.put("className", StringUtils.uncapitalize(genScheme.getGenTable().getClassName()));
        model.put("ClassName", StringUtils.capitalize(genScheme.getGenTable().getClassName()));
        model.put("class_name", StringUtils.toUnderScoreCase(genScheme.getGenTable().getClassName()));

        model.put("functionName", genScheme.getFunctionName());
        model.put("functionNameSimple", genScheme.getFunctionNameSimple());
        model.put("functionAuthor", StringUtils.isNotBlank(genScheme.getFunctionAuthor())?genScheme.getFunctionAuthor():"李杰");
        model.put("functionVersion", DateUtils.getDate());

        model.put("urlPrefix", model.get("moduleName")+(StringUtils.isNotBlank(genScheme.getSubModuleName())
                ?"/"+StringUtils.lowerCase(genScheme.getSubModuleName()):"")+"/"+model.get("className"));
        model.put("viewPrefix", //StringUtils.substringAfterLast(model.get("packageName"),".")+"/"+
                model.get("urlPrefix"));
        model.put("permissionPrefix", model.get("moduleName")+(StringUtils.isNotBlank(genScheme.getSubModuleName())
                ?":"+StringUtils.lowerCase(genScheme.getSubModuleName()):"")+":"+model.get("className"));

        //model.put("dbType", Global.getConfig("jdbc.type"));

        model.put("table", genScheme.getGenTable());

        return model;
    }


    public static void render(String tpl,Map<String, Object> root,Writer out) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("D:\\VisizenProject\\cq_ataike\\code\\server\\trunk\\jpm\\jpm-generator\\src\\main\\resources\\ftl"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template temp = cfg.getTemplate(tpl);
        temp.process(root, out);
    }
}
