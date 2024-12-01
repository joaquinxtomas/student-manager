package org.jtp.data;

import org.jtp.db_connection.DbConnection;
import org.jtp.domain.Student;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.jtp.db_connection.DbConnection.getConnection;

public class StudentDAO {
    public List<Student> listStudents(){
        List<Student> students= new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;

        Connection conn = DbConnection.getConnection();
        String sqlScript = "SELECT * FROM student ORDER BY id_student";
        try{
            ps = conn.prepareStatement(sqlScript);
            rs = ps.executeQuery();

            while(rs.next()){
                Student student = new Student();
                student.setId_student(rs.getInt("id_student"));
                student.setName(rs.getString("name"));
                student.setLast_name(rs.getString("last_name"));
                student.setPhonenumber(rs.getString("phonenumber"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }

        }catch(Exception e){
            System.out.println("Error al seleccionar datos: " + e.getMessage());
        }

        finally{
            try{
                conn.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion a la base de datos: " + e.getMessage());
            }
        }

        return students;
    }

    public Student findById(int id){
        PreparedStatement ps;
        ResultSet rs;
        Connection conn = DbConnection.getConnection();

        Student student = new Student(id);

        String strId = String.valueOf(id);
        String sqlScript = "SELECT * FROM student WHERE id_student = " + strId;
        try{
            ps = conn.prepareStatement(sqlScript);
            rs = ps.executeQuery();
            if(rs.next()){
                student.setName(rs.getString("name"));
                student.setLast_name(rs.getString("last_name"));
                student.setPhonenumber(rs.getString("phonenumber"));
                student.setEmail(rs.getString("email"));
            } else {
                student = null;
            }
        }catch(Exception e){
            System.out.println("Error al buscar el estudiante: " + e.getMessage());
        }

        finally {
            try{
                conn.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion con la base de datos: "+ e.getMessage());
            }
        }

        return student;
    }

    public static void main(String[] args) {

        StudentDAO studentdao = new StudentDAO();

        //System.out.println("Listado de estudiantes: ");
        //List<Student> students = studentdao.listStudents();

        Student student = new Student();

        Student finded = studentdao.findById(6);
        if(finded != null){
            System.out.println(finded);
        } else {
            System.out.println("No existe el estudiante en la base de datos.");
        }


        //students.forEach(System.out::println);
    }
}
