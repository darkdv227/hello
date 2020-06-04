package kr.re.kitri.hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class KitriAspect {

    private Logger logger = LoggerFactory.getLogger(KitriAspect.class);

    @Before("execution(* kr.re.kitri.hello.service.*Service.*(..))")
    public void logging(JoinPoint joinPoint) {
        logger.info("로그를 남깁니다. - " + joinPoint.getSignature().getName()
                                        + " ::에서 남김");
    }

    @Around("execution(* kr.re.kitri.hello..dao.*Dao.*(..))")
    public Object measureAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = pjp.proceed(); // 해당 함수를 실행 시킨다.
        long endTime = System.currentTimeMillis();

        long estimatedTime = endTime - startTime;
        logger.debug("메소드 Aroung 관련 로그 남기기 - "
                        + pjp.getSignature().getDeclaringTypeName() + "클래스의 "
                        + pjp.getSignature().getName() + " :: 메소드의 시간측정 - "
                        + estimatedTime + " 밀리초 입니다.");
        return obj;
    }

}
