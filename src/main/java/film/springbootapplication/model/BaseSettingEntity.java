package film.springbootapplication.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public abstract class BaseSettingEntity extends BaseEntity {

    @Column
    private String name;
}
