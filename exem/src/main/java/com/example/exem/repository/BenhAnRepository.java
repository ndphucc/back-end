package com.example.exem.repository;

import com.example.exem.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface BenhAnRepository extends JpaRepository<BenhAn, Integer> {
    @Query(value = "select * from benh_an", nativeQuery = true)
    Page<BenhAn> findAll(Pageable pageable);

    @Modifying
    @Query(value = "insert into benh_an value (:bac_si_dieu_tri,:ly_do,:ngay_nhap_vien,:ngay_ra_vien,:phuong_phap_dieu_tri,:ten_benh_vien,:benh_nhan_id", nativeQuery = true)
    BenhAn create(@Param("bac_si_dieu_tri") String bacSiDieuTri, @Param("ly_do") String lyDo, @Param("ngay_nhap_vien") String ngayNhapVien, @Param("ngay_ra_vien") String ngayRaVien, @Param("phuong_phap_dieu_tri") String phuongPhapDieuTri, @Param("ten_benh_vien") String tenBenhVien, @Param("benh_nhan_id") int id);

    @Modifying
    @Query(value = "update  benh_an set bac_si_dieu_tri=:bac_si_dieu_tri,ly_do=:ly_do,ngay_nhap_vien=:ngay_nhap_vien,ngay_ra_vien=:ngay_ra_vien,phuong_phap_dieu_tri=:phuong_phap_dieu_tri,ten_benh_vien=:ten_benh_vien,benh_nhan_id=:benh_nhan_id where id=:id", nativeQuery = true)
    BenhAn update(@Param("bac_si_dieu_tri") String bacSiDieuTri, @Param("ly_do") String lyDo, @Param("ngay_nhap_vien") String ngayNhapVien, @Param("ngay_ra_vien") String ngayRaVien, @Param("phuong_phap_dieu_tri") String phuongPhapDieuTri, @Param("ten_benh_vien") String tenBenhVien, @Param("benh_nhan_id") int benhNhanId, @Param("id") int id);

    @Modifying
    @Query(value = "delete from benh_an where id=:id", nativeQuery = true)
    BenhAn delete(@Param("id") int id);

    @Query(value = "select * from benh_an where bac_si_dieu_tri like :bac_si_dieu_tri", nativeQuery = true)
    Page<BenhAn> search(@Param("bac_si_dieu_tri") String bacSiDieuTri, Pageable pageable);

    @Query(value = "select * from benh_an where id=:id", nativeQuery = true)
    BenhAn findById(@Param("id") int id);
}
