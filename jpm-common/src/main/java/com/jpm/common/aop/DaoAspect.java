package com.jpm.common.aop;

import com.jpm.common.entity.DataEntity;
import com.jpm.common.utils.IdGenUtils;
import com.jpm.common.utils.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @description: 为实体生成id生成UUID值
 * @author: 李杰
 * @create: 2018-08-02 17:28
 **/
@Aspect
@Component
public class DaoAspect {
    //拦截所有DAO的insert方法
    @Pointcut("execution(* com.jpm..dao..*.insert(..))")
    public void insert() { }


    //拦截所有DAO的update方法
    @Pointcut("execution(* com.jpm..dao..*.update(..))")
    public void update() { }


    //拦截所有DAO的selectAll方法
    @Pointcut("execution(* com.jpm..dao..*.test(..))")
    public void selectAll() { }

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


    //生成UUID,创建时间，更新时间，创建人，更新人
    @Around("selectAll()")
    public Object findEntity(ProceedingJoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Object[] args = point.getArgs();
        Map p = (Map) args[0];
        //System.out.println(p.get("asc"));
        String asc = (String)p.get("asc");
        if(null!=asc&&!asc.equals("")){
            p.put("asc",StringUtils.toUnderScoreCase(asc));
        }
        String desc = (String)p.get("desc");
        if(null!=desc&&!desc.equals("")){
            p.put("desc",StringUtils.toUnderScoreCase(asc));
        }
        try {
            return point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
