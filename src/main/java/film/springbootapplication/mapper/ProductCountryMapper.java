//package film.springbootapplication.mapper;
//
//import film.springbootapplication.dto.InfoProductCompanyDto;
//import film.springbootapplication.model.ProductionCompany;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Objects;
//
//public class ProductCountryMapper {
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public ProductionCompany toEntity(InfoProductCompanyDto dto) {
//        return Objects.isNull(dto) ? null : modelMapper.map(dto, ProductionCompany.class);
//    }
//
//    public InfoProductCompanyDto toDto(InfoProductCompanyDto entity) {
//        return Objects.isNull(entity) ? null : modelMapper.map(entity, InfoProductCompanyDto.class);
//    }
//}
