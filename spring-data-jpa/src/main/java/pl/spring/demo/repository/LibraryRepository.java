package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.LibraryEntity;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

	@Query("select lib from LibraryEntity lib where upper(lib.name) like concat(upper(:name), '%')")
	public List<LibraryEntity> findLibraryByName(@Param("name") String name);

}