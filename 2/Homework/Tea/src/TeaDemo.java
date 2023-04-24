import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class TeaDemo {
    private static Scanner input;
    private static PrintStream out;

    static {
        input = new Scanner(System.in, "UTF-8");
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        String msg = "-----------\n";
        msg += "testConstruction测试" + (testConstruction() ? "通过" : "不通过") + "\n";
        msg += "testSetter测试" + (testSetter() ? "通过" : "不通过") + "\n";
        out.println(msg);
    }

    public static boolean testConstruction() {
        boolean bRtn1 = false;
        Tea mingqianlongjing = new Tea();
        String answer = "南湖龙井的GREENTEA生产于Sun  Dec  03  10:15:30  GMT  2023售价108.66保质期180天请在Fri  May  31  10:15:30  GMT  2024前饮用。";
        if (answer.equals(mingqianlongjing.toString()))
            bRtn1 = true;
        boolean bRtn2 = false;
        mingqianlongjing = new Tea(2, Date.from(Instant.parse("2021-12-03T10:15:30Z")), 30, "茶到人生", 123.45);
        answer = "茶到人生的OOLONGTEA生产于Fri  Dec  03  10:15:30  GMT  2021售价123.45保质期30天请在Sun  Jan  02  10:15:30  GMT  2022前饮用。";
        if (answer.equals(mingqianlongjing.toString())) {
            bRtn2 = true;
        }
        return bRtn1 && bRtn2;
    }

    public static boolean testSetter() {
        boolean bRtn1 = false;
        Tea tieguanyin = new Tea();
        tieguanyin.setType(12);
        String answer = "南湖龙井的GREENTEA生产于Sun  Dec  03  10:15:30  GMT  2023售价108.66保质期180天请在Fri  May  31  10:15:30  GMT  2024前饮用。";

        if (answer.equals(tieguanyin.toString()))
            bRtn1 = true;

        boolean bRtn2 = false;
        tieguanyin.setType(1);
        ;
        answer = "南湖龙井的BLACKTEA生产于Sun  Dec  03  10:15:30  GMT  2023售价108.66保质期180天请在Fri  May  31  10:15:30  GMT  2024前饮用。";

        if (answer.equals(tieguanyin.toString())) {
            bRtn2 = true;
        }

        boolean bRtn3 = false;
        tieguanyin.setPrice(-128);
        if (answer.equals(tieguanyin.toString())) {
            bRtn3 = true;
        }

        boolean bRtn4 = false;
        tieguanyin.setExpirationDay(-28);
        ;
        if (answer.equals(tieguanyin.toString())) {
            bRtn4 = true;
        }
        return bRtn1 && bRtn2 && bRtn3 && bRtn4;
    }
}


class Tea {
    private static int type;
    PrintStream out;//为了实现在CG中输出中文，需要将标准的输出流进行转换，请大家使用这个out对象进行输出，具体使用同System.out
    private Date productionDate;
    private long expirationDay;
    private String name;
    private double price;

    {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            //e.printStackTrace();
        }
    }

    public Tea() {
        this.type = 0; // default to GREEN TEA
        this.productionDate = Date.from(Instant.parse("2023-12-03T10:15:30.00Z"));
        this.expirationDay = 180; // default to 180 days
        this.name = "南湖龙井";
        this.price = 108.66; // default to 108.66
    }

    public Tea(int type, Date productionDate, long expirationDay, String name, double price) {
        this.type = type;
        this.productionDate = productionDate;
        this.expirationDay = expirationDay;
        this.name = name;
        this.price = price;
    }

    //这个东西还不能用高级switch
//    private String getTypeName() {
//        return switch (type) {
//            case 0 -> "GREENTEA";
//            case 1, 5 -> "BLACKTEA";
//            case 2 -> "OOLONGTEA";
//            case 3 -> "WHITETEA";
//            case 4 -> "YELLOWTEA";
//            default -> "UNKNOWN";
//        };
//    }
    private String getTypeName() {
        String typeName;
        switch (type) {
            case 0:
                typeName = "GREENTEA";
                break;
            case 1:
            case 5:
                typeName = "BLACKTEA";//这个不是老师代码写错了我是不信的
                break;
            case 2:
                typeName = "OOLONGTEA";
                break;
            case 3:
                typeName = "WHITETEA";
                break;
            case 4:
                typeName = "YELLOWTEA";
                break;
            default:
                typeName = "UNKNOWN";
        }
        return typeName;
    }

    private Date getExpirationDate() {
        return Date.from(productionDate.toInstant().plus(expirationDay, ChronoUnit.DAYS));
    }

    // getters and setters

    public Date getProductionDate() {
        return productionDate;
    }

    public long getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(long expirationDay) {
        if (expirationDay > 0) {
            this.expirationDay = expirationDay;
        } else {
            out.println("质保时间必须大于0天。");
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            out.println("价格必须大于0元。");
        }
    }

    // setters
    public void setType(int type) {
        if (type >= 0 && type <= 5) {
            this.type = type;
        }else {
            out.println("输入的茶叶类型不在要求范围内，请核对。\n" +
                    "茶分类绿茶（GREENTEA，0）、红茶（BLACKTEA，1）、乌龙茶（OOLONGTEA，2）、\n" +
                    "白茶（WHITETEA，3）、黄茶（YELLOWTEA，4）、黑茶（BLACKTEA，5）");
        }

    }

    // toString method
    public String toString() {
        String typeName = getTypeName();
        Date expirationDate = getExpirationDate();
        String result = String.format("%s的%s生产于%s售价%.2f保质期%d天请在%s前饮用。",
                getName(), typeName, getProductionDate(), getPrice(), getExpirationDay(), expirationDate);
        return result;
    }
}