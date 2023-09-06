import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scann = new Scanner(System.in);
    	int n=scann.nextInt();
    	Person[] p = new Person[n];
    	
    	for(int i=0;i<n;i++) {
    		p[i] = new Person(scann.nextInt(),scann.next());
    	}
    	Arrays.sort(p, new Comparator<Person>() {
    		@Override
    		public int compare(Person p1, Person p2) {
    			return p1.age-p2.age;
    		}
    	});
    	for(int i=0;i<n;i++) {
    		System.out.println(p[i].age+" "+p[i].name);
    	}
    }

    public static class Person{
        int age;
        String name;
        
		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}

		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
    }
}
