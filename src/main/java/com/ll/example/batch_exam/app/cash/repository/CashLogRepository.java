package com.ll.example.batch_exam.app.cash.repository;

import com.ll.example.batch_exam.app.cash.entity.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashLogRepository extends JpaRepository<CashLog, Long> {
}
