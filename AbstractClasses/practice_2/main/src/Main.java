public class Main {

    public static void main(String[] args) {

//        Operator operator = new Operator(180);
//        Manager manager = new Manager(80);
//        TopManager topManager = new TopManager(10);

        Company company = new Company(10_000_000);
        company.hire(new Operator(180));
        company.hire(new Manager(80));
        company.hire(new TopManager(10));
        System.out.println(company.getTopSalaryStaff(15));
        System.out.println(company.getLowestSalaryStaff(30));
//        company.fire()
        System.out.println(company.getTopSalaryStaff(15));
        System.out.println(company.getLowestSalaryStaff(30));

    }
}
