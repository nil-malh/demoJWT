package fr.nil.demojwt.repositories;

import fr.nil.demojwt.entities.user.stations.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
