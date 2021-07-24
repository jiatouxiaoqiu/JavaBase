package cn.ebing.dog.api.test;

import cn.ebing.dog.api.domain.entity.UserEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qhb
 * @Date 2021/7/22 11:13 上午
 * @Version 1.0
 */
public class FastJsonTest {
  public static void main(String[] args) {
      /**
       * 2021年07月22日14:37:55
       *
       * 好大一个坑，大驼峰在 JDK 1.6 是ok的，但是在 JDK 1.8 是不ok的，需要下载一个 JDK 1.7 试试
       *
       */

      /**
       * @time 2021年07月23日16:44:32
       *
       * 奇葩代码说明：
       *
       * 起因：
       * 1、发现在 branch 环境下， json 库不能用（没发现原因），使用了 fastjson gson 等，均不行，日志会被吃掉，没报错
       * 2、ETP -> csr 中，一个报文只允许一个 record（数组）
       *
       * 做法：
       * 步骤1、第三方 -> ETP 的转化：
       *    1 各种 split 和 substring 拆分，变成[[]],
       *    2 set 到 map 中做 key value，
       *    3 最后得到 List<BillInfo>
       *
       * 步骤2、ETP -> csr 中，一个报文只允许一个 record（数组），所以这依然需要再转化一下
       *    1 List<BillInfo> 通过 toString() 方法和遍历，使用特殊的 | # 符号作为隔断
       *    2 拿到前端后，再 split 变成数组展示
       *
       * 所以，这份代码，是很特殊的，CCS（第三方系统）、ETP CSR 这3个工程都有特殊约定，
       * 如果有变动，这3个工程都需要变动，需要CCS的联调。仔细阅读代码即可，代码复杂恶心但不难。
       *
       *
       */
      List<UserEntity> list = new ArrayList<>();
      UserEntity user = new UserEntity("NAME", 1, true);
      list.add(user);

      Gson gson = new Gson();
      String userJson = gson.toJson(list);
      System.out.println(userJson);

      List<UserEntity> resultList = gson.fromJson(userJson, new TypeToken<List<UserEntity>>(){}.getType());
      resultList.size();
  }
}
