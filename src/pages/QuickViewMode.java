package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.Log;


public class QuickViewMode extends BasePage {

    public QuickViewMode(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********


    public void isOnQuickViewMode(){

    }

    public String getPriceProductInQuickView(){
        String s = null;
        return s;
    }

    public String getNameProductInQuickView(){
        String s = null;
        return s;
    }

    public boolean isPriceDisplayCorrectly(String orgPrice){
        boolean b = true;
        return b;
    }

    public boolean isNameDisplayCorrectly(String orgName){
        boolean b = true;
        return b;
    }

    public boolean isMinusIconWorkingCorrectly(){
        boolean b = true;
        return b;
    }

    public boolean isPlusIconWorkingCorrectly(){
        boolean b = true;
        return b;
    }

    public int getValueInQuantityField(){
        int i = 0;
        return i;
    }

    public void writeNumberInQuantityField(){
    }

}
