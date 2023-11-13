package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features="D:\\Users\\Hp\\eclipse-workspace\\Guruschools13-maven\\src\\test\\java\\feature\\tester.feature",
		features="/home/ubuntu/Desktop/project/My vlab projects/JPetStoreProject/src/test/java/features/login.feature",
		glue="stepDef",
		//plugin = {"pretty","html:target/HTML_Reports"},
		//plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true
	)


public class Run {

}
///home/ubuntu/eclipse-workspace/JPetStoreProject/src/test/java/feature/login.feature