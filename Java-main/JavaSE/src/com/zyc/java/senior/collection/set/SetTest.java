package com.zyc.java.senior.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.zyc.java.senior.pojo.User;

public class SetTest {
	/**
	 * Set接口是List的子接口，其中的元素是无序的，不可重复的，底层使用hash表
	 * 常用实现类，HashSet,LinkedHashSet(HashSet的子类),TreeSet
	 */
	public static void main(String[] args) {
		// HashSet
		Set<Integer> set = new HashSet<>();
		set.add(100);
		set.add(2);
		set.add(5);
		set.add(1);
		System.out.println(set);

		// LinkedHashSet
		Set<Integer> link = new LinkedHashSet<>();// 有序指遍历顺序与添加顺序一致
		link.add(12);
		link.add(1);
		link.add(43);
		link.add(1);
		System.out.println(link);

		// 存储自定义类型，自定义类型需要重写HashCode和equals方法，指定当满足某些条件时即可认为是重复的元素，应丢弃
		Set<User> users = new HashSet<>();
		User u1 = new User("1346", "khdka", 45, 154.46);
		User u2 = new User("1346", "khdka", 24, 174.46);
		User u3 = new User("1346", "hka", 75, 194.46);
		User u4 = new User("46", "hka", 34, 154.6);
		User u5 = new User("7987", "hka", 34, 54.6);
		User u6 = new User("7987", "hy", 324, 187.6);
		User u7 = new User("091", "doi", 324, 954.6);
		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);
		users.add(u5);
		users.add(u6);
		users.add(u7);
		users.forEach((u) -> System.out.println(u));

		// TreeSet,可以对元素类型进行排序，也可自定义比较规则,
		Set<Integer> tree = new TreeSet<>();
		tree.add(12);
		tree.add(1);
		tree.add(122);
		tree.add(10);
		System.out.println(tree);

		// 自定义类型的自定义比较规则,注意，TreeSet存储元素时，只有当通过指定的排序规则返回0时才认为相同
		Set<User> treeUser = new TreeSet<>((o1, o2) -> {
			if (o1.getId() != null && o1.getId() != o2.getId())
				return o1.getId().compareTo(o2.getId());
			else if (o1.getName() != null && o1.getName() != o2.getName())
				return o1.getName().compareTo(o2.getName());
			else
				return o1.getAge() == null ? 1 : o1.getAge() - o2.getAge();
		});
		treeUser.add(u1);
		treeUser.add(u2);
		treeUser.add(u3);
		treeUser.add(u4);
		treeUser.add(u5);
		treeUser.add(u6);
		treeUser.add(u7);
		treeUser.add(new User("091", "doi", 324, 954.6));//被丢弃，与u7相同
		treeUser.add(new User());
		treeUser.forEach((x) -> System.out.println(x));
	}
}
