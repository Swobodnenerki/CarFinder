package org.kozak.carfinder.Models;

import javax.persistence.*;

@Entity
@Table(name = "intrest", schema = "public", catalog = "Carfinder")
public class IntrestEntity {
    private Integer id;

    @Id
    @SequenceGenerator(name="intrest_id_seq", sequenceName="intrest_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="intrest_id_seq")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntrestEntity that = (IntrestEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
