package proyecto.paumasia.apimarketplace.Models;

import lombok.Getter;

@Getter
public class ResponseResPartnerModel<T> {
    private String message;
    private T data;

    public ResponseResPartnerModel(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
