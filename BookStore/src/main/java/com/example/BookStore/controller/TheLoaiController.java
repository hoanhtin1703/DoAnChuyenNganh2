package com.example.BookStore.controller;

import com.example.BookStore.dao.TheLoaiDAO;
import com.example.BookStore.dto.BangTheLoaiDTO;
import com.example.BookStore.entity.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/the-loai")
public class TheLoaiController {
    private TheLoaiDAO theLoaiDAO;

    @Autowired
    public TheLoaiController(TheLoaiDAO theLoaiDAO){
        this.theLoaiDAO = theLoaiDAO;
    }


    @GetMapping("")
    public List<BangTheLoaiDTO> layDanhSachTheLoai(){
        return theLoaiDAO.getAll();
    }

    @PostMapping("/them")
    public ResponseEntity<Object> themTheLoai(@RequestBody TheLoai theLoai){
        theLoaiDAO.save(theLoai);
        HashMap<String,Object> result = new HashMap<>();
        result.put("message","Thêm thể loại thành công");
        result.put("status",true);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/cap-nhat")
    public String capNhatTheLoai(@RequestBody TheLoai theLoai){
        theLoaiDAO.update(theLoai);
        return "Cập nhật thành công!";
    }

    @DeleteMapping("/xoa/{id}")
    public ResponseEntity<Object> xoaTheLoai(@PathVariable("id") int id){
        theLoaiDAO.deleteTheLoaiById(id);
        HashMap<String,Object> result = new HashMap<>();
        result.put("message","Xoá thể loại thành công");
        result.put("status",true);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public BangTheLoaiDTO layTheLoaiTheoID(@PathVariable("id") int id){
        return theLoaiDAO.theLoaiTheoIDHienThi(id);
    }
}
