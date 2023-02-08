package fr.nil.demojwt.repositories;

import fr.nil.demojwt.entities.stations.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
