package entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author yan
 * @date 2018/10/21 20:03
 * @descripition
 */
@Entity
public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private Boolean authority;
    private List<Phone> phone;

    @Id
    @Column(name = "uid")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "authority")
    public Boolean getAuthority() {
        return authority;
    }

    public void setAuthority(Boolean authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (uid != null ? !uid.equals(user.uid) : user.uid != null) {
            return false;
        }
        if (username != null ? !username.equals(user.username) : user.username != null) {
            return false;
        }
        if (password != null ? !password.equals(user.password) : user.password != null) {
            return false;
        }
        if (authority != null ? !authority.equals(user.authority) : user.authority != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    public List<Phone> getPhone() {
        return phone;
    }
    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }
}
