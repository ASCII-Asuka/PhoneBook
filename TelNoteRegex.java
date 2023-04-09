package PhoneBook;

import java.util.Scanner;

/**
 * 数据校验类
 */
public class TelNoteRegex {
    /**
     * 对菜单输入项的验证
     * @param min
     * @param max
     * @return
     */
    public int menuItemValidate(int min,int max){
        //定义验证菜单项的正则表达式
        String regex = "[1-9][0-9]{0,}";

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入正确的数字，最小是"+min+"\t"+"最大是"+max);
            String input = scanner.nextLine();

            if (input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if (inputNum <= max){
                    return inputNum;
                }else {
                    System.out.println("您输入的菜单项不符，请重新输入！");
                    continue;
                }
            }else {
                System.out.println("输入数字错误，请检查！");
            }
        }
    }

    /**
     * 对用户输入姓名的验证
     * @return
     */
    public String nameValidate(){
        //定义验证姓名的正则表达式（字母可以说大小写且长度为1-10位）
        String regex = "[a-zA-Z]{1,10}";

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入姓名，格式为：1-10之间的大小写字母");
            String input = scanner.nextLine();

            if (input.matches(regex)){
                return input;
            }else {
                System.out.println("您当前输入的姓名有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户输入年龄的验证
     * @return
     */
    public String ageValidate(){
        //定义验证年龄的正则表达式（1-99岁之间）
        String regex = "[1-9][0-9]?";

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入年龄，格式为：1-99岁之间");
            String input = scanner.nextLine();

            if (input.matches(regex)){
                return input;
            }else {
                System.out.println("您当前输入的年龄有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户输入性别的验证
     * @return
     */
    public String sexValidate(){
        //定义验证性别的正则表达式（男输入m或M，女输入f或F）
        String regex = "[mMfF]";

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入性别，格式为：男输入m或M，女输入f或F");
            String input = scanner.nextLine();

            if (input.matches(regex)){
                return input;
            }else {
                System.out.println("您当前输入的性别有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户输入号码的验证
     * @return
     */
    public String telNumValidate(){
        //定义验证号码的正则表达式（允许带有区号的座机号，允许手机号）
        String regex = "([0-9]{3,4}-[0-9]{7,8})|([1][0-9]{10})";//正则表达式中不能加空格！

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入号码，格式为：允许带有区号的座机号，允许手机号");
            String input = scanner.nextLine();

            if (input.matches(regex)){
                return input;
            }else {
                System.out.println("您当前输入的号码有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户输入地址的验证
     * @return
     */
    public String addressValidate(){
        //定义验证地址的正则表达式（允许字母或数字，长度为1-50）
        String regex = "\\w{1,50}";

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入地址，格式为：允许字母或数字，长度为1-50");
            String input = scanner.nextLine();

            if (input.matches(regex)){
                return input;
            }else {
                System.out.println("您当前输入的地址有误，请重新输入！");
            }
        }
    }
}
