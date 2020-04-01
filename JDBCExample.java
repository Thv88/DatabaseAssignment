import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JDBCExample {
    public static void main(String[] args) throws  SQLException, IOException
    {
        Employee.getAllEmployeesByld().entrySet().forEach(entry->{
            System.out.println(entry.getValue());
        });

        for (Departments d : Departments.getSetOfDapartments())
            System.out.println(d);

    }
}
