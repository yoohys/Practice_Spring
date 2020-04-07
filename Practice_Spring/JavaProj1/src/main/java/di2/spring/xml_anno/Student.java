package di2.spring.xml_anno;

import java.util.ArrayList;

public class Student {

		private String name;
		private int age;
		private ArrayList<String> hobbys;
		private int height;
		private int weight;
		
		public Student(String name, int age, ArrayList<String> hobbys) {
			super();
			this.name = name;
			this.age = age;
			this.hobbys = hobbys;
		}


		public void setHeight(int height) {
			this.height = height;
		}

		public void setWeight(int weight) {
			this.weight = weight;
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


		public ArrayList<String> getHobbys() {
			return hobbys;
		}


		public void setHobbys(ArrayList<String> hobbys) {
			this.hobbys = hobbys;
		}


		public int getHeight() {
			return height;
		}


		public int getWeight() {
			return weight;
		}
		
		
		
		
}
