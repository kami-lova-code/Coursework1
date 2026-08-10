public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();


        String[] names = {"Иванов И.И.", "Петров П.П.", "Сидоров С.С.", "Кузнецов К.К.",
                "Смирнов С.С.", "Васильев В.В.", "Михайлов М.М.", "Новиков Н.Н.",
                "Федоров Ф.Ф.", "Яковлев Я.Я.", "Алексеев А.А."};
        int[] departments = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1};
        int[] salaries = {50, 100, 150, 200, 300, 350, 400, 450, 60, 80, 90};


        for (int i = 0; i < names.length; i++) {
            Employee newEmp = new Employee(names[i], departments[i], salaries[i]);
            newEmp.printShortInfo();
            boolean added = book.addEmployee(newEmp);
            System.out.println((i + 1) + ". Сотрудник добавлен: " + added);
        }

        System.out.println("\n--- Список всех сотрудников ---");
        book.printAllEmployees();

        System.out.println("\n--- Средняя зарплата ---");
        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());

        System.out.println("\n--- Налоги (PROPORTIONAL) ---");
        book.printTaxes("PROPORTIONAL");

        System.out.println("\n--- Налоги (PROGRESSIVE) ---");
        book.printTaxes("PROGRESSIVE");

        System.out.println("\n--- Индексация зарплат отдела 1 на 10% ---");
        book.indexSalariesByDepartment(1, 10);
        book.printAllEmployees();

        System.out.println("\n--- Поиск первого сотрудника отдела 3 с зарплатой > 200 ---");
        book.findFirstEmployeeAboveWageInDepartment(3, 200);

        System.out.println("\n--- Первые 3 сотрудника с зарплатой < 100 ---");
        book.printFirstEmployeesBelowWage(100, 3);

        System.out.println("\n--- Проверка containsEmployeeByAccountingEquals (по зарплате) ---");
        Employee sample = new Employee("Тест Тест", 1, 150); // такая зарплата есть у Сидорова
        System.out.println("Есть ли сотрудник с такой зарплатой: " + book.containsEmployeeByAccountingEquals(sample));

        System.out.println("\n--- Поиск сотрудника по ID ---");
        Employee found = book.getEmployeeById(3);
        if (found != null) {
            found.printShortInfo();
        } else {
            System.out.println("Сотрудник с таким ID не найден");
        }
    }
}
