package md.factorydream.entites;
// Generated Apr 13, 2016 10:19:57 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reports generated by hbm2java
 */
@Entity
@Table(name = "reports", schema = "public"
)

public class Reports implements java.io.Serializable {

    private int id;
    private Orders orders;
    private ReportTemplate reportTemplate;
    private Roles roles;
    private StatusCod statusCod;
    private Users users;
    private String description;
    private Date lastUpdateDate;
    private Set<ReportOrderParams> reportOrderParamses = new HashSet<ReportOrderParams>(0);
    private Set<ReportSequence> reportSequences = new HashSet<ReportSequence>(0);

    public Reports() {
    }

    public Reports(int id, Orders orders, ReportTemplate reportTemplate, Roles roles, Users users, String description) {
        this.id = id;
        this.orders = orders;
        this.reportTemplate = reportTemplate;
        this.roles = roles;
        this.users = users;
        this.description = description;
    }

    public Reports(int id, Orders orders, ReportTemplate reportTemplate, Roles roles, StatusCod statusCod, Users users, String description, Date lastUpdateDate, Set<ReportOrderParams> reportOrderParamses, Set<ReportSequence> reportSequences) {
        this.id = id;
        this.orders = orders;
        this.reportTemplate = reportTemplate;
        this.roles = roles;
        this.statusCod = statusCod;
        this.users = users;
        this.description = description;
        this.lastUpdateDate = lastUpdateDate;
        this.reportOrderParamses = reportOrderParamses;
        this.reportSequences = reportSequences;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order", nullable = false)
    public Orders getOrders() {
        return this.orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_report_template", nullable = false)
    public ReportTemplate getReportTemplate() {
        return this.reportTemplate;
    }

    public void setReportTemplate(ReportTemplate reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", nullable = false)
    public Roles getRoles() {
        return this.roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status_code")
    public StatusCod getStatusCod() {
        return this.statusCod;
    }

    public void setStatusCod(StatusCod statusCod) {
        this.statusCod = statusCod;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_last_update", nullable = false)
    public Users getUsers() {
        return this.users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Column(name = "description", nullable = false, length = 250)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", length = 29)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reports")
    public Set<ReportOrderParams> getReportOrderParamses() {
        return this.reportOrderParamses;
    }

    public void setReportOrderParamses(Set<ReportOrderParams> reportOrderParamses) {
        this.reportOrderParamses = reportOrderParamses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "reports")
    public Set<ReportSequence> getReportSequences() {
        return this.reportSequences;
    }

    public void setReportSequences(Set<ReportSequence> reportSequences) {
        this.reportSequences = reportSequences;
    }

}
