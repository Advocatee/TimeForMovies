package film.springbootapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@Slf4j
@ControllerAdvice
public class BaseExceptionHandler extends RuntimeException {

    @ExceptionHandler(Exception.class)
    public String CustomException(Exception exception) {
        log.error("Raised: " + exception);
        return "error" ;
    }


}
