package com.paysuremiddleware.easypayservice.repository;

import com.paysuremiddleware.easypayservice.models.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
