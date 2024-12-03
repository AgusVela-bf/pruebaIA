package bordero.backend.service;

import bordero.backend.model.Customer;
import bordero.backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public JpaRepository<Customer, Long> getRepository() {
        return repository;
    }

    @Override
    public Response<Customer> insert(Customer p) {
        if (p != null) {
            if (p.getName() != null && !p.getName().isEmpty()) {
                p = repository.saveAndFlush(p);
                return Response.ofValid(p);
            } else return Response.ofError(CustomerService.ERROR_CUSTOMER_NAME_MISSING);
        } else return Response.ofError(CustomerService.ERROR_CUSTOMER_UNSPECIFIED);
    }


}
