package org.spring.stu.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zyc
 * @date 2022/10/24
 */
public class User {
    private String name;
    private Integer age;

    private static final Logger log = LoggerFactory.getLogger(User.class);

    public User() {
        log.info("User#new User()");
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge");
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return getAge() != null ? getAge().equals(user.getAge()) : user.getAge() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }
}
