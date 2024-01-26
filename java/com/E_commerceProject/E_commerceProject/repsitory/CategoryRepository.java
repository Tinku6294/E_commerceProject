package com.E_commerceProject.E_commerceProject.repsitory;

import com.E_commerceProject.E_commerceProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
