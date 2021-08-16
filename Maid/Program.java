import java.util.*;
public class Program {
    public static void main(String[] args) {
        new Program();
    }

    String name;
    int people;
    double zp;

    Program()
    {
        System.out.println("--------------------------------------------------------------"); // Начало
        System.out.println("Введите количество горничных в отеле: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Maid work[] = new Maid[n];

        for (int i = 0; i < work.length; i++) {
            System.out.println("Введите ФИО горничной: ");
            scan.nextLine();
            name = scan.nextLine();

            System.out.println("Введите заработную плату горничной: ");
            zp = scan.nextDouble();

            System.out.println("Является ли горничная старшей? (True/False)");
            boolean otvet = scan.nextBoolean();
            if(otvet) {
                System.out.println("Введите количество сотрудников старшей горничной: ");
                people = scan.nextInt();
                work[i] = new SeniorMaid(name, zp, people);
            }else work[i] = new Maid(name, zp);

        }

        for (int i = 0; i < work.length; i++) {
            System.out.println();
            System.out.println("ФИО сотрудника: "+work[i].name);
            System.out.println("Зарплата: "+work[i].getZp());
            System.out.println("**************************************");
        }
    }
}
