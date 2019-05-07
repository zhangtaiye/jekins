package trade.axht.springboot.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import trade.axht.springboot.demo.exception.entity.ErrorInfo;
import trade.axht.springboot.demo.exception.entity.MyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过使用@ControllerAdvice来进行统一异常处理，
 * @ExceptionHandler(value = Exception.class)来指定捕获的异常
 * 下面针对两种异常进行了特殊处理分别返回页面和json数据，
 * 使用这种方式有个局限，无法根据不同的头部返回不同的数据格式，而且无法针对404、403等多种状态进行处理
 */
@ControllerAdvice
public class GlobalExceptionHandler{
    public static final String DEFAULT_ERROR_VIEW="error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response,Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("exception",ex);
        mv.addObject("url",request.getRequestURL());
        mv.setViewName("500");
        return mv;
    }


    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException ex){
        ErrorInfo<String> r=new ErrorInfo<>();
        r.setMessage(ex.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(request.getRequestURI().toString());
        return r;
    }

}
