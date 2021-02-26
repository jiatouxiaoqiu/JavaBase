package cn.ebing.dog.api.utils.io;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BIO {
  /**
   * 如果不序列化，会报错，如下：Caused by: java.io.NotSerializableException: cn.ebing.dog.api.utils.io.BIO$User
   * 所以要序列化
   */
  public static class User implements Serializable {
        private String name;
        private String sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

      @Override
      public String toString() {
          return "name: " + this.name + " ;sex: " + this.sex;
      }
  }

    public static void readFile(String filepath) {
        File file = new File(filepath);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
            System.out.println(newUser);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
//            try {
//                FileUtils.forceDelete(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void writeFile(String filepath) {
        User user = new User();
        user.setName("name");
        user.setSex("sex1");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filepath));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }
    }

    public static void main(String[] args) {
        String filepath = "/Users/mx/Documents/java/dog_api/src/main/java/cn/ebing/dog/api/utils/io/bio.text";
        writeFile(filepath);
        readFile(filepath);
    }
}
