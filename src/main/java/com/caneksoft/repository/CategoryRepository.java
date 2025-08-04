package com.caneksoft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.caneksoft.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>
{

}
