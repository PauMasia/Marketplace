package proyecto.paumasia.apimarketplace;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "create_uid")
    private ResPartner create_uid;

    @Column(nullable = false)
    private Date create_date;

    // Hacer funcion para detectar el usuario logeado, si esto esta bien, hacer funcion para ultima modificacion tiempo y usuario
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
