package com.example.exem.repository;

import com.example.exem.model.BenhNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BenhNhanRepository extends JpaRepository<BenhNhan, Integer> {
    @Query(value = "select * from benh_nhan", nativeQuery = true)
    List<BenhNhan> findAll();

    @Query(value = "select * from benh_nhan where id=:id", nativeQuery = true)
    BenhNhan findById(@Param("id") int id);
}
