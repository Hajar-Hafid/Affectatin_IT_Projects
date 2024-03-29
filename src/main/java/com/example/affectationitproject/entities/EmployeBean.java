package com.example.affectationitproject.entities;

import com.example.affectationitproject.dao.AffectationDao;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;

import java.util.List;

@ManagedBean
@RequestScoped
public class EmployeBean {
    private List<Employe> employeList;
    private Employe newEmp;
    @PostConstruct
    public void init() {
        AffectationDao afd;
        employeList = afd.getEmployees();
        newEmp= new Employe;
    }
    public List<Employe> getUserList() {
        return employeList;
    }
    public void delete(int id) {

        AffectationDao afd;
        Employe emp=afd.deleteEmp(id);
    }
}
