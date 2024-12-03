package bordero.backend.service;

import bordero.backend.model.Bordero;
import bordero.backend.model.Performance;
import bordero.backend.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository repository;

    @Autowired
    private BorderoService borderoService;

    @Override
    public JpaRepository<Performance, Long> getRepository() {
        return repository;
    }

    @Override
    public Response<Performance> insert(Performance p) {
        if (p != null) {
            if (p.getPlay() != null && !p.getPlay().getCode().isEmpty()) {
                p = repository.saveAndFlush(p);
                return Response.ofValid(p);
            } else return Response.ofError(PerformanceService.ERROR_PERFORMANCE_PLAY_MISSING);
        } else return Response.ofError(PerformanceService.ERROR_PERFORMANCE_UNSPECIFIED);
    }

    @Override
    public List<Performance> findChildrenForParent(long parentId) {
        Response<Bordero> response = borderoService.findById(parentId);
        if (response.isValid()) {
            Bordero bordero = response.getValue();
            return bordero.getPerformances();
        } else return new ArrayList<>();
    }

}
