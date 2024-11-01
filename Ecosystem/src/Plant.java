import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Plant {
    String species;
    double waterConsumption;
    double optimalTemperature;
    double optimalHumidity;
    int quantity;

    public Plant(String species, double waterConsuption, double optimalTemperature, double optimalHumid, int quantity) {
        this.species = species;
        this.waterConsumption = waterConsuption;
        this.optimalTemperature = optimalTemperature;
        this.optimalHumidity = optimalHumid;
        this.quantity = quantity;
    }

    public static void writerplant() {
        Scanner scanner = new Scanner(System.in);
        String filePath = "Plants.txt";
        String species;
        String line;
        int count;
        System.out.print("Введите вид растения: ");
        while (true) {
            species = scanner.nextLine();
            if (species.equals("")) {
                System.out.println("Строка вид не может быть пустым, Попробуйте снова :");
            }
            else {
                try {
                    List<String> lines = Files.readAllLines(Paths.get(filePath));
                    count = 0;
                    for (int i = 0; i < lines.size(); i++) {
                        count = 0;
                        while ((line = lines.get(i)) != null) {
                            String[] parts = line.split(",");
                            if (species.equals(parts[0].trim())) {
                                count++;
                                break;
                            } else
                                break;
                        }
                    }
                    if (count != 0) {
                        System.out.println("Растение c таким названием уже есть, попробуйте ещё раз :");

                    } else {
                        double waterConsumption = 0;
                        double optimalTemperature = 0;
                        double optimalHumidity = 0;
                        int quantity = 0;
                        while (true) {
                            System.out.print("Введите потребление воды: ");
                            try {
                                waterConsumption = scanner.nextDouble();
                                if (waterConsumption < 0) {
                                    System.out.println("Потребление воды не может быть отрицательным. Попробуйте снова.");
                                    continue;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Введено неверное значение. Пожалуйста, введите число.");
                                scanner.next();
                            }
                        }
                        while (true) {
                            System.out.print("Введите оптимальную температуру: ");
                            try {
                                optimalTemperature = scanner.nextDouble();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Введено неверное значение. Пожалуйста, введите число.");
                                scanner.next();
                            }
                        }

                        while (true) {
                            System.out.print("Введите оптимальную влажность: ");
                            try {
                                optimalHumidity = scanner.nextDouble();
                                if (optimalHumidity < 0) {
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
                            System.out.print("Введите количество: ");
                            try {
                                quantity = scanner.nextInt();
                                if (quantity < 0) {
                                    System.out.println("Популяция не может быть отрицательным. Попробуйте снова.");
                                    continue;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Введено неверное значение. Пожалуйста, введите (целое) число.");
                                scanner.next();
                            }
                        }
                        Plant plant = new Plant(species, waterConsumption, optimalTemperature, optimalHumidity, quantity);

                        try (FileWriter writer = new FileWriter("Plants.txt", true)) {
                            writer.write(plant.toString() + System.lineSeparator());
                            System.out.println("Растение успешно записано в файл.");
                        } catch (IOException e) {
                            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
                        }
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка " + e.getMessage());
                }
            }
        }
    }

    public static void updatePlant(){
        Scanner scanner = new Scanner(System.in);
        String filePath = "Plants.txt";
        System.out.print("Введите вид Растение: ");
        double waterConsumption = 0;
        double optimalTemperature = 0;
        double optimalHumidity = 0;
        int quantity = 0;
        String line;
        int count;
        boolean running = true;
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            while (running) {
                String species = scanner.nextLine();
                count = 0;
                for (int i = 0; i < lines.size(); i++) {
                    while ((line = lines.get(i)) != null) {
                        String[] parts = line.split(",");
                        if (species.equals(parts[0].trim())) {
                            while (true) {
                                System.out.print("Введите потребление воды: ");
                                try {
                                    waterConsumption = scanner.nextDouble();
                                    if (waterConsumption < 0) {
                                        System.out.println("Потребление воды не может быть отрицательным. Попробуйте снова.");
                                        continue;
                                    }
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введено неверное значение. Пожалуйста, введите число.");
                                    scanner.next();
                                }
                            }

                            while (true) {
                                System.out.print("Введите оптимальную температуру: ");
                                try {
                                    optimalTemperature = scanner.nextDouble();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введено неверное значение. Пожалуйста, введите число.");
                                    scanner.next();
                                }
                            }
                            while (true) {
                                System.out.print("Введите оптимальную влажность: ");
                                try {
                                    optimalHumidity = scanner.nextDouble();
                                    if (optimalHumidity < 0) {
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
                                System.out.print("Введите количество: ");
                                try {
                                    quantity = scanner.nextInt();
                                    if (quantity < 0) {
                                        System.out.println("Популяция не может быть отрицательным. Попробуйте снова.");
                                        continue;
                                    }
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введено неверное значение. Пожалуйста, введите (целое) число.");
                                    scanner.next();
                                }
                            }
                            Plant plant = new Plant(species, waterConsumption, optimalTemperature, optimalHumidity, quantity);
                            lines.set(i, plant.toString());
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Plants.txt"))) {
                                for (int j = 0; j < lines.size(); j++) {
                                    writer.write(lines.get(j));
                                    writer.newLine();
                                }
                                System.out.println("Растение успешно перезаписано в файл.");
                                running = false;
                            } catch (IOException e) {
                                System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                            }

                        }else
                            count++;
                    }
                }
                if (count == lines.size())
                    System.out.println("Растение не найдено, попробуйте снова :");
            }

        } catch (IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

    }
    public static void deletePlant() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String filePath = "Plants.txt";
        System.out.print("Введите вид Растение: ");
        String line;
        int count;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            while (running) {
                String species = scanner.nextLine();
                count = 0;
                for (int i = 0; i < lines.size(); i++) {
                    if ((line = lines.get(i)) != null) {
                        String[] parts = line.split(",");
                        if (species.equals(parts[0].trim())) {
                            lines.remove(i);

                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Plants.txt"))) {
                                for (int j = 0; j < lines.size(); j++) {
                                    writer.write(lines.get(j));
                                    writer.newLine();
                                }
                                System.out.println("Растение успешно удалено из файла.");
                                running = false;
                            } catch (IOException e) {
                                System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                            }
                        }
                        else {
                            count++;
                        }
                    }
                    else System.out.println("Пустая строка");
                }
                if(count == lines.size()) {
                    System.out.println("Растение не найдено, попробуйте снова :");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

    }
    public static void getPlants(){
        System.out.printf("%-10s %-20s %-30s %-30s %-30s%n", "Вид", "Потребление воды", "Оптимальная температура", "Оптимальная влажность","Популяция");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader("Plants.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String species = parts[0].trim();
                    double waterConsumption = Double.parseDouble(parts[1].trim());
                    double optimalTemperature = Double.parseDouble(parts[2].trim());
                    double optimalHumidity = Double.parseDouble(parts[3].trim());
                    int quantity = Integer.parseInt(parts[4].trim());


                    System.out.printf("%-10s %-20.2f %-30.2f %-30.2f %-30d%n", species, waterConsumption, optimalTemperature, optimalHumidity, quantity);
                }
            }

        } catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
        
    }
    public static void vitalActivity() {
        String filePath = "Plants.txt";
        String filepath1 = "Enviroment.txt";
        String species;
        double waterConsumption = 0;
        double optimalTemperature = 0;
        double optimalHumidity = 0;
        int quantity = 0;
        double temperature = 0;
        double humidity = 0;
        double water = 0;
        String line;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> lines1 = Files.readAllLines(Paths.get(filepath1));
            line = lines1.get(0);
            String[] parts1 = line.split(",");
            temperature = Double.parseDouble(parts1[0].trim());
            humidity = Double.parseDouble(parts1[1].trim());
            water = Double.parseDouble(parts1[2].trim());
            for (int i = 0; i < lines.size(); i++) {
                if ((line = lines.get(i)) != null) {
                    String[] parts = line.split(",");
                    species = parts[0].trim();
                    waterConsumption = Double.parseDouble(parts[1].trim());
                    optimalTemperature = Double.parseDouble(parts[2].trim());
                    optimalHumidity = Double.parseDouble(parts[3].trim());
                    quantity = Integer.parseInt(parts[4].trim());
                    if((optimalTemperature - 5 < temperature)&&(optimalTemperature + 5 > temperature)) {
                        quantity = (int) (quantity + Math.round(quantity * 0.1));
                    }
                    else if((optimalTemperature - 15 < temperature)&&(optimalTemperature + 15 > temperature)&&(optimalTemperature - 5 >= temperature)&&(optimalTemperature + 5 <= temperature)){
                        quantity = (int) (quantity - Math.round(quantity * 0.1));
                    }
                    else if((optimalTemperature - 20 < temperature)&&(optimalTemperature + 20 > temperature)&&(optimalTemperature - 15 >= temperature)&&(optimalTemperature + 15 <= temperature)){
                        quantity = (int) (quantity - Math.round(quantity * 0.4));
                    }
                    else
                        quantity = 0;
                    if ((optimalHumidity - 10 < humidity)&&(optimalHumidity + 10 > humidity)) {
                        quantity = (int) (quantity + Math.round(quantity * 0.1));
                    }
                    else if ((optimalHumidity - 20 < humidity)&&(optimalHumidity + 20 > humidity)&&(optimalHumidity - 10 >= humidity)&&(optimalHumidity + 10 <= humidity)){
                        quantity = (int) (quantity - Math.round(quantity * 0.1));
                    }
                    else if ((optimalHumidity - 30 < humidity)&&(optimalHumidity + 30 > humidity)&&(optimalHumidity - 20 >= humidity)&&(optimalHumidity + 20 <= humidity)) {
                        quantity = (int) (quantity - Math.round(quantity * 0.4));
                    }
                    else
                        quantity = 0;
                    water = water - waterConsumption * quantity;
                        Plant plant = new Plant(species, waterConsumption, optimalTemperature, optimalHumidity, quantity);
                        lines.set(i, plant.toString());
                        if(quantity <= 0)
                            lines.remove(i);

                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Plants.txt"))) {
                            for (int j = 0; j < lines.size(); j++) {
                                writer.write(lines.get(j));
                                writer.newLine();
                            }

                        } catch (IOException e) {
                            System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                        }
                    System.out.println(species + " выпило " + waterConsumption * quantity);
                    Enviroment enviroment = new Enviroment(temperature, humidity,water);
                    lines1.set(0, enviroment.toString());
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Enviroment.txt"))) {
                        for (int j = 0; j < lines1.size(); j++) {
                            writer.write(lines1.get(j));
                            writer.newLine();
                        }
                    } catch (IOException e) {
                        System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                    }
                }
            }
        }catch (IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
        if(water < 0){
            System.out.println("Экосистема вымерла");
            System.exit(0);
        }
    }
        public String toString () {
            return species + "," + waterConsumption + "," + optimalTemperature + "," + optimalHumidity + "," + quantity;
        }
    }

