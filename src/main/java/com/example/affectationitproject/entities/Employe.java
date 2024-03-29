package com.example.affectationitproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@NamedQuery(name="Employe.findByMC",
        query="SELECT e FROM Employe e Where e.name LIKE : mc")
@NamedQuery(name="Employe.List",
        query="SELECT e FROM Employe e ")
@Entity
public class Employe implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmp;
    @Column(length = 15)
    private String name;
    @Column(length = 20)
    private String email;
    private List<String> skills;
    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    private Post post;
    @ManyToMany(mappedBy = "idProject")
    private List<Project> projects;

    public Employe() {
    }

    public Employe(String name, String email, List<String> skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public Long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Long idEmp) {
        this.idEmp = idEmp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
