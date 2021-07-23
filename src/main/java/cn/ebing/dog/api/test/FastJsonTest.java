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
