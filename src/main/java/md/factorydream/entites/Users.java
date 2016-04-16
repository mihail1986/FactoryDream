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
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", schema = "public"
)

public class Users implements java.io.Serializable {

    private int id;
    private StatusCod statusCod;
    private String login;
    private String password;
    private String note;
    private Date lastUpdateDate;
    private Set<Diameters> diameterses = new HashSet<Diameters>(0);
    private Set<OrderParameters> orderParameterses = new HashSet<OrderParameters>(0);
    private Set<ReportTemplate> reportTemplates = new HashSet<ReportTemplate>(0);
    private Set<Appointment> appointments = new HashSet<Appointment>(0);
    private Set<Employees> employeeses = new HashSet<Employees>(0);
    private Set<Statuses> statuseses = new HashSet<Statuses>(0);
    private Set<Departments> departmentses = new HashSet<Departments>(0);
    private Set<Jobs> jobses = new HashSet<Jobs>(0);
    private Set<Orders> orderses = new HashSet<Orders>(0);
    private Set<UserDepartment> userDepartments = new HashSet<UserDepartment>(0);
    private Set<Colors> colorses = new HashSet<Colors>(0);
    private Set<Customers> customerses = new HashSet<Customers>(0);
    private Set<Equipment> equipments = new HashSet<Equipment>(0);
    private Set<TemplateParameters> templateParameterses = new HashSet<TemplateParameters>(0);
    private Set<NoteGroups> noteGroupses = new HashSet<NoteGroups>(0);
    private Set<StatusCod> statusCods = new HashSet<StatusCod>(0);
    private Set<Events> eventses = new HashSet<Events>(0);
    private Set<Threads> threadses = new HashSet<Threads>(0);
    private Set<ReportSequence> reportSequences = new HashSet<ReportSequence>(0);
    private Set<Reports> reportses = new HashSet<Reports>(0);
    private Set<Types> typeses = new HashSet<Types>(0);
    private Set<JobsHistory> jobsHistories = new HashSet<JobsHistory>(0);
    private Set<RoleAccess> roleAccesses = new HashSet<RoleAccess>(0);
    private Set<GroupNotes> groupNoteses = new HashSet<GroupNotes>(0);
    private Set<StatusGroup> statusGroups = new HashSet<StatusGroup>(0);
    private Set<EventParameters> eventParameterses = new HashSet<EventParameters>(0);
    private Set<Roles> roleses = new HashSet<Roles>(0);
    private Set<ParamNames> paramNameses = new HashSet<ParamNames>(0);
    private Set<OrderNote> orderNotes = new HashSet<OrderNote>(0);
    private Set<Notes> noteses = new HashSet<Notes>(0);
    private Set<Models> modelses = new HashSet<Models>(0);

    public Users() {
    }

