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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = Physician.TABLE_NAME)
public class Physician {
    public static final String TABLE_NAME = "Physician";

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

    @NotNull
    @Column(name = "Email")
    private String email;

    @JoinColumn(name = "ProviderGroupId", nullable = false)
    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private ProviderGroup providerGroup;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "OrgainisationPhysician",
        joinColumns = @JoinColumn(name = "PhysicianId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "OrganizationId", referencedColumnName = "id")
    )
    private Set<Organization> organizations = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PhysicianPrivilege",
        joinColumns = @JoinColumn(name = "PhysicianId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "PrivilegeId", referencedColumnName = "id"))
    private Set<Privilege> privileges;
}
