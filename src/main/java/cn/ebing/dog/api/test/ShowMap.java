package cn.ebing.dog.api.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @Author qhb
 * @Date 2021/7/20 9:30 下午
 * @Version 1.0
 */
public class ShowMap {

  public static void main(String[] args) {
    Map<String, Object> map = new HashMap<>();
    List<Integer> dValue = new ArrayList<>();
      dValue.add(1);
      dValue.add(null);
      dValue.add(3);

      Map<String, Object> aValue = new HashMap<>();
      List<Object> abValue = new ArrayList<>();
      abValue.add("v");
      abValue.add(2);
      aValue.put("b", abValue);

      map.put("a", aValue);
      map.put("d", dValue);

      Set<String> set = showMap(map);
      System.out.println(set);
//      {"a":{"b":["v",2,{"c":0}]},"d":[1,null,3]}
  }

    public static Set<String> showMap(Map<String, Object> map) {
        HashSet<String> strings = new HashSet<>();
        for (String s : map.keySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            Object obj = map.get(s);
            if (obj instanceof String || obj instanceof Number){
                stringBuilder.append("=").append(obj);
                strings.add(stringBuilder.toString());
            } else if(obj instanceof Object[] || obj.getClass().isArray()){
                showArray(strings, stringBuilder, (Object[]) obj);
            } else if(obj instanceof List){
                showList(strings, stringBuilder, (List<Object>) obj);
            } else {
                showMap(strings,stringBuilder,(Map<String, Object>) obj);
            }
        }
        return strings;
    }

    private static void showArray(HashSet<String> strings, StringBuilder stringBuilder, Object[] obj) {
        Object[] objects= obj;
        String str="";
        for (int i = 0; i < objects.length; i++) {
            str=stringBuilder.toString();
            stringBuilder.append("[").append(i).append("]");
            Object object = objects[i];
            if (object instanceof String || object instanceof Number || object==null){
                stringBuilder.append("=").append(object);
                strings.add(stringBuilder.toString());
            } else if (object instanceof Map) {
                showMap(strings, stringBuilder, (Map<String, Object>) object);
            } else if(object instanceof List){
                showList(strings, stringBuilder, (List<Object>) object);
            } else {
                showArray(strings,stringBuilder,(Object[]) object);
            }
            stringBuilder=new StringBuilder(str);
        }
    }

    private static void showList(HashSet<String> strings, StringBuilder stringBuilder, List<Object> obj) {
        String str="";
        for (int i = 0; i < obj.size(); i++) {
            str=stringBuilder.toString();
            stringBuilder.append("[").append(i).append("]");
            Object object = obj.get(i);
            if (object instanceof String || object instanceof Number || object==null){
                stringBuilder.append("=").append(object);
                strings.add(stringBuilder.toString());
            }else if (object instanceof Map){
                showMap(strings, stringBuilder, (Map<String, Object>) object);
            }else {
                showArray(strings,stringBuilder,(Object[]) object);
            }
            stringBuilder=new StringBuilder(str);
        }
    }

    private static void showMap(HashSet<String> strings, StringBuilder stringBuilder, Map<String, Object> hashMap) {
        for (String ss : hashMap.keySet()) {
            stringBuilder.append(".").append(ss);
            Object object = hashMap.get(ss);
            if (object instanceof String || object instanceof Number){
                stringBuilder.append("=").append(object);
                strings.add(stringBuilder.toString());
            } else if (object instanceof Object[]){
                showArray(strings,stringBuilder,(Object[]) object);
            } else if (object instanceof List){
                showList(strings,stringBuilder,(List<Object>) object);
            } else {
                showMap(strings,stringBuilder, (Map<String, Object>) object);
            }
        }
    }

    public static void addSet(Set<String> set, StringBuilder builder, Object v, String k, Stack<String> stack) {
        stack.push(k);
        if (v instanceof Map) {
            Map<String, Object> c = ((Map<String, Object>) v);
            builder.append(k);
            for (Map.Entry<String, Object> e : c.entrySet()) {
                String k1 = e.getKey();
                Object v1 = e.getValue();
                String temp = builder.toString();
                addSet(set, builder, v1, "." + k1, stack);
                builder = new StringBuilder(temp);
                stack.pop();
            }
        } else if (v.getClass().isArray()) {
            builder.append(k);
            Object[] v1 = (Object[]) v;
            int size = 0;
            for (Object o : v1) {
                String temp = builder.toString();
                addSet(set, builder, o, "[" + size + "]", stack);
                builder = new StringBuilder(temp);
                stack.pop();
                size++;
            }
        } else {
            builder.append(k + "=" + v);
            set.add(builder.toString());
        }
    }
}
