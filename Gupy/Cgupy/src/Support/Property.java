package Support;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	
	
	public static Properties getProp() throws IOException
    {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("configs/config.properties");
        props.load(file);
        return props;
      
    }
}
