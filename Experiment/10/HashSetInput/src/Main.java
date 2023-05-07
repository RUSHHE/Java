import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSetRule hashSetRule = new HashSetRule();

        hashSetRule.input();
        hashSetRule.display();
    }
}

class HashSetRule {
    Set<String> hashSet1 = new HashSet<>();
    Set<String> hashSet2 = new HashSet<>();
    Set<String> and = new HashSet<>();
    Set<String> or = new HashSet<>();
    Set<String> diff = new HashSet<>();

    public void input() {
        Scanner scan = new Scanner(System.in);

        System.out.print("enter names(separated by , ):");
        hashSet1.addAll(Arrays.asList(spilt(scan.nextLine())));
        System.out.println("your enter:" + sort(hashSet1));

        System.out.print("enter names(separated by , ):");
        hashSet2.addAll(Arrays.asList(spilt(scan.nextLine())));
        System.out.println("your enter:" + sort(hashSet2));

        setAnd(hashSet1, hashSet2);
        setOr(hashSet1, hashSet2);
        setDiff(hashSet1, hashSet2);
    }

    //以,分割String，输出String[]
    private String[] spilt(String string) {
        return string.split(",");
    }

    public void setAnd(Set<String> set1, Set<String> set2) {
        this.and = generateAnd(set1, set2);
    }

    public void setOr(Set<String> set1, Set<String> set2) {
        this.or = generateOr(set1, set2);
    }

    public void setDiff(Set<String> set1, Set<String> set2) {
        this.diff = generateDiff(set1, set2);
    }

    //生成交集
    private Set<String> generateAnd(Set<String> set1, Set<String> set2) {
        HashSet<String> result = new HashSet<>(set1);
        result.retainAll(set2);
        return sort(result);
    }

    //生成并集
    private Set<String> generateOr(Set<String> set1, Set<String> set2) {
        HashSet<String> result = new HashSet<>(set1);
        result.addAll(set2);
        return sort(result);
    }

    //生成两个并集和交集的差集
    private Set<String> generateDiff(Set<String> set1, Set<String> set2) {
        HashSet<String> result = new HashSet<>(generateOr(set1, set2));
        result.removeAll(generateAnd(set1, set2));
        return sort(result);
    }

    //接受一个Set类转成TreeSet输出（间接实现排序）
    private Set<String> sort(Set<String> set) {
        return new TreeSet<>(set);
    }

    public void display() {
        System.out.println("and:" + and.toString());
        System.out.println("or:" + or.toString());
        System.out.println("diff:" + diff.toString());
    }
}