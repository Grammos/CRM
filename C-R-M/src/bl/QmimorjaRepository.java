/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Qmimorja;
import java.util.List;

/**
 *
 * @author Gramos
 */
public class QmimorjaRepository extends EntMngClass implements QmimorjaInterface
{

    @Override
    public void create(Qmimorja qmimorja) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(qmimorja);
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
    public void edit(Qmimorja qmimorja) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(qmimorja);
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
    public void remove(Qmimorja qmimorja) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(qmimorja);
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
    public List<Qmimorja> findAll() {
        return em.createNamedQuery("Qmimorja.findAll").getResultList();
    }
    
}
