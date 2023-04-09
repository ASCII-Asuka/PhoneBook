package PhoneBook;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话本项目入口类
 */

public class App {
    /**
     * 启动电话本项目
     * @param args
     */
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    /**
     * 控制主菜单
     */
    public void start(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        List<Person> list = new ArrayList<>();

        Person p1 = new Person(1,"Alan","19","M","13870028350","shanghai");
        Person p2 = new Person(2,"Mikasa","18","f","15070112388","beijing");
        list.add(p1);
        list.add(p2);

        Operate operate = new Operate(list);
        while (true){
            menu.mainMenu();
            int item = regex.menuItemValidate(1,6);
            switch (item){
                case 1:operate.addLogic();break;
                case 2:operate.searchLogic();break;
                case 3:operate.modifyLogic();break;
                case 4:operate.deleteLogic();break;
                case 5:operate.orderLogic();break;
                case 6:System.exit(0);//作用：结束当前正在运行的Java虚拟机
            }
        }
    }
}
