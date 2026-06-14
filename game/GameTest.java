package game;

public class GameTest {

    public static void main(String[] args) {

        GameEntity npc = new NpcCharacter("Guard");
            GameEntity merchant = new Merchant("Trader");
            GameEntity enemy = new Enemy("Orc");
            GameEntity[] entities = {
            new NpcCharacter("Town Guard"),
            new Merchant("Potion Vendor"),
            new Enemy("Goblin"),
        

        };

        for (GameEntity entity : entities) {

            entity.displayInfo();

            entity.performAction();

            System.out.println("------------------");
        }
    }
}
