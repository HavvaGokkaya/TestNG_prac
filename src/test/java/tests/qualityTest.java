package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QualityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class qualityTest {

    // Kullanici https://qualitydemy.com/ sayfasina gider
    // Siteye basarili bir sekilde giris yapar
    // sag taraf bulunan kullanici menusunden User Profile kismina gider
    // FirstName,Lastname,Biography, ve Linklerin kendine ait oldugunu dogrular
    // Bu kutucuklarda degisiklik yaparak kaydeder degisiklikleri dogrular

    QualityPage qualityPage = new QualityPage();

    @Test
    public void qualityProfilTest(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        qualityPage.loginMethod();
        ReusableMethods.bekle(7);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(qualityPage.kullaniciLogo).click(qualityPage.userProfile).build().perform();

        SoftAssert softAssert = new SoftAssert();
        String userName = qualityPage.profileNameBox.getAttribute("value");
        softAssert.assertTrue(userName.contains("nevzat"));
        String userLastName = qualityPage.profileLastNameBox.getAttribute("value");
        softAssert.assertTrue(userLastName.contains("celik"));

        Driver.getDriver().switchTo().frame(qualityPage.biographyiframe);
        String biographyBox = qualityPage.biographyBox.getText();

        softAssert.assertTrue(biographyBox.contains("wisequarter"));

        Driver.getDriver().switchTo().defaultContent();
        qualityPage.profileNameBox.clear();
        qualityPage.profileNameBox.sendKeys("fatih");

        qualityPage.profileLastNameBox.clear();
        qualityPage.profileLastNameBox.sendKeys("gokkaya");

        Driver.getDriver().switchTo().frame(qualityPage.biographyiframe);
        qualityPage.biographyBox.clear();
        qualityPage.biographyBox.sendKeys("techpro");

        Driver.getDriver().switchTo().defaultContent();
        Driver.closeDriver();


        softAssert.assertAll();


    }
}
