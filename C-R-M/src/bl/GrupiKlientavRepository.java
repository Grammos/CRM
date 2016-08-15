/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.GrupiKlientav;
import java.util.List;

/**
 *
 * @author Gramos
 */
public class GrupiKlientavRepository extends EntMngClass implements GrupiKlientavInterface
{

    @Override
    public void create(GrupiKlientav grKlientav) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(grKlientav);
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
    public void edit(GrupiKlientav grKlientav) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(grKlientav);
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
    public void remove(GrupiKlientav grKlientav) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(grKlientav);
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
    public List<GrupiKlientav> findAll() {
        return em.createNamedQuery("GrupiKlientav.findAll").getResultList();
    }
    
}
