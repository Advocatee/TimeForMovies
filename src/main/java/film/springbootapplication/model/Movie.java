package film.springbootapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "REALEASE_DATE")
    private Date releaseDate;
    @Column(name = "RUNTIME")
    private Integer runtime;
    @Column(name = "VOTE_AVERAGE")
    private String voteAverage;

    //List of genres + List of ProductionCountries


}
