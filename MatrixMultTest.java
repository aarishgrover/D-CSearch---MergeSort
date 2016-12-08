/*
   Class: CS146-01 & 2
   Semester: Fall 2016
   Project: #1 - Matrix Multiplication
   sample JUnit tests for checking and comparing the result of
   regular O(n^3) matrix multiplication algorithm with Strassen
   multiplication algorithm.	 
 */
package sjsu.grover.cs146.project1.part1;
import static org.junit.Assert.assertArrayEquals;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


/**
 * The main JUnit Test class to test regular multiplication 
 * and Strassen multiplication method.
 * 
 *
 */
public class MatrixMultTest {

	private MatrixMult A, B; //input matrices
	private MatrixMult productRegularResult, productStrassenResult; // Matrices for storing the results
	private int N; // size of the NXN matrix
	@Before
	public void setUp() throws Exception
	{
	   N = 4; // size of the matrix
	   
	   double[][] array1 = new double[N][N];
	   double[][] array2 = new double[N][N];
	   A = new MatrixMult(array1);
	   B = new MatrixMult(array2);
	   productRegularResult = new MatrixMult(N);
	   productStrassenResult = new MatrixMult(N);
	   
	} // setUp()

	
	/* compare result matrices of regular multiplication method and Strassen multiplication method:
	 */
	
	
	/* multiplying a 2D array using the regular method:
	 */
	
//Prof. Potika test: N =4	
	@Test
	public void testProductRegular() {
	    
	    //expected output
		double[][] expected = {{96.0,94.0,81.0,128.0},{144.0,117.0,112.0,162.0},{132.0,112.0,101.0,152.0},{112.0,86.0,87.0,130.0}};
	    
		// input 2D arrain
		double[][] array1 = {{2.0,4.0,5.0,7.0},{6.0,7.0,2.0,8.0},{4.0,6.0,3.0,9.0},{8.0,4.0,1.0,5.0}};
		double[][] array2 = {{6.0,4.0,5.0,8.0},{8.0,7.0,8.0,8.0},{2.0,6.0,5.0,9.0},{6.0,4.0,2.0,5.0}}; 		
	    
		MatrixMult m1 = new MatrixMult(array1);
		MatrixMult m2 = new MatrixMult(array2);
	    // run productRegular()
			double start = System.currentTimeMillis();
			productRegularResult = m1.productRegular(m2);
			double end = System.currentTimeMillis();
		    System.out.println("\nRuntime for 4 input regular is is"+(end-start));  
	    for (int i = 0; i < N; i++) {
			assertArrayEquals(expected[i],productRegularResult.data[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
	    
	}
	
	/* multiplying a 2D array using the Strassen method:
	 */
//My Test for Method Subtract
	@Test
	public void testSubtract() {
	    
		//expected output
				double[][] expected = {{47.0,98.0},{113.0,151.0}};
			    
				// input 2D array
				double[][] array1 = {{209.0,231.0},{239.0,250.0}};
				double[][] array2 = {{162.0,133.0},{126.0,99.0}}; 		
			    double[][] array3 = A.subtract(array1,array2);  		
			    for (int i = 0; i < 2; i++) {
					assertArrayEquals(expected[i],array3[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
				}
	    
	}
	//My test for Method Split
	@Test
	public void testSplitMatrix() {
	    
	    //expected output
		double[][] expected = {{4.0, 6.0},{ 8.0, 4.0}};
				// input 2D array
				double[][] array1 = {{2.0,4.0,5.0,7.0},{6.0,7.0,2.0,8.0},{4.0,6.0,3.0,9.0},{8.0,4.0,1.0,5.0}};
				double[][] array2 = {{0.0,0.0},{0.0,0.0}}; 		
			    A.splitmatrix(array1,array2, 2, 0); 
			    double[][] array3 = A.getsplitarray();
	    for (int i = 0; i < 2; i++) {
			assertArrayEquals(expected[i],array3[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
	    
	}
//My test for Method Sum
	@Test
	public void testSum() {
	    
	    //expected output
		double[][] expected = {{5.0,13.0},{7.0,12.0}};
	    
		// input 2D array
		double[][] array1 = {{2.0,4.0},{6.0,7.0}};
		double[][] array2 = {{3.0,9.0},{1.0,5.0}}; 		
	    double[][] array3 = A.sum(array1,array2);  		
	    for (int i = 0; i < 2; i++) {
			assertArrayEquals(expected[i],array3[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
	    
	}
	//Prof. Potika test: N =4	
	@Test
	public void testProductStrassen() {
	    
	    //expected output
		double[][] expected = {{96.0,94.0,81.0,128.0},{144.0,117.0,112.0,162.0},{132.0,112.0,101.0,152.0},{112.0,86.0,87.0,130.0}};
	    
		// input 2D array
		double[][] array1 = {{2.0,4.0,5.0,7.0},{6.0,7.0,2.0,8.0},{4.0,6.0,3.0,9.0},{8.0,4.0,1.0,5.0}};
		double[][] array2 = {{6.0,4.0,5.0,8.0},{8.0,7.0,8.0,8.0},{2.0,6.0,5.0,9.0},{6.0,4.0,2.0,5.0}}; 		
	    
		MatrixMult m1 = new MatrixMult(array1);
		MatrixMult m2 = new MatrixMult(array2);
	      
		double start = System.currentTimeMillis();
		productStrassenResult= m1.productStrassen(m2);
		double end = System.currentTimeMillis();
	    System.out.println("\nRuntime for 4 input strassen is"+(end-start));  
	    // run productRegular()
	    
		
	    for (int i = 0; i < N; i++) {
			assertArrayEquals(expected[i],productStrassenResult.data[i], 0.0); // data[][] is a data member for storing matrix values in class Matrix.
		}
	    
	}
	//Prof. Potika test comparison N = 4	

	@Test
	public void testProductCompare() { 
	     //run user defined random() method to generate the matrices  
		A = A.random();
		//A.printarray(A.arr);
	    B = B.random(); 
	     // run productRegular()
	     productRegularResult = A.productRegular(B);
	     ////A.printarray(A.data);
	     // run productStrassen()
		 productStrassenResult = A.productStrassen(B);
	     ////A.printarray(A.data);

	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult.data[i], productStrassenResult.data[i], 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
		}
		
	    
	}
//My test N = 16 compare both algos	
	@Test
	public void testProductCompareSize16() { 
		N = 16; // size of the matrix 
		   double[][] array1 = new double[N][N];
		   double[][] array2 = new double[N][N];
		   A = new MatrixMult(array1);
		   B = new MatrixMult(array2);
		   productRegularResult = new MatrixMult(N);
		   productStrassenResult = new MatrixMult(N);
	     //run user defined random() method to generate the matrices  
		A = A.random();
		////A.printarray(A.arr);
	    B = B.random(); 
	     // run productRegular()
	    
	    
	     // run productStrassen()
	     
	     	double start = System.currentTimeMillis();
	     	 productRegularResult = A.productRegular(B);
			double end = System.currentTimeMillis();
		    System.out.println("\nRuntime for 16 input regular is"+(end-start));   
		    ////A.printarray(A.data);
		    
		     start = System.currentTimeMillis();
			 productStrassenResult = A.productStrassen(B);
			 end = System.currentTimeMillis();
		    System.out.println("\nRuntime for 16 input strassen is"+(end-start));   
		    ////A.printarray(A.data);

	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult.data[i], productStrassenResult.data[i], 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
		}
		
	    
	}
	//My test N = 512 compare both algos	
	@Test
	public void testProductCompareSize512() { 
	     //run user defined random() method to generate the matrices  
		N = 512; // size of the matrix 
		   double[][] array1 = new double[N][N];
		   double[][] array2 = new double[N][N];
		   A = new MatrixMult(array1);
		   B = new MatrixMult(array2);
		   productRegularResult = new MatrixMult(N);
		   productStrassenResult = new MatrixMult(N);
		A = A.random();
		//A.printarray(A.arr);
	    B = B.random(); 
	     // run productRegular()


	     double start = System.currentTimeMillis();
     	 productRegularResult = A.productRegular(B);
		double end = System.currentTimeMillis();
	    System.out.println("\nRuntime for 512 input regular is"+(end-start));   
	   // //A.printarray(A.data);
	    
	     start = System.currentTimeMillis();
		 productStrassenResult = A.productStrassen(B);
		 end = System.currentTimeMillis();
	    System.out.println("\nRuntime for 512 input strassen is"+(end-start));   
	    ////A.printarray(A.data);
	     
	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult.data[i], productStrassenResult.data[i], 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
		}
		
	    
	}
	//My test N = 1024 compare both algos	

	@Test
	public void testProductCompareSize1024() { 
	     //run user defined random() method to generate the matrices  
		N = 1024; // size of the matrix 
		   double[][] array1 = new double[N][N];
		   double[][] array2 = new double[N][N];
		   A = new MatrixMult(array1);
		   B = new MatrixMult(array2);
		   productRegularResult = new MatrixMult(N);
		   productStrassenResult = new MatrixMult(N);
		A = A.random();
	//	//A.printarray(A.arr);
	    B = B.random(); 
	 //   B.printarray(B.arr);
	     // run productRegular()
	     // run productStrassen()    
	     double start = System.currentTimeMillis();
     	 productRegularResult = A.productRegular(B);
		double end = System.currentTimeMillis();
		System.out.println("\nRuntime for 1024 input regular is"+(end-start));     
	     start = System.currentTimeMillis();
		 productStrassenResult = A.productStrassen(B);
		 end = System.currentTimeMillis();
	    System.out.println("\nRuntime for 1024 input strassen is"+(end-start));   
	    ////A.printarray(A.data);

	     for (int i = 0; i < N; i++) {
	    	assertArrayEquals(productRegularResult.data[i], productStrassenResult.data[i], 0.0001 ); // data[][] is a data member for storing matrix values in class Matrix.
		}
		
	    
	}
	
} // class MatrixTest