package com.jpm.common.utils;

import java.util.UUID;

/**
 * @description: 实体id生成策略
 * @author: 李杰
 * @create: 2018-08-02 17:41
 **/
public class IdGenUtils {
    /**
     * 生成UUID
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
