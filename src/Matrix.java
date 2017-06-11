import java.util.InputMismatchException;
import java.util.Scanner;


public class Matrix {
	private int m, n;
	private double[][] array;

	public Matrix(int m, int n){
		this.m = m;
		this.n = n;
		this.array = new double[m][n];
	}
	public Matrix(double[][] array){
		this.array = array;
		this.m = array.length;
		this.n = array[0].length;
	}
	//Standard get and set methods for the values of the class.
	//set m and n are omitted as you can't change an array's size.
	public int getM(){
		return m;
	}
	public int getN(){
		return n;
	}
	public double[][] getArray(){
		return array;
	}
	public void setArray(double[][] array){
		this.array = array;
	}
	public double getVal(int i, int j){
		return getArray()[i][j];
	}
	public void setVal(int i, int j, double val){
		this.array[i][j] = val;
	}

	public void print(){
		for(int i = 0; i < getM(); i++){
			for(int j = 0; j < getN(); j++){
				System.out.printf("%.2f ", getVal(i, j));
			}
			System.out.println();
		}
	}

	public void randomise(){
		for(int i = 0; i < getM(); i++){
			for(int j = 0; j < getN(); j++){
				setVal(i, j, Math.random());
			}
		}
	}

	//question ii, a void is used to replace the values of a matrix with added values.
	public void addScaledMatrix(Matrix m, double scale){

		for(int i = 0; i < getM(); i ++){
			for(int j = 0; j < getN(); j++){
				setVal(i, j, (getVal(i, j)+(m.getVal(i, j)*scale)));
			}
		}
	}

	//question iii, a static method is used as it returns an entirely new matrix.
	public static Matrix multipliedMatrix(Matrix m1, Matrix m2){

		if(m1.getN() != m2.getM()) return null;

		Matrix m3 = new Matrix(m1.getM(), m2.getN());

		for(int i = 0; i < m1.getM(); i++){
			for(int j = 0; j < m2.getN(); j++){
				m3.setVal(i, j, 0);
				for(int k = 0; k < m1.getN(); k++){
					m3.setVal(i, j, m3.getVal(i, j) + m1.getVal(i, k)*m2.getVal(k, j));
				}
			}
		}
		return m3;
	}




	//This allows for user input, and provides necessary checks.
	public static Matrix askDimensions(){
		Scanner keyboard = new Scanner(System.in);
		int m = 0, n = 0;
		//This handles invalid entries, such as entering letters, decimals or negative values.
		while(true){
			try{
				System.out.println("Please enter the m dimension of the matrix: ");
				m = keyboard.nextInt();
				if(m > 0)break;
				System.out.println("Value must be greater than 0.");
			}catch(InputMismatchException e){
				System.out.println("Please enter an integer.");
				keyboard.nextLine();
			}
		}
		while(true){
			try{
				System.out.println("Please enter the n dimension of the matrix: ");
				n = keyboard.nextInt();
				if(n > 0) break;
				System.out.println("Value must be greater than 0.");
			}catch(InputMismatchException e){
				keyboard.nextLine();
			}
		}
		return new Matrix(m,n);
	}

	//returns a matrix of random values.
	public static Matrix askRandom(){
		Matrix m = askDimensions();
		m.randomise();
		return m;
	}

	//exp question: calculates the exponential form of the matrix. It returns the exp value of the diagonal values.
	public static Matrix exponentialMatrix(Matrix A, int nSteps){

		Matrix runningTotal = MatrixSelection.idendityMatrix(A.getM());
		Matrix seriesTerm = MatrixSelection.idendityMatrix(A.getM());
		double term = 1.0;

		for(int i = 1; i <= nSteps; i++){

			term/=i;
			//uses recursion for the power series·
			seriesTerm = Matrix.multipliedMatrix(seriesTerm, A);
			runningTotal.addScaledMatrix(seriesTerm, term);
		}
		return runningTotal;
	}


}

