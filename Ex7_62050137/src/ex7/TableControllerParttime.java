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
public class TableControllerParttime {

    public static void insertStudent(ParttimeEmployee parttimeEmployee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex7PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(parttimeEmployee);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public static void updateEmployee(ParttimeEmployee parttimeEmployee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex7PU");
        EntityManager em = emf.createEntityManager();
        ParttimeEmployee fromDb = em.find(ParttimeEmployee.class, parttimeEmployee.getId());
        fromDb.setHoursWork(parttimeEmployee.getHoursWork());
        fromDb.setName(parttimeEmployee.getName());
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

    public static void removeEmployee(ParttimeEmployee parttimeEmployee) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex7PU");
        EntityManager em = emf.createEntityManager();
        ParttimeEmployee fromDb = em.find(ParttimeEmployee.class, parttimeEmployee.getId());
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
