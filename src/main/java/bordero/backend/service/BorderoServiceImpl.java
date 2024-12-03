package bordero.backend.service;

import bordero.backend.model.Bordero;
import bordero.backend.repository.BorderoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BorderoServiceImpl implements BorderoService {

    @Autowired
    private BorderoRepository repository;

    @Override
    public JpaRepository<Bordero, Long> getRepository() {
        return repository;
    }

    @Override
    public Response<Bordero> insert(Bordero aBordero) {
        if (aBordero != null) {
            if (aBordero.getCustomer() != null) {
                aBordero = repository.saveAndFlush(aBordero);
                System.out.println("Insert bordero called");
                return Response.ofValid(aBordero);
            } else return Response.ofError(BorderoService.ERROR_BORDERO_CUSTOMER_MISSING);
        } else return Response.ofError(BorderoService.ERROR_BORDERO_UNSPECIFIED);
    }

}
