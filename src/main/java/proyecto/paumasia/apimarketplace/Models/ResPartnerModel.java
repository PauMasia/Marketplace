package proyecto.paumasia.apimarketplace.Models;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResPartnerModel {
    public String username;
    @Email
    public String mail;
    public String password;
}
