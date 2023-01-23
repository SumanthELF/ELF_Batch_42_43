package basics;

public class TwoDArray {

	public static void main(String[] args) {

		String[][] studentNames = { 
				{ "Diwahar", "Gayatri", "Akshata", "Apoorva", "Prajna" },
				{ "Megha", "Safeer", "Rohith", "Anup", "Manju", "Ankita", "Keerthika" },
				{ "Meghana", "Pragathi", "Charan", "Chandana", "Bhoomika", "Praveen M" },
				{ "Sagar", "Nagendra", "Sudarshan", "Rakshith", "Dinesh", "Surya", "Santhosh" },
				{ "Hemanth", "Lokesh", "Naraine", "Prem", "Collin", "Harsha", "Shashank", "Naveen" },
				{ "Nisarga", "Sonika", "Suraksha", "Praveen", "Preetham" } 
			};

		System.out.println(studentNames[5][3]);
		System.out.println(studentNames[3][0]);
	}
}
