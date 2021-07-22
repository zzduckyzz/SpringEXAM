package com.example.springexam.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "emp", catalog = "")
public class EmpEntity {
    private Integer id;
    private String name;
    private String wage;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Basic
    @Column(name = "wage", nullable = true)
    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpEntity that = (EmpEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(wage, that.wage)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, wage);
    }
}
