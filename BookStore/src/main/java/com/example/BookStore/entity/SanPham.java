package com.example.BookStore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "bang_san_pham")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SanPham {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_san_pham")
    private int maSanPham;

    @Column(name = "ma_the_loai")
    private int maTheLoai;

    @Column(name = "giam_gia")
    private int giamGia;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "gia_nhap")
    private long giaNhap;

    @Column(name = "gia_ban")
    private long giaBan;

    @Column(name = "so_luong_trong_kho")
    private int soLuongTrongKho;

    @Column(name = "trang_thai")
    private int trangThai;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "the_san_pham")
    private String theSanPham;

    @OneToMany(mappedBy = "sanPham",
            cascade = CascadeType.ALL)

    private List<DanhGia> danhGia;

    @OneToMany(mappedBy = "sanPham",
            cascade = CascadeType.ALL
    )
    private List<HinhAnhSanPham> hinhAnhSanPhams;


    @ManyToMany(mappedBy = "sanPhams",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )

    private List<NhaCungCap> nhaCungCaps;

    @OneToMany(mappedBy = "sanPham",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })

    private List<DonHangChiTiet> donHangChiTiets;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_the_loai", insertable = false, updatable = false)
    private TheLoai theLoai;


    public SanPham() {
    }

    public SanPham(int maTheLoai, int giamGia, String tenSanPham, long giaNhap, long giaBan, int soLuongTrongKho, int trangThai, String moTa, String theSanPham) {
        this.maTheLoai = maTheLoai;
        this.giamGia = giamGia;
        this.tenSanPham = tenSanPham;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuongTrongKho = soLuongTrongKho;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.theSanPham = theSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }


    public int getMaTheLoai() {
        return this.maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongTrongKho() {
        return soLuongTrongKho;
    }

    public void setSoLuongTrongKho(int soLuongTrongKho) {
        this.soLuongTrongKho = soLuongTrongKho;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTheSanPham() {
        return theSanPham;
    }

    public void setTheSanPham(String theSanPham) {
        this.theSanPham = theSanPham;
    }

    public List<DanhGia> getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(List<DanhGia> danhGia) {
        this.danhGia = danhGia;
    }

    public List<HinhAnhSanPham> getHinhAnhSanPhams() {
        return hinhAnhSanPhams;
    }

    public void setHinhAnhSanPhams(List<HinhAnhSanPham> hinhAnhSanPhams) {
        this.hinhAnhSanPhams = hinhAnhSanPhams;
    }

    public List<NhaCungCap> getNhaCungCaps() {
        return nhaCungCaps;
    }

    public void setNhaCungCaps(List<NhaCungCap> nhaCungCaps) {
        this.nhaCungCaps = nhaCungCaps;
    }

    public List<DonHangChiTiet> getDonHangChiTiets() {
        return donHangChiTiets;
    }

    public void setDonHangChiTiets(List<DonHangChiTiet> donHangChiTiets) {
        this.donHangChiTiets = donHangChiTiets;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setMaGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }
}
