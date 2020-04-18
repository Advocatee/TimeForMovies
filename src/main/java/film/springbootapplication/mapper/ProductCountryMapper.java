package film.springbootapplication.mapper;

import film.springbootapplication.dto.ProductCountryDto;
import film.springbootapplication.model.ProductionCountry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class ProductCountryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductionCountry toEntity(ProductCountryDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, ProductionCountry.class);
    }

    public ProductCountryDto toDto(ProductCountryDto entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, ProductCountryDto.class);
    }
}
