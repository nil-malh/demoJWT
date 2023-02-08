package fr.nil.demojwt.entities.user.stations;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_services")

public class Service {

    @Id
    @GeneratedValue
    private Integer id;
    private String serviceName;
    private String serviceDescription;


}
