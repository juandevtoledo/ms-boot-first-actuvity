package academy.digitallab.store.security.domain.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenDto  implements Serializable {
    private String token;
}
