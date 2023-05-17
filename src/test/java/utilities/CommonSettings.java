package utilities;

import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import lombok.Setter;

/**
 * This CommonSetting class help in generate results
 */
@Getter
@Setter
public class CommonSettings {

    @SuppressWarnings("rawtypes")
    private static AndroidDriver mdriver;
    private String appType;
    private String appEnvironment;
    private String projectName;
    private String emailOutput;
    private String emailId;
    private String htmlReport;
    private String xlsReport;
    private String testLogs;
    private String executionEnv;
    private String cloudProvider;
    private String hostName;
    private String key;
    private String remoteOS;
    private String buildNumber;
    private String browser;
    private String url;
    private String manageToolName;
    private String testlinkTool;
    private String testLinkHostName;
    private String testlinkAPIKey;
    private String testlinkProjectName;
    private String testlinkPlanName;
    private String jiraTestManagement;
    private String jiraTestCycleVersionName;
    private String jiraProjectID;
    private String bugToolName;
    private String bugTool;
    private String bugToolHostName;
    private String bugToolUserName;
    private String bugToolPassword;
    private String bugToolProjectName;
    private double androidVersion;
    private String androidName;
    private String androidID;
    private String androidBrowser;
    private double iosVersion;
    private String iosName;
    private String iosUDID;
    private String iosBrowser;
    private String paidPortalJiraCycleId;
    private String trinityJiraCycleId;
    private String chPortalJiraCycleId;
    private String paidAppAndroidJiraCycleId;
    private String paidAppiOSJiraCycleId;
    private String lyftAppiOSJiraCycleId;
    private String dasherDirectAppiOSJiraCycleId;
    private String taliPayAppiOSJiraCycleId;
    private String lyftAppAndroidJiraCycleId;
    private String dasherDirectAppAndroidJiraCycleId;
    private String taliPayAppAndroidJiraCycleId;
    private String email;
    private String password;


    /**
     * Instantiates a new Common settings.
     *
     * @param projectName    the project name
     * @param appType        the app type
     * @param appEnvironment the app environment
     * @param emailOutput    the email output
     * @param emailId        the email id
     * @param htmlReport     the html report
     * @param xlsReport      the xls report
     * @param testLogs       the test logs
     */
    public CommonSettings(String projectName, String appType, String appEnvironment, String emailOutput, String emailId,
                          String htmlReport, String xlsReport, String testLogs) {
        super();
        this.projectName = projectName;
        this.appType = appType;
        this.appEnvironment = appEnvironment;
        this.emailOutput = emailOutput;
        this.emailId = emailId;
        this.htmlReport = htmlReport;
        this.xlsReport = xlsReport;
        this.testLogs = testLogs;
    }

    /**
     * Instantiates a new Common settings.
     */
    public CommonSettings() {
        super();
    }

}
