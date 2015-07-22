package pl.xurten.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.xurten.model.Department;
public interface DepartmentRepository extends MongoRepository<Department,String>
{

}
