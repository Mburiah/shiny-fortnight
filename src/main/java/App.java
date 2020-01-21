import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeeDao;
import dao.Sql2oNewsDao;
import org.sql2o.Sql2o;

import java.sql.Connection;

public class App {
    public static void main(String[] args){
        Sql2oDepartmentDao departmentDao;
        Sql2oEmployeeDao employeeDao;
        Sql2oNewsDao newsDao;
        Connection conn;
//        Gson gson = new Gson();

        String postgres = "jdbc:postgresql://localhost:5432/org_api_test";
        Sql2o sql2o = new Sql2o(postgres, "postgres", "password");

    }
}
