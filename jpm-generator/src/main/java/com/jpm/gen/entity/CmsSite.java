package com.jpm.gen.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import org.hibernate.validator.constraints.URL;
import com.jpm.common.anno.validator.Date;
import com.jpm.common.anno.validator.Number;
import com.jpm.common.anno.validator.Integer;
import com.jpm.common.anno.validator.Digits;
import com.jpm.common.anno.validator.Abc;
import com.jpm.common.anno.validator.SimplePhone;
import com.jpm.common.anno.validator.Phone;
import com.jpm.common.anno.validator.ZipCode;
import com.jpm.common.anno.validator.IPv4;
import com.jpm.common.anno.validator.IPv6;
import com.jpm.common.anno.validator.QQ;
import com.jpm.common.anno.validator.IdCard;
import com.jpm.common.entity.DataEntity;
/**
 * 单表Entity
 * @author 李杰
 * @version 2018-08-06
 */
public class CmsSite extends DataEntity<CmsSite,String> {

    private static final long serialVersionUID = 1L;
    private String name;        // 站点名称
    private String title;        // 站点标题
    private String logo;        // 站点Logo
    private String domain;        // 站点域名
    private String description;        // 描述
    private String keywords;        // 关键字
    private String theme;        // 主题
    private String copyright;        // 版权信息
    private String customIndexView;        // 自定义站点首页视图
    public CmsSite() {
        super();
    }

    public CmsSite(String id){
        super(id);
    }

    @Length(min=1, max=100, message="站点名称长度必须介于 1 和 100 之间")
    @Email(message = "站点名称邮箱格式不正确！")
    @URL(message = "站点名称无效的URL！")
    @Date(message = "站点名称日期格式不正确！")
    @Number(message = "站点名称数值格式不正确！")
    @Integer(message = "站点名称整数格式不正确！")
    @Digits(message = "站点名称正整数格式不正确！")
    @Abc(message = "站点名称数字字母下划线格式不正确！")
    @SimplePhone(message = "站点名称固定电话格式不正确！")
    @Phone(message = "站点名称手机号格式不正确！")
    @ZipCode(message = "站点名称邮政编码格式不正确！")
    @IPv4(message = "站点名称IPv4格式不正确！")
    @IPv6(message = "站点名称IPv6格式不正确！")
    @QQ(message = "站点名称QQ格式不正确！")
    @IdCard(message = "站点名称身份证格式不正确！")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Length(min=1, max=100, message="站点标题长度必须介于 1 和 100 之间")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Length(min=0, max=255, message="站点Logo长度必须介于 0 和 255 之间")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    @Length(min=0, max=255, message="站点域名长度必须介于 0 和 255 之间")
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    @Length(min=0, max=255, message="描述长度必须介于 0 和 255 之间")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Length(min=0, max=255, message="关键字长度必须介于 0 和 255 之间")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    @Length(min=0, max=255, message="主题长度必须介于 0 和 255 之间")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    @Length(min=0, max=255, message="自定义站点首页视图长度必须介于 0 和 255 之间")
    public String getCustomIndexView() {
        return customIndexView;
    }

    public void setCustomIndexView(String customIndexView) {
        this.customIndexView = customIndexView;
    }
}