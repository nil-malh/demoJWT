package fr.nil.demojwt.entities.user.stations.fuels;

import fr.nil.demojwt.entities.user.stations.Station;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
