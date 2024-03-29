package com.example.affectationitproject.dao;

import com.example.affectationitproject.entities.Employe;
import com.example.affectationitproject.entities.JPAInst;
import com.mysql.cj.xdevapi.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AffectationDao {
    private final EntityManager em = JPAInst.getEntityManagerFactory().createEntityManager();
    public Employe addEmploye(Employe emp){
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }
    public Employe getEmploye(Long id) {
        em.getTransaction().begin();
        Employe emp=em.find(Employe.class,id);
        if(emp==null)
            throw new RuntimeException("Employe introuvable") ;
        em.getTransaction().commit();
        return emp;
    }
    public List<Employe> findEmployeByMC(String mc) {
        Query req= em.createNamedQuery("Employe.findByMC").setParameter("mc","%"+mc+"%");
        return req.getResultList();

    }
    public void deleteEmp(Long id) {
        Employe emp = em.find(Employe.class, id);
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }
    public List<Employe> getEmployees(String mc) {
        Query req= em.createNamedQuery("Employe.List");
        return req.getResultList();

    }






}
