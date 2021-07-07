package film.springbootapplication.controller.exception;

import lombok.Data;
import org.springframework.validation.BindingResult;

@Data
public class AppControllerException extends RuntimeException {

    private BindingResult bindingResult;

    public AppControllerException(String message) {
        super(message);
    }

    public AppControllerException(BindingResult result) {
        this.bindingResult = result;
    }
}
