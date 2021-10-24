/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex7;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DELL
 */
public class TableControllerFulltime {

    public static void insertStudent(FulltimeEmployee fulltimeEmployee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex7PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(fulltimeEmployee);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void updateEmployee(FulltimeEmployee fulltimeEmployee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex7PU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, fulltimeEmployee.getId());
        fromDb.setName(fulltimeEmployee.getName());
        fromDb.setSalary(fulltimeEmployee.getSalary());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void removeEmployee(FulltimeEmployee fulltimeEmployee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex7PU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, fulltimeEmployee.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
