package com.example.BookStore.controller;

import com.example.BookStore.dao.SanPhamDAO;
import com.example.BookStore.dto.BangSanPhamDTO;
import com.example.BookStore.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/san-pham")
public class SanPhamController {
    private SanPhamDAO sanPhamDAO;

    @Autowired
    public SanPhamController(SanPhamDAO sanPhamDAO){
        this.sanPhamDAO = sanPhamDAO;
    }

    @GetMapping("")
    public List<BangSanPhamDTO> hienThiDSSP(){
        return sanPhamDAO.getAll();
    }

    @GetMapping("/{id}")
    public BangSanPhamDTO laySanPhamTheoId(@PathVariable("id") int maSanPham){
        return sanPhamDAO.timSanPhamTheoIdDeHienThi(maSanPham);
    }

    @GetMapping("/tim-kiem")
    public List<BangSanPhamDTO> laySanPhamTheoTen(@RequestParam(name = "ten") String tenSanPham){
        return sanPhamDAO.timSanPhamBangTen(tenSanPham);
    }

    @GetMapping("/giam-gia")
    public List<BangSanPhamDTO> laySanPhamGiamGia() {
        return sanPhamDAO.layTatCaSanPhamGiamGia();
    }

    @GetMapping("/giam-gia-moi")
    public List<BangSanPhamDTO> laySanPhamGiamGiaMoi() {
        return sanPhamDAO.laySanPhamGiamGiaMoi()    ;
    }

    @GetMapping("/ban-chay")
    public List<BangSanPhamDTO> laySanPhamBanChay() {
        return sanPhamDAO.laySanPhamBanChay();
    }

    @PostMapping("/them")
    public ResponseEntity<Object> themSanPham(@RequestBody SanPham sanPham){
        sanPham.setTheSanPham(sanPhamDAO.removeUnikey(sanPham.getTenSanPham()));
        sanPhamDAO.save(sanPham);
        HashMap<String,Object> result = new HashMap<>();
        result.put("message","Thêm sản phẩm thành công");
        result.put("status",true);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/cap-nhap")
    public String capNhatSanPham(@RequestBody SanPham sanPham){
        sanPhamDAO.update(sanPham);
        return "Bạn đã cập nhật thành công!";
    }

    @DeleteMapping("/xoa/{id}")
    public String xoaSanPham(@PathVariable("id") int id){
        sanPhamDAO.deleteSanPhamById(id);
        return "Bạn đã xóa thành công!";
    }

    @GetMapping("/the-loai/{id}")
    public List<BangSanPhamDTO> laySanPhamTheoTheLoai(@PathVariable("id") int maTheLoai){
        return sanPhamDAO.timKiemSanPhamTheoTheLoai(maTheLoai);
    }

    @GetMapping("/gia")
    public List<BangSanPhamDTO> laySanPhamTheoGia(@RequestParam("min") double minPrice, @RequestParam("max") double maxPrice){
        return sanPhamDAO.timKiemSanPhamTheoGia(minPrice, maxPrice);
    }

    @GetMapping("/so-luong")
    public Long soLuongSanPham(){
        return sanPhamDAO.count();
    }

    @GetMapping("/san-pham-moi")
    public List<BangSanPhamDTO> laySanPhamMoi() {
        return sanPhamDAO.laySanPhamMoi();
    }
}
