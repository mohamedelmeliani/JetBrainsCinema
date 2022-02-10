import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        while (!sc.hasNextInt()) {
            System.out.println("Wrong input!");
            sc.nextLine();
        }
        int row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        while (!sc.hasNextInt()) {
            System.out.println("Wrong input!");
            sc.nextLine();
        }
        int place = sc.nextInt();
        String[][] str = new String[row][place];
        int income = 0, num = 0;
        int choix = -1;
        boolean flag = false;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < place; j++) {
                str[i - 1][j] = "S";
            }
        }
        System.out.println("Cinema : ");
        System.out.print("  ");
        for (int i = 1; i <= place; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= row; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < place; j++) {
                System.out.print(str[i - 1][j] + " ");
            }
            System.out.println();
        }
        do {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            while (!sc.hasNextInt()) {
                System.out.println("Wrong input!");
                sc.nextLine();
            }
            choix = sc.nextInt();
            if (choix == 1) {
                System.out.println("Cinema : ");
                System.out.print("  ");
                for (int i = 1; i <= place; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                for (int i = 1; i <= row; i++) {
                    System.out.print(i + " ");
                    for (int j = 0; j < place; j++) {
                        System.out.print(str[i - 1][j] + " ");
                    }
                    System.out.println();
                }
            } else if (choix == 2) {
                boolean r = false;
                while (!r) {
                    System.out.println("Enter a row number:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Wrong input!");
                        sc.nextLine();
                    }
                    int row1 = sc.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    while (!sc.hasNextInt()) {
                        System.out.println("Wrong input!");
                        sc.nextLine();
                    }
                    int place1 = sc.nextInt();
                    if (row1>=1&&row1<=row&&place1>=1&&place1<=place) {
                        if(!str[row1 - 1][place1 - 1].equals("B")){
                            str[row1 - 1][place1 - 1] = "B";
                            num++;
                            int total = 0;
                            if (row * place < 60)
                                total = 10;
                            else {
                                if (row1 >= 0 && row1 <= row / 2) {
                                    total = 10;
                                } else
                                    total = 8;
                            }
                            income += total;
                            System.out.println("Ticket price: $" + total);
                            r = true;
                        }else {
                            System.out.println("That ticket has already been purchased!");
                        }
                    } else {
                        System.out.println("Wrong input!");
                    }
                }
            } else if (choix == 3) {
                System.out.println("Number of purchased tickets: " + num);
                System.out.println("Percentage: " + String.format("%.2f", (double) num / (double) (row*place) * 100.0) + "%");
                System.out.println("Current income: $" + income);
                int totalincome = 0;
                if (row * place < 60)
                    totalincome = row * place * 10;
                else {
                    if (row % 2 == 0) {
                        totalincome = ((row / 2) * place * 10) + ((row / 2) * place * 8);
                    } else
                        totalincome = ((row / 2) * place * 10) + (((row / 2) + 1) * place * 8);
                }
                System.out.println("Total income: $" + totalincome);
            }
        } while (choix != 0);

    }
}
