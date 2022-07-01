package com.grenapex.Repository;

import com.grenapex.Entity.Compliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceRepository extends JpaRepository<Compliance,Integer> {
}
