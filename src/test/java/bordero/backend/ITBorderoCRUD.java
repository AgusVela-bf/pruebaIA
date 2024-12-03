package bordero.backend;

import bordero.backend.model.Customer;
import bordero.backend.service.CRUDService;
import bordero.client.RestCRUDClient;
import bordero.dto.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ITBorderoCRUD {

    @LocalServerPort
    private int port;

    private RestCRUDClient<CustomerDTO> custCli;
    private RestCRUDClient<BorderoDTO> bordCli;

    BorderoDTO aBordero = null;
    CustomerDTO aCustomer = null;
    LocalDate date = null;

    public String baseURL() {
        return "http://localhost:" + port + "/api/borderos/";
    }

    public String customersURL() {
        return "http://localhost:" + port + "/api/customers/";
    }

    List<BorderoDTO> borderos;




}
