/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.OpenLead;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class OpenLeadRepository extends EntMngClass implements OpenLeadInterface
{

    @Override
    public void create(OpenLead lead) throws UsersException {
         try {
            em.getTransaction().begin();
            em.persist(lead);
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
    public void edit(OpenLead lead) throws UsersException {
        try {
            em.getTransaction().begin();
            em.persist(lead);
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
    public void remove(OpenLead lead) throws UsersException {
         try{
            em.getTransaction().begin();
            em.remove(lead);
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
    public List<OpenLead> findAll() {
        return em.createNamedQuery("OpenLead.findAll").getResultList();
    }

    @Override
    public OpenLead findByEmri(String openLead) throws UsersException {
       Query query=em.createQuery("SELECT o FROM OpenLead o WHERE o.emri = :emri");
        query.setParameter("emri", openLead);
        try{
            return (OpenLead)query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    }
    
}
