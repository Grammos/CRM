/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Kontrata;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class KontrataRepository extends EntMngClass implements KontrataInterface {

    @Override
    public void create(Kontrata kontrata) throws UsersException {
       try{
            em.getTransaction().begin();
            em.persist(kontrata);
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
    public void edit(Kontrata kontrata) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(kontrata);
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
    public void remove(Kontrata kontrata) throws UsersException {
         try{
            em.getTransaction().begin();
            em.remove(kontrata);
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
    public List<Kontrata> findAll() {
        return em.createNamedQuery("Kontrata.findAll").getResultList();
    }

    @Override
    public Kontrata findByKEmri(String kontrata) throws UsersException {
       Query query=em.createQuery("SELECT k FROM Kontrata k WHERE k.Emri = :Emri");
        query.setParameter("Emri", kontrata);
        try{
            return (Kontrata)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("E dhëna nuk egziston!");
        }
    }
    
}
