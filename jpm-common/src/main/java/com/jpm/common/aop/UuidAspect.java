package com.jpm.common.aop;

import com.jpm.common.entity.BaseEntity;
import com.jpm.common.entity.DataEntity;
import com.jpm.common.utils.IdGenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @description: 为实体生成id生成UUID值
 * @author: 李杰
 * @create: 2018-08-02 17:28
 **/
@Aspect
@Component
public class UuidAspect {
    //拦截所有DAO的insert方法
    @Pointcut("execution(* com.jpm..dao..*.insert(..))")
    public void insert() { }


    //拦截所有DAO的update方法
    @Pointcut("execution(* com.jpm..dao..*.update(..))")
    public void update() { }

    //生成UUID,创建时间，更新时间，创建人，更新人
    @Before("insert()")
    public void addEntity(JoinPoint joinPoint){
        for (Object entity : joinPoint.getArgs()) {
            if (entity instanceof DataEntity) {
                DataEntity e = (DataEntity) entity;
                e.setId(IdGenUtils.uuid());
                e.setCreateDate(new Date());
                e.setUpdateDate(new Date());
                e.setCreateBy(null);
            }
        }
    }

    //生成UUID,创建时间，更新时间，创建人，更新人
    @Before("update()")
    public void updateEntity(JoinPoint joinPoint){
        for (Object entity : joinPoint.getArgs()) {
            if (entity instanceof DataEntity) {
                DataEntity e = (DataEntity) entity;
                e.setUpdateDate(new Date());
                e.setUpdateBy(null);
            }
        }
    }
}
