package film.springbootapplication.controller.exception;

import lombok.Data;

@Data
public class ApiError {

    private String key;
    private String value;
    private String message;

    public ApiError(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public ApiError(String message) {
        this.message = message;
    }
}
