package film.springbootapplication.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public abstract class BaseSettingEntity extends BaseEntity {

    @Column
    private String name;
}
