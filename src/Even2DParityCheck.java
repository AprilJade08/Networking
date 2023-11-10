import java.util.Scanner;
public class Even2DParityCheck {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Rows  : ");
        int rows=sc.nextInt();
        System.out.print("Columns : ");
        int col=sc.nextInt();

        int[][] dataSegments=new int[rows][col];

        System.out.println("\nEnter data segments : \n");
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                dataSegments[i][j]=sc.nextInt();
            }
        }

        int[] rowParity=new int[rows];
        int[] colParity=new int[col];

        for(int i=0;i<rows;i++) {
            for (int j = 0; j < col; j++) {
                rowParity[i] ^= dataSegments[i][j];
                colParity[j] ^= dataSegments[i][j];
            }
        }

        System.out.println("\nData Segments with even 2D parity check: ");
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dataSegments[i][j]+" ");
            }
            System.out.println(" | "+rowParity[i]);
        }
        System.out.println("-----------------");
        for(int j=0;j<col;j++){
            System.out.print(colParity[j]+" ");
        }

    }
}
