package proyecto.paumasia.apimarketplace.Entity;

import proyecto.paumasia.apimarketplace.BaseModel;

public class AccountMoveLine extends BaseModel {
    public ProductProduct product_id;
    public AccountMove move_id;
    public Float quantity;
    public Float line_discount; // %
    public Float product_price;
    public Float total_price;

    public AccountMoveLine(ResPartner create_uid) {
        super(create_uid);
    }
    // Se deberi de añadir tasas extra por linea, por si el envio tiene un coste extra en aduanas o algo
    // public Integer extra_tax;
    // realmente deberia de ser una lista de tasas y luego sacar el %, por si hay varias, no se va a tener el cuenta por ahora

    static public void compute_total_price(){ // metodo calculo precio lineas
        total
    }
}
