package Support;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * Controle das Propriedades do Projeto.
 * 
 * @author Bruno Viana Lopes
 * @version 0.0.1
 */
public class Property {
	
	 /**
	  * Carrega as propriedades localizada configs/config.properties
	  * @return Objeto com as Propriedades do Projeto
	  */
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
