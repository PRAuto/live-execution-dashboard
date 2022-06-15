package live.execution.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import live.execution.dashboard.beans.Execution;

public interface ExecutionRepository extends JpaRepository<Execution, Integer>{
	//also called as data access object DAO

}
