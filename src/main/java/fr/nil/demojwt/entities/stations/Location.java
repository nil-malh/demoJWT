package fr.nil.demojwt.entities.stations;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "_locations")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @NonNull
    private String cityName;
    @NonNull
    private String zipCode;
    @NonNull
    private Float latitude;
    @NonNull
    private Float longitude;
    @NonNull
    private String address;





}
