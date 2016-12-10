package mum.edu.cs544.service;

import java.util.List;

import mum.edu.cs544.model.Brand;

//import com.finalproject.model.Brand;

//import model.Brand;

public interface BrandService {
	public List<Brand> getbrands();

	public void saveBrand(Brand brand);

	public Brand getBrand(int brandId);

	public void deleteBrand(int brandId);

}
