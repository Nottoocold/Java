package com.zyc.ssm.ioc;

import com.zyc.ssm.utils.StringUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/8 17:27
 */
public class BeanFactoryImpl implements BeanFactory {
    private Map<String, Object> beanMap = new HashMap<>();

    public BeanFactoryImpl(String path) {
        if (StringUtil.isEmpty(path))
            throw new RuntimeException("IOC容器配置文件路径错误!");
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //得到Document对象
            Document document = documentBuilder.parse(inputStream);
            //获取xml配置文件中bean标签节点列表
            NodeList beanNodes = document.getElementsByTagName("bean");
            for (int i = 0; i < beanNodes.getLength(); i++) {
                Node item = beanNodes.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {//判断是否是ELEMENT_NODE类型
                    Element ob = (Element) item;
                    String id = ob.getAttribute("id");
                    String className = ob.getAttribute("class");//全类名
                    Class<?> aClass = Class.forName(className);
                    Object o = aClass.newInstance();//拿到不同的bean对象
                    beanMap.put(id, o);//存入map中
                }
            }
            //组装bean之间的依赖关系
            for (int j = 0; j < beanNodes.getLength(); j++) {
                Node node = beanNodes.item(j);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;//元素类型节点
                    String needToDIbeanId = element.getAttribute("id");//当前需要进行依赖注入的bean ID
                    NodeList childNodes = element.getChildNodes();
                    for (int k = 0; k < childNodes.getLength(); k++) {
                        Node child = childNodes.item(k);
                        if (child.getNodeType() == Node.ELEMENT_NODE &&
                                "property".equals(child.getNodeName())) {
                            Element childEm = (Element) child;
                            String beanField = childEm.getAttribute("name");//需要进行依赖注入的bean的属性
                            String beanRefID = childEm.getAttribute("ref");//bean属性所依赖的其他的bean ID
                            Object refBean = beanMap.get(beanRefID);//获取所依赖的bean
                            Object needToDIBean = beanMap.get(needToDIbeanId);//需要依赖注入的实例
                            Class<?> toDIClass = needToDIBean.getClass();
                            Field toDIClassDeclaredField = toDIClass.getDeclaredField(beanField);//实例中需要依赖注入的属性
                            toDIClassDeclaredField.setAccessible(true);
                            toDIClassDeclaredField.set(needToDIBean, refBean);//进行依赖注入
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
