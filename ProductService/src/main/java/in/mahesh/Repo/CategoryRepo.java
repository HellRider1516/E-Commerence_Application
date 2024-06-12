package in.mahesh.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
