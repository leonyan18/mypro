package entity;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yan
 * @date 2018/10/18 13:18
 * @descripition
 */
@Entity
public class Phone implements Serializable {
    private User user;
    private Integer pid;
    private String ptype;

    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "ptype")
    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (pid != null ? !pid.equals(phone.pid) : phone.pid != null) return false;
        if (ptype != null ? !ptype.equals(phone.ptype) : phone.ptype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + (ptype != null ? ptype.hashCode() : 0);
        result = 31 * result + (user.getUid() != null ? user.getUid().hashCode() : 0);
        return result;
    }
}
