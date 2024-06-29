package com.example.BookStore.controller;

import com.example.BookStore.dao.DonHangDAO;
import com.example.BookStore.dto.BangDonHangDTO;
import com.example.BookStore.dto.BangSanPhamDTO;
import com.example.BookStore.entity.DonHang;
import com.example.BookStore.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/don-hang")
public class DonHangController {
    private DonHangDAO donHangDAO;

    @Autowired
    public DonHangController(DonHangDAO donHangDAO) {
        this.donHangDAO = donHangDAO;
    }


    @GetMapping("")
    public List<BangDonHangDTO> hienThiDSDonHang(){
        return donHangDAO.getAll();
    }

    @PostMapping("/them")
    public String themSanPham(@RequestBody DonHang donHang) {
        donHangDAO.save(donHang);
        return "Bạn đã thêm thành công!";
    }

    @PutMapping("/cap-nhat")
    public String capNhatSanPham(@RequestBody DonHang donHang){
        donHangDAO.update(donHang);
        return "Bạn đã cập nhật thành công!";
    }

    @DeleteMapping("/xoa/{id}")
    public String xoaDonHang(@PathVariable("id") String id){
        System.out.println("Vào đây làm");
        donHangDAO.xoaDonHangTheoID(id);
        return "Bạn đã xóa thành công!";
    }

    @GetMapping("/{id}")
    public BangDonHangDTO layDonHangTheoID(@PathVariable("id") String maDatHang){

        return donHangDAO.timDonHangTheoIdDeHienThi(maDatHang);
    }

    @GetMapping("/nguoi-dung/{id}")
    public List<BangDonHangDTO> layDonHangNguoiDung(@PathVariable("id") int maDatHang){
        return donHangDAO.layDanhSachDonHangTheoNguoiDung(maDatHang);
    }
}
