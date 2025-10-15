public class j3 {
    public static void main(String[] args) {
        //2*2 matrixes
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        int[][] matrix2 = {
            {5, 6},
            {7, 8}
        };

        int[][] resultMatrix = new int[2][2];

        for (int i = 0; i < 2; i++) { 
            for (int j = 0; j < 2; j++) { 
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Resulted Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%4d", resultMatrix[i][j]); 
            }
            System.out.println(); 
        }
    }
}

