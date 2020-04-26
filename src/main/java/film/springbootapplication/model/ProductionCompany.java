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
    private String name;
    @Column
    private String dataSourceId;
    @Column
    private String country;
    @ManyToMany(mappedBy = "company")
    private Set<Movie> movies;
}
