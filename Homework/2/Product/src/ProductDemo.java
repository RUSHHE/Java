import  java.io.PrintStream;
import  java.io.UnsupportedEncodingException;
import  java.util.Scanner;
public  class  ProductDemo  {
    private  static  Scanner  input;
    private  static  PrintStream  out;
    static  {
        input  =  new  Scanner(System.in,"UTF-8");
        try  {
            out  =  new  PrintStream(System.out,false,"UTF-8");
        }  catch  (UnsupportedEncodingException  e)  {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }
    public  static  void  main(String[]  args)  {
        //  TODO  Auto-generated  method  stub
        String  msg  =  "-----------\n";
        msg  +=  "testProductID测试"  +  (testProductID()  ?  "通过"  :  "不通过")  +  "\n";
        msg  +=  "testDateInProduced测试"  +  (testDateInProduced()  ?  "通过"  :  "不通过")  +  "\n";
        msg  +=  "testProductToString测试"  +  (testProductToString()  ?  "通过"  :  "不通过")  +  "\n";
        msg  +=  "testProduct测试"  +  (testProduct()  ?  "通过"  :  "不通过")  +  "\n";
        out.println(msg);
    }
    private  static  boolean  testProductID()  {
        boolean  bRtn1  =  false;
        Product  pen  =  new  Product();
        String  sId  =  "1234567890123";
        pen.setId(sId);
        if(pen.getId().equals(sId))
            bRtn1  =  true;
        boolean  bRtn2  =  false;
        sId  =  "123456789012";
        pen.setId(sId);
        if(!pen.getId().equals(sId))
            bRtn2  =  true;
        boolean  bRtn3  =  false;
        sId  =  "123456789012a";
        pen.setId(sId);
        if(!pen.getId().equals(sId))
            bRtn3  =  true;
        return  bRtn1  &&  bRtn2  &&  bRtn3;
    }
    private  static  boolean  testDateInProduced()  {
        //完成下面代码实现，模仿testProductID方法对MyDate日期类进行测试
        //1.测试一个正常日期初始化MyDate对象，并检查该对象的toString方法得到的日期是否是我们期望的；
        //2.测试一个年份小于或大于规定年份的日期，创建MyDate对象；
        //3.测试一个月份不在要求范围的日期，创建MyDate对象；
        //4.测试一个日不在要求范围的日期，创建MyDate对象；

        boolean bRtn1 = false;
        MyDate date = new MyDate();
        date.setYear(1970);
        date.setMonth(11);
        date.setDay(4);
        date.setHour(5);
        date.setMinute(14);
        date.setSecond(19);
        String dDt = "1970年11月4日  5:14:19";
        if (date.toString().equals(dDt)) {
            bRtn1 = true;
        }
        boolean bRtn2 = false;
        int year = 1919;
        date.setYear(year);
        if (date.getYear() == year) {
            bRtn2 = true;
        }
        boolean bRtn3 = false;
        int month = 14;
        date.setMonth(month);
        if (date.getMonth() == month) {
            bRtn3 = true;
        }
        boolean bRtn4 = false;
        int day = 114;
        date.setDay(day);
        if (date.getDay() == day) {
            bRtn4 = true;
        }
        return bRtn1 && bRtn2 && bRtn3 && bRtn4;
    }
    private  static  boolean  testProductToString()  {
        //完成下面代码实现，模仿testProductID方法对产品的toString方法进行测试
        boolean bRtn1 = false;
        String sPd = "龙芯一号\t\tCPU\t\t2023年5月17日\t出厂检验合格";
        Product product = new Product();
        product.setId("1234567890123");
        product.setName("龙芯一号");
        product.setPid("000001");
        product.setDateInProduced(2023, 5, 17);
        product.setStatus(1);
        if (product.toString().equals(sPd)) {
            bRtn1 = true;
        }
        boolean bRtn2 = false;
        int day = 114;
        product.setDateInProduced(2023, 5, day);
        if (product.getDateInProduced().toString().equals("2023年5月" + day + "日")) {
            bRtn2 = true;
        }
        boolean bRtn3 = false;
        int status = 114;
        product.setStatus(status);
        if (product.getStatus() != status) {
            bRtn3 = true;
        }
        return bRtn1 && bRtn2 && bRtn3;


    }
    private  static  boolean  testProduct()  {
        //完成下面代码实现，模仿testProductID方法对产品的其他方法进行测试
        boolean bRtn1 = false;
        Product product = new Product();
        String pid = "000001";
        product.setPid(pid);
        if (product.getPid().equals(pid)) {
            bRtn1 = true;
        }
        boolean bRtn2 = false;
        pid = "000004";
        product.setPid(pid);
        if (("老黄能不能别把" + product.getPidName() + "卖的这么贵").equals("老黄能不能别把显卡卖的这么贵")) {
            bRtn2 = true;
        }
        return bRtn1 && bRtn2;


    }
}
/**
 *提示：
 *        private  String  id;//与业务无关的id
 *        private  String  name;//产品名称
 *        private  String  pid;//产品编号，6位产品编号000001到000009分别表示CPU、主板、内存、显卡、网卡、键盘、鼠标、机箱、电源
 *        private  MyDate  dateInProduced;//生产日期
 *        private  int  status;//产品的状态,-1表示产品不可用（默认值），0表示生产中，1表示出厂检验合格，2表示出厂检验不合格，
 *                                                //3表示报废中，4表示已经报废，5表示产品已销售，
 *                                                //6表示产品已经返厂维修，其他数值无效
 */
class  Product{
    PrintStream out;//为了实现在CG中输出中文，需要将标准的输出流进行转换，请大家使用这个out对象进行输出，具体使用同System.out
    private String id;
    private String name;
    private String pid;
    private MyDate dateInProduced;
    private int status = -1;

