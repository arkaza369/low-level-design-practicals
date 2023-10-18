import java.util.List;

public class ConfigReaderContext {
    ConfigReader configReader;
    public void setConfigReader(ConfigReader configReader){
        this.configReader = configReader;
    }
    public List<String> getConfigs(){
        return configReader.getConfigs();
    }
}