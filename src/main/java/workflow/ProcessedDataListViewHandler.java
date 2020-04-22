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
public class ProcessedDataListViewHandler {


    @Autowired
    private ProcessedDataListRepository processedDataListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDataPreprocessed_then_CREATE_1 (@Payload DataPreprocessed dataPreprocessed) {
        try {
            if (dataPreprocessed.isMe()) {
                // view 객체 생성
                ProcessedDataList processedDataList = new ProcessedDataList();
                // view 객체에 이벤트의 Value 를 set 함
                processedDataList.setId(dataPreprocessed.getId());
                processedDataList.setDataType(dataPreprocessed.getDataType());
                // view 레파지 토리에 save
                processedDataListRepository.save(processedDataList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}