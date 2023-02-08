package fr.nil.demojwt;

import fr.nil.demojwt.entities.stations.Location;
import fr.nil.demojwt.entities.stations.Service;
import fr.nil.demojwt.entities.stations.Station;
import fr.nil.demojwt.entities.stations.StationSchedule;
import fr.nil.demojwt.entities.stations.fuels.Fuel;
import fr.nil.demojwt.repositories.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoJwtApplicationTests {

    private Logger logger = LoggerFactory.getLogger(DemoJwtApplicationTests.class);

    @Autowired
    private FuelsRepository fuelsRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private StationsRepository stationsRepository;

    @Autowired
    private StationScheduleRepository stationScheduleRepository;


    @Test
    void contextLoads() {

    }


    @Test
    void checkFuelCreationFunctionality() {
        Fuel sp98 = new Fuel("SP98", 1.598F, " Sans-Plomb 98");
        logger.warn(() -> "Creating a new fuel of type " + sp98.getFuelType() + " with the name" + sp98.getFuelName());
        logger.warn(() -> "Now saving it to its repository.");
        fuelsRepository.save(sp98);
        logger.warn(() -> "Fuel should now be saved into the database.");

        if (fuelsRepository.existsById(sp98.getId()))
            logger.warn(() -> "Fuel has been found in the database ! ");
    }

    @Test
    void checkStationCreationFunctionality() {
        /*** Location Saving **/
        logger.warn(() -> "Creating Location and saving it into its repository");
        Location location = new Location("Lempdes-sur-Allagnon", "43410", 3.175F, 3.1564864F, "Moulin de la Ribeyre");
        locationRepository.save(location);
        logger.warn(() -> "Location should be saved into repository.");

        /** Services List Saving **/
        logger.warn(() -> "Creating two services, and saving them into their repository");
        Service toilet = new Service("Toilette à disposition", "Pour pisser par example quoi");
        Service atm = new Service("DAB", "Pour sortir la kishta tu connais");
        logger.warn(() -> "Services has been created, putting them into a List<Service>");
        List<Service> serviceList = List.of(toilet, atm);
        logger.warn(() -> "Services has been put into a List<Service>, now saving them in their repository.");
        serviceRepository.saveAll(serviceList);
        logger.warn(() -> "Services should be saved in their repo now.");
        /** Fuel List Saving **/

        logger.warn(() -> "Creating two fuels, and saving them into their repository");
        Fuel sp98 = new Fuel("SP98", 1.598F, " Sans-Plomb 98");
        Fuel e85 = new Fuel("e85", 0.598F, " Super-Ethanol");
        logger.warn(() -> "Fuels has been created, putting them into a List<Fuel>");

        List<Fuel> fuelList = List.of(sp98,e85);
        logger.warn(() -> "Fuels has been put into a List<Fuel>, now saving them in their repository.");
        fuelsRepository.saveAll(fuelList);
        logger.warn(() -> "Fuels should be saved in their repo now.");
        /** StationSchedule Saving **/
        logger.warn(() -> "Creating StationSchedule and saving it into its repository");
        StationSchedule stationSchedule =  new StationSchedule(List.of("Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"), LocalDateTime.now(),LocalDateTime.now(),false);
        stationScheduleRepository.save(stationSchedule);
        logger.warn(() -> "StationSchedule should be saved into repository.");

        logger.warn(() -> "Here come the tricky part, creating station and saving it into its repository");
        Station station = new Station("Putain de merde", new Date(),true,serviceList,location,fuelList,stationSchedule);
        stationsRepository.save(station);
        logger.warn(() -> "Station should be saved into repository.");

    }

    @Test
    void checkStationDataIntegrity()
    {

        final Integer STATION_ID_TEST = 252;


    }

}
