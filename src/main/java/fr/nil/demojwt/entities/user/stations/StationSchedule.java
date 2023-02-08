package fr.nil.demojwt.entities.user.stations;

import fr.nil.demojwt.utils.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_stations_schedule")
public class StationSchedule {


    @Id
    @GeneratedValue
    private Integer id;

    @Convert(converter = StringListConverter.class)
    private List<String> openedDays;

    private LocalDateTime open_at;
    private LocalDateTime close_at;
    private boolean isClosed;


}
