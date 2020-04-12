package film.springbootapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class ProductionCountry extends BaseEntity {

    @Column
    private String name;
    @Column
    private String productCountry;
    @Column
    private String dataSourceId;
    @ManyToMany(mappedBy = "country")
    private Set<Movie> movie;

}
