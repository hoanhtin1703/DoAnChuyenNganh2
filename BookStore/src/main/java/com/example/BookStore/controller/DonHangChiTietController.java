package com.example.BookStore.controller;

import com.example.BookStore.dao.DonHangChiTietDAO;
import com.example.BookStore.dto.BangDonHangChiTietDTO;
import com.example.BookStore.dto.BangDonHangDTO;
import com.example.BookStore.entity.DonHang;
import com.example.BookStore.entity.DonHangChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/don-hang-chi-tiet")
public class DonHangChiTietController {
    private DonHangChiTietDAO donHangChiTietDAO;

    @Autowired
    public DonHangChiTietController(DonHangChiTietDAO donHangChiTietDAO){
        this.donHangChiTietDAO = donHangChiTietDAO;
    }

    @GetMapping("")
    public List<BangDonHangChiTietDTO> hienThiDSDonHang(){
        return donHangChiTietDAO.getAll();
    }

    @PostMapping("/them")
    public String themSanPham(@RequestBody List<DonHangChiTiet> donHang) {
        for(DonHangChiTiet donHangChiTiet : donHang) {
            donHangChiTietDAO.save(donHangChiTiet);
        }
        return "Bạn đã thêm thành công!";
    }

    @PutMapping("/cap-nhat")
    public String capNhatSanPham(@RequestBody DonHangChiTiet donHang){
        donHangChiTietDAO.update(donHang);
        return "Bạn đã cập nhật thành công!";
    }

    @DeleteMapping("/xoa/{id}")
    public String xoaSanPham(@PathVariable("id") int id){
        donHangChiTietDAO.xoaDonHangChiTiet(id);
        return "Bạn đã xóa thành công!";
    }

    @GetMapping("/{id}")
    public BangDonHangChiTietDTO laySanPhamTheoId(@PathVariable("id") int maSanPham){
        return donHangChiTietDAO.timDonHangChiTietDeHienThi(maSanPham);
    }
}
