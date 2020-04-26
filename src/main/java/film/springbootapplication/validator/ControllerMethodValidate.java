package film.springbootapplication.validator;

import film.springbootapplication.dto.BaseDto;

public interface ControllerMethodValidate<T extends BaseDto> {

     void saveValidate(T dto);
     void editValidate(T dto);
     void removeValidate(T dto);


}
