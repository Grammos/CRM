/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Forms;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class FormsRepository extends EntMngClass implements FormsInterface
{

    @Override
    public void create(Forms forms) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(forms);
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
    public void edit(Forms forms) throws UsersException {
        try
        {
            em.getTransaction().begin();
            em.persist(forms);
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
    public void remove(Forms forms) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(forms);
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
    public List<Forms> findAll() {
        return em.createNamedQuery("Forms.findAll").getResultList();
    }
    @Override
    public Forms findById(String forms) throws UsersException {
        Query query=em.createQuery("SELECT f FROM Forms f WHERE f.fid = :fid");
        query.setParameter("fid", forms);
        try{
            return (Forms)query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    }


}
