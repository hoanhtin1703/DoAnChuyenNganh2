package com.example.BookStore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bang_don_hang")
public class DonHang {

    @Id
    @Column(name = "ma_dat_hang")
    private String maDatHang;

    @Column(name = "ma_nguoi_dung")
    private Integer maKhachHang;

    @Column(name = "ma_nhan_vien")
    private Integer maNhanVien;

    @Column(name = "ngay_dat_hang")
    private String ngayDatHang;

    @Column(name = "ngay_giao_hang")
    private String ngayGiaoHang;

    @Column(name = "dia_chi_giao_hang")
    private String diaChiGiaoHang;

    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;

    @Column(name = "so_dien_thoai_nguoi_nhan")
    private String soDienThoaiNguoiNhan;

    @Column(name = "trang_thai_don_hang")
    private int trangThaiDonHang;

    @Column(name = "ma_thanh_toan")
    private int maThanhToan;

    @Column(name = "tong_tien")
    private long tongTien;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_thanh_toan", insertable = false, updatable = false)
    private ThanhToan thanhToan;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_nguoi_dung", insertable = false, updatable = false)
    private NguoiDung nguoiDung;

    @OneToMany(mappedBy = "donHang",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    private List<DonHangChiTiet> donHangChiTiets;


    public DonHang() {
    }

    public DonHang(int maKhachHang, int maNhanVien, String ngayDatHang, String ngayGiaoHang, String diaChiGiaoHang, String tenNguoiNhan, String soDienThoaiNguoiNhan, int trangThaiDonHang, int maThanhToan, long tongTien) {
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.ngayDatHang = ngayDatHang;
        this.ngayGiaoHang = ngayGiaoHang;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDienThoaiNguoiNhan = soDienThoaiNguoiNhan;
        this.trangThaiDonHang = trangThaiDonHang;
        this.maThanhToan = maThanhToan;
        this.tongTien = tongTien;
    }

    public void setMaDatHang(String maDatHang) {
        this.maDatHang = maDatHang;
    }

    public String getMaDatHang() { return maDatHang; }
    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(String ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public String getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(String ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getSoDienThoaiNguoiNhan() {
        return soDienThoaiNguoiNhan;
    }

    public void setSoDienThoaiNguoiNhan(String soDienThoaiNguoiNhan) {
        this.soDienThoaiNguoiNhan = soDienThoaiNguoiNhan;
    }

    public int getTrangThaiDonHang() {
        return trangThaiDonHang;
    }

    public void setTrangThaiDonHang(int trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }


    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public ThanhToan getThanhToan() {
        return thanhToan;
    }

    public void setThanhToans(ThanhToan thanhToan) {
        this.thanhToan = thanhToan;
    }

    public NguoiDung getKhachHang() {
        return nguoiDung;
    }

    public void setKhachHangs(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public List<DonHangChiTiet> getDonHangChiTiets() {
        return donHangChiTiets;
    }

    public void setDonHangChiTiets(List<DonHangChiTiet> donHangChiTiets) {
        this.donHangChiTiets = donHangChiTiets;
    }


}
