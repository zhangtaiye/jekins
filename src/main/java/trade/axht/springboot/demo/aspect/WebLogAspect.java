package trade.axht.springboot.demo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.logging.Logger;

/**
 * 描述:
 * Web层的日志切面
 *
 * @outhor Administrator
 * @create 2017-12-24 20:08
 */
@Aspect
@Component
@Order(1)
public class WebLogAspect {
    private Logger logger=Logger.getLogger("redis");

    private ThreadLocal<Long> startTime=new ThreadLocal<>();

    private ThreadLocal<HashMap> hashMapThreadLocal=new ThreadLocal<>();

    @Pointcut("execution(public * trade.axht.springboot.demo.web..*.*(..))")
    public void webLog(){
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        System.out.println("当前线程号："+Thread.currentThread().getId()+"time:"+startTime);
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        hashMapThreadLocal.set(getBasicDBObject(request,joinPoint));
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        //处理完请求，返回内容
        hashMapThreadLocal.get().put("RESPONSE",ret);
        hashMapThreadLocal.get().put("处理消耗时间",(System.currentTimeMillis()-startTime.get())+"毫秒");
        hashMapThreadLocal.get().put("当前线程号",Thread.currentThread().getId());
        HashMap<String,Object> h=hashMapThreadLocal.get();
        System.out.println(JSON.toJSONString(hashMapThreadLocal.get()));
        logger.info(JSON.toJSONString(hashMapThreadLocal.get()));
    }

    private HashMap<String, Object> getBasicDBObject(HttpServletRequest request, JoinPoint joinPoint) {
        // 基本信息
        HashMap r = new LinkedHashMap();
        r.put("requestURL", request.getRequestURL().toString());
        r.put("requestURI", request.getRequestURI());
        r.put("queryString", request.getQueryString());
        r.put("remoteAddr", request.getRemoteAddr());
        r.put("remoteHost", request.getRemoteHost());
        r.put("remotePort", request.getRemotePort());
        r.put("localAddr", request.getLocalAddr());
        r.put("localName", request.getLocalName());
        r.put("method", request.getMethod());
        r.put("headers", getHeadersInfo(request));
        r.put("parameters", request.getParameterMap());
        r.put("classMethod", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        r.put("args", Arrays.toString(joinPoint.getArgs()));
        return r;
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }


}
