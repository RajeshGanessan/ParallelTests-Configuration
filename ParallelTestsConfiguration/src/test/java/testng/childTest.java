package testng;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class childTest extends basetest {

	
    @BeforeMethod
    public void beforeChildMethod() {
        System.out.println("ChildClass's Before Test method");
        
//        	utils = new ExcelUtils(filePath, "google");
    }
 
     
    @Test
    public void testCase1() throws IOException {
        System.out.println("===== Executing actual test 1 ======");
        
       System.out.println(browserFactory.getDriver().getTitle());
//       System.out.println(utils.getCellData(0, 1));
    }
    
    @Test
    public void testCase2() throws IOException {
        System.out.println("===== Executing actual test 2 ======");
        
        System.out.println(browserFactory.getDriver().getCurrentUrl());
//        System.out.println(utils.getCellData(0, 1));

    }
    
    
    @Test
    public void testCase3() {
        System.out.println("===== Executing actual test 3 ======");
       browserFactory.getDriver().navigate().to("https://staging.mystartupequity.com");
       
       System.out.println(browserFactory.getDriver().getTitle());

    }
}
