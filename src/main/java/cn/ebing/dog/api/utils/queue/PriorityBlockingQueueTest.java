package cn.ebing.dog.api.utils.queue;

class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }
}

public class PriorityBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {

        PriorityBlockingQueue<Person> priorityBlockingQueue = new PriorityBlockingQueue<>(1, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        });

        Person p2 = new Person(7, "李四");
        Person p1 = new Person(9, "张三");
        Person p3 = new Person(6, "王五");
        Person p4 = new Person(2, "赵六");
        priorityBlockingQueue.add(p1);
        priorityBlockingQueue.add(p2);
        priorityBlockingQueue.add(p3);
        priorityBlockingQueue.add(p4);

		//由于二叉树最小堆实现，用这种方式直接打印元素，不能保证有序
        System.out.println(priorityBlockingQueue);
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue);
        System.out.println(priorityBlockingQueue.take());
        System.out.println(priorityBlockingQueue);

    }
}