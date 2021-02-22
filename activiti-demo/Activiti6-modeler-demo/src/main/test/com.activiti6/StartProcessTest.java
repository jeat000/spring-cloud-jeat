import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @auther ADun
 * @date 2020/7/23 14:50
 */
public class StartProcessTest {
    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void startProcess(){
        String processDefinitionId="MyProcess:1:7";
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinitionId);
        //从act_ru_exection中查询
        System.out.println("流程启动成功：\n"+"执行实例id："+processInstance.getId()
                +"\n流程定义id："+processInstance.getProcessDefinitionId()
                +"\n流程实例id："+processInstance.getProcessInstanceId());

    }

}
