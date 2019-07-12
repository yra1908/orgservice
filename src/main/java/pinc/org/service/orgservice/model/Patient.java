package pinc.org.service.orgservice.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = Patient.TABLE_NAME)
public class Patient {
    public static final String TABLE_NAME = "Patient";

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @NotNull
    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String midleName;

    @NotNull
    @Column(name = "LastName")
    private String lastName;

    @NotNull
    @Column(name = "DoB")
    private Date doB;

    @Column(name = "Active")
    private boolean active = true;

    @JoinColumn(name = "ProviderGroupId", nullable = false)
    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private ProviderGroup  providerGroup;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PatientPhysician",
        joinColumns = @JoinColumn(name = "PatientId"),
        inverseJoinColumns = @JoinColumn(name = "PhysicianId")
    )
    private Set<Physician> physicians = new HashSet<>();

    public Physician getPrimaryPhysician(){
        return this.getPhysicians().stream()
            .filter(Physician::isActive)
            .findFirst().get();
    }



}
