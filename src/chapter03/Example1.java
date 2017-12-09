package chapter03;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father.Child child = new Father().new Child();

		System.out.println(child.introFather());
	}

}

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
