import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.fedinskiy.spring.AppConfig;
import ru.fedinskiy.spring.DataHandler;

/**
 * Created by fedinskiy on 01.03.17.
 */
public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		DataHandler dataHandler= ctx.getBean(DataHandler.class);//("dataHandler");;
		dataHandler.handleData("","");
	}
}
