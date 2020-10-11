package org.kozak.carfinder.Models;


import javax.persistence.*;

@Entity
@Table(name = "photos", schema = "public", catalog = "Carfinder")
public class PhotosEntity {
    private Integer id;
    private String url;
    private AdvertEntity  advertByAdvertid;

    @Id
    @SequenceGenerator(name="photos_id_seq", sequenceName="photos_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="photos_id_seq")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 500)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotosEntity that = (PhotosEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
    @OneToOne
    @JoinColumn(name = "advert_id", referencedColumnName = "id", nullable = false)
    public AdvertEntity getAdvertByAdvertid() {
        return advertByAdvertid;
    }

    public void setAdvertByAdvertid(AdvertEntity advertByAdvertid) {
        this.advertByAdvertid = advertByAdvertid;
    }
}
