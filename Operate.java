package PhoneBook;

import java.util.*;

/**
 * 核心业务类
 */

public class Operate {
    private List<Person> list;

    public Operate(){

    }

    public Operate(List<Person> list){
        this.list = list;
    }

    /**
     * 用户添加记录业务逻辑控制
     */
    public void addLogic(){
        System.out.println("控制添加业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();

        while (true){
            menu.addMenu();
            int item = regex.menuItemValidate(1,3);
            switch (item){
                case 1:this.addOperation();break;
                case 2:this.showAll();break;
                case 3:return;//直接结束该方法
            }
        }
    }

    /**
     * 用户查询记录业务逻辑控制
     */
    public void searchLogic(){
        System.out.println("控制查询记录业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();

        while (true){
            menu.searchMenu();
            int item = regex.menuItemValidate(1,7);
            switch (item){
                case 1:this.searchByName();break;
                case 2:this.searchByAge();break;
                case 3:this.searchBySex();break;
                case 4:this.searchByTelNum();break;
                case 5:this.searchByAddress();break;
                case 6:this.showAll();break;
                case 7:return;
            }
        }
    }

    /**
     * 修改记录业务逻辑控制
     */
    public void modifyLogic(){
        System.out.println("控制修改业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();

        while (true){
            menu.modifyMenu();
            int item = regex.menuItemValidate(1,3);
            switch (item){
                case 1:this.showAll();break;
                case 2:this.modifyOperation();break;
                case 3:return;
            }
        }
    }

    /**
     * 删除记录业务逻辑控制
     */
    public void deleteLogic(){
        System.out.println("控制删除记录业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();

        while (true){
            menu.deleteMenu();
            int item = regex.menuItemValidate(1,4);
            switch (item){
                case 1:this.showAll();break;
                case 2:this.deleteOperation();break;
                case 3:this.deleteAllOperation();break;
                case 4:return;
            }
        }
    }

    /**
     * 排序记录业务逻辑控制
     */
    public void orderLogic(){
        System.out.println("控制排序记录业务逻辑");
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();

        while (true){
            menu.orderMenu();
            int item = regex.menuItemValidate(1,5);
            switch (item){
                case 1:this.orderName();break;
                case 2:this.orderAge();break;
                case 3:this.orderSex();break;
                case 4:this.showAll();break;
                case 5:return;
            }
        }
    }

    /**
     * 添加新记录信息
     */
    public void addOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        String age = regex.ageValidate();
        String sex = regex.sexValidate();
        String telNum = regex.telNumValidate();
        String address = regex.addressValidate();

        Person person = new Person(name,age,sex,telNum,address);

        this.list.add(person);
        person.setId(list.size());
    }

    /**
     * 查询全部记录
     */
    public void showAll(){
        if (this.list.size() == 0){
            System.out.println("暂无记录！");
        }else {
            for (Person person : this.list){
                System.out.println(person);
            }
        }
    }

    /**
     * 按姓名查询记录
     */
    public void searchByName(){
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();

        Boolean flag = true;
        for (Person person : this.list){
            if (person.getName().equals(name)){
                System.out.println(person);
                flag = false;
            }
        }

        if (flag){
            System.out.println("未查询到有关信息！");
        }
    }

    /**
     * 按年龄查询记录
     */
    public void searchByAge(){
        TelNoteRegex regex = new TelNoteRegex();
        String age = regex.ageValidate();

        Boolean flag = true;
        for (Person person : this.list){
            if (person.getAge().equals(age)){
                System.out.println(person);
                flag = false;
            }
        }

        if (flag){
            System.out.println("未查询到有关信息！");
        }
    }

    /**
     * 按性别查询记录
     */
    public void searchBySex(){
        TelNoteRegex regex = new TelNoteRegex();
        String sex = regex.sexValidate();

        Boolean flag = true;
        for (Person person : this.list){
            if (person.getSex().equalsIgnoreCase(sex)){
                System.out.println(person);
                flag = false;
            }
        }

        if (flag){
            System.out.println("未查询到有关信息！");
        }
    }

    /**
     * 按号码查询记录
     */
    public void searchByTelNum(){
        TelNoteRegex regex = new TelNoteRegex();
        String telNum = regex.telNumValidate();

        Boolean flag = true;
        for (Person person : this.list){
            if (person.getTelNum().equals(telNum)){
                System.out.println(person);
                flag = false;
            }
        }

        if (flag){
            System.out.println("未查询到有关信息！");
        }
    }

    /**
     * 按地址查询记录
     */
    public void searchByAddress(){
        TelNoteRegex regex = new TelNoteRegex();
        String address = regex.addressValidate();

        Boolean flag = true;
        for (Person person : this.list){
            if (person.getAddress().equals(address)){
                System.out.println(person);
                flag = false;
            }
        }

        if (flag){
            System.out.println("未查询到有关信息！");
        }
    }

    /**
     * 修改指定记录
     */
    public void modifyOperation(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();

        int id = regex.menuItemValidate(1,this.list.size());
        Person p = null;
        for (Person person : this.list){
            if (person.getId() == id){
                p = person;
                break;
            }
        }

        while (true){
            menu.subModifyMenu();
            int item = regex.menuItemValidate(1,6);

            switch (item){
                case 1:String name = regex.nameValidate();
                p.setName(name);
                break;
                case 2:String age = regex.ageValidate();
                p.setAge(age);
                break;
                case 3:String sex = regex.sexValidate();
                p.setSex(sex);
                break;
                case 4:String telNum = regex.telNumValidate();
                p.setTelNum(telNum);
                break;
                case 5:String address = regex.addressValidate();
                p.setAddress(address);
                break;
                case 6:return;
            }
        }
    }

    /**
     * 删除指定记录
     */
    public void deleteOperation(){
        TelNoteRegex regex = new TelNoteRegex();

        int id = regex.menuItemValidate(1,this.list.size());
        this.list.remove(id - 1);

        for (Person person : this.list){
            if (person.getId() > id){
                person.setId(person.getId() - 1);
            }
        }

        System.out.println("删除成功！请继续操作");
    }

    /**
     * 删除全部记录
     */
    public void deleteAllOperation(){
        System.out.println("您确定要删除全部记录吗？这可能造成无法挽回的损失！请输入：\"是\"或\"否\"");
        Scanner scanner = new Scanner(System.in);

        String regex = scanner.nextLine();
        if (regex.equals("是")){
            this.list.clear();
            System.out.println("全部记录已删除！");
        }
    }

    /**
     * 按姓名排序记录
     */
    public void orderName(){
        Collections.sort(this.list,new OrderByName());
        for (int i = 0;i<this.list.size();i++){
            (this.list.get(i)).setId(i + 1);
        }
    }

    /**
     * 按年龄排序记录
     */
    public void orderAge(){
        Collections.sort(this.list,new OrderByAge());
        for (int i = 0;i<this.list.size();i++){
            (this.list.get(i)).setId(i + 1);
        }
    }

    /**
     * 按性别排序记录
     */
    public void orderSex(){
        Collections.sort(this.list,new OrderBySex());
        for (int i = 0;i<this.list.size();i++){
            (this.list.get(i)).setId(i + 1);
        }
    }

    /**
     * 按姓名排序的比较器内部类
     */
    class OrderByName implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    /**
     * 按年龄排序的比较器内部类
     */
    class OrderByAge implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge().compareTo(o2.getAge());
        }
    }

    /**
     * 按性别排序的比较器内部类
     */
    class OrderBySex implements Comparator<Person>{

        @Override
        public int compare(Person o1, Person o2) {
            return (o1.getSex().toLowerCase(Locale.ROOT)).compareTo((o2.getSex()).toLowerCase(Locale.ROOT));
        }
    }
}
