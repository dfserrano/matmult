package ca.ualberta.cmput681.assignment1.test;

import org.junit.Assert;
import org.junit.Test;

import ca.ualberta.cmput681.assignment1.CoarseGrainedThreadPoolMatrixMultiplication;

public class CoarseGrainedThreadPoolMatrixMultiplicationTest {

	@Test
	public void testMultiplication() {

		String[] args = { String.valueOf(3), String.valueOf(3), "RANDOM",
				"RANDOM", String.valueOf(2) };

		CoarseGrainedThreadPoolMatrixMultiplication.main(args);
		int[][] matrixC = CoarseGrainedThreadPoolMatrixMultiplication
				.getResult();

		int[][] expectedResult = new int[3][3];
		expectedResult[0][0] = 6754;
		expectedResult[0][1] = 4490;
		expectedResult[0][2] = 8018;
		expectedResult[1][0] = 7109;
		expectedResult[1][1] = 7429;
		expectedResult[1][2] = 8984;
		expectedResult[2][0] = 8271;
		expectedResult[2][1] = 9545;
		expectedResult[2][2] = 11385;

		for (int i = 0; i < expectedResult.length; i++) {
			for (int j = 0; j < expectedResult[0].length; j++) {
				Assert.assertTrue("Element at [" + i + "][" + j
						+ "] is equals to " + expectedResult[i][j],
						expectedResult[i][j] == matrixC[i][j]);
			}
		}
	}

	@Test
	public void testMultiplicationAxI() {

		String[] args = { String.valueOf(100), String.valueOf(3), "RANDOM",
				"IDENTITY", String.valueOf(2) };

		CoarseGrainedThreadPoolMatrixMultiplication.main(args);
		int[][] matrixC = CoarseGrainedThreadPoolMatrixMultiplication
				.getResult();
		int[][] matrixA = CoarseGrainedThreadPoolMatrixMultiplication
				.getMatrixA();

		for (int i = 0; i < matrixC.length; i++) {
			for (int j = 0; j < matrixC[0].length; j++) {
				Assert.assertTrue("Element at [" + i + "][" + j
						+ "] is equals to " + matrixA[i][j] + " in AxI",
						matrixA[i][j] == matrixC[i][j]);
			}
		}
	}

	@Test
	public void testMultiplicationIxB() {

		String[] args = { String.valueOf(100), String.valueOf(3), "IDENTITY",
				"RANDOM", String.valueOf(2) };

		CoarseGrainedThreadPoolMatrixMultiplication.main(args);
		int[][] matrixC = CoarseGrainedThreadPoolMatrixMultiplication
				.getResult();
		int[][] matrixB = CoarseGrainedThreadPoolMatrixMultiplication
				.getMatrixB();

		for (int i = 0; i < matrixC.length; i++) {
			for (int j = 0; j < matrixC[0].length; j++) {
				Assert.assertTrue("Element at [" + i + "][" + j
						+ "] is equals to " + matrixB[i][j] + " in IxB",
						matrixB[i][j] == matrixC[i][j]);
			}
		}
	}

}
