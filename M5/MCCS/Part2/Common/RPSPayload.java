package M5.MCCS.Part2.Common;

// omg6 RPS data target player, move choice, accept/decline between client and server 7/19/2026
public class RPSPayload extends Payload {
    private static final long serialVersionUID = 1L;

    private long targetUser;
    private Move move;
    private boolean accepted;

    public long getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(long targetUser) {
        this.targetUser = targetUser;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public boolean isAccepted() {
        return accepted;  
    }

    public void setAccepted(boolean accepted) {
         this.accepted = accepted;
    }

    @Override
    public String toString() {
         return super.toString() +
            String.format(" TargetUser: [%d] Move: [%s] Accepted: [%b]",
                targetUser, move, accepted);
    }
}
