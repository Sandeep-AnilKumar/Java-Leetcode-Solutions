package DesignPatterns.CreationalPatterns.Builder;

import java.util.Objects;

public class Employee {

  enum Department {
    Engineering(1), HR(2), Payroll(3), Sales(4), Unknown(5);

    private int departmentId;

    Department(int departmentId) {
      this.departmentId = departmentId;
    }
  }

  enum Sex {
    Male(1), Female(2), Unknown(3);

    private int sexId;

    Sex(int sexId) {
      this.sexId = sexId;
    }
  }

  private String firstName;
  private String lastName;
  private Long id;
  private Long salary;
  private Department department;
  private Integer age;
  private Sex sex;
  private Long phone;
  private Long managerId;

  private Employee() { }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Long getId() {
    return id;
  }

  public Long getSalary() {
    return salary;
  }

  public Department getDepartment() {
    return department;
  }

  public Integer getAge() {
    return age;
  }

  public Sex getSex() {
    return sex;
  }

  public Long getPhone() {
    return phone;
  }

  public Long getManagerId() {
    return managerId;
  }

  public static Builder getBuilder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", id=" + id +
            ", salary=" + salary +
            ", department=" + department +
            ", age=" + age +
            ", sex=" + sex +
            ", phone=" + phone +
            ", managerId=" + managerId +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(firstName, employee.firstName) &&
            Objects.equals(lastName, employee.lastName) &&
            Objects.equals(id, employee.id) &&
            Objects.equals(salary, employee.salary) &&
            department == employee.department &&
            Objects.equals(age, employee.age) &&
            sex == employee.sex &&
            Objects.equals(phone, employee.phone) &&
            Objects.equals(managerId, employee.managerId);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName, id, salary, department, age, sex, phone, managerId);
  }

  public static class Builder {
    private String firstName;
    private String lastName;
    private Long id;
    private Long salary;
    private Department department;
    private Integer age;
    private Sex sex;
    private Long phone;
    private Long managerId;

    private Builder() { }

    public Builder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder withId(Long id) {
      this.id = id;
      return this;
    }

    public Builder withSalary(Long salary) {
      this.salary = salary;
      return this;
    }

    public Builder withDepartment(Department department) {
      this.department = department;
      return this;
    }

    public Builder withAge(Integer age) {
      this.age = age;
      return this;
    }

    public Builder withSex(Sex sex) {
      this.sex = sex;
      return this;
    }

    public Builder withPhone(Long phone) {
      this.phone = phone;
      return this;
    }

    public Builder withManagerId(Long managerId) {
      this.managerId = managerId;
      return this;
    }

    public Employee build() {
      Employee employee = new Employee();
      employee.firstName = firstName;
      employee.lastName = lastName;
      employee.id = id;
      employee.salary = salary;
      employee.department = department;
      employee.age = age;
      employee.sex = sex;
      employee.phone = phone;
      employee.managerId = managerId;
      return employee;
    }
  }
}
