package mum.edu.cs544.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mum.edu.cs544.model.Brand;


public interface BrandRepository extends CrudRepository<Brand, Integer> {

	void delete(int brandId);

	List<Brand> findAll();

	Brand findOne(int brandId);

	Brand save(Brand persisted);

}
