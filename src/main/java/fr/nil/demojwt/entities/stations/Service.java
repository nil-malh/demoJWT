package fr.nil.demojwt.entities.stations;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "_services")

public class Service {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @NonNull
    private String serviceName;
    @NonNull
    private String serviceDescription;


}
