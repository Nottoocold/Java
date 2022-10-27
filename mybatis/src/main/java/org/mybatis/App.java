package org.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.mapper.GradeMapper;
import org.mybatis.mapper.TestMapper;
import org.mybatis.pojo.Grade;
import org.mybatis.pojo.My;
import org.mybatis.vo.PageItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static final String path = "mybatis-config.xml";
    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final ObjectMapper jsonExecutor = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        jsonExecutor.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try (InputStream is = Resources.getResourceAsStream(path)) {
            /*
                1.Reader或InputStream->build(is)->
                    new XMLConfigBuilder(is).Parse()核心配置文件->生成Configuration对象->
                        new DefaultSqlSessionFactory(config)返回
                2.具体如何解析成Configuration对象：
                    2.1 new XPathParser(inputStream, true, props, new XMLMapperEntityResolver())
                        首先将xml定义文档转成 XMLMapperEntityResolver对象
                        其次通过inputStream将核心配置文件转成Document对象
                        再将两对象封装进XpathParser中
                    2.2 将上一步的XpathParser作为参数构造XMLConfigBuilder对象(此时对象中就含有了Document对象，并且可以进行解析)
                            且手动new Configuration()对象，此时该对象成员还没没有被配置，因为还没从DOM中解析
                    2.3 回到SqlSessionFactoryBuilder中，new XMLConfigBuilder()返回上一步创建的实例，
                    2.4 在SqlSessionFactoryBuilder，用刚才返回的parser.parse()方法解析DOM对象
                    2.5 接着就是首先找到<configuration/>根节点，解析它的子节点，最终将配置信息设置到Configuration对象中
                    2.6 最后用配置好的Configuration对象创建出SqlSessionFactory
             */
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

            Map<String, Class<?>> typeAliases = factory.getConfiguration().getTypeAliasRegistry().getTypeAliases();
            typeAliases.keySet().stream()
                    .filter(s -> s.equals("world") || s.equals("grade"))
                    .forEach(s -> log.debug("{}", typeAliases.get(s)));

            SqlSession sqlSession = factory.openSession();

            /*
                返回的是代理类对象，代理对象中封装了MapperProxy对象
             */
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);

            PageItem pageItem = new PageItem(2, 10);

            pageItem.setAutoCount(false);

            List<My> mies = testMapper.selectByPage(pageItem);
            List<Grade> grades = gradeMapper.selectList();

            mies.forEach(s -> {
                try {
                    String jsonStr = jsonExecutor.writeValueAsString(s);
                    log.debug("{}", jsonStr);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });

            grades.forEach(s -> {
                try {
                    String jsonStr = jsonExecutor.writeValueAsString(s);
                    log.debug("{}", jsonStr);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            });


            sqlSession.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
