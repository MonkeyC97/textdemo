package com.monkeyc.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        dbManager.getConnection();
        ResultSet resultSet = dbManager.queryMethod("select * from employee");
        LinkedList<Employee> list = new LinkedList<Employee>();
        try {
            while(resultSet!= null && resultSet.next()){
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employeeId"));
                employee.setEmpolyeeName(resultSet.getString("employeeName"));
//                employee.setDepartNum(resultSet.getInt("departNum "));
                list.add(employee);
                System.out.println(list);
            }
        }catch (SQLException e){

        }
        dbManager.closeDb();
    }
}
