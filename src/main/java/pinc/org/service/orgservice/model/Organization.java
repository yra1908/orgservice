package pinc.org.service.orgservice.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = Organization.TABLE_NAME)
public class Organization {
    public static final String TABLE_NAME = "Organization";

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Active")
    private boolean active = true;

    @JoinColumn(name = "ClientId", nullable = false)
    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Client client;

    /*@ManyToMany(fetch = FetchType.LAZY,
     cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
        mappedBy = TABLE_NAME)
    private Set<Physician> physician = new HashSet<>();*/
}
