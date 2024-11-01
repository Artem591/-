import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Animal {
    String species;
    boolean carnivorous;
    double waterConsumption;
    double foodConsumption;
    int quantity;

    public Animal(String species,boolean carnivorous, double foodConsumption, double waterConsumption, int quantity) {
        this.species = species;
        this.carnivorous = carnivorous;
        this.waterConsumption = waterConsumption;
        this.foodConsumption = foodConsumption;
        this.quantity = quantity;
    }

    public static void writerAnimal() {
        String filePath = "Animals.txt";
        Scanner scanner = new Scanner(System.in);
        String species;
        String line;
        int count ;
        System.out.print("Введите вид животного: ");
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
                        System.out.println("Животное c таким названием уже есть, попробуйте ещё раз :");

                    } else {
                        boolean carnivorous = false;
                        double waterConsumption = 0;
                        double foodConsumption = 0;
                        int quantity = 0;
                        System.out.println("Введите true, если животное плотоядное. А если травоядное, то введите false:");
                        while (true) {
                            String animalcarnivorous = scanner.nextLine();
                            String toLower = animalcarnivorous.toLowerCase();
                            if (toLower.equals("true") || toLower.equals("false")) {
                                carnivorous = Boolean.parseBoolean(toLower);
                                break;
                            } else
                                System.out.println("Введено неверное значение. Пожалуйста, введите true, если животное плотоядное. А если травоядное, то введите false");

                        }

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
                            System.out.print("Введите потребление пищи: ");
                            try {
                                foodConsumption = scanner.nextDouble();
                                if (foodConsumption < 0) {
                                    System.out.println("Потребление пищи не может быть отрицательным. Попробуйте снова.");
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
                        Animal animal = new Animal(species, carnivorous, waterConsumption, foodConsumption, quantity);

                        try (FileWriter writer = new FileWriter("Animals.txt", true)) {
                            writer.write(animal.toString() + System.lineSeparator());
                            System.out.println("Животное успешно записано в файл.");
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
    public static void updateAnimal(){

            Scanner scanner = new Scanner(System.in);
            String filePath = "Animals.txt";
            System.out.print("Введите вид животного: ");
            boolean carnivorous = false;
            double waterConsumption = 0;
            double foodConsumption = 0;
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
                                System.out.println("Введите true, если животное плотоядное. А если травоядное, то введите false:");
                                while (true) {
                                    String animalcarnivorous = scanner.nextLine();
                                    String toLower = animalcarnivorous.toLowerCase();
                                    System.out.println(toLower);
                                    if (toLower.equals("true") || toLower.equals("false")) {
                                        carnivorous = Boolean.parseBoolean(toLower);
                                        break;
                                    } else
                                        System.out.println("Введено неверное значение. Пожалуйста, введите true, если животное плотоядное. А если травоядное, то введите false");

                                }
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
                                    System.out.print("Введите потребление пищи: ");
                                    try {
                                        foodConsumption = scanner.nextDouble();
                                        if (foodConsumption < 0) {
                                            System.out.println("Потребление пищи не может быть отрицательным. Попробуйте снова.");
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
                                Animal animal = new Animal(species, carnivorous, waterConsumption, foodConsumption, quantity);
                                lines.set(i, animal.toString());
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Animals.txt"))) {
                                    for (int j = 0; j < lines.size(); j++) {
                                        writer.write(lines.get(j));
                                        writer.newLine();
                                    }
                                    System.out.println("Животное успешно перезаписано в файл.");
                                    running = false;
                                } catch (IOException e) {
                                    System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                                }

                            }else
                                count++;
                        }
                    }
                    if (count == lines.size())
                        System.out.println("Животное не найдено, попробуйте снова :");
                }
        } catch (IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }
    public static void deleteAnimal(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String filePath = "Animals.txt";
        System.out.print("Введите вид Животного: ");
        String line;
        int count;
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
while(running) {
    String species = scanner.nextLine();
    count = 0;
    for (int i = 0; i < lines.size(); i++) {
        if ((line = lines.get(i)) != null) {
            String[] parts = line.split(",");
            if (species.equals(parts[0].trim())) {
                lines.remove(i);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Animals.txt"))) {
                    for (int j = 0; j < lines.size(); j++) {
                        writer.write(lines.get(j));
                        writer.newLine();
                    }
                    System.out.println("Животное успешно удалено из файла.");
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
        System.out.println("Животное не найдено, попробуйте снова :");
    }
}
        }catch (IOException e) {
                System.out.println("Ошибка " + e.getMessage());
        }

    }
public static void getAnimals(){
        System.out.printf("%-10s %-18s %-25s %-25s %-30s%n", "Вид", "Хищник", "Потребление воды", "Потребление еды", "Популяция");
        System.out.println("---------------------------------------------------------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader("Animals.txt"))) {
            System.out.println("");
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String species = parts[0].trim();
                    boolean carnivorous = Boolean.parseBoolean(parts[1].trim());
                    double waterConsumption = Double.parseDouble(parts[2].trim());
                    double foodConsumption = Double.parseDouble(parts[3].trim());
                    int quantity = Integer.parseInt(parts[4].trim());
                    System.out.printf("%-10s %-20s %-23.2f %-30.2f %-30d%n", species, carnivorous, waterConsumption, foodConsumption, quantity);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e.getMessage());
        }

    }
    public static void animalsEat() {
        Random random = new Random();
        String filePath = "Animals.txt";
        String filepath1 = "Plants.txt";
        String species;
        boolean carnivorous = false;
        double waterConsumption = 0;
        double foodConsumption = 0;
        int quantity = 0;
        String speciesminus;
        boolean carnivorousminus = false;
        double waterConsumptionminus = 0;
        double foodConsumptionminus = 0;
        int quantityminus = 0;
        String speciespl;
        double waterConsumptionpl = 0;
        double optimalTemperaturepl = 0;
        double optimalHumiditypl = 0;
        int quantitypl = 0;
        int count = 0;
        int count1 = 0;
        int minus = 0;
        String line;
        String lineminus;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> lines1 = Files.readAllLines(Paths.get(filepath1));
            for (int i = 0; i < lines.size(); i++) {
                count++;
            }
            for (int i = 0; i < lines1.size(); i++) {
                count1++;
            }

            int animalseat = random.nextInt(count);
            for (int i = 0; i < animalseat; i++) {
                while (true) {
                    int animaleat = random.nextInt(lines.size());
                    int minusanimal = random.nextInt(count);
                    if(animaleat != minusanimal){
                        line = lines.get(animaleat);
                        String[] parts = line.split(",");
                        species = parts[0].trim();
                        carnivorous = Boolean.parseBoolean(parts[1].trim());
                        waterConsumption = Double.parseDouble(parts[2].trim());
                        foodConsumption = Double.parseDouble(parts[3].trim());
                        quantity = Integer.parseInt(parts[4].trim());
                        if (carnivorous) {

                            lineminus = lines.get(minusanimal);
                            String[] partsminus = lineminus.split(",");
                            speciesminus = partsminus[0].trim();
                            carnivorousminus = Boolean.parseBoolean(partsminus[1].trim());
                            waterConsumptionminus = Double.parseDouble(partsminus[2].trim());
                            foodConsumptionminus = Double.parseDouble(partsminus[3].trim());
                            quantityminus = Integer.parseInt(partsminus[4].trim());
                            quantity = (int) (quantity + Math.round(quantity * 0.03));
                            quantityminus = (int) (quantityminus - foodConsumption * quantity);

                            Animal animalminus = new Animal(speciesminus, carnivorousminus, waterConsumptionminus, foodConsumptionminus, quantityminus);
                            lines.set(minusanimal, animalminus.toString());
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Animals.txt"))) {
                                for (int j = 0; j < lines.size(); j++) {
                                    writer.write(lines.get(j));
                                    writer.newLine();
                                }
                            } catch (IOException e) {
                                System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                            }
                            System.out.println(species + " съел " + speciesminus);
                            if (quantityminus <= 0) {
                                System.out.println(speciesminus + " вымерло");
                                lines.remove(minusanimal);
                                if (animaleat > minusanimal)
                                    animaleat--;

                            }
                        } else {
                            int minusplant = random.nextInt(count1);
                            lineminus = lines1.get(minusplant);
                            String[] partsminus = lineminus.split(",");
                            speciespl = partsminus[0].trim();
                            waterConsumptionpl = Double.parseDouble(partsminus[1].trim());
                            optimalTemperaturepl = Double.parseDouble(partsminus[2].trim());
                            optimalHumiditypl = Double.parseDouble(partsminus[3].trim());
                            quantitypl = Integer.parseInt(partsminus[4].trim());
                            quantity = (int) (quantity + Math.round(quantity * 0.03));
                            quantitypl = (int) (quantitypl - foodConsumption * quantity);
                            Plant plant = new Plant(speciespl, waterConsumptionpl, optimalTemperaturepl, optimalHumiditypl, quantitypl);
                            lines1.set(minusplant, plant.toString());

                            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Plants.txt"))) {
                                for (int j = 0; j < lines1.size(); j++) {
                                    writer.write(lines1.get(j));
                                    writer.newLine();
                                }
                            } catch (IOException e) {
                                System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                            }
                            System.out.println(species + " съел " + speciespl);
                            if (quantitypl <= 0) {
                                System.out.println(speciespl + " вымерло");
                                lines.remove(minusplant);
                                if (animaleat > minusanimal)
                                    animaleat--;
                            }

                        }
                        Animal animal = new Animal(species, carnivorous, waterConsumption, foodConsumption, quantity);
                        lines.set(animaleat, animal.toString());
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Animals.txt"))) {
                            for (int j = 0; j < lines.size(); j++) {
                                writer.write(lines.get(j));
                                writer.newLine();
                            }
                        } catch (IOException e) {
                            System.out.println("Произошла ошибка при перезаписи в файл: " + e.getMessage());
                        }
                    }
                    break;
                }
            }
            if(lines1.isEmpty()){
                System.out.println("Экосистема вымерла");
                System.exit(0);
            }
        }catch (IOException e) {
            System.out.println("Ошибка " + e.getMessage());
        }

    }
    public static void vitalActivity(){
        String filePath = "Animals.txt";
        String filepath1 = "Enviroment.txt";
        String species;
        boolean carnivorous = false;
        double waterConsumption = 0;
        double foodConsumption = 0;
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
                    carnivorous = Boolean.parseBoolean(parts[1].trim());
                    waterConsumption = Double.parseDouble(parts[2].trim());
                    foodConsumption = Double.parseDouble(parts[3].trim());
                    quantity = Integer.parseInt(parts[4].trim());
                    water = water - waterConsumption * quantity;
                    Animal animal = new Animal(species, carnivorous, waterConsumption, foodConsumption, quantity);
                    lines.set(i, animal.toString());
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Animals.txt"))) {
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
    public String toString() {
        return species + "," + carnivorous + "," + foodConsumption + "," + waterConsumption + "," + quantity;
    }
}
