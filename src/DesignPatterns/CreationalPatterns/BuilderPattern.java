package DesignPatterns.CreationalPatterns;

public class BuilderPattern {

  public static void main(String[] args) {
    Employee employee1 = Employee.getBuilder()
            .withFirstName("John")
            .withLastName("Doe")
            .withId(getRandomNumber(1L, 5L).longValue())
            .withAge(getRandomNumber(22L, 56L).intValue())
            .withDepartment(Employee.Department.HR)
            .withSex(Employee.Sex.Male)
            .withPhone(getRandomNumber(1111111111L, 9999999999L).longValue())
            .withSalary(getRandomNumber(20000L, 200000000L).longValue())
            .withManagerId(getRandomNumber(101L, 200L).longValue())
            .build();
    
    System.out.println(employee1);
    
    Employee employee2 = Employee.getBuilder()
            .withFirstName("Jenny")
            .withLastName("Doe")
            .withAge(getRandomNumber(5L, 10L).intValue())
            .withManagerId(employee1.getId())
            .build();
    
    System.out.println(employee2);
  }
  
  private static Number getRandomNumber(long min, long max) {
    return min + Math.random() * (max - min);
  }
}
