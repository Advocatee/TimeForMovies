package film.springbootapplication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private Date releaseDate;
    @Column
    private Integer runtime;
    @Column
    private String voteAverage;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Genre> genreList = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movie")
    private List<ProductionCountry> productionCountryList = new ArrayList<>();

    //List of genres + List of ProductionCountries


}
