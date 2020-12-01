package jdbc;

import entity.Drink;

public interface DrinkDao {
    int insertDrink(Drink drink);

    Drink queryDrinkByName(String name);

    int updateDrink(Drink drink);

    int deleteDrinkByName(String name);
}
