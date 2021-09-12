package net.example.demofinproject.service;

import net.example.demofinproject.model.AuditEntity;
import net.example.demofinproject.repository.audit.AuditRepository;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Service
public class AuditService{

    private AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void saveAction(JoinPoint auditedPoint, HttpServletRequest request)
    {
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setIp_address(request.getRemoteAddr());
        auditEntity.setParameters(Arrays.toString(auditedPoint.getArgs()));
        auditEntity.setEndpoint(request.getRequestURL().toString());
        auditRepository.save(auditEntity);

    }
}
