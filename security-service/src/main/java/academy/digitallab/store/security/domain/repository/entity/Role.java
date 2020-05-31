package academy.digitallab.store.security.domain.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "tbl_role")
public class Role  implements Serializable {

    @Id
    private String role;
    private String status;
}
