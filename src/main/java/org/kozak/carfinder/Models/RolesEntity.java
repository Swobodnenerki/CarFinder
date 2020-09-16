package org.kozak.carfinder.Models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "roles", schema = "public", catalog = "Carfinder")
public class RolesEntity {
    private Integer id;
    private String role;
    private AccountEntity accountByAccountid;

    @Id
    @SequenceGenerator(name="roles_id_seq", sequenceName="roles_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roles_id_seq")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 10)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    public AccountEntity getAccountByAccountid() {
        return accountByAccountid;
    }

    public void setAccountByAccountid(AccountEntity accountByAccountid) {
        this.accountByAccountid = accountByAccountid;
    }
}
