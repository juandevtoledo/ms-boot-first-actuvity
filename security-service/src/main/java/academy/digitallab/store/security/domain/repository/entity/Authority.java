package academy.digitallab.store.security.domain.repository.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_authorities" ,
        uniqueConstraints=@UniqueConstraint (columnNames={"role","user_id"} ))
public class Authority  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "user_id")
    private String username;
}
