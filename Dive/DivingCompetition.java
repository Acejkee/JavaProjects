import java.io.*;
import java.text.NumberFormat;

public class DivingCompetition {
    String s;
    int noOfDives, noOfJudges;
    double result;
    Dive jump;
    int [] data;

    DivingCompetition()throws IOException {

        NumberFormat Nd = NumberFormat.getInstance();
        Nd.setMaximumFractionDigits(2);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("===================================\n" + "!!!СОРЕВНОВАНИЯ ПО ПРЫЖКАМ В ВОДУ!!!\n" + "===================================");

        System.out.println("Показать результаты предыдущих соревнований? (+/-)");
        s = in.readLine();
        if (s.equals("+"))
            readResult();

        System.out.println();
        System.out.println("Введите количество судей: ");
        s = in.readLine();
        noOfJudges = Integer.parseInt(s);
        if (noOfJudges < 3) {
            System.out.print("Минимальное кол-во судей 3, попробуйте снова");
            System.exit(0);
        }
        System.out.println("Введите количество прыжков: ");
        s = in.readLine();
        noOfDives = Integer.parseInt(s);

        data = new int[noOfJudges];


        for (int i = 0; i < noOfDives; i++) {// внешний цикл прыжков
            System.out.println("Прыжок №" + (i + 1));
            System.out.println("Введите оценки выставленные судьями");
            String str = "";


            for (int j = 0; j < noOfJudges; j++) {//внутренний цикл судьи
                System.out.println("Судья №" + (j + 1) + " оценка");
                s = in.readLine();
                data[j] = Integer.parseInt(s);
                if (data[j] > 10  || data[j] < 0) {
                    System.out.println("Оценки могут быть в диапазоне только от 1 до 10, попробуйте снова");
                    System.exit(0);
                }
                else
                    str += data[j] + "";

            }


            jump = new Dive(data);
            jump.assessScores();

            result = (double) (jump.sum - jump.minScore - jump.maxScore) / (double) (noOfJudges - 2);
            System.out.println("Средний балл: " + Nd.format(result));


            headings(jump);

            System.out.println();
            System.out.println("Исключаются оценки: ");
            System.out.println(jump.minScore + " - минимальная оценка выставленная судьей " + jump.minJudge);
            System.out.println(jump.maxScore + " - максимальная оценка выставленная судьей " + jump.maxJudge);
            System.out.println("Итоговая оценка: " + Nd.format(result));//Вывод средней оценки
            System.out.println();

            write(str);
        }
    }
    void headings (Dive d) {
        System.out.println();
        System.out.println("=========================\n" + " ИНФОРМАЦИОННОЕ ТАБЛО \n" + "=========================\n");
        for (int i = 0; i < noOfJudges; i++) {
            System.out.println("Судья " + (i + 1) + ": оценка - " + Dive.getScore(i));
        }
        System.out.println();
    }


    void write (String n) {
        String filePath = ("E:\\игры\\drive.txt");
        String text = s +"\n";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Файл не создан");
        }
    }

    void readResult() {
        try {
            FileInputStream fyle = new FileInputStream("E:\\игры\\drive.txt");

            int i;
            int noOfDives = 1;

            while ((i = fyle.read()) != -1) {
                if ((char) i == '\n') {
                    System.out.print("  Прыжок №" + noOfDives);
                    noOfDives++;
                }
                System.out.print((char) i);

            }
            fyle.close();
            System.out.println();
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        new DivingCompetition();}}