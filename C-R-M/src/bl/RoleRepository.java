/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import Ejb.Role;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Gramos
 */
public class RoleRepository extends EntMngClass implements RoleInterface
{

    @Override
    public void create(Role role) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("2627"))
            {
                throw new UsersException("E dhëna egziston!");
            }
            else{
                throw new UsersException("Create: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }

    @Override
    public void edit(Role role) throws UsersException {
        try{
            em.getTransaction().begin();
            em.persist(role);
            em.getTransaction().commit();
        }catch(Throwable thro)
        {
            if(thro.getMessage().contains("2627"))
            {
                throw new UsersException("E dhëna egziston!");
            }   
            else{
                throw new UsersException("Update: "+thro.getClass()+" - "+thro.getMessage());
            } 
        }
    }

    @Override
    public void remove(Role role) throws UsersException {
        try{
            em.getTransaction().begin();
            em.remove(role);
            em.getTransaction().commit();
        }catch(Throwable thro){
            if(thro.getMessage().contains("547")){
                throw new UsersException("E dhëna është përdorur, nuk mund ta fshini!!");
            }
            else{
                 throw new UsersException("Remove: "+thro.getClass()+" - "+thro.getMessage());
            }
        }
    }
    @Override
    public List<Role> findAll() {
        return em.createNamedQuery("Role.findAll").getResultList();
    }
    @Override
    public Role findById(String role) throws UsersException {
    Query query=em.createQuery("SELECT r FROM Role r WHERE r.roleid = : roleid");
        query.setParameter("roleid", role);
        try{
            return (Role)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("E dhëna nuk egziston!");
        }
    }

    @Override
    public Role findByKEmri(String role) throws UsersException {
        Query query=em.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName");
        query.setParameter("roleName", role);
        try{
            return (Role)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("E dhëna nuk egziston!");
        }
    }
    public Role findByForm(String role) throws UsersException {
        Query query=em.createQuery("SELECT f FROM Role r join Forms f where r.roleName = :roleName");
        query.setParameter("roleName", role);
        try{
            return (Role)query.getSingleResult();
        } catch (NoResultException nre) {
              throw new UsersException("E dhëna nuk egziston!");
        }
    }

    


}

    