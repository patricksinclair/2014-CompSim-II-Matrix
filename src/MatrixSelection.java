
public class MatrixSelection extends Matrix{

	private int m, n;
	private double[][]array;

	public MatrixSelection(int m, int n){
		super(m,n);
	}

	public MatrixSelection(double[][] array){
		super(array);
	}


	public static Matrix add1(){
		double[][] array = {new double[]{1}, new double[]{1}};
		return new Matrix(array);
	}

	public static Matrix add2(){
		double[][] array = {new double[]{2}, new double[]{-3}};	
		return new Matrix(array);
	}


	public static Matrix mult1(){
		double[][] array = {new double[]{2, -1}, new double[]{3, 4}, new double[]{-1, 1}};	
		return new Matrix(array); 
	}

	public static Matrix mult2(){
		double[][] array = {new double[]{-1, 0, 1}, new double[]{2, 3, 4}};
		return new Matrix(array);
	}


	public static Matrix exp1(){
		double[][] array = {new double[]{1, 0}, new double[]{0, 10}};
		return new Matrix(array);
	}

	public static Matrix exp2(){
		double[][] array = {new double[]{0, 2, 1, 6}, new double[]{0, 0, 1, 2}, 
				new double[]{0, 0, 0, 3}, new double[]{0, 0, 0, 0}};
		return new Matrix(array);
	}


	public static Matrix idendityMatrix(int m){
		Matrix I = new Matrix(m, m);

		for(int i = 0; i < I.getM(); i++){
			for(int j = 0; j < I.getN(); j++){
				if(i==j) I.setVal(i, j, 1);
				else I.setVal(i, j, 0);
			}
		}
		return I;
	}
}
