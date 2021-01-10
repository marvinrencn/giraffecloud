package cn.ren.marvinren.giraffe.test;

import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author ：marvin ren
 * @date ：Created in 12/31/2020 4:46 PM
 * @description：
 * @modified By：
 * @version: 1.0
 */
@RunWith(Karate.class)
@CucumberOptions(features = "classpath:demo.feature")
public class DemoRunner {

}
