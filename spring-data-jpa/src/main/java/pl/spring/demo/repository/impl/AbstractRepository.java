package pl.spring.demo.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractRepository<T, K extends Serializable> implements JpaRepository<T, K> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> domainClass;

	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(getDomainClass());
		criteriaQuery.from(getDomainClass());
		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<T> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll(Iterable<K> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		entityManager.persist(entity);
		flush();
		return entity;
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public T getOne(K id) {
		return entityManager.getReference(getDomainClass(), id);
	}

	@Override
	public Page<T> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return (long) entityManager.createQuery("Select count(*) from " + getDomainClassName()).getSingleResult();
	}

	@Override
	public void delete(K id) {
		 entityManager.remove(getOne(id));

	}

	@Override
	public void delete(T entity) {
		 entityManager.remove(entity);

	}

	@Override
	public void delete(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		entityManager.createQuery("delete " + getDomainClassName()).executeUpdate();
	}

	@Override
	public boolean exists(K id) {
		return findOne(id) != null;
	}

	@Override
	public T findOne(K id) {
		return entityManager.find(getDomainClass(), id);
	}

	@Override
	public <S extends T> S save(S entity) {
		entityManager.persist(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class<T>) type.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	protected String getDomainClassName() {
		return getDomainClass().getName();
	}

}
