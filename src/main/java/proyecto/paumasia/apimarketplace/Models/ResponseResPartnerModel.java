package proyecto.paumasia.apimarketplace.Models;

import lombok.Getter;
import proyecto.paumasia.apimarketplace.Entity.ResPartner;

@Getter
public class ResponseResPartnerModel<T> {
    private String message;
    private T data;
//    private String partner_id;

    public ResponseResPartnerModel(String message, T data) {
        this.message = message;
        this.data = data;
    }
//
//    public ResponseResPartnerModel(String message, ResPartner partner_id) {
//        this.message = message;
////        this.data = data;
//        // Aqui en un futuro hacer que pase el token en vez de de esto
////        this.partner_id = String.valueOf(partner_id.getId());
//    }

}

