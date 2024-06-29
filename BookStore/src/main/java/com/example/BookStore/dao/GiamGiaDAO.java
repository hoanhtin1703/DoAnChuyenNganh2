package com.example.BookStore.dao;

import com.example.BookStore.dto.BangDonHangDTO;
import com.example.BookStore.dto.BangGiamGiaDTO;
import com.example.BookStore.dto.BangSanPhamDTO;
import com.example.BookStore.dto.BangTheLoaiDTO;
import com.example.BookStore.entity.DanhGia;
import com.example.BookStore.entity.GiamGia;
import com.example.BookStore.entity.TheLoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GiamGiaDAO implements DAO<GiamGia>{
    private EntityManager entityManager;

    @Autowired
    public GiamGiaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<BangGiamGiaDTO> getAll() {
        TypedQuery<GiamGia> theLoaiTypedQuery = entityManager.createQuery("SELECT tl FROM GiamGia tl", GiamGia.class);
        return theLoaiTypedQuery.getResultList()
                .stream()
                .map(giamGia -> new BangGiamGiaDTO(giamGia, 0))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(GiamGia giamGia) {
        entityManager.persist(giamGia);

    }

    public BangGiamGiaDTO timKiemGiamGiaId(int id) {
        TypedQuery<GiamGia> theLoaiTypedQuery = entityManager.createQuery("SELECT tl FROM GiamGia tl WHERE tl.maGiamGia=:x", GiamGia.class);
        theLoaiTypedQuery.setParameter("x", id);
        return new BangGiamGiaDTO(theLoaiTypedQuery.getSingleResult(), -1);
    }


    public GiamGia timKiemTheoId(int id)  {
        TypedQuery<GiamGia> giamGiaTypedQuery = entityManager.createQuery("SELECT tl FROM GiamGia tl WHERE tl.maGiamGia=:x", GiamGia.class);
        giamGiaTypedQuery.setParameter("x", id);
        return giamGiaTypedQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void update(GiamGia giamGia) {
        entityManager.merge(giamGia);
        entityManager.flush();
    }

    @Transactional
    public void xoaGiamGiaID(int id) {
        GiamGia giamGiaRemove = timKiemTheoId(id);
        if (giamGiaRemove != null) {
            entityManager.remove(giamGiaRemove);
        }
    }
}
