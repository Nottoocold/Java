package com.zyc.dao.iml;

import com.zyc.dao.BaseDao;
import com.zyc.dao.FruitDao;
import com.zyc.pojo.Fruit;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/6 上午11:49
 */
public class FruitDaoImpl implements FruitDao<Fruit> {

    @Override
    public List<Fruit> getBeanList() {
        List<Fruit> list = null;
        list = BaseDao.queryForList(Fruit.class, "select * from fruit");
        return list;
    }

    @Override
    public Fruit getBeanObject(Integer id) {
        Fruit fruit = null;
        fruit = BaseDao.queryForOne(Fruit.class, "select * from fruit where id = ?", id);
        return fruit;
    }

    @Override
    public int updateById(Fruit f) {
        String sql = "update fruit set name = ?,price = ?,count = ?,remark = ? where id = ?";
        return BaseDao.updateSQL(sql, f.getName(), f.getPrice(), f.getCount(), f.getRemark(), f.getId());
    }

    /**
     * 删除指定对象对应的数据行
     *
     * @param fruit 对象
     * @return 插入失败返回-1 否则返回受影响的行数
     */
    @Override
    public int insert(Fruit fruit) {
        String sql = "insert into fruit(name,price,count,remark) values(?,?,?,?)";
        return BaseDao.updateSQL(sql, fruit.getName(), fruit.getPrice(), fruit.getCount(), fruit.getRemark());
    }

    /**
     * 根据id删除指定数据
     *
     * @param id 主键id
     * @return 返回受影响的行数 否则返回-1
     */
    @Override
    public int deleteById(Integer id) {
        return BaseDao.updateSQL("delete from fruit where id = ?", id);
    }

    @Override
    public List<Fruit> selectByPage(Integer x, Integer y) {
        String sql = "select * from fruit limit ?,?";
        return BaseDao.queryForList(Fruit.class, sql, x, y);
    }

    @Override
    public int selectTotalCount() {
        Object o = BaseDao.queryForSingleValue("select count(*) from fruit");
        return Integer.parseInt(String.valueOf(o));
    }
}
