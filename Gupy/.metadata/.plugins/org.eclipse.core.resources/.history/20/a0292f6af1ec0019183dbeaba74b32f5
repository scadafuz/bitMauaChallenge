package Support;
import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	

	public static  Properties getProp() 
    {
		try {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream("configs/config.properties");
        props.load(file);
        return props;
		}
		catch (Exception e) {
			return new Properties();
		}
      
    }
}
