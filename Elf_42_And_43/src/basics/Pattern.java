package basics;

public class Pattern {

	public static void main(String[] args) {
		int row=4, col=4, space=0;
		
		for(int i=0; i<row; i++) {
			for(int j=0;j<space;j++) {
				System.out.print("  ");
			}
			for(int k=0;k<col;k++) {
				System.out.print("* ");
			}
			System.out.println();
			space++;
		}
	}

}
