/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Marketing;
import java.util.List;

/**
 *
 * @author Gramos
 */
public class MarketingRepository extends EntMngClass implements MarketingInterface
{
    
    @Override
    public void create(Marketing marketing) throws UsersException {
         try{
            em.getTransaction().begin();
            em.persist(marketing);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
           if(thro.getMessage().contains("2627"))
            {
                  throw new UsersException("E dhëna egziston!");
            }
            else{
                 throw new UsersException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public void edit(Marketing marketing) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(marketing);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("2627"))
            {
                throw new UsersException("E dhëna egziston!");
            }
            else 
            {
                throw new UsersException("Update :"+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public void remove(Marketing marketing) throws UsersException {
         try{
            em.getTransaction().begin();
            em.remove(marketing);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("547"))
            {
                throw new UsersException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new UsersException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public List<Marketing> findAll() {
        return em.createNamedQuery("Marketing.findAll").getResultList();
    }
    
}
