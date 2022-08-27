package com.example.exem.service;

import com.example.exem.model.BenhNhan;

import java.util.List;

public interface BenhNhanService {
    List<BenhNhan> findAll();

    BenhNhan findById(int id);
}
