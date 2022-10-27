package com.zyc.java.senior.generic;

/**
 * 泛型于多态，泛型不仅可以用在类、成员，方法上，还可以用在接口上。
 */
public class GenericDepthTest2 {
	public static void main(String[] args) {
		Person<String> person1 = new Person<>("初始化...");
		System.out.println(person1.getInfo());
	}
}


//当实现此接口时，我们可以选择在实现类明确泛型类型或是继续使用此泛型，让具体创建的对象来确定类型。还有一种是在实现接口时就指定类型
class Person<T> implements MyInterface<T> {//将Score转变为泛型类<T>
	/*
	 * 此类中T本质上是Object类型
	 */
	
	T info;
	
	public Person(T info) {
		this.info = info;
	}
	@Override
	public void speak(T customInfo) {
		System.out.println("自定义 " + customInfo);
	}

	@Override
	public T getInfo() {
		return info;
	}
	
}

//直接在实现接口时就指定类型
class Person1 implements MyInterface<String> {
	/*
	 * 这两个方法的返回值类型以及参数类型均与父类或接口中不同，为什么还可以重写，还不报错？
	 * 通过反编译结果来看，编译器本质上是帮我们创建了真正的重写父类过接口中的方法，如下所示
	 * public void speak(Object info){
	 * 		this.speak((String)info);//调用自己重写的那个speak
	 * }
	 * public Object getInfo(){
	 * 		return this.getInfo();//调用自己重写的那个getInfo
	 * }
	 * 以上看来编译器是不是很聪明？
	 */
	
	@Override
	public void speak(String info) {
		System.out.println("直接指定 " + info);
	}

	@Override
	public String getInfo() {
		return "直接指定类型";
	}
	
}