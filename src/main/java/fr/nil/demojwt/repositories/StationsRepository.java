package fr.nil.demojwt.repositories;

import fr.nil.demojwt.entities.stations.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationsRepository extends JpaRepository<Station,Integer> {




}
