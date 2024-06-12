package in.mahesh.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Products;

public interface ProductRepo extends JpaRepository<Products, Integer>{

}
