package bordero.backend.controller;

import bordero.backend.model.Customer;
import bordero.backend.service.CustomerService;
import bordero.dto.CustomerDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/customers", produces = "application/json")
public class CustomerController extends CRUDRestController<CustomerDTO, Customer> {

    public CustomerController(CustomerService service, DTOModelMapper<CustomerDTO, Customer> mapper) {
        super(service, mapper);
    }

    @Override
    public String url() {
        return "/customers/";
    }


    @GetMapping(value = "", params = "name")
    public ResponseEntity<List<CustomerDTO>> findByName(@RequestParam("name") String name) {
        Customer buscado = new Customer();
        buscado.setName(name);
        ExampleMatcher matcher =
                ExampleMatcher.matchingAny()
                .withIgnorePaths("id")
                .withMatcher("name",
                        ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        List<Customer> result = getService().query(Example.of(buscado, matcher));
        List<CustomerDTO> outDTO = getMapper().toDTO(result);
        return ResponseEntity.ok().body(outDTO);
    }


}
