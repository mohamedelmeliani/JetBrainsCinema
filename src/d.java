import java.util.Scanner;
public class d {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        String [][] str=new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                str[i][j]=scanner.next();
            }
        }
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
        if(symWins(str,"X")&&!symWins(str,"O"))
            System.out.println("X wins");
        else if(symWins(str,"O")&&!symWins(str,"X"))
            System.out.println("O wins");
        else if(!symWins(str,"X")&&!symWins(str,"O")&&!isEmpty(str))
            System.out.println("Draw");
        else if(isEmpty(str)&&(!symWins(str,"O")&&!symWins(str,"X"))&&(Countsym(str,"X")==Countsym(str,"O")||
                Countsym(str,"X")==Countsym(str,"O")+1||Countsym(str,"X")+1==Countsym(str,"O")))
            System.out.println("Game not finished");
        else
            System.out.println("Impossible");
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
}