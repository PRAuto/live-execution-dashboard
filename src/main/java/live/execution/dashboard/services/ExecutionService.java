package live.execution.dashboard.services;

import live.execution.dashboard.beans.Execution;
import live.execution.dashboard.repositories.ExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ExecutionService {

	@Autowired
	private ExecutionRepository executionRepository;

    public List<Execution> getAllExecution(){
        return executionRepository.findAll();
    }

    public Execution getExecutionByID(int id){
    	List<Execution> executions = executionRepository.findAll();
    	Execution execution = null;
    	for(Execution con:executions) {
    		if(con.getId() == id) {
                execution = con;
    		}
    	}
        return execution;
    }

    public Execution addExecution(Execution country){
        country.setId(getMaxExecutionID());
        executionRepository.save(country);
        return country;
    }

    public int getMaxExecutionID(){
    	return executionRepository.findAll().size()+1;
    }

    public int getMaxExecutionID1(){
        return executionRepository.findAll().size()+1;
    }

}
