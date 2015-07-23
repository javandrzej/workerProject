package pl.xurten.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.xurten.model.Department;
public interface MongoDepartmentRepository extends MongoRepository<Department,String>
{

}
