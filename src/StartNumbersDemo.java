import services.DemoService;
import services.NumbersDemoServiceImpl;

public class StartNumbersDemo {
    public static void main(String[] args) {
        DemoService demoService = new NumbersDemoServiceImpl();
        demoService.run();
    }
}
