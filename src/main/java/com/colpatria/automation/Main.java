package com.colpatria.automation;

import com.colpatria.automation.test.TestPage;
import org.apache.log4j.BasicConfigurator;


/**
 *
 * @author Jose Aguirre
 */
public class Main {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        TestPage test = new TestPage();
        test.goToPage();
    }

}
