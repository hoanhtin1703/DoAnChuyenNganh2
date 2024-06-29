package com.example.BookStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "bang_nguoi_dung")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NguoiDung {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_dung")
    private int maNguoiDung;

    @Column(name = "ten_nguoi_dung")
    private String tenNguoiDung;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "loai_tai_khoan")
    private int loaiTaiKhoan;

    @OneToMany(mappedBy = "nguoiDung",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DanhGia> danhGia;

    @OneToMany(mappedBy = "nguoiDung",
    fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private List<DonHang> donHangs;

    public NguoiDung() {
    }

    public NguoiDung(String tenNguoiDung, String soDienThoai, String email, String matKhau, String diaChi, int loaiTaiKhoan) {
        this.tenNguoiDung = tenNguoiDung;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(int loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public List<DanhGia> getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(List<DanhGia> danhGia) {
        this.danhGia = danhGia;
    }

    public List<DonHang> getDonHangs() {
        return donHangs;
    }

    public void setDonHangs(List<DonHang> donHangs) {
        this.donHangs = donHangs;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
