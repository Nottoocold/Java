package com.zyc.java.senior.API.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zyc.java.senior.pojo.User;

public class ComparatorTest {
	public static void main(String[] args) {
		List<User> list = new ArrayList<User>();
		list.add(new User("134668", "zhao", 20, 175.3));//
		list.add(new User("134668", "wang", 22, 174.1));//
		list.add(new User("234368", "fan", 32, 185.3));
		list.add(new User("134668", "hao", 22, 165.0));//
		list.add(new User("014255", "liu", 12, 165.3));
		list.add(new User("224884", "niu", 32, 185.3));
		list.add(new User("783255", "zhang", 25, 170.0));
		list.add(new User());
		list.add(new User());
		User[] UserArr = list.toArray(new User[0]);

		/**
		 * Arrays 中自定义比较规则API
		 */

//		Arrays.sort(UserArr, new Comparator<User>() {
//
//			@Override
//			public int compare(User o1, User o2) {
//				if (o1 == null && o2 == null)
//					return 0;
//				if (o1 == null && o2 != null)
//					return 1;
//				if (o1 != null && o2 == null)
//					return -1;
//				if (o1.getId() != null && o1.getId() != o2.getId())
//					return o1.getId().compareTo(o2.getId());
//				else if (o1.getAge() != null && o1.getAge() != o2.getAge())
//					return o1.getAge() - o2.getAge();
//				else if (o1.getHigh() != null && o1.getHigh() != o2.getHigh())
//					return Double.compare(o1.getHigh(), o2.getHigh());
//				else
//					return 1;
//			}
//		});

		// 此比较器对象可以使用lambda表达式
		Arrays.sort(UserArr, (User o1, User o2) -> {
			if (o1 == null && o2 == null)
				return 0;
			if (o1 == null && o2 != null)
				return 1;
			if (o1 != null && o2 == null)
				return -1;
			if (o1.getId() != null && o1.getId() != o2.getId())
				return o1.getId().compareTo(o2.getId());
			else if (o1.getAge() != null && o1.getAge() != o2.getAge())
				return o1.getAge() - o2.getAge();
			else if (o1.getHigh() != null && o1.getHigh() != o2.getHigh())
				return Double.compare(o1.getHigh(), o2.getHigh());
			else
				return 1;
		});

		for (User user : UserArr) {
			System.out.println(user.toString());
		}
	}
}
