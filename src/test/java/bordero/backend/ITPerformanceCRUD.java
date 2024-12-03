package bordero.backend;

import bordero.backend.service.CRUDService;
import bordero.backend.service.PerformanceService;
import bordero.client.RestCRUDClient;
import bordero.dto.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ITPerformanceCRUD {

    @LocalServerPort
    private int port;

    private RestCRUDClient<PlayDTO> playCli;
    private RestCRUDClient<BorderoDTO> bordCli;
    private RestCRUDClient<CustomerDTO> custCli;
    private RestCRUDClient<PerformanceDTO> perfCli;


    public String baseURL() {
        return "http://localhost:" + port + "/api/performances/";
    }

    public String playsURL() {
        return "http://localhost:" + port + "/api/plays/";
    }

    public String customersURL() {
        return "http://localhost:" + port + "/api/customers/";
    }

    public String borderoURL() {
        return "http://localhost:" + port + "/api/borderos/";
    }




}
