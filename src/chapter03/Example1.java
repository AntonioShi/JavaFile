package chapter03;
/*
 * 这个是什嘛呀:内部类的创建和使用
 */
public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father.Child child = new Father().new Child();

		System.out.println(child.introFather());
	}

}
//内部类
class Father {
	private String name = "zhangjun";

	public Father() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Father(String name) {
		super();
		this.name = name;
	}

	class Child {
		String introFather() {
			return name;
		}
	}

}
