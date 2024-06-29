package com.example.BookStore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bang_giam_gia")
public class GiamGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_giam_gia")
    private int maGiamGia;

    @Column(name = "ten_giam_gia")
    private String tenGiamGia;

    @Column(name = "phan_tram_giam")
    private int phanTramGiam;

    @Column(name = "trang_thai")
    private int trangThai;

    @OneToMany(mappedBy = "giamGia",
            cascade = CascadeType.ALL)

    private List<SanPham> dsSanPham;

    public GiamGia(String tenGiamGia, int phanTramGiam, int trangThai) {
        this.tenGiamGia = tenGiamGia;
        this.phanTramGiam = phanTramGiam;
        this.trangThai = trangThai;
    }

    public GiamGia() {

    }

    public int getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(int maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getTenGiamGia() {
        return tenGiamGia;
    }

    public void setTenGiamGia(String tenGiamGia) {
        this.tenGiamGia = tenGiamGia;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<SanPham> getDsSanPham() {
        return dsSanPham;
    }

    public void setDsSanPham(List<SanPham> dsSanPham) {
        this.dsSanPham = dsSanPham;
    }
}
