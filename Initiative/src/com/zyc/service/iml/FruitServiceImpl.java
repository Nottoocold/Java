package com.zyc.service.iml;

import com.zyc.dao.FruitDao;
import com.zyc.pojo.Fruit;
import com.zyc.pojo.PageBean;
import com.zyc.service.FruitService;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/6 上午11:59
 */
public class FruitServiceImpl implements FruitService<Fruit> {
    private static FruitDao<Fruit> FRUIT_DAO = null;

    @Override
    public List<Fruit> select() {
        List<Fruit> fruitList = null;
        fruitList = FRUIT_DAO.getBeanList();
        return fruitList;
    }

    @Override
    public Fruit selectOne(Integer id) {
        Fruit fruit = null;
        fruit = FRUIT_DAO.getBeanObject(id);
        return fruit;
    }

    @Override
    public int insert(Fruit fruit) {
        return FRUIT_DAO.insert(fruit);
    }

    /**
     * 批量插入数据
     *
     * @param fruit 对象实例
     * @return 返回受影响的行数
     */
    @Override
    public int insert(List<Fruit> fruit) {
        int row = 0;
        for (Fruit f : fruit) {
            if (FRUIT_DAO.insert(f) != -1)
                row++;
        }
        return row;
    }

    @Override
    public Fruit update(Fruit f) {
        int i = FRUIT_DAO.updateById(f);
        if (i != -1) {
            return FRUIT_DAO.getBeanObject(f.getId());
        }
        return null;
    }

    /**
     * 批量删除数据
     *
     * @param id id数组
     * @return 返回受影响的行数
     */
    @Override
    public int deleteByIds(Integer[] id) {
        int row = 0;
        for (Integer integer : id) {
            if (FRUIT_DAO.deleteById(integer) != -1)
                row++;
        }
        return row;
    }

    @Override
    public PageBean<Fruit> selectByPage(Integer curPage, Integer numPerPage) {
        int begin = (curPage - 1) * numPerPage;
        List<Fruit> list = FRUIT_DAO.selectByPage(begin, numPerPage);
        int total = FRUIT_DAO.selectTotalCount();
        return new PageBean<Fruit>(total, (total + numPerPage - 1) / numPerPage, list);
    }
}
