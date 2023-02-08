package fr.nil.demojwt.entities.stations;

import fr.nil.demojwt.entities.stations.fuels.Fuel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "_stations")
public class Station {

        @Id
        @Column(name = "id")

        @GeneratedValue
        private Integer id;
        @NonNull
        private String name;
        @NonNull
        private Date updated_at;
        @NonNull
        private boolean hasAutomaticPayment;

        @NonNull
        @ManyToMany
        private List<Service> serviceList;

        @NonNull
        @ManyToOne
        private Location location;

        @NonNull
        @ManyToMany
        private List<Fuel> fuelList;

        @NonNull
        @ManyToOne
        private StationSchedule schedule;

}
