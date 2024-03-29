package com.example.affectationitproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Project implements Serializable {
    private static final long serialVersionUID=1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProject;
    @Column(length = 15)
    private String name;
    private double budget;
    @ManyToMany
    @JoinTable(name="Affectation",joinColumns =@JoinColumn(name="idProject"),
            inverseJoinColumns = @JoinColumn(name="idEmp"))
    private List<Employe> employes;

    public Project() {
    }

    public Project(String name, double budget) {

        this.name = name;
        this.budget = budget;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
}
