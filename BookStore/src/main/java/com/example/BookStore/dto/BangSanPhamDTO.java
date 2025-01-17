package com.example.BookStore.dto;

import com.example.BookStore.entity.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BangSanPhamDTO {
    private Integer maSanPham;
    private Long giaBan;
    private Long giaNhap;
    private BangTheLoaiDTO theLoai;
    private String moTa;
    private Integer soLuongTrongKho;
    private String tenSanPham;
    private String theSanPham;
    private Integer trangThai;
    private List<BangDanhGiaDTO> danhGia;
    private List<BangHinhAnhSanPhamDTO> hinhAnhSanPham;
    private int giamGia;
    public BangSanPhamDTO(SanPham sanPham, int choose) {
        this.maSanPham = sanPham.getMaSanPham();
        this.tenSanPham = sanPham.getTenSanPham();
        this.giaNhap = sanPham.getGiaNhap();
        this.giaBan = sanPham.getGiaBan();
        this.soLuongTrongKho = sanPham.getSoLuongTrongKho();
        this.trangThai = sanPham.getTrangThai();
        this.moTa = sanPham.getMoTa();
        this.theSanPham = sanPham.getTheSanPham();
//        this.maTheLoai = sanPham.getMaTheLoai();
        this.theLoai = new BangTheLoaiDTO(sanPham.getTheLoai(), -1);
        this.hinhAnhSanPham = sanPham.getHinhAnhSanPhams()
                .stream()
                .map(BangHinhAnhSanPhamDTO::new)
                .collect(Collectors.toList());
        this.giamGia = sanPham.getGiamGia();
        if (choose == 1) {
            this.danhGia = sanPham.getDanhGia()
                    .stream()
                    .map(BangDanhGiaDTO::new)
                    .collect(Collectors.toList());
        }

    }
}
