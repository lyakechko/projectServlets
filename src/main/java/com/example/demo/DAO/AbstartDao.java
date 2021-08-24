package com.example.demo.DAO;

import com.example.demo.HibernateUtil.HibernateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstartDao<T, PK extends Serializable> implements IDao<T, PK> {
    protected Class<T> type;

    @PersistenceContext(unitName = "item-manager")
    private EntityManager entityManager;

    public AbstartDao() {
        Type genericSuperClass = getClass().getGenericSuperclass();
        if (genericSuperClass instanceof ParameterizedType) {
            this.type = (Class<T>) ((ParameterizedType) genericSuperClass).getActualTypeArguments()[0];
        }
    }

    public T findById(Integer id) {
        final T result;
        return  entityManager.find(type, id);
    }
}
