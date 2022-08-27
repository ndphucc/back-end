package com.example.exem.service;

import com.example.exem.model.BenhAn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BenhAnService {
    Page<BenhAn> findAll(Pageable pageable);

    BenhAn create(BenhAn benhAn);

    BenhAn update(BenhAn benhAn);

    BenhAn delete(int id);

    BenhAn finById(int id);

    Page<BenhAn> search(String bacSi,Pageable pageable);

}