    public Users(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public Users(int id, StatusCod statusCod, String login, String password, String note, Date lastUpdateDate, Set<Diameters> diameterses, Set<OrderParameters> orderParameterses, Set<ReportTemplate> reportTemplates, Set<Appointment> appointments, Set<Employees> employeeses, Set<Statuses> statuseses, Set<Departments> departmentses, Set<Jobs> jobses, Set<Orders> orderses, Set<UserDepartment> userDepartments, Set<Colors> colorses, Set<Customers> customerses, Set<Equipment> equipments, Set<TemplateParameters> templateParameterses, Set<NoteGroups> noteGroupses, Set<StatusCod> statusCods, Set<Events> eventses, Set<Threads> threadses, Set<ReportSequence> reportSequences, Set<Reports> reportses, Set<Types> typeses, Set<JobsHistory> jobsHistories, Set<RoleAccess> roleAccesses, Set<GroupNotes> groupNoteses, Set<StatusGroup> statusGroups, Set<EventParameters> eventParameterses, Set<Roles> roleses, Set<ParamNames> paramNameses, Set<OrderNote> orderNotes, Set<Notes> noteses, Set<Models> modelses) {
        this.id = id;
        this.statusCod = statusCod;
        this.login = login;
        this.password = password;
        this.note = note;
        this.lastUpdateDate = lastUpdateDate;
        this.diameterses = diameterses;
        this.orderParameterses = orderParameterses;
        this.reportTemplates = reportTemplates;
        this.appointments = appointments;
        this.employeeses = employeeses;
        this.statuseses = statuseses;
        this.departmentses = departmentses;
        this.jobses = jobses;
        this.orderses = orderses;
        this.userDepartments = userDepartments;
        this.colorses = colorses;
        this.customerses = customerses;
        this.equipments = equipments;
        this.templateParameterses = templateParameterses;
        this.noteGroupses = noteGroupses;
        this.statusCods = statusCods;
        this.eventses = eventses;
        this.threadses = threadses;
        this.reportSequences = reportSequences;
        this.reportses = reportses;
        this.typeses = typeses;
        this.jobsHistories = jobsHistories;
        this.roleAccesses = roleAccesses;
        this.groupNoteses = groupNoteses;
        this.statusGroups = statusGroups;
        this.eventParameterses = eventParameterses;
        this.roleses = roleses;
        this.paramNameses = paramNameses;
        this.orderNotes = orderNotes;
        this.noteses = noteses;
        this.modelses = modelses;
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
    @JoinColumn(name = "id_status_code")
    public StatusCod getStatusCod() {
        return this.statusCod;
    }

    public void setStatusCod(StatusCod statusCod) {
        this.statusCod = statusCod;
    }

    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "note")
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", length = 29)
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Diameters> getDiameterses() {
        return this.diameterses;
    }

    public void setDiameterses(Set<Diameters> diameterses) {
        this.diameterses = diameterses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<OrderParameters> getOrderParameterses() {
        return this.orderParameterses;
    }

    public void setOrderParameterses(Set<OrderParameters> orderParameterses) {
        this.orderParameterses = orderParameterses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<ReportTemplate> getReportTemplates() {
        return this.reportTemplates;
    }

    public void setReportTemplates(Set<ReportTemplate> reportTemplates) {
        this.reportTemplates = reportTemplates;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Employees> getEmployeeses() {
        return this.employeeses;
    }

    public void setEmployeeses(Set<Employees> employeeses) {
        this.employeeses = employeeses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Statuses> getStatuseses() {
        return this.statuseses;
    }

    public void setStatuseses(Set<Statuses> statuseses) {
        this.statuseses = statuseses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Departments> getDepartmentses() {
        return this.departmentses;
    }

    public void setDepartmentses(Set<Departments> departmentses) {
        this.departmentses = departmentses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Jobs> getJobses() {
        return this.jobses;
    }

    public void setJobses(Set<Jobs> jobses) {
        this.jobses = jobses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }

    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<UserDepartment> getUserDepartments() {
        return this.userDepartments;
    }

    public void setUserDepartments(Set<UserDepartment> userDepartments) {
        this.userDepartments = userDepartments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Colors> getColorses() {
        return this.colorses;
    }

    public void setColorses(Set<Colors> colorses) {
        this.colorses = colorses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Customers> getCustomerses() {
        return this.customerses;
    }

    public void setCustomerses(Set<Customers> customerses) {
        this.customerses = customerses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Equipment> getEquipments() {
        return this.equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<TemplateParameters> getTemplateParameterses() {
        return this.templateParameterses;
    }

    public void setTemplateParameterses(Set<TemplateParameters> templateParameterses) {
        this.templateParameterses = templateParameterses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<NoteGroups> getNoteGroupses() {
        return this.noteGroupses;
    }

    public void setNoteGroupses(Set<NoteGroups> noteGroupses) {
        this.noteGroupses = noteGroupses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<StatusCod> getStatusCods() {
        return this.statusCods;
    }

    public void setStatusCods(Set<StatusCod> statusCods) {
        this.statusCods = statusCods;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Events> getEventses() {
        return this.eventses;
    }

    public void setEventses(Set<Events> eventses) {
        this.eventses = eventses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Threads> getThreadses() {
        return this.threadses;
    }

    public void setThreadses(Set<Threads> threadses) {
        this.threadses = threadses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<ReportSequence> getReportSequences() {
        return this.reportSequences;
    }

    public void setReportSequences(Set<ReportSequence> reportSequences) {
        this.reportSequences = reportSequences;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Reports> getReportses() {
        return this.reportses;
    }

    public void setReportses(Set<Reports> reportses) {
        this.reportses = reportses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Types> getTypeses() {
        return this.typeses;
    }

    public void setTypeses(Set<Types> typeses) {
        this.typeses = typeses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<JobsHistory> getJobsHistories() {
        return this.jobsHistories;
    }

    public void setJobsHistories(Set<JobsHistory> jobsHistories) {
        this.jobsHistories = jobsHistories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<RoleAccess> getRoleAccesses() {
        return this.roleAccesses;
    }

    public void setRoleAccesses(Set<RoleAccess> roleAccesses) {
        this.roleAccesses = roleAccesses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<GroupNotes> getGroupNoteses() {
        return this.groupNoteses;
    }

    public void setGroupNoteses(Set<GroupNotes> groupNoteses) {
        this.groupNoteses = groupNoteses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<StatusGroup> getStatusGroups() {
        return this.statusGroups;
    }

    public void setStatusGroups(Set<StatusGroup> statusGroups) {
        this.statusGroups = statusGroups;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<EventParameters> getEventParameterses() {
        return this.eventParameterses;
    }

    public void setEventParameterses(Set<EventParameters> eventParameterses) {
        this.eventParameterses = eventParameterses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Roles> getRoleses() {
        return this.roleses;
    }

    public void setRoleses(Set<Roles> roleses) {
        this.roleses = roleses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<ParamNames> getParamNameses() {
        return this.paramNameses;
    }

    public void setParamNameses(Set<ParamNames> paramNameses) {
        this.paramNameses = paramNameses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<OrderNote> getOrderNotes() {
        return this.orderNotes;
    }

    public void setOrderNotes(Set<OrderNote> orderNotes) {
        this.orderNotes = orderNotes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Notes> getNoteses() {
        return this.noteses;
    }

    public void setNoteses(Set<Notes> noteses) {
        this.noteses = noteses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<Models> getModelses() {
        return this.modelses;
    }

    public void setModelses(Set<Models> modelses) {
        this.modelses = modelses;
    }

}
