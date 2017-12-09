package chapter04;


public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student("石云成", 20);
		student.show();
		
		Student under = new Undergraduate("秋生", 21, "演员") ;
		under.show();
//		student.show();
	}

}

class Student{
	String name ;
	int age ;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	void show() {
		System.out.println("name: " + this.name + "  age: " + this.age);
	}
}

class Undergraduate extends Student{
	String degree ;

	public Undergraduate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Undergraduate(String name, int age, String degree) {
		super(name, age);
		this.degree = degree;
		// TODO Auto-generated constructor stub
	}
	
	void show() {
		System.out.println("name: " + this.name + "  age: " + this.age + "  degree: " + this.degree);
	}
	
}