package com.example.BookStore.controller;

import com.example.BookStore.dao.NguoiDungDAO;
import com.example.BookStore.dto.BangNguoiDungDTO;
import com.example.BookStore.entity.NguoiDung;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/nguoi-dung")
public class NguoiDungController {
    private NguoiDungDAO khachHangDAO;

    @Autowired
    public NguoiDungController(NguoiDungDAO khachHangDAO) {
        this.khachHangDAO = khachHangDAO;
    }

    @GetMapping("")
    public List<BangNguoiDungDTO> hienThiDSKH(NguoiDung nguoiDung){
        return khachHangDAO.getAll();
    }

    @PostMapping("/them")
    public ResponseEntity<String> themKhachHang(@RequestBody NguoiDung nguoiDung){
        if(khachHangDAO.kiemTraTonTai(nguoiDung.getEmail())) {
            System.out.println();
            return new ResponseEntity<>("Email này đã tồn tại", HttpStatus.BAD_REQUEST);
        }
        nguoiDung.setMatKhau(DigestUtils.sha256Hex(nguoiDung.getMatKhau()));
        khachHangDAO.save(nguoiDung);
        return new ResponseEntity<>("Bạn đã thêm thành công!", HttpStatus.OK);
    }

    @PostMapping("/dang-nhap")
    public BangNguoiDungDTO dangNhap(@RequestBody NguoiDung nguoiDung) {

        String matKhau = DigestUtils.sha256Hex(nguoiDung.getMatKhau());
        return khachHangDAO.dangNhap(nguoiDung.getEmail(), matKhau);
    }

    @PutMapping("/cap-nhat")
    public String capNhatKhachHang(@RequestBody NguoiDung nguoiDung){
        khachHangDAO.update(nguoiDung);
        return "Bạn đã cập nhật thành công!";
    }

    @DeleteMapping("/xoa/{id}")
    public String xoaKhachHang(@PathVariable("id") int id){
        khachHangDAO.xoaKhachHangTheoID(id);
        return "Bạn đã xóa thành công khách hàng với id là " + id;
    }

    @GetMapping("/thong-tin/{id}")
    public NguoiDung thongTinKhachHang(@PathVariable("id") int id) {
        NguoiDung nguoiDung = khachHangDAO.timKiemKhachHangTheoID(id);
        return nguoiDung;
    }

    @GetMapping("/tim-kiem")
    public List<BangNguoiDungDTO> layKhachHangTheoTen(@RequestParam(name = "ten") String tenKhachHang){
        return khachHangDAO.timKiemKhachHangTheoTen(tenKhachHang);
    }


}
