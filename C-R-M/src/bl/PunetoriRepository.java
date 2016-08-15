/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Punetori;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class PunetoriRepository extends EntMngClass implements PunetoriInterface
{

    @Override
    public void create(Punetori punetori) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(punetori);
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
    public void edit(Punetori punetori) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(punetori);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
           if(thro.getMessage().contains("2627")){
            throw new UsersException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else
               throw new UsersException("Remove: "+thro.getClass()+" - "+thro.getMessage());       
        }
    }

    @Override
    public void remove(Punetori punetori) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(punetori);
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
    public List<Punetori> findAll() {
        return em.createNamedQuery("Punetori.findAll").getResultList();
    }

    @Override
    public Punetori findById(String punetori) throws UsersException {
        Query query=em.createQuery("SELECT p FROM Punetori p WHERE p.P_id= : P_id");
        query.setParameter("P_id", punetori);
        try{
            return (Punetori)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("E dhëna nuk egziston!");
        }
    }

    @Override
    public Punetori findByEmri(String punetori) throws UsersException {
        Query query=em.createQuery("SELECT p FROM Punetori p WHERE p.emri = :emri");
        query.setParameter("emri", punetori);
        try{
            return (Punetori)query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    }

    @Override
    public Punetori find(String punetori) throws UsersException 
    {
        Query query=em.createQuery("SELECT p FROM Punetori p WHERE p.pid = :pid");
        query.setParameter("pid",punetori);
        try{
            return (Punetori)query.getSingleResult();
        }
        catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    }
    
}
