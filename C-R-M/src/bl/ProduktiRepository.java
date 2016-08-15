/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Produkti;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class ProduktiRepository extends EntMngClass implements ProduktiInterface
{

    @Override
    public void create(Produkti produkti) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(produkti);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("2627")){
                   throw new UsersException("E dhëna egziston!");
            }
            else 
            {
                throw new UsersException("Create : "+thro.getClass()+" - "+thro.getMessage());
            }
        
        }
    }

    @Override
    public void edit(Produkti produkti) throws UsersException {
         try{
            em.getTransaction().begin();
            em.persist(produkti);
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
    public void remove(Produkti produkti) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(produkti);
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
    public List<Produkti> findAll() {
        return em.createNamedQuery("Produkti.findAll").getResultList();
    }

    @Override
    public Produkti findByEmri(String produkti) throws UsersException {
        Query query=em.createQuery("SELECT p FROM Produkti p WHERE p.pEmri = :pEmri");
        query.setParameter("pEmri", produkti);
        try{
            return (Produkti)query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    }
    
}
