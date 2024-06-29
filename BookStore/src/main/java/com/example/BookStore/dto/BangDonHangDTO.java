package com.example.BookStore.dto;

import com.example.BookStore.entity.DonHang;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BangDonHangDTO {
    private String maDatHang;
    private String diaChiGiaoHang;
    private String ngayDatHang;
    private String ngayGiaoHang;
    private String soDienThoaiNguoiNhan;
    private int maNhanVien;
    private String tenNguoiNhan;
    private Long tongTien;
    private Integer trangThaiDonHang;
    private BangNguoiDungDTO nguoiDung;
    private List<BangDonHangChiTietDTO> donHangChiTiet;
    private String phuongThucThanhToan;

    public BangDonHangDTO(DonHang donHang, int choose) {
        this.maDatHang = donHang.getMaDatHang();
        this.diaChiGiaoHang = donHang.getDiaChiGiaoHang();
        this.ngayDatHang = donHang.getNgayDatHang();
        this.ngayGiaoHang = donHang.getNgayGiaoHang();
        this.soDienThoaiNguoiNhan = donHang.getSoDienThoaiNguoiNhan();
//        this.maNhanVien = donHang.getMaNhanVien();
        this.tenNguoiNhan = donHang.getTenNguoiNhan();
        this.tongTien = donHang.getTongTien();
        this.trangThaiDonHang = donHang.getTrangThaiDonHang();
        this.phuongThucThanhToan = donHang.getThanhToan().getPhuongThucThanhToan();
        this.nguoiDung = new BangNguoiDungDTO(donHang.getKhachHang());
        // Choose == 1 dùng khi xem chi tiết về đơn hàng
        if(choose == 1) {
            this.donHangChiTiet = donHang
                    .getDonHangChiTiets()
                    .stream()
                    .map(sanPham -> new BangDonHangChiTietDTO(sanPham, 1))
                    .collect(Collectors.toList());
        }

    }

}
