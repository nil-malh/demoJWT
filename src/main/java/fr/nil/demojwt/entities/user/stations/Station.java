package fr.nil.demojwt.entities.user.stations;

import fr.nil.demojwt.entities.user.stations.fuels.Fuel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_stations")
public class Station {

        @Id
        @GeneratedValue
        private Integer id;
        private String name;
        private Date updated_at;
        private boolean hasAutomaticPayment;

        @ManyToOne
        private Service service;

        @ManyToOne
        private Location location;

        @ManyToMany
        private List<Fuel> fuelList;

        @ManyToOne
        private StationSchedule schedule;




}
