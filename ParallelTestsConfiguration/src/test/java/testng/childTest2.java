package testng;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.testng.basetest;

public class childTest2 extends basetest {

	
    @BeforeMethod
    public void beforeChildMethod() {
        System.out.println("ChildClass's Before Test method");

        basetest.utils = new testng.ExcelUtils(filePath, "vesting");
    }
 
     
    @Test
    public void CtestCase1() throws IOException {
        System.out.println("===== Executing actual test 1 - Child 2 ======");
        
       System.out.println(test.java.testng.basetest.browserFactory.getDriver().getTitle());
       System.out.println("vesting ==> " + utils.getCellData(0, 1));
       
    }
    
    @Test
    public void CtestCase2() throws IOException {
        System.out.println("===== Executing actual test 2 - Child 2 ======");
        
        System.out.println(browserFactory.getDriver().getCurrentUrl());
        System.out.println("vesting  2 ==> " + utils.getCellData(0, 1));

    }
    
    
    @Test
    public void CtestCase3() {
        System.out.println("===== Executing actual test 3 - Child 2 ======");
       browserFactory.getDriver().navigate().to("https://staging.mystartupequity.com");
       
       System.out.println(browserFactory.getDriver().getTitle());

    }
}
