package pinc.org.service.orgservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = Privilege.TABLE_NAME)
public class Privilege {
    public static final String TABLE_NAME = "Privilege";

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    public Privilege(String name) {
        this.name = name;
    }
}
