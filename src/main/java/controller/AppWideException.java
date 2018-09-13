package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * @author yan
 * @date 2018/9/11 18:08
 * @descripition 处理所有的控制器异常
 */
@ControllerAdvice
public class AppWideException {
    /**
     * 异常处理和捕捉（只是测试）
     */
    @ExceptionHandler(IOException.class)
    public String handleIOIOException(){
        return "error/io";
    }

}
