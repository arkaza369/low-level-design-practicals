import java.util.List;

public class XMLConfigReader implements ConfigReader{
    List<String> config = null;
    @Override
    public List<String> getConfigs() {
        //assuming there would be xml config file in resources which we could load here inside config list.
        return config;
    }
}