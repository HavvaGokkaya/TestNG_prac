package tests;

import org.testng.annotations.Test;
import pages.iiensitu.AnaSayfa;
import utilities.ConfigReader;
import utilities.Driver;

public class test01 {
    // Kullanici https://www.iienstitu.com/en sayfasina gider
    // Login butonuna tiklar
    // Giris bilgilerini girer ve basarili sekilde giris yaptigini test eder
    // headers da bulunan egitimler kismina tiklar
    // acilan egitimler sayfasindan fiyat araligi olarak artan fiyat olarak secer
    // ucretsiz egitimlerden herhangi birini alir
    // kimlik dogrulama islemlerini girer
    // egitimin ucretsiz oldugunu test eder ve siparisi tamamlar.

    AnaSayfa anaSayfa = new AnaSayfa();
    @Test
    public void girisTest(){
        Driver.getDriver().get("https://www.iienstitu.com/en");
        anaSayfa.loginButtonHomePage.click();
        anaSayfa.username.sendKeys(ConfigReader.getProperty("email"));
        anaSayfa.password.sendKeys(ConfigReader.getProperty("password"));
        anaSayfa.submitButton.click();
    }
}
