/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student6;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author POY
 */
public class Student6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student stu1 = new Student(1, "Natta", 11111.1);
       Student stu2 = new Student(2, "wadee", 12345.0);
       Student6.insertStudent(stu1);
       Student6.insertStudent(stu2);
    }
    
    public static void insertStudent(Student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student6PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(stu);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
        public static void updateStudent(Student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student6PU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stu.getId());
        fromDb.setName(stu.getName());
        fromDb.setGpa(stu.getGpa());
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
        public static void removeStudent(Student stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student6PU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stu.getId());
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

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student6PU");
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
