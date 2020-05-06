package film.springbootapplication.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Slf4j
@ControllerAdvice
public class BaseExceptionHandler extends RuntimeException {

    @ExceptionHandler(AppControllerException.class)
    public ResponseEntity<?> handleIAException(AppControllerException ex) {
        return Objects.nonNull(ex.getBindingResult())
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(convertToCommon(ex.getBindingResult()))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(convertToCommon(ex.getMessage()));
    }

    private List<ApiError> convertToCommon(BindingResult result) {
        List<ApiError> errors = result.getFieldErrors().stream().map(it -> new ApiError(it.getField(), it.getDefaultMessage())).collect(Collectors.toList());
        errors.addAll(result.getGlobalErrors().stream().map(it -> new ApiError(it.getObjectName(), it.getDefaultMessage())).collect(Collectors.toList()));
        return errors;
    }

    private List<ApiError> convertToCommon(String... ex) {
        List<String> strings = Arrays.asList(ex);
        return strings.stream().map(ApiError::new).collect(Collectors.toList());
    }

}