package com.mssql.web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyohinDataEntityRepository extends JpaRepository<SyohinDataEntity, Integer> {
	List<SyohinDataEntity> findBy_SyohinCode(Short find);
}
