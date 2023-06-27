package stepDefinitions.WWPiOS;

import io.cucumber.java.en.When;
import utilities.DriverUtil;

import java.util.HashMap;

public class Login {
    public static HashMap<String ,String> dataMap = new HashMap<>();
    // @Given("Read the data {string} from excel files")
//    public void readTheDataFromExcelFiles(String ID) {
//        try {
//            dataMap = ExcelDataUtil.getTestDataWithTestCaseID("WelMart", ID);
//            System.out.println(dataMap);
//        } catch (Throwable e) {
//            GlobalUtil.e = e;
//            GlobalUtil.errorMsg = e.getMessage();
//            Assert.fail(e.getMessage());
//        }
//
//    }
    @When("User launches the application on iOS {string}")
    public void userLaunchesTheApplicationOniOS(String deviceName) {
        DriverUtil.invokeLocaliOSApp(deviceName);
    }
}
