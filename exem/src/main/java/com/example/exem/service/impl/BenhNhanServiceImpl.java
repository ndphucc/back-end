package com.example.exem.service.impl;

import com.example.exem.model.BenhNhan;
import com.example.exem.repository.BenhAnRepository;
import com.example.exem.repository.BenhNhanRepository;
import com.example.exem.service.BenhNhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BenhNhanServiceImpl implements BenhNhanService {
    @Autowired
    private BenhNhanRepository benhNhanRepository;
    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }

    @Override
    public BenhNhan findById(int id) {
        return benhNhanRepository.findById(id);
    }
}
