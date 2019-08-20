package Review.Test.reflect;

class Emp1{
    private String ename;
    private String job;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}

public class Test11 {
    public static void main(String[] args) {
        Emp1 emp = new Emp1();
        emp.setEname("monkeyc");
        emp.setJob("doctor");
        System.out.println(emp);
    }
}
