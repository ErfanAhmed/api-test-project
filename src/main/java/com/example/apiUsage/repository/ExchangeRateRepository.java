package com.example.apiUsage.repository;

import com.example.apiUsage.domain.ExchangeRateDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRateDetail, Integer> {
}
