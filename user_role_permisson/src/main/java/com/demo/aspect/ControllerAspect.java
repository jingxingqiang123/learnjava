package com.demo.aspect;

import com.demo.common.constant.RoleConstant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class ControllerAspect {
    //  Pointcut
    //  Around
    // 切点  切面 通知
    // @Pointcut(value = "execution(public * com.demo.controlleraspect.controller.*.*(..)) || @annotation(AccessController )")
    @Pointcut(value = "@annotation(com.demo.aspect.RightsController)")
    public void accessController() {

    }

    @Around("accessController()")
    public Object accessControllerProcess(ProceedingJoinPoint joinPoint) {
        // Object[] args = joinPoint.getArgs();
        try {
            // 获取目标方法的方法签名
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取到拦截方法名字
            Method method = signature.getMethod();
            // 获取被拦截的方法名
            String methodName = method.getName();
            Annotation[] annotations = method.getAnnotations();

            // 获取目标方法是否有AccessController注解,
            boolean annotationPresent = method.isAnnotationPresent(RightsController.class);

            // 校验用户角色权限是否具有访问权限
            if (annotationPresent) {
                checkRolePermission(method.getAnnotation(RightsController.class).role(), getRoleValues());
            }
            // 执行目标方法controller
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable.getMessage());
        }
    }

    private void checkRolePermission(String[] annotationRoleTypes, String[] roleValues) {
        if (roleValues.length == 0) {
            throw new RuntimeException("用户无权限访问");
        }
        // 系统自带的权限
        List<String> systemRole = Arrays.stream(annotationRoleTypes).collect(Collectors.toList());
        // 用户token中获取到的权限roleValues
        Arrays.stream(roleValues).forEach(roleValue -> {
            boolean contains = systemRole.contains(roleValue);
            if (!contains) {
                throw new RuntimeException("用户无权限访问");
            }
        });

//        boolean b = Arrays.stream(roleValues).anyMatch(systemRole::contains);
//        if (!b) throw new RuntimeException("用户无权限访问");

    }

    private String[] getRoleValues() {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return new String[]{};
        }
        String value = "";
        for (int i = 0; i < cookies.length; i++) {
            if (RoleConstant.OPT_TOKEN.equals(cookies[i].getName())) {
                value = cookies[i].getValue();
                break;
            }
        }
        return value.split(",");
    }


}
