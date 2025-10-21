package proyecto.paumasia.apimarketplace.Entity;

import proyecto.paumasia.apimarketplace.BaseModel;

public class AccountMoveLine extends BaseModel {
    public ProductProduct product_id;
    public AccountMove move_id;
    public Integer quantity;
    public Integer line_discount; // %
    public Integer product_price;
    public Integer total_price;

    public AccountMoveLine(ResPartner create_uid) {
        super(create_uid);
    }
    // Se deberi de añadir tasas extra por linea, por si el envio tiene un coste extra en aduanas o algo
    // public Integer extra_tax;
    // realmente deberia de ser una lista de tasas y luego sacar el %, por si hay varias, no se va a tener el cuenta por ahora

    public //metodo calculo precio lineas
}
