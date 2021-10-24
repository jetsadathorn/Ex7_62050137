/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DELL
 */
public class Ex7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        insertdatatest();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose table \n"
                + "1 : FulltimeEmployee \n"
                + "2 : ParttimeEmployee \n");
        int choose = sc.nextInt();
        if (choose == 1) {
            System.out.println("Table Fulltime \n"
                    + "1 : Insert data \n"
                    + "2 : Update data \n"
                    + "3 : Remove data (need id)");
            int choose2 = sc.nextInt();
            switch (choose2) {
                case 1: {
                    FulltimeEmployee data = new FulltimeEmployee();
                    System.out.println("Insert \n"
                            + "Pls enter the Name");
                    String name = sc.next();
                    System.out.println("Insert \n"
                            + "Pls enter the Salary");
                    int salary = sc.nextInt();
                    data.setName(name);
                    data.setSalary(salary);
                    TableControllerFulltime.insertStudent(data);
                    break;
                }
                case 2: {
                    FulltimeEmployee data = new FulltimeEmployee();
                    System.out.println("Update \n"
                            + "Pls enter the id");
                    Long id = sc.nextLong();
                    System.out.println("Insert \n"
                            + "Pls enter the Name");
                    String name = sc.next();
                    System.out.println("Insert \n"
                            + "Pls enter the Salary");
                    int salary = sc.nextInt();
                    data.setId(id);
                    data.setName(name);
                    data.setSalary(salary);
                    TableControllerFulltime.updateEmployee(data);
                    break;
                }
                case 3: {
                    FulltimeEmployee data = new FulltimeEmployee();
                    System.out.println("Delete \n"
                            + "Pls enter the id");
                    Long id = sc.nextLong();
                    data.setId(id);
                    TableControllerFulltime.removeEmployee(data);
                    break;
                }
                default:
                    break;
            }
        } else if (choose == 2) {
            System.out.println("Table Partime \n"
                    + "1 : Insert data \n"
                    + "2 : Update data \n"
                    + "3 : Remove data (need id)");
            int choose2 = sc.nextInt();
            switch (choose2) {
                case 1: {
                    ParttimeEmployee data = new ParttimeEmployee();
                    System.out.println("Insert \n"
                            + "Pls enter the Name");
                    String name = sc.next();
                    System.out.println("Insert \n"
                            + "Pls enter the HoursWork");
                    int hourswork = sc.nextInt();
                    data.setName(name);
                    data.setHoursWork(hourswork);
                    TableControllerParttime.insertStudent(data);
                    break;
                }
                case 2: {
                    ParttimeEmployee data = new ParttimeEmployee();
                    System.out.println("Update \n"
                            + "Pls enter the id");
                    Long id = sc.nextLong();
                    System.out.println("Insert \n"
                            + "Pls enter the Name");
                    String name = sc.next();
                    System.out.println("Insert \n"
                            + "Pls enter the HoursWork");
                    int hourswork = sc.nextInt();
                    data.setId(id);
                    data.setName(name);
                    data.setHoursWork(hourswork);
                    TableControllerParttime.updateEmployee(data);
                    break;
                }
                case 3: {
                    ParttimeEmployee data = new ParttimeEmployee();
                    System.out.println("Delete \n"
                            + "Pls enter the id");
                    Long id = sc.nextLong();
                    data.setId(id);
                    TableControllerParttime.removeEmployee(data);
                    break;
                }
                default:
                    break;
            }
        }

    }

    public static void insertdatatest() {
        FulltimeEmployee data = new FulltimeEmployee();
        ParttimeEmployee data11 = new ParttimeEmployee();
        data.setName("John");
        data.setSalary(500000);
        data11.setName("Jane");
        data11.setHoursWork(4);
        TableControllerFulltime.insertStudent(data);
        TableControllerParttime.insertStudent(data11);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex7PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
