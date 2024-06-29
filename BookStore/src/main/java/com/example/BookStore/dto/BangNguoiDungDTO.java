package com.example.BookStore.dto;

import com.example.BookStore.entity.NguoiDung;
import lombok.Data;

@Data
public class BangNguoiDungDTO {
    private Integer maNguoiDung;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private String tenNguoiDung;
    private int loaiTaiKhoan;
    private String matKhau;
    public BangNguoiDungDTO(NguoiDung nguoiDung) {
        this.maNguoiDung = nguoiDung.getMaNguoiDung();
        this.diaChi = nguoiDung.getDiaChi();
        this.email = nguoiDung.getEmail();
        this.soDienThoai = nguoiDung.getSoDienThoai();
        this.tenNguoiDung = nguoiDung.getTenNguoiDung();
        this.loaiTaiKhoan = nguoiDung.getLoaiTaiKhoan();
        this.matKhau = nguoiDung.getMatKhau();
    }
}
