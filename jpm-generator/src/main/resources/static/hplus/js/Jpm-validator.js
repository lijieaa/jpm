$(document).ready(function () {
    //自定义正则表达示验证方法

    //手机或电话
    $.validator.addMethod("checkPhone", function (value, element, params) {
        var reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的手机号码！");


    $.validator.addMethod("checkEmail", function (value, element, params) {
        var checkEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        return this.optional(element) || (checkEmail.test(value));
    }, "*请输入正确的邮箱！");

    //网址
    $.validator.addMethod("checkUrl", function (value, element, params) {
        var reg = /(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的网址！");

    //日期
    $.validator.addMethod("checkDate", function (value, element, params) {
        var reg = /[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的日期！");


    //数值
    $.validator.addMethod("checkNumber", function (value, element, params) {
        var reg = /^[-+]?\d+(\.\d+)?$/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的数值！");


    //整数
    $.validator.addMethod("checkInteger", function (value, element, params) {
        var reg = /^-?\d+$/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的整数！");


    //正整数
    $.validator.addMethod("checkDigits", function (value, element, params) {
        var reg = /^\+?[1-9][0-9]*$/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的正整数！");


    //登录账号
    $.validator.addMethod("checkUserName", function (value, element, params) {
        var reg = "";
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的登录账号！");

    //真实姓名
    $.validator.addMethod("checkRealName", function (value, element, params) {
        var reg = "";
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的真实姓名！");

    //字母数字下划线
    $.validator.addMethod("checkAbc", function (value, element, params) {
        var reg = /^[0-9a-zA-Z_]{1,}$/;
        return this.optional(element) || (reg.test(value));
    }, "*字母数字下划线！");


    //固定电话
    $.validator.addMethod("checkSimplePhone", function (value, element, params) {
        var reg = /^[0-9a-zA-Z_]{1,}$/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的固定电话！");


    //邮政编码
    $.validator.addMethod("checkZipCode", function (value, element, params) {
        var reg = '/[1-9]/d{5}? !/d)/';
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的邮政编码！");


    //IPv4
    $.validator.addMethod("checkIPv4", function (value, element, params) {
        var reg = /^((25[0-5]|2[0-4]\d|[01]?\d\d?)\.){3}(25[0-5]|2[0-4]\d|[01]?\d\d?)$/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的IPv4！");

    //IPv6
    $.validator.addMethod("checkIPv6", function (value, element, params) {
        var reg = /^([\da-fA-F]{1,4}:){7}[\da-fA-F]{1,4}$/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的IPv6！");


    //QQ
    $.validator.addMethod("checkQQ", function (value, element, params) {
        var reg = /[1-9][0-9]{4,}/;
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的QQ！");

    //身份证
    $.validator.addMethod("checkIdcard", function (value, element, params) {
        var reg = '//d{15}|/d{18}/';
        return this.optional(element) || (reg.test(value));
    }, "*请输入正确的身份证！");
})