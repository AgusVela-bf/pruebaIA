package bordero.backend.repository;

import bordero.backend.model.Performance;
import bordero.backend.model.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> { }