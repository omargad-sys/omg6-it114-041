public abstract class GameEntity {
    protected String name;
    public GameEntity(String name) { this.name = name; }
    public abstract void performAction();
}
