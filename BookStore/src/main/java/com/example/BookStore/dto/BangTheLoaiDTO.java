package com.example.BookStore.dto;

import com.example.BookStore.entity.SanPham;
import com.example.BookStore.entity.TheLoai;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BangTheLoaiDTO {
    private Integer maTheLoai;
    private String tenTheLoai;
    private Integer trangThaiTheLoai;
    private int soLuong;
    private List<BangSanPhamDTO> dsSanPham;
    public BangTheLoaiDTO(TheLoai theLoai, int choose) {
        this.maTheLoai = theLoai.getMaTheLoai();
        this.tenTheLoai = theLoai.getTenTheLoai();
        this.trangThaiTheLoai = theLoai.getTrangThaiTheLoai();
        this.soLuong = theLoai.getSanPhams().size();

        if(choose == 0) {
            this.dsSanPham = theLoai.getSanPhams().stream()
                    .map(sanPham -> new BangSanPhamDTO(sanPham, -1))
                    .collect(Collectors.toList());
        }
    }

}
