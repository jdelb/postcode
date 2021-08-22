package com.example.postcode;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface PostcodeRepository extends JpaRepository<Postcode, Long> {
    List<Postcode> findByCodeBetweenOrderByNameAsc(Integer start, Integer end);
}
