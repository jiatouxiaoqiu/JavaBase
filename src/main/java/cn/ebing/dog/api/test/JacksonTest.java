package cn.ebing.dog.api.test;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 */
public class JacksonTest {
    public static void main(String[] args) throws Exception {
        Writer wanger = new Writer("name", 18);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(wanger);
        System.out.println(jsonString);

    /**
     * PS：如果反序列化的对象有带参的构造方法，它必须有一个空的默认构造方法，否则将会抛出 InvalidDefinitionException 一行。
     */
    String jsonString2 = "{\n" + "  \"name\" : \"嘻嘻\",\n" + "  \"age\" : 18\n" + "}";
        Writer deserializedWriter = mapper.readValue(jsonString2, Writer.class);
        System.out.println(deserializedWriter);
    }
}

class Writer {
    private String name;
    private int age;

    // 需要一个默认的构造函数，才能反序列化？？？？
    public Writer() {
    }

    public Writer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}