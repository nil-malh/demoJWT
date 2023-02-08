package fr.nil.demojwt.entities.stations.fuels;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "_fuels")
public class Fuel {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @NonNull
    private String fuelType;
    @NonNull
    private Float price;
    @NonNull
    private String fuelName;



}