    {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            //e.printStackTrace();
        }
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() == 13) {
            for (int i = 0; i < id.length(); i++) {
                if (!(Character.isDigit(id.toCharArray()[i]))) {
                    out.println("产品的无业务无关的id必须是13位数字组成的字符串。");
                    break;
                } else if ((i == id.length() - 1)) {
                    this.id = id;
                }
            }
        } else {
            out.println("产品的无业务无关的id必须是13位数字组成的字符串。");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public MyDate getDateInProduced() {
        return dateInProduced;
    }

    public void setDateInProduced(int year, int month, int day) {
        dateInProduced = new MyDate(year, month, day);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (!(status >= -1 && status <= 6)) {
            out.println("产品状态信息参数异常，请检查。");
        } else {
            this.status = status;
        }
    }

    public String getPidName() {
        String pidName;
        switch (pid) {
            case "000001":
                pidName = "CPU";
                break;
            case "000002":
                pidName = "主板";
                break;
            case "000003":
                pidName = "内存";
                break;
            case "000004":
                pidName = "显卡";
                break;
            case "000005":
                pidName = "网卡";
                break;
            case "000006":
                pidName = "键盘";
                break;
            case "000007":
                pidName = "鼠标";
                break;
            case "000008":
                pidName = "机箱";
                break;
            case "000009":
                pidName = "电源";
                break;
            default:
                pidName = "UNKNOWN";
        }
        return pidName;
    }

    public String getStatusName() {
        String statusName;
        switch (status) {
            case -1:
                statusName = "不可用";
                break;
            case 0:
                statusName = "生产中";
                break;
            case 1:
                statusName = "出厂检验合格";
                break;
            case 2:
                statusName = "出厂检验不合格";
                break;
            case 3:
                statusName = "报废中";
                break;
            case 4:
                statusName = "已经报废";
                break;
            case 5:
                statusName = "产品已销售";
                break;
            case 6:
                statusName = "产品已经返厂";
                break;
            default:
                statusName = "数值无效";
        }
        return statusName;
    }

    @Override
    public String toString() {
        String sRtn = "";
        out.println("产品名称\t\t产品类型\t\t生成时间\t\t产品状态");
        sRtn = name + "\t\t" + getPidName() + "\t\t" + dateInProduced + "\t" + getStatusName();
        out.println(sRtn);
        return sRtn;
    }
}

class  MyDate  {
    private  int  year;
    private  int  month;
    private  int  day;
    private  int  hour;
    private  int  minute;
    private  int  second;
    private  boolean  isOnlyYMD;

    private  static  Scanner  input;
    private  static  PrintStream  out;
    static  {
        input  =  new  Scanner(System.in,"UTF-8");
        try  {
            out  =  new  PrintStream(System.out,false,"UTF-8");
        }  catch  (UnsupportedEncodingException  e)  {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }
    public  MyDate(int  year,  int  month,  int  day,  int  hour,  int  minute,  int  second)  {
        super();
        setYear(year);
        setMonth(month);
        setDay(day);
        setHour(year);
        setMinute(minute);
        setSecond(second);
        isOnlyYMD  =  false;
    }
    public  MyDate()  {
        super();
        //  TODO  Auto-generated  constructor  stub
    }
    public  MyDate(int  year,  int  month,  int  day)  {
        super();
        setYear(year);
        setMonth(month);
        setDay(day);
        isOnlyYMD  =  true;
    }
    public  int  getYear()  {
        return  year;
    }
    public  void  setYear(int  year)  {
        if(year  <  1970  ||  year  >  2023)  {
            out.println("你输入的年份无法通过数据验证，请检查。年份必须介于[1970,2023]");
        }
        this.year  =  year;
    }
    public  int  getMonth()  {
        return  month;
    }
    public  void  setMonth(int  month)  {
        if(month  <  1  ||  month  >  12)  {
            out.println("你输入的月份无法通过数据验证，请检查。月份必须介于[1,12]");
        }
        this.month  =  month;
    }
    public  int  getDay()  {
        return  day;
    }
    public  void  setDay(int  day)  {
        if(day  <  1  ||  day  >  12)  {
            out.println("你输入的日无法通过数据验证，请检查。日必须介于[1,31]");
        }
        this.day  =  day;
    }
    public  int  getHour()  {
        return  hour;
    }
    public  void  setHour(int  hour)  {
        if(hour  <  1  ||  hour  >  24)  {
            out.println("你输入的时无法通过数据验证，请检查。时必须介于[1,24]");
        }
        isOnlyYMD  =  false;
        this.hour  =  hour;
    }
    public  int  getMinute()  {
        return  minute;
    }
    public  void  setMinute(int  minute)  {
        if(minute  <  1  ||  minute  >  60)  {
            out.println("你输入的分无法通过数据验证，请检查。分必须介于[1,60]");
        }
        isOnlyYMD  =  false;
        this.minute  =  minute;
    }
    public  int  getSecond()  {
        return  second;
    }
    public  void  setSecond(int  second)  {
        if(second  <  1  ||  second  >  60)  {
            out.println("你输入的秒无法通过数据验证，请检查。秒必须介于[1,60]");
        }
        isOnlyYMD  =  false;
        this.second  =  second;
    }
    @Override
    public  String  toString()  {
        String  sRtn  =  "";
        sRtn  =  year  +  "年"  +  month  +  "月"  +  day  +  "日";
        if(!isOnlyYMD)  {
            sRtn  +=  "  "  +  hour  +  ":"  +  minute  +  ":"  +  second;
        }
        return  sRtn;
    }
}