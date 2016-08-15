/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Porosia;
import java.util.List;

/**
 *
 * @author Gramos
 */
public class PorosiaRepository extends EntMngClass implements PorosiaInterface
{

    @Override
    public void create(Porosia porosia) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(porosia);
            em.getTransaction().commit();
        }
        catch(Throwable thro)
        {
            if(thro.getMessage().contains("2627"))
            {
                   throw new UsersException("E dhëna egziston!");
            }
            else 
            {
                throw new UsersException("Create : "+thro.getClass()+" - "+thro.getMessage());
            }
        }
        
    }

    @Override
    public void edit(Porosia porosia) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(porosia);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("2627"))
            {
               throw new UsersException("E dhëna egziston!");
            }
            else 
            {
                throw new UsersException("Create : "+thro.getClass()+" - "+thro.getMessage());
            }
        }
        
    }

    @Override
    public void remove(Porosia porosia) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(porosia);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {   
           if(thro.getMessage().contains("547")){
                throw new UsersException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new UsersException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }

    }

    @Override
    public List<Porosia> findAll() {
        return em.createNamedQuery("Porosia.findAll").getResultList();
    }
    
}
