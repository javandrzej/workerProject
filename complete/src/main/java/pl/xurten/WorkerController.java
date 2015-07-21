package pl.xurten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class WorkerController
{
    @Autowired WorkerRepository workerRepository;

    @RequestMapping(value = "/workers",method = RequestMethod.GET)
    String getWorkers()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(Worker worker : workerRepository.findAll())
        {
            stringBuilder.append(worker+"<br/>");
        }
        System.out.println(stringBuilder);
        return "We have "+String.valueOf(workerRepository.findAll().size()) +" entries. <br/>" +"\n"+stringBuilder.toString();
    }

    @RequestMapping(value = "/addworker",method = RequestMethod.POST)
    ResponseEntity<?> addWorkers(@RequestBody Worker inputWorker){
        final Worker workerResult = workerRepository.save(new Worker(inputWorker.getId(), inputWorker.getName(), inputWorker.getLastname(), inputWorker.getDepartmentId()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/addworker")
                .buildAndExpand(workerResult.getId()).toUri());
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deleteworkerwithid",method = RequestMethod.DELETE)
    ResponseEntity<?> deleteWorkerWithId(int id)
    {
        workerRepository.delete(String.valueOf(id));
        return new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
    }

    @RequestMapping("/worker")
    String getWorker()
    {
        return "String worker ..";
    }

    @RequestMapping("/")
    String getName()
    {
        return "Andrzej";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WorkerController.class, args);
    }
}
