package proyecto.paumasia.apimarketplace;

import jakarta.persistence.*;
import proyecto.paumasia.apimarketplace.Entity.ResUser;

import java.util.Date;

@MappedSuperclass
public abstract class Models {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "create_uid")
    private ResUser create_uid;

    @Column(nullable = false)
    private Date create_date;

    public ResUser getCreate_uid() {
        return create_uid;
    }

    public void setCreate_uid(ResUser create_uid) {
        this.create_uid = create_uid;
    }

    public Models(Date create_date, ResUser create_uid) {
        this.create_date = create_date;
        this.create_uid = create_uid;
    }
}
