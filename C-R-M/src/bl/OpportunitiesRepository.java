/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Oppertunities;
import java.util.List;

/**
 *
 * @author Gramos
 */
public class OpportunitiesRepository extends EntMngClass implements OpportunitiesInterface
{

    @Override
    public void create(Oppertunities opportunities) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(opportunities);
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
    public void edit(Oppertunities opportunities) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(opportunities);
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
    public void remove(Oppertunities opportunities) throws UsersException {
         try{
            em.getTransaction().begin();
            em.remove(opportunities);
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
    public List<Oppertunities> findAll() {
        return em.createNamedQuery("Oppertunities.findAll").getResultList();
    }
    
}
