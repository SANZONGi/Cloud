import com.demo.entity.Admin;
import com.demo.http.HttpClientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpClientApplication.class)
public class test {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextTest(){
        String url = "http://10.21.206.218:8080/ssm/selectById/1";
        Admin admin = restTemplate.getForObject(url,Admin.class);
        System.out.println(admin);
    }
}
