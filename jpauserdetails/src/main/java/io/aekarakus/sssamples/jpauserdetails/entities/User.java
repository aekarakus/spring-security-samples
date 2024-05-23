package io.aekarakus.sssamples.jpauserdetails.entities;


import io.aekarakus.sssamples.jpauserdetails.converters.AuthoritiesConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "USERS_TABLE")
@Entity
public class User {
    @Id
    private Long id;
    private String password;
    private String userName;
    private String email;

    @Column
    @Convert(converter = AuthoritiesConverter.class)
    private List<String> authorities = new ArrayList<>();
}
