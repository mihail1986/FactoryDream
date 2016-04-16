package md.factorydream.entites;
// Generated Apr 13, 2016 10:19:57 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ReportSequence generated by hbm2java
 */
@Entity
@Table(name = "report_sequence", schema = "public"
)

public class ReportSequence implements java.io.Serializable {

    private int id;
    private Reports reports;
    private StatusCod statusCod;
    private Users users;
    private String reportSequenceDescription;
    private Date lastUpdateDate;

    public ReportSequence() {
    }

    public ReportSequence(int id, Reports reports, Users users) {
        this.id = id;
        this.reports = reports;
        this.users = users;
    }

    public ReportSequence(int id, Reports reports, StatusCod statusCod, Users users, String reportSequenceDescription, Date lastUpdateDate) {
        this.id = id;
        this.reports = reports;
        this.statusCod = statusCod;
        this.users = users;
        this.reportSequenceDescription = reportSequenceDescription;
        this.lastUpdateDate = lastUpdateDate;
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
    @JoinColumn(name = "id_report", nullable = false)
    public Reports getReports() {
        return this.reports;
    }

    public void setReports(Reports reports) {
        this.reports = reports;
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

    @Column(name = "report_sequence_description", length = 250)
    public String getReportSequenceDescription() {
        return this.reportSequenceDescription;
    }

    public void setReportSequenceDescription(String reportSequenceDescription) {
        this.reportSequenceDescription = reportSequenceDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", length = 29)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
