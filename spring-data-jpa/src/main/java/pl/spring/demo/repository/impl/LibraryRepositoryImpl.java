package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.repository.LibraryRepository;

public class LibraryRepositoryImpl extends AbstractRepository<LibraryEntity, Long> implements LibraryRepository {

	@Override
	public List<LibraryEntity> findLibraryByName(String name) {
		TypedQuery<LibraryEntity> query = entityManager.createQuery(
				"select lib from LibraryEntity lib where upper(lib.name) like concat(upper(:name), '%')",
				LibraryEntity.class);
		query.setParameter("name", name);
		return query.getResultList();
	}

}
