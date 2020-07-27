package wang.ismy.htmlcachesystem.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MY
 * @date 2020/7/27 15:50
 */
@Service
public class HealthService {

    public Map<String,String> getHealthState() throws IOException {
        var list = List.of("local","192.168.1.101","192.168.1.110");

        Map<String,String> map = new HashMap<>();
        for (String s : list) {
            InetAddress inetAddress = InetAddress.getByName(s);
            if (inetAddress.isReachable(3000)){
                map.put(s,"reachable");
            }else {
                map.put(s,"unreachable");
            }
        }
        return map;
    }
}
