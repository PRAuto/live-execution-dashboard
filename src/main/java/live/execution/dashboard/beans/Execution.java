package live.execution.dashboard.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="execution")
public class Execution {

	@Id
	@Column(name="id")
    private int id;

    @Column(name="execution_id")
    private String executionID;

	@Column(name="testcase_name")
    private String testcaseName;
	
	@Column(name="execution_status")
    private String executionStatus;

    @Column(name="execution_date")
    private String executionDate;

   public Execution() {
	   
   }

    public Execution(int id, String executionID, String testcaseName, String executionStatus, String executionDate) {
        this.id = id;
        this.executionID = executionID;
        this.testcaseName = testcaseName;
        this.executionStatus = executionStatus;
        this.executionDate = executionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExecutionID() {
        return executionID;
    }

    public void setExecutionID(String executionID) {
        this.executionID = executionID;
    }

    public String getTestcaseName() {
        return testcaseName;
    }

    public void setTestcaseName(String testcaseName) {
        this.testcaseName = testcaseName;
    }

    public String getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

}
