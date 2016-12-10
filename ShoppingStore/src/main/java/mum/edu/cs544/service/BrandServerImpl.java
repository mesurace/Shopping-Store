package mum.edu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.cs544.model.Brand;
import mum.edu.cs544.repository.BrandRepository;



@Service
public class BrandServerImpl implements BrandService {
	
	@Autowired	
	private BrandRepository brandDAO;

	@Override
	@Transactional
	public List<Brand> getbrands() {
		
		return  brandDAO.findAll();
	}

	@Override
	@Transactional
	public void saveBrand(Brand brand) {
		brandDAO.save(brand);
	}

	@Override
	@Transactional
	public Brand getBrand(int brandId) {
	
		return brandDAO.findOne(brandId);
	}

	@Override
	@Transactional
	public void deleteBrand(int brandId) {
		brandDAO.delete(brandId);

	}

}
