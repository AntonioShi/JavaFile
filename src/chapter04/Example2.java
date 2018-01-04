package chapter04;


public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape square = new Square() ;
		Shape circle = new Circle() ;
		
		System.out.println("方形的面积: " + square.area(2));
		System.out.println("圆形的面积: " + circle.area(3));
	}

}

interface Shape{
	double area(double x) ;
}

class Square implements Shape{
	
	public double area(double x) {
		return x*x ;
	}
}

class Circle implements Shape{
//	实现shape接口的功能
	public double area(double x) {
		return (3.14*x*x) ;
	}
}

