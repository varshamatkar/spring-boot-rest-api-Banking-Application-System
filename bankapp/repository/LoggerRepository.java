package com.bankapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.entity.Logger;

public interface LoggerRepository extends JpaRepository<Logger, Integer> {

}
