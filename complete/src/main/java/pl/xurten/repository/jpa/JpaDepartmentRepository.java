package pl.xurten.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import pl.xurten.model.Department;
public interface JpaDepartmentRepository extends CrudRepository<Department,String>
{

}
