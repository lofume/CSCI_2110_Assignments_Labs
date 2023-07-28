import java.util.*;
public class MatrixMult{
    public static void main(String[] args){
        //Srini's notation
        Scanner sc = new Scanner(System.in);
        int n;
        double num;
        while((n=sc.nextInt())>0){
            num = sc.nextDouble();
            double[][] matrix1 = new double[n][n];
            for (int i=0; i<n; i++)
                Arrays.fill(matrix1[i], num);

            double[][] matrix2 = new double[n][n];
            for(int i=0; i<n;i++)
                Arrays.fill(matrix2[i], num);

            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();

            double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);

            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println("Execution time: " + executionTime + "millisecs");
        }
        public static double[][] multiplyMatrix(double[][] m1, double[][] m2){
            //end
        }
    }
//had issues understanding the matrix problem

