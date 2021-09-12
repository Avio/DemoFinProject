package net.example.demofinproject.repository.audit;

import net.example.demofinproject.model.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditEntity, Integer> {
}
