import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Enviroment {
    double temperature;
    double humidity;
    double water;
    public Enviroment(double temperature, double humidity, double water) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.water = water;
    }
    public static void writerEnviroment() {
        Scanner scanner = new Scanner(System.in);
        double temperature = 0;
        double humidity = 0;
        double water = 0;
        while (true) {
            System.out.print("Введите значение температуры: ");
            try {
                temperature = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введено неверное значение. Пожалуйста, введите число.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Введите значение влажности: ");
            try {
                humidity = scanner.nextDouble();
                if (humidity < 0) {
                    System.out.println("Влажность не может быть отрицательной. Попробуйте снова.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введено неверное значение. Пожалуйста, введите число.");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Введите количество воды: ");
            try {
                water = scanner.nextDouble();
                if (water < 0) {
                    System.out.println("Количество воды не может быть отрицательным. Попробуйте снова.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введено неверное значение. Пожалуйста, введите число.");
                scanner.next();
            }
        }
        Enviroment env = new Enviroment(temperature, humidity, water);

        try (FileWriter writer = new FileWriter("Enviroment.txt", false)) {
            writer.write(env.toString() + System.lineSeparator());
            System.out.println("Природные условия успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
        }

    }
    public static void getEnviroment(){
        String filePath = "Enviroment.txt";
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String line;
            for (int i = 0; i < lines.size(); i = i + 3) {
                if ((line = lines.get(i)) != null) {
                    String[] parts = line.split(",");
                    System.out.println("Температура: " + parts[i].trim());
                    System.out.println("Влажность: " + parts[i + 1].trim());
                    System.out.println("Количество воды: " + parts[i + 2].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
        }
    }

    public static void getWater(){
        String filePath = "Enviroment.txt";
        double temperature = 0;
        double humidity = 0;
        double water = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String line;
            for (int i = 0; i < lines.size(); i = i + 3) {
                if ((line = lines.get(i)) != null) {
                    String[] parts = line.split(",");
                    temperature = Double.parseDouble(parts[i].trim());
                    humidity = Double.parseDouble(parts[i + 1].trim());
                    water = Double.parseDouble(parts[i + 2].trim());
                }
            }
            water = water + humidity * 1000;
            Enviroment enviroment = new Enviroment(temperature, humidity, water);
            lines.set(0, enviroment.toString());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Enviroment.txt"))) {
                writer.write(lines.get(0));
                System.out.println("Добавлена влажность");
            } catch (IOException e) {
                System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
        }

        System.out.println(water);
    }
    public static void rain(int rainlevel){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String filePath = "Enviroment.txt";
        double temperature = 0;
        double humidity = 0;
        double water = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String line;
            for (int i = 0; i < lines.size(); i = i + 3) {
                if ((line = lines.get(i)) != null) {
                    String[] parts = line.split(",");
                    temperature = Double.parseDouble(parts[0].trim());
                    humidity = Double.parseDouble(parts[1].trim());
                    water = Double.parseDouble(parts[i + 2].trim());
                }
            }
            int number = rand.nextInt(10);
            if (number <= rainlevel) {
                water = water + 100000;

                Enviroment enviroment = new Enviroment(temperature, humidity, water);
                lines.set(0, enviroment.toString());
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Enviroment.txt"))) {
                    writer.write(lines.get(0));
                } catch (IOException e) {
                    System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                }
                System.out.println("Выпал дождь");
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
        }



    }
    public String toString() {
        return temperature + "," + humidity +"," + water;
    }
}
