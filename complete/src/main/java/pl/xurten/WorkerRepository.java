package pl.xurten;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface WorkerRepository extends MongoRepository<Worker,String>
{
    public List<Worker> findByName(String name);
}
