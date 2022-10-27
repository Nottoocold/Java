package com.zyc.java.senior.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.zyc.java.senior.pojo.User;

public class SetTest {
	/**
	 * Set�ӿ���List���ӽӿڣ����е�Ԫ��������ģ������ظ��ģ��ײ�ʹ��hash��
	 * ����ʵ���࣬HashSet,LinkedHashSet(HashSet������),TreeSet
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
		Set<Integer> link = new LinkedHashSet<>();// ����ָ����˳�������˳��һ��
		link.add(12);
		link.add(1);
		link.add(43);
		link.add(1);
		System.out.println(link);

		// �洢�Զ������ͣ��Զ���������Ҫ��дHashCode��equals������ָ��������ĳЩ����ʱ������Ϊ���ظ���Ԫ�أ�Ӧ����
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

		// TreeSet,���Զ�Ԫ�����ͽ�������Ҳ���Զ���ȽϹ���,
		Set<Integer> tree = new TreeSet<>();
		tree.add(12);
		tree.add(1);
		tree.add(122);
		tree.add(10);
		System.out.println(tree);

		// �Զ������͵��Զ���ȽϹ���,ע�⣬TreeSet�洢Ԫ��ʱ��ֻ�е�ͨ��ָ����������򷵻�0ʱ����Ϊ��ͬ
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
		treeUser.add(new User("091", "doi", 324, 954.6));//����������u7��ͬ
		treeUser.add(new User());
		treeUser.forEach((x) -> System.out.println(x));
	}
}
