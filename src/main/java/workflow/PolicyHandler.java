package workflow;

import workflow.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired
    private InferenceResultRepository inferenceResultRepository;
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDataPreprocessed_StartInference(@Payload DataPreprocessed dataPreprocessed){

        if(dataPreprocessed.isMe()){
            System.out.println("##### listener StartInference : " + dataPreprocessed.toJson());
            InferenceResult inferenceResult = new InferenceResult();
            inferenceResult.setProcessedDataId(dataPreprocessed.getId());
            inferenceResultRepository.save(inferenceResult);
        }
    }

}
