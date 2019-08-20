package Review.Test.reflect;

public class TestEmp {
    public static void main(String[] args) throws Exception {
        String value = "emp.ename:monkeyc|emp.job:Java Coder";
        EmpAction empAction = new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
