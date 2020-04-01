import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Departments {
    int departmentNumber;
    String departmentName;
    String loc;

    public Departments(int departmentNumber, String departmentName, String loc) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.loc = loc;
    }

    public static Set<Departments> getSetOfDapartments() throws SQLException, IOException
    {
        HashSet<Departments> departments = new HashSet<Departments>();

        DatabaseConnectionManager conn = new DatabaseConnectionManager();
        Connection forbindelseTilMySQL = conn.getConnection();
        Statement mitStatement = forbindelseTilMySQL.createStatement();
        String getAllDepartments = "select * from dept";

        ResultSet allDepartments = mitStatement.executeQuery(getAllDepartments);

        while (allDepartments.next())
        {
            departments.add(new Departments(allDepartments.getInt(1), allDepartments.getString(2), allDepartments.getString(3)));
        }

        return departments;

    }

    @Override
    public String toString() {
        return "Departments{" +
                "departmentNumber=" + departmentNumber +
                ", departmentName='" + departmentName + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
