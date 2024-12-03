package bordero.backend;

import bordero.backend.service.CRUDService;
import bordero.backend.service.PlayService;
import bordero.client.RestCRUDClient;
import bordero.dto.PlayDTO;
import bordero.dto.ResponseDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ITPlayCRUD {

    @LocalServerPort
    private int port;

    private RestCRUDClient<PlayDTO> client;

    public String baseURL() {
        return "http://localhost:" + port + "/api/plays/";
    }

    PlayDTO aPlay = null;
    String code = "hamlet";
    String name = "Hamlet";
    String type = "tragedy";

    List<PlayDTO> plays;





}
