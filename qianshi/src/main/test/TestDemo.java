import com.itdr.controller.UserController;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserController bean = ac.getBean(UserController.class);

        String wyy = bean.register("wyy", "123456","牛",5,"双子座");
        if(wyy == "注册成功"){
            String wyy1 = bean.login("wyy", "123456");
            if(wyy1 == "登陆成功"){
                String mingzi = bean.mingzi("牛", 5, "双子座");
                System.out.println(mingzi);
            }
        }
    }
}
