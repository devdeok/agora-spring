package com.demos.agora.model.manner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MannerRepository extends JpaRepository<Manner, Long> {

    @Query(value = "SELECT * FROM study", nativeQuery = true)
    int 스터디매너평가();


}
