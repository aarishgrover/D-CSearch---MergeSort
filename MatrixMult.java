package sjsu.grover.cs146.project1.part1;
import java.util.Random;


public class MatrixMult {
public int n;
double arr[][];
double data[][];
double splitarray[][];
double buildarray[][]; 
public MatrixMult(double[][] array1) {

		arr= array1;
		
	}
	
public MatrixMult(int a) {

		n = a;

	}
public void printarray(double d[][])
{
	System.out.println("\n printing\n");
	for (int i = 0; i < d.length; i++) {
          for (int j = 0; j < d[0].length; j++) {
              System.out.print(d[i][j] + " ");
          }
       }
}
public MatrixMult random() {
int size = this.arr.length;
	for ( int row = 0; row < size; row++ )
	    for ( int column = 0; column < size; column++ )
	    {
	    	Random rand =new Random();
	    	arr [ row ] [ column ] = rand.nextDouble();
	    }
	return this;
	//here
}
	public MatrixMult productRegular(MatrixMult b) {
		int n = arr.length;
		int a_rows = n;
		int b_columns = n;
		int a_columns = n;
		double arraya[][]= new double[n][n];
		arraya = arr;
		double arrayb[][] = new double[n][n];
		arrayb = b.arr;
		double data1[][] = new double[n][n];
		for (int i = 0; i < a_rows; i++) {
	           for (int j = 0; j < b_columns; j++) {
	               for (int k = 0; k < a_columns; k++) {
	                   data1[i][j] = data1[i][j] + arraya[i][k] * arrayb[k][j];
	               }}}
		data = data1;
				return this;
	}	
	public MatrixMult productStrassen(MatrixMult b) {
			int n = arr.length;
			double arraya[][]= new double[n][n];
			arraya = arr;
			double arrayb[][] = new double[n][n];
			arrayb = b.arr;
			data = strassenmatrixmultiplication(arraya, arrayb);
		
			return this;
				
		}
	public double [][] strassenmatrixmultiplication(double [][] a, double [][] b)
	{
		int n = a.length;
		double [][] c = new double[n][n];
		if(n == 1)
		{
			c[0][0] = a[0][0] * b[0][0];
		}
		else
		{
			double [][] A11 = new double[n/2][n/2];
			double [][] A12 = new double[n/2][n/2];
			double [][] A21 = new double[n/2][n/2];
			double [][] A22 = new double[n/2][n/2];

			double [][] B11 = new double[n/2][n/2];
			double [][] B12 = new double[n/2][n/2];
			double [][] B21 = new double[n/2][n/2];
			double [][] B22 = new double[n/2][n/2];

			splitmatrix(a, A11, 0 , 0);
			splitmatrix(a, A12, 0 , n/2);
			splitmatrix(a, A21, n/2, 0);
			splitmatrix(a, A22, n/2, n/2);

			splitmatrix(b, B11, 0 , 0);
			splitmatrix(b, B12, 0 , n/2);
			splitmatrix(b, B21, n/2, 0);
			splitmatrix(b, B22, n/2, n/2);
			// 7 recursive calls
			double [][] M1 = strassenmatrixmultiplication(sum(A11, A22), sum(B11, B22));
			double [][] M2 = strassenmatrixmultiplication(sum(A21, A22), B11);
			double [][] M3 = strassenmatrixmultiplication(A11, subtract(B12, B22));
			double [][] M4 = strassenmatrixmultiplication(A22, subtract(B21, B11));
			double [][] M5 = strassenmatrixmultiplication(sum(A11, A12), B22);
			double [][] M6 = strassenmatrixmultiplication(subtract(A21, A11), sum(B11, B12));
			double [][] M7 = strassenmatrixmultiplication(subtract(A12, A22), sum(B21, B22));
			
			double [][] C11 = sum(subtract(sum(M1, M4), M5), M7);
			double [][] C12 = sum(M3, M5);
			double [][] C21 = sum(M2, M4);
			double [][] C22 = sum(subtract(sum(M1, M3), M2), M6);
			
			buildmatrix(C11, c, 0 , 0);
			buildmatrix(C12, c, 0 , n/2);
			buildmatrix(C21, c, n/2, 0);
			buildmatrix(C22, c, n/2, n/2);
		}
		return c;
	}

		public double [][] sum(double[][] a11, double[][] a22)
		{
			int n = a11.length;

			double [][] c = new double [n][n];

			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
				c[i][j] = a11[i][j] + a22[i][j];
			return c;
		}

		public double [][] subtract(double[][] b12, double[][] b22)
		{
			int n = b12.length;

			double [][] c = new double[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
				c[i][j] = b12[i][j] - b22[i][j];
			}}

			return c;
		}
public double[][] getsplitarray(){
	return this.splitarray;
}
public double[][] getbuildarray(){
	return this.buildarray;
}
		public void splitmatrix(double[][] arraya, double[][] a11, int iB, int jB)
		{

			for(int i1 = 0, i2=iB; i1<a11.length; i1++, i2++)
				for(int j1 = 0, j2=jB; j1<a11.length; j1++, j2++)
				{
					a11[i1][j1] = arraya[i2][j2];
				}

			splitarray = a11;
		}

		public void buildmatrix(double[][] c11, double[][] c, int iB, int jB)
		{
				
			for(int i1 = 0, i2=iB; i1<c11.length; i1++, i2++)
				for(int j1 = 0, j2=jB; j1<c11.length; j1++, j2++)
				{
					c[i2][j2] = c11[i1][j1];
				}
			System.out.println("final array\n");
			buildarray = c;
			printarray(c);
		}

	
}
