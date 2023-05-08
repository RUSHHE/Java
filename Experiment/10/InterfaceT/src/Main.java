/**
 * 泛型接口    CRUDService
 *
 * @param <T> 类型变量
 */
interface CRUDService<T> {
    int add(T record);

    int update(T record);

    T find(int id);

    int delete(int id);
}

class Stu {
    private String name;
    private Integer id;

    public Stu(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}

class P {
    private String name;
    private Integer id;

    public P(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
}

class CommonService<T> implements CRUDService<T> {
    @Override
    public int add(T record) {
        System.out.println("add  T  class:" + record.getClass());
        return 1;
    }

    @Override
    public int update(T record) {
        System.out.println("update  T  class:" + record.getClass());
        return 1;
    }

    @Override
    public T find(int id) {
        System.out.println("find:" + id);
        return null;
    }

    @Override
    public int delete(int id) {
        System.out.println("delete:" + id);
        return 1;
    }


}

class StuCommonService implements CRUDService<Stu> {
    @Override
    public int add(Stu record) {
        System.out.println("add  Stu  class:" + record.getClass());
        return 1;
    }

    @Override
    public int update(Stu record) {
        System.out.println("update  Stu  class:" + record.getClass());
        return 1;
    }

    @Override
    public Stu find(int id) {
        System.out.println("find:" + id);
        return null;
    }

    @Override
    public int delete(int id) {
        System.out.println("delete:" + id);
        return 1;
    }


}

public class Main {
    public static void main(String[] args) {
        CommonService<Stu> cs1 = new CommonService<Stu>();
        Stu stu1 = new Stu("tom", 1);
        cs1.add(stu1);
        cs1.update(stu1);
        cs1.find(1);
        cs1.delete(1);

        StuCommonService stucs1 = new StuCommonService();
        stucs1.add(stu1);


        CommonService<P> cs2 = new CommonService<>();

        P p1 = new P("Jack", 2);
        cs2.add(p1);
        cs2.update(p1);
        cs2.find(2);
        cs2.delete(2);
    }
}