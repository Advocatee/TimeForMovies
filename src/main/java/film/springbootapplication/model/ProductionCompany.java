package film.springbootapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class ProductionCompany extends BaseSettingEntity {

    @Column
    private String productCompany;
    @Column
    private String dataSourceId;
    @ManyToMany(mappedBy = "company")
    private Set<Movie> movies;
}
