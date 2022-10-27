package org.mybatis.pojo;

import java.io.Serializable;

/**
 * @author zyc
 * @date 2022/10/21
 */
public class World implements Serializable {
    private String name;
    private String continent;
    private Integer area;
    private Integer population;
    private Integer gdp;

    public World() {
    }

    public World(String name, String continent, Integer area, Integer population, Integer gdp) {
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        if (!getName().equals(world.getName())) return false;
        return getArea().equals(world.getArea());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getArea().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "World{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", area=" + area +
                ", population=" + population +
                ", gdp=" + gdp +
                '}';
    }
}
