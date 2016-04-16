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
 * Types generated by hbm2java
 */
@Entity
@Table(name = "types", schema = "public"
)

public class Types implements java.io.Serializable {

    private short id;
    private StatusCod statusCod;
    private Users users;
    private String value;
    private String typeDescription;
    private Date lastUpdateDate;
    private Set<ReportOrderParams> reportOrderParamses = new HashSet<ReportOrderParams>(0);
    private Set<Orders> orderses = new HashSet<Orders>(0);

    public Types() {
    }

    public Types(short id, Users users, String value) {
        this.id = id;
        this.users = users;
        this.value = value;
    }

    public Types(short id, StatusCod statusCod, Users users, String value, String typeDescription, Date lastUpdateDate, Set<ReportOrderParams> reportOrderParamses, Set<Orders> orderses) {
        this.id = id;
        this.statusCod = statusCod;
        this.users = users;
        this.value = value;
        this.typeDescription = typeDescription;
        this.lastUpdateDate = lastUpdateDate;
        this.reportOrderParamses = reportOrderParamses;
        this.orderses = orderses;
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

    @Column(name = "value", nullable = false, length = 250)
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "type_description", length = 250)
    public String getTypeDescription() {
        return this.typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", length = 29)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "types")
    public Set<ReportOrderParams> getReportOrderParamses() {
        return this.reportOrderParamses;
    }

    public void setReportOrderParamses(Set<ReportOrderParams> reportOrderParamses) {
        this.reportOrderParamses = reportOrderParamses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "types")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

}
