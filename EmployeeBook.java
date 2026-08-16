public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }


    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }


    public double calculateAverageSalary() {
        int count = 0;
        int sum = 0;
        for (Employee e : employees) {
            if (e == null) break;
            count++;
            sum += e.getSalary();
        }
        if (count == 0) {
            return 0.0;
        }
        return (double) sum / count;
    }




    public void printTaxes(String scheme) {
        double totalTax = 0.0;
        for (Employee e : employees) {
            if (e == null) {
                continue;
            }

            int salary = e.getSalary();
            double tax = 0;

            switch (scheme) {
                case "PROPORTIONAL" -> tax = salary * 0.13;
                case "PROGRESSIVE" -> tax = calculateProgressiveTax(salary);
            }

            totalTax += tax;
            System.out.printf("Сотрудник: %s, зарплата: %d, налог: %.1f%n",
                    e.getFullName(), salary, tax);
        } // Конец цикла for

        // 6. Выводим ИТОГО после цикла, но ВНУТРИ метода printTaxes
        System.out.println("Итого налог по схеме: " + totalTax);
    }
    private double calculateProgressiveTax(int salary) {
        if (salary < 150) {
            return salary * 0.13;
        } else if (salary <= 350) {
            return salary * 0.17;
        } else {
            return salary * 0.21;
        }
    } // <--- ЭТА СКОБКА была потеряна! Она закрывает calculateProgressiveTax// Конец метода printTaxes



    public void indexSalariesByDepartment(int department, int percent) {
        for (Employee e : employees) {
            if (e == null) break;
            if (e.getDepartment() != department) {
                continue;
            }
            int oldSalary = e.getSalary();
            int newSalary = oldSalary + (e.getSalary() * percent / 100);
            if (oldSalary == newSalary) {
                continue;
            }
            e.setSalary(newSalary);
        }
    }

    public void findFirstEmployeeAboveWageInDepartment(int department, int wage) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e == null) break;
            if (e.getDepartment() == department && e.getSalary() > wage) {
                System.out.println("Найден сотрудник (порядковый номер в списке: " + (i + 1) + "):");
                e.printShortInfo();
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }

    public void printFirstEmployeesBelowWage(int wage, int EmployeeNumber) {
        int count = 0;
        int i = 0;
        while (i < employees.length) {
            Employee e = employees[i];
            if (e == null) break;
            if (e.getSalary() < wage) {
                e.printShortInfo();
                count++;
                if (count > EmployeeNumber) {
                    break;
                }
            }
            i++;
        }
    }

    public boolean containsEmployeeByAccountingEquals(Employee target) {
        for (Employee e : employees) {
            if (e == null) break;
            if (e.equals(target)) {
                return true;
            }
        }
        return false;
    }



    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e == null) break;
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
















