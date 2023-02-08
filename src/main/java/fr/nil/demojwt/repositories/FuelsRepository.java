package fr.nil.demojwt.repositories;

import fr.nil.demojwt.entities.user.stations.fuels.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelsRepository extends JpaRepository<Fuel, Integer> {




}
