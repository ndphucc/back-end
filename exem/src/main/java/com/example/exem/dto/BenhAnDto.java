package com.example.exem.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class BenhAnDto implements Validator {
    @NotBlank
    @NotNull
    private String tenBenhVien;
    @NotNull
    private Date ngayNhapVien;
    @NotNull
    private Date ngayRaVien;
    @NotBlank
    private String lyDo;
    @NotBlank
    private String phuongPhapDieuTri;
    @NotBlank
    private String bacSiDieuTri;
    @NotNull
    private int IdBenhNhan;

    public BenhAnDto() {
    }

    public String getTenBenhVien() {
        return tenBenhVien;
    }

    public void setTenBenhVien(String tenBenhVien) {
        this.tenBenhVien = tenBenhVien;
    }

    public Date getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(Date ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public Date getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(Date ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getPhuongPhapDieuTri() {
        return phuongPhapDieuTri;
    }

    public void setPhuongPhapDieuTri(String phuongPhapDieuTri) {
        this.phuongPhapDieuTri = phuongPhapDieuTri;
    }

    public String getBacSiDieuTri() {
        return bacSiDieuTri;
    }

    public void setBacSiDieuTri(String bacSiDieuTri) {
        this.bacSiDieuTri = bacSiDieuTri;
    }

    public int getIdBenhNhan() {
        return IdBenhNhan;
    }

    public void setIdBenhNhan(int idBenhNhan) {
        IdBenhNhan = idBenhNhan;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BenhAnDto temp = (BenhAnDto) target;
        try{
            if (temp.ngayNhapVien.after(temp.ngayRaVien)) {
                errors.rejectValue("ngayRaVien","dateValidator"," Ngày ra viện phải sau ngày nhập viện!");
            }
        }catch (NullPointerException e){
            e.getMessage();
        }

    }
}
