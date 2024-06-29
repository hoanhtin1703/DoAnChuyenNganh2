package com.example.BookStore.dao;

import com.example.BookStore.dto.BangNguoiDungDTO;
import com.example.BookStore.entity.NguoiDung;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NguoiDungDAO implements DAO<NguoiDung> {
    private EntityManager entityManager;

    @Autowired
    public NguoiDungDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<BangNguoiDungDTO> getAll() {
        TypedQuery<NguoiDung> khachHangTypedQuery = entityManager.createQuery("SELECT kh FROM NguoiDung kh", NguoiDung.class);
        return khachHangTypedQuery.getResultList()
                .stream()
                .map(BangNguoiDungDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(NguoiDung nguoiDung) {
        entityManager.persist(nguoiDung);
    }

    //Tìm kiếm khách hàng theo ID
    public NguoiDung timKiemKhachHangTheoID(int id) {
        TypedQuery<NguoiDung> khachHangTypedQuery = entityManager.createQuery("SELECT kh FROM NguoiDung kh WHERE kh.maNguoiDung=:x", NguoiDung.class);
        khachHangTypedQuery.setParameter("x", id);
        List<NguoiDung> nguoiDungs = khachHangTypedQuery.getResultList();
        return nguoiDungs.isEmpty() ? null : nguoiDungs.get(0);
    }

    public boolean kiemTraTonTai(String email) {
        TypedQuery<NguoiDung> khachHangTypedQuery = entityManager.createQuery("SELECT kh FROM NguoiDung kh WHERE kh.email=:x", NguoiDung.class);
        khachHangTypedQuery.setParameter("x", email);
        List<NguoiDung> resultList = khachHangTypedQuery.getResultList();
        return !resultList.isEmpty();
    }

    //Tìm kiếm khách hàng theo tên để hiển thị
    public List<BangNguoiDungDTO> timKiemKhachHangTheoTen(String tenKhachHang){
        TypedQuery<NguoiDung> khachHangTypedQuery = entityManager.createQuery("SELECT kh FROM NguoiDung kh WHERE kh.tenNguoiDung LIKE :x", NguoiDung.class);
        khachHangTypedQuery.setParameter("x", "%" + tenKhachHang + "%");

        return khachHangTypedQuery.getResultList()
                .stream()
                .map(BangNguoiDungDTO::new)
                .collect(Collectors.toList());
    }

    public BangNguoiDungDTO dangNhap(String email, String matKhau) {
        TypedQuery<NguoiDung> nguoiDungTypedQuery = entityManager.createQuery("SELECT kh FROM NguoiDung kh WHERE kh.email=:email AND kh.matKhau=:matKhau", NguoiDung.class);
        nguoiDungTypedQuery.setParameter("email", email);
        nguoiDungTypedQuery.setParameter("matKhau", matKhau);

        if(nguoiDungTypedQuery.getSingleResult() != null) {
            return new BangNguoiDungDTO(nguoiDungTypedQuery.getSingleResult());
        }
        return new BangNguoiDungDTO(new NguoiDung());
    }

    @Override
    @Transactional
    public void update(NguoiDung nguoiDung) {
        entityManager.merge(nguoiDung);
        entityManager.flush();
    }

    //Xóa khách hàng theo ID
    @Transactional
    public void xoaKhachHangTheoID(int id) {
        NguoiDung nguoiDungToRemove = timKiemKhachHangTheoID(id);
        if (nguoiDungToRemove != null) {
            entityManager.remove(nguoiDungToRemove);
        }
    }
}
