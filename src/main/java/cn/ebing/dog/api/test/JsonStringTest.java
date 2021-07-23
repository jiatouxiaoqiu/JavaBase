package cn.ebing.dog.api.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author qhb
 * @Date 2021/7/22 11:13 上午
 * @Version 1.0
 */
public class JsonStringTest {

    /**
     * JSON库感觉有问题，自己处理 json ，自定义格式，比较特殊，不推荐重复使用
     */
    private static List<Map<String, String>> json2list(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length <= 4) {
            return null;
        }
        // substring 去掉[{ 和 }]
        String str1 = removeSameStartEnd(str, 2);
        String[] strs = str1.split("},\\{");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (int i = 0; i < strs.length; i++) {
            String[] arrayString = strs[i].trim().split(",");
            Map<String, String> map = new HashMap<String, String>();
            for (int j = 0; j < arrayString.length; j++) {
                  String[] keyValues = arrayString[j].trim().split("\":\"");
                  // 去掉 "
                  String key = removeSameStartEnd(keyValues[0], 1);
                  String value = removeSameStartEnd(keyValues[1], 1);
                  map.put(key, value);
            }
            list.add(map);
        }
        return list;
    }

    /**
     * 去除头部和尾部
     * @param str
     * @param offset
     * @return
     */
    private static String removeSameStartEnd(String str, int offset) {
        return str.trim().substring(offset, str.length()-offset).trim();
    }

  public static void main(String[] args) {
      String str = "[{\"merchantId\": \"id\", \"merchantName\": \"name\"}]";
    String str2 = "[{\"merchantId\": \"id\", \"merchantName\": \"name\"},{\"merchantId\": \"id\", \"merchantName\": \"name\"}]";
    String str3 =
        "[{\"merchantId\": \"id\", \"merchantName\": \"name\"},{\"merchantId\": \"id\", \"merchantName\": \"name\"},{\"merchantId\": \"id\", \"merchantName\": \"name\"}]";

      json2list(str2);
      System.out.println(str);
  }
}
