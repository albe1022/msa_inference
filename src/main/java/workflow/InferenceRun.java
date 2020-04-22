package workflow;

public class InferenceRun extends AbstractEvent {

    private Long id;
    private Long processedDataId;
    private String inferenceResult;

    public InferenceRun(){
        super();
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
