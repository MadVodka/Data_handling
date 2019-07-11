import services.DemoService;
import services.DemoServiceImpl;

public class Start {
    public static void main(String[] args) {
        DemoService demoService = new DemoServiceImpl();
        demoService.run();
    }
}
