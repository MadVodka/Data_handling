import services.DemoService;
import services.TextDemoService;

public class StartTextDemo {
    public static void main(String[] args) {
        DemoService demoService = new TextDemoService();
        demoService.run();
    }
}
