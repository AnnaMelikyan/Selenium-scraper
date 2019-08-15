import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScraperApplication {
    public static void main(String[] args) throws Exception {

        String str;
//        System.setProperty("webdriver.chrome.driver",)
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        Document document = Jsoup.connect("https://www.google.com/search?q=selenium+maven+dependency&oq=selenium+mave&aqs=chrome.0.0j69i57j0l4.7611j0j7&sourceid=chrome&ie=UTF-8").get();

        for (int i = 1; i<= 10; i++){
            Elements elements = document.select("div.r");
            for (Element element :elements){
                Elements a = element.getElementsByTag("a");
                for (Element element1 : a) {
                    String text1 = element1.select("h3.LC20lb").text();
                    String text2 = element1.select("cite.iUh30").text();
                    System.out.println(text1+" - "+text2);
                }
            }

            if (i > 1){
                str = "//a[@class='fl' and text()='"+i+"']";
                driver.findElement(By.xpath(str)).click();
                Thread.sleep(1500);
            }

        }
    }
}
