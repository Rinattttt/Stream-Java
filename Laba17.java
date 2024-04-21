import java.io.*;
import java.util.Scanner;
public class Main  {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите х:");
        double x = input.nextDouble();
        Calculation calculation = new Calculation(x);
        System.out.println("Результат = " + calculation.calculateY());
        Scanner bim = new Scanner(System.in);
        System.out.println("Введите слово 'save' для сохранения:");
        String saveWord = bim.nextLine();
        if (saveWord.equals("save")) {
                FileOutputStream outputStream = new FileOutputStream("C:\\Users\\kosoi\\IdeaProjects\\output.txt");
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                oos.writeDouble(x);
                oos.writeDouble(calculation.result);
                oos.close();
                outputStream.close();
        }
        else {System.out.println("Слово для сохранения введено неверно! Перезапустите программу и попробуйте еще раз.");}
        Scanner bam = new Scanner(System.in);
        System.out.println("Введите слово 'upload' для возобновления:");
        String restartWord = bam.nextLine();
        if (restartWord.equals("upload")) {
                FileInputStream fileInputStream = new FileInputStream("C:\\Users\\kosoi\\IdeaProjects\\output.txt");
                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
                double a = ois.readDouble();
                double b = ois.readDouble();
                System.out.println("Исходные данные: " + a);
                System.out.println("Результат: " + b);
                ois.close();
        }
        else {System.out.println("Слово для возобновления введено неверно! Перезапустите программу и попробуйте еще раз.");}
    }
}
class Calculation implements Serializable {
    public double x;
    public double result;

    public Calculation(double x) {
        this.x = x;
        this.result = calculateY();
    }

    public double calculateY() {
        return x - Math.sin(x);
    }
}

