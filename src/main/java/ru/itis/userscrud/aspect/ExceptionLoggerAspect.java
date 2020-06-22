//package ru.itis.userscrud.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class ExceptionLoggerAspect {
//
//    @Pointcut("execution(* ru.itis.userscrud..*(..) )")
//    private void anyMethod(){}
//
//    @AfterThrowing(pointcut = "anyMethod()", throwing = "e")
//    private void logException(JoinPoint joinPoint, Throwable e) {
//        System.out.println(joinPoint + " -> " + e);
//    }
//}
