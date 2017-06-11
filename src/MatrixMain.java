import java.util.InputMismatchException;
import java.util.Scanner;


public class MatrixMain {
	public static void main(String args[]){

		Scanner keyboard = new Scanner(System.in);
		int choice;
		boolean quit = false;

		while(!quit){
			try{
				printOptions();
				choice = keyboard.nextInt();

				switch(choice){

				case 1: 
					Matrix m = Matrix.askRandom();
					m.print();
					System.out.println("The bottom rightmost value will now be returned.");
					System.out.println("The value at ["+(m.getM()-1)+"]["+(m.getN()-1)+"] is: "+m.getVal(m.getM()-1, m.getN()-1));
					break;


				case 2: 
					Matrix ma1 = MatrixSelection.add1();
					Matrix ma2 = MatrixSelection.add2();
					System.out.println("The first matrix is: ");
					ma1.print();
					System.out.println("The second is: (this one will be multiplied by 2)");
					ma2.print();
					System.out.println("When added, the resulting matrix is: ");
					ma1.addScaledMatrix(ma2, 2.0);
					ma1.print();


				case 3:
					Matrix mm1 = MatrixSelection.mult1();
					Matrix mm2 = MatrixSelection.mult2();
					System.out.println("The first matrix is: ");
					mm1.print();
					System.out.println("The second one is: ");
					mm2.print();
					Matrix mm3 = Matrix.multipliedMatrix(mm1, mm2);
					System.out.println("When multiplied together, the resulting matrix is: ");
					mm3.print();
					break;


				case 4:
					Matrix me1 = MatrixSelection.exp1();
					Matrix me2 = Matrix.exponentialMatrix(me1, 50);
					System.out.println("The matrix to be exponentiated is: ");
					me1.print();
					System.out.println("The resulting matrix is: ");
					me2.print();
					break;


				case 5:
					Matrix me3 = MatrixSelection.exp2();
					Matrix me4 = Matrix.exponentialMatrix(me3, 50);
					System.out.println("The matrix to be exponentiated is: ");
					me3.print();
					System.out.println("The resulting matrix is: ");
					me4.print();
					break;


				case 6:
					Matrix mg = MatrixSelection.exp2();
					MatrixFrame mf = new MatrixFrame(mg);
					break;

				case 0:
					System.out.println("You quit.");
					quit = true;
					break;		
				}
			}catch(InputMismatchException e){
				System.out.println("Please enter a number.");
				keyboard.nextLine();
			}
		}
	}


	public static void printOptions(){

		System.out.println("Choose from the following options: ");
		System.out.println("1: Demonstration of get/set methods.");
		System.out.println("2: Demonstration of adding.");
		System.out.println("3: Demonstration of multiplication of matrices.");
		System.out.println("4: Demonstration of matrix exponentials. (2x2)");
		System.out.println("5: Demonstration of matrix exponentials. (4x4)");
		System.out.println("6: Graphical representation of matrix exponentials. (4x4)");
		System.out.println("0: quit.");
	}
}
