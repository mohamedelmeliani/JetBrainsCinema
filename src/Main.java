import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int[] coordinates=new int [2];
        int tour=1;
        String [][] str=new String[3][3];
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                str[i][j]="_";
            }
        }
        show(str);
        do{
            System.out.print("Enter the coordinates : ");
            do {
                while (!s.hasNextInt()) {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates : ");
                    s.nextLine();
                }
                for (int i=0;i<2;i++){
                    coordinates[i]=s.nextInt();
                }
                if ( goLoop(coordinates) ) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates : ");
                }
                else if(isOccupied(str,coordinates[0],coordinates[1])){
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.print("Enter the coordinates : ");
                }
            } while (goLoop(coordinates)||isOccupied(str,coordinates[0],coordinates[1]));
            if(tour%2==1){
                str[coordinates[0]-1][coordinates[1]-1]="X";
                tour++;
            }
            else {
                str[coordinates[0]-1][coordinates[1]-1]="O";
                tour++;
            }
            show(str);
            if(symWins(str,"X")&&!symWins(str,"O")){
                System.out.println("X wins");
                break;
            }
            else if(symWins(str,"O")&&!symWins(str,"X")){
                System.out.println("O wins");
                break;
            }else if(!symWins(str,"X")&&!symWins(str,"O")&&!isEmpty(str)) {
                System.out.println("Draw");
                break;
            }
        }while(isEmpty(str)&&(!symWins(str,"O")&&!symWins(str,"X")));
        /*if(symWins(str,"X")&&!symWins(str,"O"))
            System.out.println("X wins");
        else if(symWins(str,"O")&&!symWins(str,"X"))
            System.out.println("O wins");
        else if(!symWins(str,"X")&&!symWins(str,"O")&&!isEmpty(str))
            System.out.println("Draw");
        else if(isEmpty(str)&&(!symWins(str,"O")&&!symWins(str,"X"))&&(Countsym(str,"X")==Countsym(str,"O")||
                Countsym(str,"X")==Countsym(str,"O")+1||Countsym(str,"X")+1==Countsym(str,"O")))
            System.out.println("Game not finished");
        else
            System.out.println("Impossible");*/
    }
    public static boolean symWins(String [][] str,String sym){
        if((str[0][0].equals(sym)&&str[0][1].equals(sym)&&str[0][2].equals(sym))||
                (str[1][0].equals(sym)&&str[1][1].equals(sym)&&str[1][2].equals(sym))||
                (str[2][0].equals(sym)&&str[2][1].equals(sym)&&str[2][2].equals(sym))||
                (str[0][0].equals(sym)&&str[1][1].equals(sym)&&str[2][2].equals(sym))||
                (str[0][2].equals(sym)&&str[1][1].equals(sym)&&str[2][0].equals(sym))||
                (str[0][0].equals(sym)&&str[1][0].equals(sym)&&str[2][0].equals(sym))||
                (str[0][1].equals(sym)&&str[1][1].equals(sym)&&str[2][1].equals(sym))||
                (str[0][2].equals(sym)&&str[1][2].equals(sym)&&str[2][2].equals(sym)))
            return true;
        else
            return false;
    }

    public static boolean isEmpty(String [][] str){
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str[i].length;j++){
                if(!str[i][j].equals("O")&&!str[i][j].equals("X"))
                    return true;
            }
        }
        return false;
    }

    public static int Countsym(String [][] str,String sym){
        int count=0;
        for(int i=0;i<str.length;i++){
            for (int j=0;j<str[i].length;j++){
                if(str[i][j].equals(sym))
                    count++;
            }
        }
        return count;
    }

    public static boolean isOccupied(String [][] str,int row,int column){
        if(str[row-1][column-1].equals("X")||str[row-1][column-1].equals("O"))
            return true;
        return false;
    }

    public static boolean goLoop(int[] c){
        for (int i : c) {
            if(i<1||i>3)
                return true;
        }
        return false;
    }

    public static void show(String [][]str){
        System.out.println("---------");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(str[i][j]+" ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}
