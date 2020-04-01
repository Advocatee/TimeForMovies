package film.springbootapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

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

    //List of genres + List of ProductionCountries


}
