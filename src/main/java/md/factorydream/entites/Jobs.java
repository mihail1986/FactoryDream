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
 * Jobs generated by hbm2java
 */
@Entity
@Table(name = "jobs", schema = "public"
)

public class Jobs implements java.io.Serializable {

    private short id;
    private StatusCod statusCod;
    private Users users;
    private String name;
    private String jobDescription;
    private Date lastUpdateDate;
    private Set<JobsHistory> jobsHistories = new HashSet<JobsHistory>(0);
    private Set<EmployeesJobs> employeesJobses = new HashSet<EmployeesJobs>(0);

    public Jobs() {
    }

    public Jobs(short id, Users users, String name) {
        this.id = id;
        this.users = users;
        this.name = name;
    }

    public Jobs(short id, StatusCod statusCod, Users users, String name, String jobDescription, Date lastUpdateDate, Set<JobsHistory> jobsHistories, Set<EmployeesJobs> employeesJobses) {
        this.id = id;
        this.statusCod = statusCod;
        this.users = users;
        this.name = name;
        this.jobDescription = jobDescription;
        this.lastUpdateDate = lastUpdateDate;
        this.jobsHistories = jobsHistories;
        this.employeesJobses = employeesJobses;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public short getId() {
        return this.id;
    }

    public void setId(short id) {
        this.id = id;
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

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "job_description")
    public String getJobDescription() {
        return this.jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", length = 29)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jobs")
    public Set<JobsHistory> getJobsHistories() {
        return this.jobsHistories;
    }

    public void setJobsHistories(Set<JobsHistory> jobsHistories) {
        this.jobsHistories = jobsHistories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jobs")
    public Set<EmployeesJobs> getEmployeesJobses() {
        return this.employeesJobses;
    }

    public void setEmployeesJobses(Set<EmployeesJobs> employeesJobses) {
        this.employeesJobses = employeesJobses;
    }

}
