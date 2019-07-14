import services.DemoService;
import services.DatesDemoServiceImpl;

public class StartDatesDemo {
    public static void main(String[] args) {
        DemoService demoService = new DatesDemoServiceImpl();
        demoService.run();
    }
}
