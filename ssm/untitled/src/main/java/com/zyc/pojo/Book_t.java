package com.zyc.pojo;

public class Book_t {
    private Integer id;
    private String type;
    private String name;
    private String description;

    public Book_t() {
    }

    public Book_t(Integer id, String type, String name, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Book_t setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Book_t setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book_t setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book_t setDescription(String description) {
        this.description = description;
        return this;
    }
}
