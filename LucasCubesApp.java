package Igor.LukCubesCalculator;

import java.util.Scanner;

/*
        * Клас, що представляє число Люка.
        * Зберігає значення числа та його індекс у послідовності.
        */
class LucasNumber {
    private long value;  // Значення числа Люка
    private int index;   // Індекс числа Люка

    /*
            * Конструктор для створення числа Люка з індексом.
     *
             * @param value Значення числа Люка
     * @param index Індекс числа у ряді
     */
    public LucasNumber(long value, int index) {
        this.value = value;
        this.index = index;
    }

    /*
            * Повертає значення числа Люка.
            *
            * @return Значення числа Люка
     */
    public long getValue() {
        return value;
    }

    /*
            * Повертає індекс числа Люка.
            *
            * @return Індекс числа у ряді Люка
     */
    public int getIndex() {
        return index;
    }

    /*
            * Перевіряє, чи є число Люка кубом.
     *
             * @return true, якщо число є кубом; false, якщо не є
     */
    public boolean isCube() {
        long cubeRoot = Math.round(Math.cbrt(value));
        return cubeRoot * cubeRoot * cubeRoot == value;
    }

    /*
            * Повертає рядкове представлення числа Люка.
     *
             * @return Рядкове представлення числа Люка з його індексом
     */
    @Override
    public String toString() {
        return "Індекс: " + index + ", Значення: " + value;
    }
}

/*
        * Клас для обчислення чисел Люка та перевірки, чи є вони кубами.
        */
class LucasCubesCalculator {

    private int N;  // Кількість чисел Люка

    /*
            * Конструктор, який встановлює кількість чисел Люка для обчислення.
     *
             * @param N Кількість чисел Люка для обчислення
     */
    public LucasCubesCalculator(int Num) {
        N = Num;
    }

    /*
            * Метод для обчислення чисел Люка та виведення тих, які є кубами.
            * Виводить індекс та значення чисел, які є кубами.
     */
    public void printLucasCubes() {
        long prev1 = 2;  // перше число Люка
        long prev2 = 1;  // друге число Люка

        for (int i = 0; i < N; i++) {
            LucasNumber lucasNumber;
            if (i == 0) {
                lucasNumber = new LucasNumber(prev1, i);  // перше число Люка
            } else if (i == 1) {
                lucasNumber = new LucasNumber(prev2, i);  // друге число Люка
            } else {
                long current = prev1 + prev2;  // обчислюємо наступне число
                lucasNumber = new LucasNumber(current, i);
                prev1 = prev2;  // оновлюємо попередні два числа
                prev2 = current;
            }

            // Перевіряємо, чи є число кубом
            if (lucasNumber.isCube()) {
                System.out.println("Число Люка, яке є кубом: Індекс: " + lucasNumber.getIndex() + ", Значення: " + lucasNumber.getValue());
            }
        }
    }
}

/*
        * Головний клас програми для запуску обчислення чисел Люка.
        */
public class LucasCubesApp {

    /**
     * Основний метод програми, що запускає процес обчислення чисел Люка.
     *
     * @param args Аргументи командного рядка (не використовується)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість чисел Люка (N): ");
        int N = scanner.nextInt();

        LucasCubesCalculator calculator = new LucasCubesCalculator(N);
        calculator.printLucasCubes();
    }
}