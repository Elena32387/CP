import java.util.Random;

public class Main {
    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Ульяна", "Анна", "Виктория", "Елена", "Карина", "Галина", "Диана", "Олеся", "Мария", "Александра"};
    private final static String[] SURNAMES = {"Иванова", "Петрова", "Сидорова", "Васильева", "Кузнецова", "Епишкина", "Великая", "Михайлова", "Блинова", "Жабина"};
    private final static String[] PATRONYMIC_NAMES = {"Ивановна", "Петровна", "Артемовна", "Викторовна", "Антоновна", "Евгеньевна", "Игоревна", "Васильена", "Павловна", "Сергеевна"};

    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    PATRONYMIC_NAMES[RANDOM.nextInt(0, PATRONYMIC_NAMES.length)] + " ";
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(60000, 100000));


        }
    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println("Сумма затрат на ЗП: " + salarySum());
        System.out.println("Сотрудник с минимальной ЗП " + findMinSalary());
        System.out.println("Сотрудник с максимальной ЗП " + findMaxSalary());
        System.out.println("Средняя ЗП "+ averageOfSalary());
        printFullNames();

    }

    private static void print() {
        for (Employee employee : EMPLOYEES)
            System.out.println(employee);
    }

    private static int salarySum() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }
    private static double averageOfSalary (){
        return (double) salarySum()/EMPLOYEES.length;
    }
    private static void printFullNames(){
        for (Employee employee: EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

}














