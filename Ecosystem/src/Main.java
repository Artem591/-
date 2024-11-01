import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while(true) {
            System.out.println("Выберите какое действие вы хотите совершить:");
            System.out.println("0 - Ввести растение");
            System.out.println("1 - Ввести животное");
            System.out.println("2 - Ввести климатические усовия");
            System.out.println("3 - Редактировать растение");
            System.out.println("4 - Редактировать животное");
            System.out.println("5 - Удалить растение");
            System.out.println("6 - Удалить животное");
            System.out.println("7 - Вывести информацию о растениях");
            System.out.println("8 - Вывести информацию о животных");
            System.out.println("9 - Вывести климатические усовия");
            System.out.println("10 - Закончить ввод данных");
            try {
                int solution = scanner.nextInt();
                switch (solution) {
                    case 0:
                        Plant.writerplant();
                        break;
                    case 1:
                        Animal.writerAnimal();
                        break;
                    case 2:
                        Enviroment.writerEnviroment();
                        break;
                    case 3:
                        Plant.updatePlant();
                        break;
                    case 4:
                        Animal.updateAnimal();
                        break;
                    case 5:
                        Plant.deletePlant();
                        break;
                    case 6:
                        Animal.deleteAnimal();
                        break;
                    case 7:
                        Plant.getPlants();
                        break;
                    case 8:
                        Animal.getAnimals();
                        break;
                    case 9:
                        Enviroment.getEnviroment();
                        break;
                }
                if (solution == 10) {
                    break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Введено неверное значение. Пожалуйста, введите цифру от 0 до 10");
                scanner.next();
            }
        }
        int days = 0;
        int rainlevel = -1;
        while (true) {
            System.out.println("Введите сколько дней пройдёт в экосистеме :");
            try {
                days = scanner.nextInt();
                if (days < 0) {
                    System.out.println("Количество дней не может быть отрицательным. Попробуйте снова.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }


        while (true) {
            System.out.println("Выберите как часто будет идти дождь (Введите цифру от 0 до 9) :");
            try {
                rainlevel = scanner.nextInt();
                if (rainlevel < 0 || rainlevel > 9) {
                    System.out.println("Уровень дождя должен быть от 0 до 9. Попробуйте снова.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Ошибка: введите целое число от 0 до 9.");
                scanner.next();
            }
        }

        int plantv;
        int animalv;
        int animaleat;
        for (int i = 0; i < days; i++) {
            Enviroment.rain(rainlevel);
            Enviroment.getWater();
            plantv = random.nextInt(11);
            animalv = random.nextInt(11);
            animaleat = random.nextInt(11);
            if(plantv % 2 == 0)
                Plant.vitalActivity();
            if(animalv % 2 == 0)
                Animal.vitalActivity();
            if(animaleat % 2 == 0)
                Animal.animalsEat();
        }
    }
}