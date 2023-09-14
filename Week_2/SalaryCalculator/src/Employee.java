public class Employee {

    String name;
    double salary;
    int workHours;
    int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    double tax(double salary) {
        double tax = (salary < 1000) ? salary * 0 : salary * 0.03;
        return tax;
    }

    int bonus(int workHours) {
        int extraHours = workHours - 40;

        if (extraHours > 0) {
            return extraHours * 30;
        } else {
            return 0;
        }
    }

    double raiseSalary(int hireYear, double salary) {

        int workYear = 2021 - hireYear;

        if (workYear <= 0) return 0;

        if (workYear < 10) return salary * 0.05;

        else if (workYear < 20) return salary * 0.1;

        else if (workYear > 19) return salary * 0.15;

        return 0;
    }

    void toString(Employee employee) {

        System.out.println("Adı : " + employee.name);

        System.out.println("Maaşı : " + employee.salary);

        System.out.println("Çalışma Saati : " + employee.workHours);

        System.out.println("Başlangıç Yılı : " + employee.hireYear);

        System.out.println("Vergi : " + employee.tax(employee.salary));

        System.out.println("Bonus : " + employee.bonus(employee.workHours));

        System.out.println("Maaş Artışı : " + employee.raiseSalary(employee.hireYear, employee.salary));

        System.out.println("Vergi ve Bonusları ile birlikte maaş : " + (employee.salary + employee.bonus(workHours) - employee.tax(employee.salary)));

        System.out.println("Toplam Maaş : " + (employee.salary + employee.raiseSalary(employee.hireYear, employee.salary)));
    }
}
