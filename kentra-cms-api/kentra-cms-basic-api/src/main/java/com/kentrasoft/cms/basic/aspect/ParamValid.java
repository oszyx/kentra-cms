package com.kentrasoft.cms.basic.aspect;


import com.kentrasoft.cms.basic.resolver.ParamException;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;


/**
 * 描述：验证参数
 *
 * @author zhangmengkang
 * @date 2018-6-14 14:19:22
 */
@Aspect
@Configuration
@Component
public class ParamValid {
    /**
     * 验证工厂
     */
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    /**
     * 方法验证
     */
    private final ExecutableValidator methodValidator = factory.getValidator().forExecutables();
    /**
     * 对象验证
     */
    private final Validator beanValidator = factory.getValidator();

    /**
     * @Title: validMethodParams @Description: TODO(简单参数验证) @param: @param
     * obj @param: @param method @param: @param params @param: @return @return:
     * Set<ConstraintViolation<T>> @throws
     */
    private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object[] params) {
        return methodValidator.validateParameters(obj, method, params);
    }

    /**
     * @Title: validBeanParams @Description: TODO(bean参数验证) @param: @param
     * bean @param: @return @return: Set<ConstraintViolation<T>> @throws
     */
    private <T> Set<ConstraintViolation<T>> validBeanParams(T bean) {
        return beanValidator.validate(bean);
    }

    /**
     * @Title: soaBefore @Description: TODO(链接点配置) @param: @return: void @throws
     */
    @Pointcut("execution(* com.kentrasoft.controller..*.*(..))")
    protected void soaBefore() {
    }

    /**
     * @Title: before @Description: TODO(通过链接点切入执行参数验证) @param: @param
     * point @param: @throws Exception @return: void @throws
     */
    @Before("soaBefore()")
    public void before(JoinPoint point) throws Exception {
        // 获得切入目标对象
        Object target = point.getThis();
        // 获得切入方法参数
        Object[] args = point.getArgs();
        // 获得切入的方法
        Method method = ((MethodSignature) point.getSignature()).getMethod();

        // 校验以基本数据类型 为方法参数的
        Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, args);

        Iterator<ConstraintViolation<Object>> violationIterator = validResult.iterator();
        while (violationIterator.hasNext()) {
            // 抛出参数验证一次提示用户参数输入格式不正确
            String msg = violationIterator.next().getMessage();
            if (StringUtils.isNotBlank(msg)) {
                throw new ParamException(msg);
            } else {
                throw new ParamException("参数" + args + "验证失败！");
            }
        }

        // 校验以java bean对象 为方法参数的
        for (Object bean : args) {
            if (null != bean) {
                validResult = validBeanParams(bean);
                violationIterator = validResult.iterator();
                while (violationIterator.hasNext()) {
                    // 抛出参数验证一次提示用户参数输入格式不正确
                    String msg = violationIterator.next().getMessage();
                    if (StringUtils.isNotBlank(msg)) {
                        throw new ParamException("验证失败：" + msg);
                    } else {
                        throw new ParamException("验证失败：" + "参数" + args + "验证失败！");
                    }
                }
            }
        }
    }
}
