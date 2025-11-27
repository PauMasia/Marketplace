package proyecto.paumasia.apimarketplace.Models;

import lombok.Getter;

@Getter
public class ResponseResPartnerModel<T> {
    private String message;
    private T data;
    private String token;

    public ResponseResPartnerModel(String message, T data) {
        this.message = message;
        this.data = data;
    }
    public ResponseResPartnerModel(String message, T data, String token) {
        this.message = message;
        this.data = data;
        this.token = token;
    }

}
