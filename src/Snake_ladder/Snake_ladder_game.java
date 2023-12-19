package Snake_ladder;

public class Snake_ladder_game {
    private static final int WINNING_POSITION = 100;
    private static final int NUMBER_OF_PLAYERS = 2;
    private static final int[] ladder = {5, 12, 27, 35, 61, 72, 90};
    private static final int[] snake = {22, 46, 56, 62, 74, 88, 93, 96};
    private static int[] playerPositions = new int[NUMBER_OF_PLAYERS];

    public static void main(String[] args) {
        playGame();
    }
    private static void playGame() {
//        Random random = new Random();
        int currentPlayer = 0;
        boolean hasWinner = false;

        while (!hasWinner) {
            int diceRoll = (int) Math.floor(Math.random() * 10) % 7;
            int option = (int) Math.floor(Math.random() * 10) % 3;

            switch (option) {
                case 0:
                    // No Play
                    break;
                case 1:
                    // Ladder
                    playerPositions[currentPlayer] = movePlayer(currentPlayer, diceRoll, ladder);
                    break;
                case 2:
                    // Snake
                    playerPositions[currentPlayer] = movePlayer(currentPlayer, -diceRoll, snake);
                    break;
            }

            System.out.println("Player " + (currentPlayer + 1) + " rolled a " + diceRoll +
                    ", Option: " + (option == 0 ? "No Play" : (option == 1 ? "Ladder" : "Snake")) +
                    ", Position: " + playerPositions[currentPlayer]);

            if (playerPositions[currentPlayer] == WINNING_POSITION) {
                hasWinner = true;
                System.out.println("Player " + (currentPlayer + 1) + " wins!");
            }

            currentPlayer = (currentPlayer + 1) % NUMBER_OF_PLAYERS;
        }
    }



    private static int movePlayer(int playerIndex, int steps, int[] array) {
        int newPosition = playerPositions[playerIndex] + steps;

        if (newPosition < 0) {
            return 0;
        } else if (newPosition >= WINNING_POSITION) {
            return playerPositions[playerIndex];
        } else {
            for (int i = 0; i < array.length; i++) {
                if (newPosition == array[i]) {
                    return newPosition;
                }
            }
            return newPosition;
        }
    }
}
