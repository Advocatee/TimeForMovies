package film.springbootapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"dataSource", "dataSourceId"}))
public class Genre  extends BaseEntity{

    @Column
    private String name;
    @Column
    private String dataSource; //записываем откуда пришел этот жанр
    @Column
    private String dataSourceId; //Id под которым он находится в стороннем сервисе
    @ManyToMany(mappedBy = "genreList")
    private Set<Movie> movie;

}
