package demo;

import org.testng.annotations.Test;

public class NewTest {
  @Test(groups = "smoke")
  public void f() {
	  System.out.println("Demo Test");
  }
}
