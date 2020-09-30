package pojo;
public class Properties
{
    private String salary;

    private String age;

    public String getSalary ()
    {
        return salary;
    }

    public void setSalary (String salary)
    {
        this.salary = salary;
    }

    public String getAge ()
    {
        return age;
    }

    public void setAge (String age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [salary = "+salary+", age = "+age+"]";
    }
}