package ca.ualberta.cmput681.assignment1;

import java.util.Random;

public class MatrixMultiplication {

	public enum InitType {
		RANDOM, ZERO, IDENTITY
	};

	protected int size;
	protected int[][] matrixA;
	protected int[][] matrixB;
	protected int[][] matrixC;

	protected Random random;

	public void init(int size, int seed, InitType initTypeA, InitType initTypeB) {
		this.size = size;
		random = new Random(seed);

		matrixA = new int[size][size];
		matrixB = new int[size][size];
		matrixC = new int[size][size];

		initializeMatrix(matrixA, initTypeA);
		initializeMatrix(matrixB, initTypeB);
		initializeMatrix(matrixC, InitType.ZERO);

		if (matrixA.length < 10) {
			printMatrix("A", matrixA);
			printMatrix("B", matrixB);
		}
	}

	public void initializeMatrix(int[][] matrix, InitType initType) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				switch (initType) {
				case RANDOM:
					matrix[i][j] = random
							.nextInt(100);
					break;
				case ZERO:
					matrix[i][j] = 0;
					break;
				case IDENTITY:
					if (i == j) {
						matrix[i][j] = 1;
					} else {
						matrix[i][j] = 0;
					}
					break;

				}

			}
		}
	}

	public void printMatrix(String label, int[][] matrix) {
		System.out.println("Matrix " + label + ":");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static InitType fromStringToInitType(String typeStr) {
		if ("RANDOM".equals(typeStr)) {
			return InitType.RANDOM;
		} else if ("ZERO".equals(typeStr)) {
			return InitType.ZERO;
		} else if ("IDENTITY".equals(typeStr)) {
			return InitType.IDENTITY;
		} 
		
		return null;
	}
}
