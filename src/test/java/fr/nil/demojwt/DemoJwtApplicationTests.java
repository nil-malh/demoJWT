package fr.nil.demojwt;

import fr.nil.demojwt.entities.user.stations.fuels.Fuel;
import fr.nil.demojwt.repositories.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void checkFuelCreationFunctionality()
    {

        Fuel sp98 = new Fuel("SP98", 1.598F,"Sans-Plomb 98");
        logger.warn(() -> "Creating a new fuel of type " + sp98.getFuelType() + " with the name" + sp98.getFuelName());
        logger.warn(() -> "Now saving it to its repository.");
        fuelsRepository.save(sp98);
        logger.warn(() -> "Fuel should now be saved into the database.");

    }

}
