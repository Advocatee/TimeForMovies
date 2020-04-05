package film.springbootapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Date created;

    @Column
    private Date updated;

    @Column
    private Boolean active;

    @PrePersist
    public void preSave() {
        created = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updated = new Date();
    }
}
