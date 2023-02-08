package fr.nil.demojwt.entities.stations;

import fr.nil.demojwt.utils.StringListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "_stations_schedule")
public class StationSchedule {


    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    @Convert(converter = StringListConverter.class)
    private List<String> openedDays;
    @NonNull
    private LocalDateTime open_at;
    @NonNull
    private LocalDateTime close_at;
    @NonNull
    private boolean isClosed;


}
