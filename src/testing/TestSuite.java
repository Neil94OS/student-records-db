package testing;


import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)

@SuiteClasses(value={
   JunitTest.class,
   JunitTest2.class,
   JunitTest3.class
})

public class TestSuite {

}

