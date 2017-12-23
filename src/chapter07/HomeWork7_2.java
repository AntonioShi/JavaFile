package chapter07;
import java.util.*;
/*
 * HashSet集合
 */
class Person{
	private	String name ;
	private int age ;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
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
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
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
	public String toString() {
		return "[name=" + name + ", age=" + age + ", hashCode()=" + hashCode() + "]";
	}
	
}
public class HomeWork7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("Jack", 18) ;
		Person person2 = new Person("Jean", 28) ;
		Person person3 = new Person("Antonio", 20) ;
		HashSet set = new HashSet() ;
//		set.add(person1.getName()) ;
//		set.add(person2.getName()) ;
//		set.add(person3.getName()) ;
//		set.add(person3.getName()) ;
		set.add(person1) ;
		set.add(person2) ;
		set.add(person3) ;
		set.add(person3) ;//传入同名对象加以测试
		
		Iterator iterator = set.iterator() ;
		while (iterator.hasNext()) {
			Object object = (Object) iterator.next() ;
			System.out.println(object);
		}
		//System.out.println(set);
	}

}
