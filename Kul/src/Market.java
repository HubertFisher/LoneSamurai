import java.util.Scanner;

import com.users.Client;
import com.users.milk;
public class Market {
    public static void main(String[] args) {

        Client Zan = new Client(); //создание всех объектов
        milk _ReMilk = new milk();
        milk _GoodMilk = new milk();
        milk _VIPMilk = new milk();

        _ReMilk.name = "Обычное молоко 3,2% ";
        _ReMilk.price = 2;
        _GoodMilk.name = "Вкусное молоко 3,2%  ";
        _GoodMilk.price = 3;
        _VIPMilk.name = "Наивкуснейшее молоко 6% ";
        _VIPMilk.price = 8;

        System.out.println("Добро пожаловать в магазин, введите имя и количество денег:-)");
        Scanner in = new Scanner(System.in);
        Zan.name = in.next();
        Zan.money = in.nextInt();
        if (Zan.money==0) {
            System.out.println("Бомж уходи");
            System.exit(0);
        }
        Menu mainMenu = new Menu();
        mainMenu.outPutMenu();

        int n = in.nextInt();
        boolean _NotEnoughMoney = false;
        boolean _NoProduct = false;
        while (n != 0) {
            if (n == 1) {
                while (n != 4) {
                    if (_NotEnoughMoney) {
                        System.out.println("У вас недостаточно средств!");
                        _NotEnoughMoney = false;
                    }
                    if (_NoProduct) {
                        System.out.println("Товара под таким номером не существует!");
                        _NoProduct = false;
                    }
                    System.out.println("1:" + _ReMilk.name + " " + _ReMilk.price + "$");
                    System.out.println("2:" + _GoodMilk.name + " " + _GoodMilk.price + "$");
                    System.out.println("3:" + _VIPMilk.name + " " + _VIPMilk.price + "$");
                    System.out.println("У вас осталось " + Zan.money + "$");
                    System.out.println("Нажмите 4 чтобы вернутся в главное меню");
                    n = in.nextInt();
                    switch (n) {
                        case 1:
                            if (Zan.money >= _ReMilk.price)
                                Zan.buy(_ReMilk.price);
                            else _NotEnoughMoney = true;
                            break;
                        case 2:
                            if (Zan.money >= _GoodMilk.price)
                                Zan.buy(_GoodMilk.price);
                            else _NotEnoughMoney = true;
                            break;
                        case 3:
                            if (Zan.money >= _VIPMilk.price)
                                Zan.buy(_VIPMilk.price);
                            else _NotEnoughMoney = true;
                            break;
                        case 4:
                            break;
                        default:
                            _NoProduct = true;
                            break;
                    }
                    for (int i = 0; i < 20; i++)
                        System.out.println();
                    if (Zan.money == 0) {
                        System.out.println("У вас кончились деньги, уходите");
                        System.exit(0);
                    }
                }
            }
            mainMenu.outPutMenu();
            n = in.nextInt();
        }
      in.close();
    }
}
class Menu{
    void outPutMenu(){
        System.out.println("Выберите категорию продуктов:");
        System.out.println("1: Mолочные продукты.");
        System.out.println("Введите 0 чтобы выйти");
    }
}