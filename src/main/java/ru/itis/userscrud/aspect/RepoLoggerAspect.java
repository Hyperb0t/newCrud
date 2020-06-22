package ru.itis.userscrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RepoLoggerAspect {

    @Pointcut("target(ru.itis.userscrud.dao.UserRepository)")
    public void UserRepoEntityManager(){}

    @AfterReturning(pointcut = "UserRepoEntityManager()", returning = "returnValue")
    private void logRepo(JoinPoint jp, Object returnValue) {
        System.out.println(jp.getTarget().getClass() + " " + jp.getSignature().getName());
        System.out.println("with args: " + Arrays.toString(jp.getArgs()));
        System.out.println("result: " +  returnValue);
    }

}
