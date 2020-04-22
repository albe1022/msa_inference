package workflow;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="InferenceResult_table")
public class InferenceResult {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long processedDataId;
    private String inferenceResult;

    @PostPersist
    public void onPostPersist(){
        InferenceRun inferenceRun = new InferenceRun();
        BeanUtils.copyProperties(this, inferenceRun);
        inferenceRun.setInferenceResult("success");
        inferenceRun.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getProcessedDataId() {
        return processedDataId;
    }

    public void setProcessedDataId(Long processedDataId) {
        this.processedDataId = processedDataId;
    }
    public String getInferenceResult() {
        return inferenceResult;
    }

    public void setInferenceResult(String inferenceResult) {
        this.inferenceResult = inferenceResult;
    }




}
