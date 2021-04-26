package ssm.test;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.ssm.filter.JWTUtils;

import io.jsonwebtoken.Claims;

public class JWTTest {

    @Test
    public void demo() {
        try {
            JSONObject subject = new JSONObject(true);
            subject.put("tem", "哈哈哈");
            subject.put("userName", "sixmonth");
            String token = JWTUtils.createJWT("dsadaa1dsadsada", subject.toJSONString(), 1000);//10秒过期
            //System.out.println(token);
            Claims claims = JWTUtils.parseJWT(token);
            System.out.println("解析jwt：" + claims.getSubject());
            JSONObject tem = JSONObject.parseObject(claims.getSubject());
            System.out.println("获取json对象内容：" + tem.getString("userName"));

            System.out.println(claims.getExpiration().getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
