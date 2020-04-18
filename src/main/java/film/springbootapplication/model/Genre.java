package film.springbootapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Optional;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"dS", "dSId"}))
public class Genre  extends BaseEntity{

    @Column
    private String name;
    @Column
    private String dS; //записываем откуда пришел этот жанр
    @Column
    private String dSId; //Id под которым он находится в стороннем сервисе
    @ManyToMany(mappedBy = "genreList")
    private Set<Movie> movie;
//    private Optional<Genre> id;
//
//    public void setId(Optional<Genre> id) {
//        this.id = id;
//    }
}
