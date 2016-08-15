/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Departamenti;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class DepartamentiRepository extends EntMngClass implements DepartamentiInterface
{

    @Override
    public void create(Departamenti departamenti) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(departamenti);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            
            if(thro.getMessage().contains("2627")){
            
                    throw new UsersException("E dhëna egziston !");
            }
            else 
            {
                throw new UsersException("Create : "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public void edit(Departamenti departamenti) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(departamenti);
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
    public void remove(Departamenti departamenti) throws UsersException {
      try{
          em.getTransaction().begin();
          em.remove(departamenti);
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
    public List<Departamenti> findAll() {
        return em.createNamedQuery("Departamenti.findAll").getResultList();
    }

    @Override
    public Departamenti findById(String departamenti) throws UsersException {
        Query query=em.createQuery("Select d from Departamenti d where d.dId= :dId");
        query.setParameter("dId", departamenti);
        try{
            return (Departamenti)query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    
    }
    
    @Override
    public Departamenti findByEmri(String departamenti)throws UsersException
    {
        Query query=em.createQuery("SELECT d FROM Departamenti d WHERE d.dEmri = :dEmri");
        query.setParameter("dEmri", departamenti);
        try{
            return(Departamenti) query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhena nuk egziston !");
        }
    }
}
