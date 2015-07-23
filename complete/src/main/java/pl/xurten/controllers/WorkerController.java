package pl.xurten.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.xurten.model.Worker;
import pl.xurten.repository.mongo.MongoWorkerRepository;
import pl.xurten.service.MovingWorkerService;
import pl.xurten.service.PrintWorkersServiceImpl;

import java.util.List;

@RestController
public class WorkerController
{
    @Autowired
    MongoWorkerRepository mongoWorkerRepository;

    @Autowired
    MovingWorkerService movingWorkerService;

    @Autowired
    PrintWorkersServiceImpl printWorkersService;

    public WorkerController()
    {

    }

    public WorkerController(MovingWorkerService movingWorkerService)
    {
        this.movingWorkerService = movingWorkerService;
    }

    @RequestMapping(value = "/workers",method = RequestMethod.GET)
    String getWorkers()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(Worker worker : mongoWorkerRepository.findAll())
        {
            stringBuilder.append(worker+"<br/>");
        }
        System.out.println(stringBuilder);
        return "We have "+String.valueOf(mongoWorkerRepository.findAll().size()) +" entries. <br/>" +"\n"+stringBuilder.toString();
    }

    @RequestMapping(value = "/workers/department",method = RequestMethod.GET)
    String getWorkersWithDepartment()
    {
        return printWorkersService.printAllWorkersInDepartments();
    }

    @RequestMapping(value = "/addworker",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody Worker addWorker(@RequestBody Worker inputWorker){
        Worker workerResult = mongoWorkerRepository.save(new Worker(inputWorker.getId(), inputWorker.getName(), inputWorker.getLastname(), inputWorker.getDepartmentId()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/addworker")
                .buildAndExpand(workerResult.getId()).toUri());
        return workerResult;
    }

    @RequestMapping(value = "/deleteworker",method = RequestMethod.GET)
    String deleteWorkerWithId(@RequestParam("id") String id)
    {
        System.out.println("PARAMETER = "+id);
        final List<Worker> all = mongoWorkerRepository.findAll();
        Worker worker = new Worker();
        for(Worker element:all)
            if (element.getId() == Integer.valueOf(id))
            {
                worker = element;
                break;
            }
        if(worker == null)
        {
            throw new IllegalArgumentException("Worker can not be null");
        }
        mongoWorkerRepository.delete(worker);
        return "Deleted worker with id = "+id;
    }

    @RequestMapping(value = "/updateworker",method = RequestMethod.GET)
    String updateWorker(@RequestParam("id") String id,@RequestParam("name") String name)
    {
        final List<Worker> all = mongoWorkerRepository.findAll();
        Worker worker = new Worker();
        for(Worker element:all)
            if (element.getId() == Integer.valueOf(id))
            {
                worker = element;
                break;
            }
        worker.setName(name);
        mongoWorkerRepository.save(worker);
        return "Updated worker with id = "+id;
    }

    @RequestMapping("/")
    String getName()
    {
        return "Project with Workers - Andrzej";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WorkerController.class, args);
    }
}
