
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Estudante
 */
public class EntityManagerObjectFactory {
    private EntityManagerFactory emf;
    
    public EntityManager getEM(){
        return emf.createEntityManager();
    }
}
