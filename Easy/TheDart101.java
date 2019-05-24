import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        Map<Integer, Integer> playerMap = new LinkedHashMap<>();
        String[] playerName = new String[N];

        for (int i = 0; i < N; i++) {
            playerName[i] = in.nextLine();
            playerMap.put(i, 0);
        }

        for (int i = 0; i < N; i++) {
            GameState gameState = new GameState();

            String shot = in.nextLine();

            String[] playerShoots = shot.split(" ");
            for (String playerShoot : playerShoots) {
                gameState.nbShot++;

                if (playerShoot.contains("X")) {
                    gameState.addMiss();
                } else {
                    gameState.addScore(playerShoot);
                }

                if (gameState.getTotalScore() == 101) {
                    playerMap.put(i, gameState.round);
                } else if (gameState.nbShot == 3) {
                    gameState.endRound();
                    gameState.nextRound();
                } else if (gameState.getTotalScore() > 101) {
                    gameState.nextRound();
                }
            }
        }

        Optional<Map.Entry<Integer, Integer>> entry = playerMap
                .entrySet()
                .stream().filter(e -> e.getValue() > 0).min(Map.Entry.comparingByValue());

        System.out.println(playerName[entry.get().getKey()]);
    }
}

class GameState {
    int currentScore;
    int tmpScore;
    int miss;
    int round;
    int nbShot;

    public GameState() {
        this.round = 1;
    }

    private void resetScore() {
        this.currentScore = 0;
        this.tmpScore = 0;
    }

    void addMiss() {
        this.miss++;
        this.tmpScore -= 20;

        if (this.miss == 2) {
            this.tmpScore -= 10;
        }

        if (this.miss == 3) {
            this.resetScore();
        }
    }

    void addScore(String shoot) {
        this.miss = 0;
        int index = shoot.indexOf("*");
        if (index == -1) {
            this.tmpScore += Integer.parseInt(shoot);
        } else {
            this.tmpScore += Integer.parseInt(shoot.substring(0, index)) * Integer.parseInt(shoot.substring(index + 1));
        }
    }

    void nextRound() {
        this.miss = 0;
        this.nbShot = 0;
        this.tmpScore = 0;
        this.round++;
    }

    void endRound() {
        this.currentScore += tmpScore;
        this.currentScore = this.currentScore < 0 ? 0 : this.currentScore;
    }

    int getTotalScore() {
        return this.tmpScore + this.currentScore;
    }
}