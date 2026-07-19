package M5.MCCS.Part2.Server;

import M5.MCCS.Part2.Common.Move;

// omg6 Tracks Rock Paper Scissors game between two players on the server. 7/19/2026
public class RPSGame {
    private long gameId;
    private long playerAId;
    private long playerBId;
    private Move playerAMove = null;
    private Move playerBMove = null;

    public RPSGame(long gameId, long playerAId, long playerBId) {
        this.gameId = gameId;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
    }

    public long getGameId() { return gameId; }
    public long getPlayerAId() { return playerAId; }
    public long getPlayerBId() { return playerBId; }

    public boolean updateMove(long playerId, Move move) {
        if (playerId == playerAId) {
            if (playerAMove != null) return false;
            playerAMove = move;
            return true;
        } else if (playerId == playerBId) {
            if (playerBMove != null) return false;
            playerBMove = move;
            return true;
        }
        return false;
    }

    public long getOpponentId(long playerId) {
        if (playerId == playerAId) return playerBId;
        if (playerId == playerBId) return playerAId;
        return -1;
    }

    public Move getOpponentMove(long playerId) {
        if (playerId == playerAId) return playerBMove;
        if (playerId == playerBId) return playerAMove;
        return null;
    }

    public boolean isParticipant(long clientId) {
        return clientId == playerAId || clientId == playerBId;
    }

    public boolean isComplete() {
        return playerAMove != null && playerBMove != null;
    }

    public boolean playerWins(long playerId) {
        Move myMove = (playerId == playerAId) ? playerAMove : playerBMove;
        Move theirMove = (playerId == playerAId) ? playerBMove : playerAMove;
        if (myMove == null || theirMove == null) return false;
        if (myMove == theirMove) return false;
        return (myMove == Move.ROCK && theirMove == Move.SCISSORS)
            || (myMove == Move.SCISSORS && theirMove == Move.PAPER)
            || (myMove == Move.PAPER && theirMove == Move.ROCK);
    }
}
