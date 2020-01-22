import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeeDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import static spark.Spark.*;
import com.google.gson.Gson;
import models.*;

import java.util.HashMap;
import java.util.Map;


public class App {
    public static void main(String[] args){
        Sql2oDepartmentDao departmentDao;
        Sql2oEmployeeDao employeeDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql:~/organisational_api.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "postgres", "password");

        employeeDao = new Sql2oEmployeeDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();

        get("/departments", "application/json", (request, response) -> {
            return gson.toJson(departmentDao.getDepartments());
        });
        get("departments/:id", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.queryParams("id"));
            Department departmentToFind = departmentDao.findById(departmentId);
            if (departmentToFind == null) {
                throw new ApiException(404, String.format("No department with the id:\"%s\" exists", request.queryParams("id")));
            }
            return gson.toJson(departmentToFind);
        });


        get ("employeees", "application/json", (request, response) -> {
            return  gson.toJson(employeeDao.getEmployees());
        });
        get("/employees/:id", "application/json", (request, response) -> {
            response.type("/application/json");
            int employeeId = Integer.parseInt(request.queryParams("id"));
            return gson.toJson(departmentDao.findById(employeeId));
        });


        get("/news", "application/json", (request, response) -> {
            int newsId = Integer.parseInt(request.queryParams("id"));
            return gson.toJson(newsDao.findById(newsId));
        });
        get("/news/:id", "application/json", (request, response) -> {
            int newsId = Integer.parseInt(request.queryParams("id"));
            return gson.toJson(newsDao.findById(newsId));
        });

        post("/departments/new", "application/json", (request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            departmentDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });
        post("/employees/new", "application/json", (request, response) -> {
            Employee employee = gson.fromJson(request.body(), Employee.class);
            employeeDao.add(employee);
            response.status(201);
            return gson.toJson(employee);
        });
        post("/news/new", "application/json",(request, response) -> {
            News news = gson.fromJson(request.body(),News.class);
            newsDao.add(news);
            response.status(201);
            return  gson.toJson(news);
        });

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) -> {
            res.type("application/json");
        });


    }
}
