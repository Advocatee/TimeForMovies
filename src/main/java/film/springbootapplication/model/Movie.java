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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MOVIE_GENRE", joinColumns = {@JoinColumn(name = "MOVIE_ID")},
    inverseJoinColumns = {@JoinColumn(name = "GENRE_ID")})
    private Set<Genre> genreList = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MOVIE_ProductionCountry", joinColumns = {@JoinColumn(name = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ProductionCountry_ID")})
    private List<ProductionCompany> company = new ArrayList<>();

}
