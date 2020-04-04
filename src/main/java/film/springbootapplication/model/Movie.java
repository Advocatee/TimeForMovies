package film.springbootapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Entity
@Data
@Table
public class Movie extends BaseEntity {

    @Column
    private String title;
    @Column
    private Date releaseDate;
    @Column
    private Integer runtime;
    @Column
    private String voteAverage;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Genre> genreList = new HashSet<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movie")
    private List<ProductionCountry> country = new ArrayList<>();

}
