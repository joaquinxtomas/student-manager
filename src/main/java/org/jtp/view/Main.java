package org.jtp.view;

import org.jtp.data.StudentDAO;
import org.jtp.domain.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       boolean end = false;

       Scanner console = new Scanner(System.in);

       StudentDAO stdDao = new StudentDAO();

       while(!end){
           try{
               menu();
               end = options(console, stdDao);
           } catch(Exception e){
               System.out.println("Error: "+ e.getMessage());
           }
       }


    }

    private static void menu(){
        System.out.println("""
                *** GESTION DE ESTUDIANTES ***
                1. Listar todos los estudiantes.
                2. Agregar un nuevo estudiante.
                3. Buscar un estudiante por su ID.
                4. Modificar datos de un estudiante.
                5. Eliminar un estudiante.
                6. Salir.
                
                Elige una opcion: 
                """);
    }

    private static boolean options(Scanner console, StudentDAO stdDao){
        Integer option = Integer.parseInt(console.nextLine());
        boolean end = false;

        switch(option){
            case 1 -> {
                System.out.println("Listado de estudiantes: ");
                List<Student> students = stdDao.listStudents();
                students.forEach(System.out::println);
            }
            case 2 -> {
                Student newStudent = new Student();
                System.out.println("Ingresa el nombre del estudiante: ");
                String name = console.nextLine();
                System.out.println("Ingresa el apellido del estudiante: ");
                String lastName = console.nextLine();
                System.out.println("Ingresa el numero de telefono del estudiante: ");
                String phonenumber = console.nextLine();
                System.out.println("Ingresa el email del estudiante: ");
                String email = console.nextLine();

                newStudent.setName(name);
                newStudent.setLast_name(lastName);
                newStudent.setPhonenumber(phonenumber);
                newStudent.setEmail(email);

                boolean added = stdDao.addStudent(newStudent);

                if(added){
                    System.out.println("El alumno se agregó correctamente.");
                } else{
                    System.out.println("Existe un error al agregar el archivo.");
                }
            }
            case 3 -> {
                System.out.println("Ingrese el id del estudiante a buscar: ");
                int id = console.nextInt();
                console.nextLine();
                Student finded = stdDao.findById(id);
                if(finded != null){
                    System.out.println("Estudiante encontrado: " + finded);
                } else{
                    System.out.println("El estudiante no existe en la base de datos.");
                }
            }
            case 4 -> {
                System.out.println("Ingrese el id del estudiante a modificar: ");
                Integer id = console.nextInt();
                console.nextLine();
                System.out.println("Ingresa el nombre del estudiante: ");
                String name = console.nextLine();
                System.out.println("Ingresa el apellido del estudiante: ");
                String lastName = console.nextLine();
                System.out.println("Ingresa el numero de telefono del estudiante: ");
                String phonenumber = console.nextLine();
                System.out.println("Ingresa el email del estudiante: ");
                String email = console.nextLine();

                Student modifiedStudent = new Student(id, name, lastName, phonenumber,email);

                Student succesfull = stdDao.modifyStudent(modifiedStudent);

                if(succesfull != null){
                    System.out.println("El estudiante ha sido modificado correctamente.");
                } else {
                    System.out.println("Existe un error al modificar el estudiante.");
                }
            }
            case 5 -> {
                System.out.println("Proporcione el ID del estudiante a eliminar: ");
                Integer id = console.nextInt();
                console.nextLine();
                System.out.println("Está seguro de eliminar el estudiante con id: "+ id + "? (Y/n)");
                String delete = console.nextLine();
                if(delete.equalsIgnoreCase("Y")){
                    stdDao.deleteStudent(id);
                    System.out.println("Estudiante eliminado correctamente.");
                } else if(delete.equalsIgnoreCase("n")){
                    System.out.println("Se canceló la eliminación del estudiante.");
                } else {
                    System.out.println("Opcion invalida.");
                }
            }
            case 6 ->{
                System.out.println("Hasta la proxima.");
                end = true;
            }
            default -> {
                System.out.println("Opcion no válida.");
            }
        }
        return end;
    }
}