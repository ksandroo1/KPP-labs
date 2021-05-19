package com.epam.labs.repository;

import com.epam.labs.dto.YearDto;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface YearDtoRepository extends CrudRepository<YearDto,Integer> {
}
