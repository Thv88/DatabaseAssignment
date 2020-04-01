import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

public class Employee {
    private int employeeNumber;
    private String employeeName;
    private String job;
    private int manager;
    private Date hiredate;
    private int salery;
    private int comm;

    public Employee(int employeeNumber, String employeeName, String job, int manager, Date hiredate, int salery, int comm) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hiredate = hiredate;
        this.salery = salery;
        this.comm = comm;
    }

    public static HashMap<Integer, Employee> getAllEmployeesByld() throws SQLException, IOException
    {
        HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
        DatabaseConnectionManager conn = new DatabaseConnectionManager();
        Connection forbindelseTilMySQL = conn.getConnection();
        Statement mitStatement = forbindelseTilMySQL.createStatement();
        String getAllEmployees = "SELECT * FROM emp";
        ResultSet allEmployees =  mitStatement.executeQuery(getAllEmployees);

        while (allEmployees.next())
        {
            employees.put(allEmployees.getInt(1),(new Employee(allEmployees.getInt(1), allEmployees.getString(2), allEmployees.getString(3), allEmployees.getInt(4),
                    allEmployees.getDate(5), allEmployees.getInt(6), allEmployees.getInt(7))));
        }

        return employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", employeeName='" + employeeName + '\'' +
                ", job='" + job + '\'' +
                ", manager=" + manager +
                ", hiredate=" + hiredate +
                ", salery=" + salery +
                ", comm=" + comm +
                '}';
    }
}
