
package workflow;

public class DataPreprocessed extends AbstractEvent {

    private Long id;
    private Long RawDataID;
    private String DataType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRawDataId() {
        return RawDataID;
    }

    public void setRawDataId(Long RawDataID) {
        this.RawDataID = RawDataID;
    }
    public String getDataType() {
        return DataType;
    }

    public void setDataType(String DataType) {
        this.DataType = DataType;
    }
}
