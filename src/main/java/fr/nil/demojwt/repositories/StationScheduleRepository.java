package fr.nil.demojwt.repositories;

import fr.nil.demojwt.entities.user.stations.StationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationScheduleRepository extends JpaRepository<StationSchedule,Integer> {
}
