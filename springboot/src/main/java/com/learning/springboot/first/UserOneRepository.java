package com.learning.springboot.first;

import org.springframework.data.repository.CrudRepository;

public interface UserOneRepository extends CrudRepository<UserOne, Long> {
}
