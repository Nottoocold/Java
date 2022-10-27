package com.zyc.java.primary.collections;

@SuppressWarnings("rawtypes")
public class PersonBean implements Comparable{
	private String name;
	private int age;
	
	public PersonBean() {
		super();
	}

	public PersonBean(String name) {
		super();
		this.name = name;
	}

	public PersonBean(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonBean [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonBean other = (PersonBean) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {//��Ȼ����
		if ( o instanceof PersonBean) {
			PersonBean personBean = (PersonBean)o;
//			return this.name.compareTo(personBean.name);
			int compare = this.name.compareTo(personBean.name);
			if (compare != 0) {
				return compare;
			}
			else {
				return Integer.compare(this.age, personBean.age);
			}
		}else {
			throw new RuntimeException("���ݲ�ƥ�䡣");
		}
	}
	
}