package bordero.backend.controller;

import bordero.backend.model.Performance;
import bordero.backend.service.PerformanceService;
import bordero.backend.service.Response;
import bordero.dto.PerformanceDTO;
import bordero.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/performances", produces = "application/json")
public class PerformanceController extends CRUDRestController<PerformanceDTO, Performance> {

    public PerformanceController(PerformanceService service, DTOModelMapper<PerformanceDTO, Performance> mapper) {
        super(service, mapper);
    }

    @Override
    protected String url() {
        return "/performances/";
    }

}
