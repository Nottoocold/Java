package org.mybatis.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author zyc
 * @date 2022/10/21
 */
public class Grade implements Serializable {
    private Long id;
    private String name;
    private String manager;
    private String email;
    @JsonProperty(value = "tel")
    private String telephone;
    @JsonProperty(value = "desc")
    private String introducation;

    public Grade() {
    }

    public Grade(String name, String manager, String email, String telephone, String introducation) {
        this.name = name;
        this.manager = manager;
        this.email = email;
        this.telephone = telephone;
        this.introducation = introducation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroducation() {
        return introducation;
    }

    public void setIntroducation(String introducation) {
        this.introducation = introducation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (!getId().equals(grade.getId())) return false;
        return getName().equals(grade.getName());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager='" + manager + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", introducation='" + introducation + '\'' +
                '}';
    }
}
