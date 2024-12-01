package org.jtp.data;

import org.jtp.db_connection.DbConnection;
import org.jtp.domain.Student;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        Student student = null;

        String sqlScript = "SELECT * FROM student WHERE id_student = ?";
        try{
            ps = conn.prepareStatement(sqlScript);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                student = new Student(id);
                student.setName(rs.getString("name"));
                student.setLast_name(rs.getString("last_name"));
                student.setPhonenumber(rs.getString("phonenumber"));
                student.setEmail(rs.getString("email"));
            }
        }catch(SQLException e){
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

    public boolean addStudent(Student student){
        PreparedStatement ps;
        Connection conn = DbConnection.getConnection();
        String sqlScript = "INSERT INTO student (name, last_name, phonenumber, email) VALUES (?, ?, ?, ?)";
        try{
            ps = conn.prepareStatement(sqlScript);
            ps.setString(1, student.getName());
            ps.setString(2, student.getLast_name());
            ps.setString(3, student.getPhonenumber());
            ps.setString(4, student.getEmail());
            ps.execute();

            return true;
        }catch(Exception e){
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }

        finally{
            try{
                conn.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion de base de datos: "+ e.getMessage());
            }
        }

        return false;
    }

    public Student modifyStudent(Student student){
        PreparedStatement ps;
        Connection conn = DbConnection.getConnection();

        String sqlScript = "UPDATE student SET name= ?, last_name = ?, phonenumber = ?, email = ? WHERE id_student = ?";

        try{
            ps = conn.prepareStatement(sqlScript);
            ps.setString(1, student.getName());
            ps.setString(2, student.getLast_name());
            ps.setString(3,student.getPhonenumber());
            ps.setString(4,student.getEmail());
            ps.setInt(5, student.getId_student());
            ps.execute();
            return student;
        }catch(Exception e){
            System.out.println("Error al actualizar el estudiante: " + e.getMessage());
        }

        finally{
            try{
                conn.close();
            }catch(Exception e){
                System.out.println("Error al cerrar la conexion de la base de datos: "+ e.getMessage());
            }
        }

        student = null;
        return student;
    }

    public boolean deleteStudent(int id){
        PreparedStatement ps;
        Connection conn = DbConnection.getConnection();

        String strId = String.valueOf(id);
        String sqlScript = "DELETE FROM student WHERE id_student = " + strId;
        try{
            ps = conn.prepareStatement(sqlScript);
            ps.execute();

            return true;
        }catch(Exception e){
            System.out.println("Error al eliminar el estudiante: "+ e.getMessage());
        }

        finally{
            try{
                conn.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion con la base de datos: " + e.getMessage());
            }
        }
        return false;
    }
}
