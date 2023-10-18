import java.util.List;

public class TXTConfigReader implements ConfigReader{
    List<String> config = null;
    @Override
    public List<String> getConfigs() {
        //assuming there would be config text file in resources which we could load here inside config.
        return config;
    }
}