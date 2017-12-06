package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import apitest.FareSearchTest2;
import apitest.LocationListTest1;

@RunWith(Suite.class)
@Suite.SuiteClasses({ LocationListTest1.class, FareSearchTest2.class, })
public class TestExecutor {

}
