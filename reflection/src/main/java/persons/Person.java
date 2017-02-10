package persons;

import java.util.DoubleSummaryStatistics;

/**
 * Created by fedinskiy on 10.02.17.
 */
public class Person {
    private String name;
    private Integer age;
    private Double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
