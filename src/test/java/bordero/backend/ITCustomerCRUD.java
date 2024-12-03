package bordero.backend;

import bordero.backend.service.CRUDService;
import bordero.backend.service.CustomerService;
import bordero.client.RestCRUDClient;
import bordero.dto.CustomerDTO;
import bordero.dto.ResponseDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ITCustomerCRUD {

    @LocalServerPort
    private int port;

    private RestCRUDClient<CustomerDTO> client;

    public String baseURL() {
        return "http://localhost:" + port + "/api/customers/";
    }

    CustomerDTO aCustomer = null;
    String name = "Teatro Uno";



}
