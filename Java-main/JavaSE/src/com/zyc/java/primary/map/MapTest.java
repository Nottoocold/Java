package com.zyc.java.primary.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map接口中的key是无序的，不可重复的，用set存储key；Map中的value可重复，用collection存储value；一对键值对构成了一个entry
 * 			key所在类要重写equals方法和hashcode方法		value所在类要重写equals方法
 * Map接口，存储一对数据（键值对形式）。实现类：
 * 								HashMap：主要实现类，线程不安全，效率高，可以存储null；jdk8，用数组、链表和红黑树
 * 									子类LinkHashMap:能保证遍历时，可以按照添加顺序遍历，双链表存储，对于频繁地遍历可以使用
 * 								TreeMap:可以根据键值对排序，按照key来排，红黑树存储
 * 								Hashtable:古老的实现类，效率低，不能存储null
 * 									子类Properties:常用来处理配置文件，key和value都是string类型
 * hashMap底层实现原理（以jdk7为例）：
 * 			----在实例化以后创建了长度为16的一维数组entry[] table，map.put[k,v]
 * 			----当添加数组时，首先需要知道放的位子-->计算k的hash值-->得到在数组中的存放位置(需要处理hash值)
 * 			----如果此位置上没有数据，则添加成功(添加的是entry数组元素)；
 * 			----如果此位置不为空(即此位置上存在一个或多个数组)，
 * 			----比较k和已经存在的一个或多个数据的hash值，如果k的hash值与存在的数据都不相同，则添加成功；
 * 			----如果k的hash值与某一个数据相同，则继续比较，调用k的equals方法（），若不相同则添加成功，否则将用当前v替换原来的的v。--相当于修改
 * 扩容：默认扩容方式为原来的2倍，并将原数据复制
 * 
 * hashMap底层实现原理（jdk8）：相较于7有如下几点不同：1、在new时没有创建数组,2、数组类型是Node型3、首次调用put方法时，在创建长度为16的数组
 * 											4、底层结构数组+链表+红黑树，当链表存在的数据大于8，且存放位置不为null，且数组长度超过64，此时索引上的数据改为红黑树存储（方便遍历）
 * 
 * 
* @Description
* @author zyc 
* @version
* @date 2022年5月7日上午12:13:44
 */
public class MapTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(Integer.valueOf(15), new String("zyc"));//添加数据
		map.put(Integer.valueOf(15), null);
//		Map map1 = new Hashtable();
//		map1.put(null, map);//不能存null
		
		
		
		
	}
}
