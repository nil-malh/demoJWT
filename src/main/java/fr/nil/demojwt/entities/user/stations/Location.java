package fr.nil.demojwt.entities.user.stations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_locations")
public class Location {

    @Id
    @GeneratedValue
    private Integer id;
    private String cityName;
    private String zipCode;
    private Float latitude;
    private Float longitude;
    private String address;





}
