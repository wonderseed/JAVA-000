import entity.Drink;
import jdbc.DrinkDaoIml;

public class JdbcApp {
    public static void main(String[] args) {
        DrinkDaoIml drinkDaoIml = new DrinkDaoIml();
        Drink drink  = new Drink("雪碧",3.5,"apple");
        System.out.println("插入新的饮品成功"+drinkDaoIml.insertDrink(drink));

        System.out.println("query name=雪碧 drink"+drinkDaoIml.queryDrinkByName("雪碧").toString());
        Drink drink1 = new Drink("雪碧",8,"cherry");
        System.out.println("update drink"+drinkDaoIml.updateDrink(drink1));

        System.out.println("delete drink"+drinkDaoIml.deleteDrinkByName("雪碧"));
    }
}
