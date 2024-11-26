package org.npm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = null;
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("curso");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Aquí es donde se realizarían las operaciones sobre las entidades
            System.out.println("Conexión establecida correctamente");

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la traza completa del error
        } finally {
            if (em != null) {
                em.close(); // Cierra el EntityManager
            }
            if (emf != null) {
                emf.close(); // Cierra el EntityManagerFactory
            }
        }
    }
}
