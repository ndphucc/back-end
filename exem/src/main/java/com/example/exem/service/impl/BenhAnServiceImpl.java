package com.example.exem.service.impl;

import com.example.exem.model.BenhAn;
import com.example.exem.repository.BenhAnRepository;
import com.example.exem.service.BenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BenhAnServiceImpl implements BenhAnService {
    @Autowired
    private BenhAnRepository benhAnRepository;

    @Override
    public Page<BenhAn> findAll(Pageable pageable) {
        return benhAnRepository.findAll(pageable);
    }

    @Override
    public BenhAn create(BenhAn benhAn) {
        return benhAnRepository.create(benhAn.getBacSiDieuTri(), benhAn.getLyDo(), benhAn.getNgayNhapVien(), benhAn.getNgayRaVien(), benhAn.getPhuongPhapDieuTri(), benhAn.getTenBenhVien(), benhAn.getBenhNhan().getId());
    }

    @Override
    public BenhAn update(BenhAn benhAn) {
        return benhAnRepository.update(benhAn.getBacSiDieuTri(), benhAn.getLyDo(), benhAn.getNgayNhapVien(), benhAn.getNgayRaVien(), benhAn.getPhuongPhapDieuTri(), benhAn.getTenBenhVien(), benhAn.getBenhNhan().getId(),benhAn.getId());
    }

    @Override
    public BenhAn delete(int id) {
        return benhAnRepository.delete(id);
    }

    @Override
    public BenhAn finById(int id) {
        return benhAnRepository.findById(id);
    }

    @Override
    public Page<BenhAn> search(String bacSi,Pageable pageable) {
        return benhAnRepository.search(bacSi,pageable);
    }
}
