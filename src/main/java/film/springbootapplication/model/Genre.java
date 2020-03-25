package film.springbootapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"dataSource", "dataSourceId"}))
public class Genre  extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;

    @Column
    private String dataSource; //записываем откуда пришел этот жанр
    @Column
    private String dataSourceId; //Id под которым он находится в стороннем сервисе

}
