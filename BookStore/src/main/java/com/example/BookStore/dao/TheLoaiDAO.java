package com.example.BookStore.dao;

import com.example.BookStore.dto.BangTheLoaiDTO;
import com.example.BookStore.entity.TheLoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TheLoaiDAO implements DAO<TheLoai> {
    private EntityManager entityManager;

    @Autowired
    public TheLoaiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<BangTheLoaiDTO> getAll() {
        TypedQuery<TheLoai> theLoaiTypedQuery = entityManager.createQuery("SELECT tl FROM TheLoai tl", TheLoai.class);
        return theLoaiTypedQuery.getResultList()
                .stream()
                .map(theLoai -> new BangTheLoaiDTO(theLoai, -1))
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public void save(TheLoai theLoai) {
        entityManager.persist(theLoai);

    }

    public TheLoai theLoaiTheoID(int id) {
        TypedQuery<TheLoai> theLoaiTypedQuery = entityManager.createQuery("SELECT tl FROM TheLoai tl WHERE tl.maTheLoai=:x", TheLoai.class);
        theLoaiTypedQuery.setParameter("x", id);
        return theLoaiTypedQuery.getSingleResult();
    }

    public BangTheLoaiDTO theLoaiTheoIDHienThi(int id) {
        TypedQuery<TheLoai> theLoaiTypedQuery = entityManager.createQuery("SELECT tl FROM TheLoai tl WHERE tl.maTheLoai=:x", TheLoai.class);
        theLoaiTypedQuery.setParameter("x", id);
        return new BangTheLoaiDTO(theLoaiTypedQuery.getSingleResult(), 1);
    }

    @Override
    @Transactional
    public void update(TheLoai theLoai) {
        entityManager.merge(theLoai);
        entityManager.flush();
    }

    @Transactional
    public void deleteTheLoaiById(int id) {
        TheLoai theLoaiToRemove = theLoaiTheoID(id);
        if (theLoaiToRemove != null) {
            entityManager.remove(theLoaiToRemove);
        }
    }
}
