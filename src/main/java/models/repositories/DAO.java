package models.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DAO <E>{
    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;
    static {
        try{
            emf = Persistence.createEntityManagerFactory("sistema_locadora_db");
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public DAO(){

    }

    public DAO(Class<E> classe){
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> openConnection(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeConnection(){
        em.getTransaction().commit();
        return this;
    }
    public DAO<E> insert(E entidade){
        em.persist(entidade);
        return this;
    }

    public E findById(Object id) {
        return em.find(classe, id);
    }

    public E findByName(String name) {
        // Cria a consulta JPQL com um parâmetro nomeado ":name"
        String jpql = "SELECT e FROM " + classe.getSimpleName() + " e WHERE e.nome = :nome";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setParameter("nome", name);

        // Executa a consulta e retorna a lista de resultados
        return query.getSingleResult();
    }

    public List<E> findAll() {
        return em.createQuery("FROM " + classe.getName(), classe).getResultList();
    }

    public void delete(E entidade) {
        em.remove(entidade);
    }

    public E update(E entidade) {
        return em.merge(entidade);
    }

    public void fechar(){
        em.close();
    }

    public E findByModelo(String modelo) {
        String jpql = "SELECT e FROM " + classe.getSimpleName() + " e WHERE e.modelo = :modelo";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setParameter("modelo", modelo);

        return query.getSingleResult();
    }

}// Consume newline