/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;


import Ejb.Users;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class UsersRepository extends EntMngClass implements UsersInterface
{

    @Override
    public void create(Users users) throws UsersException {
        try {
            em.getTransaction().begin();
            em.persist(users);
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
    public void edit(Users users) throws UsersException {
        try {
            em.getTransaction().begin();
            em.persist(users);
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
    public void remove(Users users) throws UsersException 
    {
        try{
            em.getTransaction().begin();
            em.remove(users);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("547")){
                throw new UsersException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                throw new UsersException("Remove : "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public List<Users> findAll() {
        return em.createNamedQuery("Users.findAll").getResultList();
    }

    @Override
    public Users findById(String users) throws UsersException {
        Query query=em.createQuery("Select u from Users u where u.uid= :uid");
        query.setParameter("uid", users);
        try{
            return (Users)query.getSingleResult();
        }catch(NoResultException nre)
        {
            throw new UsersException("E dhëna nuk egziston!");
        }
    }
    
    @Override
    public Users findByUsername(String username, String password) throws UsersException {
        Query query=em.createQuery("SELECT u FROM Users u WHERE u.shfrytezuesi = :shfrytezuesi AND u.fjalekalimi = :fjalekalimi");
        query.setParameter("shfrytezuesi", username);
        query.setParameter("fjalekalimi", password);
        try{
            return (Users)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("Shfytëzuesi apo fjalëkalimi është i gabuar");
        }
        
    }

    @Override
    public Users findByUser(String username) throws UsersException {
        Query query=em.createQuery("SELECT u FROM Users u WHERE u.shfrytezuesi = :shfrytezuesi");
        query.setParameter("shfrytezuesi", username);
        
        try{
            return (Users)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("Shfytëzuesi apo fjalëkalimi është i gabuar");
        }
    }
}
