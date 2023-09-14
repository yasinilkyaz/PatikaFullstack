public class Main {
    public static void main(String[] args) {


        int[][] matrix = new int[2][3];
        int[][] transpoze = new int[3][2];
        int number = 1;

        for (int x = 0; x < matrix.length; x++) {
            int[] row = matrix[x];

            for (int y = 0; y < row.length; y++) {
                row[y] = number;
                number++;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }

        System.out.println("------------");

        for (int row = 0; row < transpoze.length; row++) {
            for (int column = 0; column < transpoze[row].length; column++) {

                transpoze[row][column] = matrix[column][row];
                System.out.print(transpoze[row][column] + " ");
            }
            System.out.println();
        }

    }
}