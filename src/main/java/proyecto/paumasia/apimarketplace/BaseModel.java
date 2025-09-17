package proyecto.paumasia.apimarketplace;

import jakarta.persistence.*;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;

import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "create_uid")
    private ResPartner create_uid;

    @Column(nullable = false)
    private Date create_date;

    public ResPartner getCreate_uid() {
        return create_uid;
    }

    public void setCreate_uid(ResPartner create_uid) {
        this.create_uid = create_uid;
    }

    public BaseModel(ResPartner create_uid) {
        this.create_date = Tools.setDateNow();
        if (create_uid != null){
        this.create_uid = create_uid;
        }
    }
}
