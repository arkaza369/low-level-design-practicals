import java.util.List;

public class JSONCOnfigReader implements ConfigReader{
    List<String> config = null;
    @Override
    public List<String> getConfigs() {
        //assuming there would be json config file in resources which we could load here inside config.
        return config;
    }
}