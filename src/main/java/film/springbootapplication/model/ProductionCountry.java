package film.springbootapplication.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductionCountry extends BaseEntity {

    @Column
    private String name;
    @Column
    private String productCountry; //записываем откуда пришел этот жанр
    @Column
    private String dataSourceId; //Id под которым он находится в стороннем сервисе

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

}
