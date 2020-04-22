package workflow;

import workflow.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProcessedDataViewHandler {


    @Autowired
    private ProcessedDataRepository processedDataRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDataPreprocessed_then_CREATE_1 (@Payload DataPreprocessed dataPreprocessed) {
        try {
            if (dataPreprocessed.isMe()) {
                // view 객체 생성
                ProcessedData processedData = new ProcessedData();
                // view 객체에 이벤트의 Value 를 set 함
                processedData.setId(dataPreprocessed.getId());
                processedData.setDataType(dataPreprocessed.getDataType());
                // view 레파지 토리에 save
                processedDataRepository.save(processedData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}