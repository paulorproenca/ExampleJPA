package repository.Shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public class BaseRepository <T,K> implements IBaseRepository<T,K> {

    private EntityManager entityManager;
    private final Class<K> entityClass;

    public BaseRepository(final EntityManager theEntityManager){
        this.entityManager = theEntityManager;
        ParameterizedType genericSuperclass = (ParameterizedType)this.getClass().getGenericSuperclass();
        this.entityClass = (Class)genericSuperclass.getActualTypeArguments()[0];
    }

    public <S extends K> S save(final S entity) {
        try {
            return this.entityManager.merge(entity);
            /*
            EntityTransaction tx = this.entityManager.getTransaction();
            tx.begin();
            this.entityManager.merge(entity);
            tx.commit();
            this.entityManager.close();
            return entity;
             */
        } catch (PersistenceException e) {
            throw this.handlePersistenceException(e);
        }
    }

    public Iterable<K> findAll() {
        return this.entityManager
                .createQuery("SELECT e FROM " + this.entityClass.getSimpleName() + " e ",this.entityClass)
                .getResultList();
    }

    public void delete(K entity) {
        try {
             entity = this.entityManager.merge(entity);
             this.entityManager.remove(entity);
        }catch (PersistenceException e) {
            throw this.handlePersistenceException(e);
        }
    }


    public Optional<K> findById(final T id) {
        return null;
    }

    private RuntimeException handlePersistenceException(final PersistenceException ex) {
        if (ex.getCause() instanceof OptimisticLockException) {
            throw new RuntimeException(ex);
        } else if (!(ex.getCause() instanceof EntityExistsException) && !(ex.getCause() instanceof RuntimeException)) {
            throw ex;
        } else {
            throw new RuntimeException(ex);
        }
    }
}
