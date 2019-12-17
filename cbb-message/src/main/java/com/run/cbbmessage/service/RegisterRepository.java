package com.run.cbbmessage.service;

import com.run.cbbmessage.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Integer> {
}
