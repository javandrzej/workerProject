package pl.xurten.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import pl.xurten.model.Worker;
public interface JpaWorkerRepository extends CrudRepository<Worker,String>
{

}
