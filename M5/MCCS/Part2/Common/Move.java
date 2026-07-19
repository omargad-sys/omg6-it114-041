package M5.MCCS.Part2.Common;

// omg6  three moves in a Rock Paper Scissors game. 7/19/2026
public enum Move {
    ROCK("rock"), PAPER("paper"), SCISSORS("scissors");

    private final String trigger;

    Move(String trigger) {
        this.trigger = trigger;
    }

    public static Move fromText(String text) {
        if (text == null) return null;
        String lower = text.trim().toLowerCase();
        for (Move m : values()) {
            if (lower.equals(m.trigger)) return m;
        }
        return null;
    }

    @Override
    public String toString() {
        return trigger;
    }
}
