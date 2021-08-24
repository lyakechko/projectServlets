package com.example.demo.DAO;

import com.example.demo.DBO.Administrator;
import com.example.demo.DBO.UserInfo;
import com.example.demo.HibernateUtil.HibernateEntityManager;
import org.hibernate.jpa.QueryHints;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

public class CreateObjects {

    static EntityManager entityManager = HibernateEntityManager.getEntityManager();

    public static void saveUser(Map<String, String> map) {
        if (Objects.nonNull(map)) {
            boolean resident = "1".equals(map.get("resident"));
            entityManager.getTransaction().begin();
            entityManager.persist(UserInfo.builder().login(map.get("login")).name(map.get("name"))
                    .surname(map.get("surname")).password(map.get("password")).
                            resident(resident).timeLastAction(System.currentTimeMillis()).build());
            entityManager.getTransaction().commit();
        } else {
            System.out.println("Пустая мапка");
        }
    }

    public static void saveAdministrator(Map<String, String> map) {
        if (Objects.nonNull(map)) {
            boolean resident = "1".equals(map.get("resident"));
            entityManager.getTransaction().begin();
            entityManager.persist(Administrator.builder().login(map.get("login")).name(map.get("name"))
                    .surname(map.get("surname")).password(map.get("password")).resident(resident).
                            codeAdministrator(map.get("codeForAdmin")).timeLastAction(System.currentTimeMillis())
                    .build());
            entityManager.getTransaction().commit();
        } else {
            System.out.println("Пустая мапка");
        }
    }

    public static Set<UserInfo> getUserInfoList() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserInfo> personCriteria = cb.createQuery(UserInfo.class);
        Root<UserInfo> personRoot = personCriteria.from(UserInfo.class);
        personCriteria.select(personRoot);
        return new HashSet<>(entityManager.createQuery(personCriteria).getResultList());
    }

    public static void updateUserInfo(UserInfo userInfo) {
        EntityManager manager = HibernateEntityManager.getEntityManager();
        manager.merge(userInfo);
    }
    public static List<UserInfo> userInfoList(int pageNumber,int pageSize) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserInfo> criteria = cb.createQuery(UserInfo.class);
        criteria.from(UserInfo.class);
        TypedQuery <UserInfo> typedQuery = entityManager.createQuery(criteria);
        typedQuery.setFirstResult(pageSize * (pageNumber - 1));
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();
    }

}
