package com.example.BookStore.dto;

import com.example.BookStore.entity.GiamGia;
import com.example.BookStore.entity.SanPham;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BangGiamGiaDTO {
    private int maGiamGia;
    private String tenGiamGia;
    private int phanTramGiam;
    private int trangThai;
    private List<BangSanPhamDTO> dsSanPham;
    private int soLuong;

    public BangGiamGiaDTO(GiamGia giamGia, int choose) {
        this.maGiamGia = giamGia.getMaGiamGia();
        this.tenGiamGia = giamGia.getTenGiamGia();
        this.phanTramGiam = giamGia.getPhanTramGiam();
        this.trangThai = giamGia.getTrangThai();
        this.soLuong = giamGia.getDsSanPham().size();
        if(choose == 0) {
            this.dsSanPham = giamGia.getDsSanPham()
                    .stream()
                    .map(sanPham -> new BangSanPhamDTO(sanPham, -1))
                    .collect(Collectors.toList());
        }
    }
}
