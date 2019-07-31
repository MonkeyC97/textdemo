package com.monkeyc.DB;

public class Employee {
    private String empolyeeName;
    private int employeeId;
    private int departNum;

    public int getDepartNum() {
        return departNum;
    }

    public void setDepartNum(int departNum) {
        this.departNum = departNum;
    }

    public String getEmpolyeeName() {
        return empolyeeName;

    }

    public void setEmpolyeeName(String empolyeeName) {
        this.empolyeeName = empolyeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empolyeeName='" + empolyeeName + '\'' +
                ", employeeId=" + employeeId +
                ", departNum=" + departNum +
                '}';
    }
}
