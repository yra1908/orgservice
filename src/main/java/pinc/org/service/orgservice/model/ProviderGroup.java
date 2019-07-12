package pinc.org.service.orgservice.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = ProviderGroup.TABLE_NAME)
public class ProviderGroup {
    public static final String TABLE_NAME = "ProviderGroup";

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Active")
    private boolean active = true;

    @JoinColumn(name = "OrganizationId", nullable = false)
    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private Organization organization;
}
