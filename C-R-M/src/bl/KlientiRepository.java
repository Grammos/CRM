/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Klienti;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class KlientiRepository  extends EntMngClass implements KlientiInterface
{

    @Override
    public void create(Klienti klienti) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(klienti);
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
    public void edit(Klienti klienti) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(klienti);
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
    public void remove(Klienti klienti) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(klienti);
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
    public List<Klienti> findAll() {
        return em.createNamedQuery("Klienti.findAll").getResultList();
    }

    @Override
    public Klienti findById(String klienti) throws UsersException {
        Query query=em.createQuery("SELECT k FROM Klienti k WHERE k.klientiid = :klientiid");
        query.setParameter("klientiid", klienti);
        try{
            return (Klienti)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("E dhëna nuk egziston!");
        }
    }

    @Override
    public Klienti findByKEmri(String klienti) throws UsersException {
        Query query=em.createQuery("SELECT k FROM Klienti k WHERE k.kEmri = :kEmri");
        query.setParameter("kEmri", klienti);
        try{
            return (Klienti)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("E dhëna nuk egziston!");
        }
    }

    
}
