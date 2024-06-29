package com.example.BookStore.controller;

import com.example.BookStore.dao.GiamGiaDAO;
import com.example.BookStore.dao.TheLoaiDAO;
import com.example.BookStore.dto.BangGiamGiaDTO;
import com.example.BookStore.dto.BangTheLoaiDTO;
import com.example.BookStore.entity.GiamGia;
import com.example.BookStore.entity.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/giam-gia")
public class GiamGiaController {
    private GiamGiaDAO giamGiaDAO;

    @Autowired
    public GiamGiaController(GiamGiaDAO giamGiaDAO){
        this.giamGiaDAO = giamGiaDAO;
    }


    @GetMapping("")
    public List<BangGiamGiaDTO> layDanhSacGiamGia(){
        return giamGiaDAO.getAll();
    }

    @PostMapping("/them")
    public String themGiamGia(@RequestBody GiamGia giamGia){
        giamGiaDAO.save(giamGia);
        return "Thêm thành công!";
    }

    @PutMapping("/cap-nhat")
    public String capNhatGiamGia(@RequestBody GiamGia giamGia){
        giamGiaDAO.update(giamGia);
        return "Cập nhật thành công!";
    }

    @DeleteMapping("/xoa/{id}")
    public String xoaGiamGia(@PathVariable("id") int id){
        giamGiaDAO.xoaGiamGiaID(id);
        return "Xóa thành công!";
    }

    @GetMapping("/{id}")
    public BangGiamGiaDTO layGiamGiaTheoID(@PathVariable("id") int id){
        return giamGiaDAO.timKiemGiamGiaId(id);
    }
}
