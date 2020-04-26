package film.springbootapplication.validator.Impl;

import film.springbootapplication.dto.BaseDto;
import film.springbootapplication.validator.ControllerMethodValidate;

public class ControllerMethodValidateImpl implements ControllerMethodValidate {
    @Override
    public void saveValidate(BaseDto dto) {
        if (dto.getName().isEmpty()) {
            throw new IllegalArgumentException("dto can't be null");
        }
    }

    @Override
    public void editValidate(BaseDto dto) {
        if (dto.getName().isEmpty()) {
            throw new IllegalArgumentException("dto can't be null for edit");
        }
    }

    @Override
    public void removeValidate(BaseDto dto) {
        if (dto.getId() < 0) throw new IllegalArgumentException("id can't be below 0");
    }
}
