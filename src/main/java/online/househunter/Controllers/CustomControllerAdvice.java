package online.househunter.Controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class CustomControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e) {
        return "404";
    }

}
