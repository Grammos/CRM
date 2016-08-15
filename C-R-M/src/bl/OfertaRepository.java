/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Oferta;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class OfertaRepository extends EntMngClass implements OfertaInterface
{

    @Override
    public void create(Oferta oferta) throws UsersException {
        try {
            em.getTransaction().begin();
            em.persist(oferta);
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
    public void edit(Oferta oferta) throws UsersException {
        try {
            em.getTransaction().begin();
            em.persist(oferta);
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
    public void remove(Oferta oferta) throws UsersException {
         try{
            em.getTransaction().begin();
            em.remove(oferta);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("547"))
            {
                throw new UsersException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                throw new UsersException("Remove : "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public List<Oferta> findAll() {
        return em.createNamedQuery("Oferta.findAll").getResultList();
    }

    @Override
    public Oferta findByEmri(String oferta) throws UsersException {
        Query query=em.createQuery("SELECT o FROM Oferta o WHERE o.ofertaEmri = :ofertaEmri");
        query.setParameter("ofertaEmri", oferta);
        try{
            return (Oferta)query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    }
}
