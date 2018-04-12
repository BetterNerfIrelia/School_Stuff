package at.fhv.scc.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.getGameField().printGameField();
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your enemy [E]asy, [M]edium, [H]ard, [P]ro:");
        String enemy = in.next();

        while (game.getOponent() == null) {
            if (enemy.equals(("E"))) {
                game.setOponent(new OpponentRandom());             //noch mit interfaces
                game.getOponent().setGame(game);                  //game zugewiesen   ZWEITE DIAGONALE AUF BEI KI!!!!
                System.out.println("Enemy is set to easy");

            }
            if (enemy.equals(("M"))) {
                game.setOponent(new OpponentMiniMax());
                game.getOponent().setGame(game);
                System.out.println("Enemy is set to medium");

            }
            if (enemy.equals(("H"))) {
                game.setOponent(new OpponentPruning());
                game.getOponent().setGame(game);
                System.out.println("Enemy is set to hard");

            }
            if (enemy.equals(("P"))) {
                game.setOponent(new OpponentInTime());
                System.out.println("Enemy is set to pro");

            }
        }
        System.out.println("Want to make the first move? [Y]es or [N]o");
        String move = in.next();
        if (move.equals("Y")) {
            game.setPlayersTurn(true);
        }
        while (!game.gameOver()) {

            if (game.isPlayersTurn()) {

                String test = in.next();

                if (test.equals("11")) {

                    if (game.getGameField().getMatrix(0, 0).isSet()) {          //logik (ist feld besetzt usw. alles was player + KI brauchen in GameField.
                        System.out.println("Choose another field");
                    } else {

                        game.getGameField().setMatrix(0, 0, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("12")) {

                    if (game.getGameField().getMatrix(0, 1).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(0, 1, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("13")) {
                    if (game.getGameField().getMatrix(0, 2).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(0, 2, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("21")) {
                    if (game.getGameField().getMatrix(1, 0).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(1, 0, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("22")) {
                    if (game.getGameField().getMatrix(1, 1).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(1, 1, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("23")) {
                    if (game.getGameField().getMatrix(1, 2).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(1, 2, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("31")) {
                    if (game.getGameField().getMatrix(2, 0).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(2, 0, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("32")) {
                    if (game.getGameField().getMatrix(2, 1).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(2, 1, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                if (test.equals("33")) {
                    if (game.getGameField().getMatrix(2, 2).isSet()) {
                        System.out.println("Choose another field");
                    } else {
                        game.getGameField().setMatrix(2, 2, 'X');
                        game.getGameField().printGameField();
                        if (game.isWinner('X')) {
                            System.out.println("Player won!");
                            game.printSkull();
                        }
                        if(game.isDraw()){
                            System.out.println("Draw!");
                            game.printSkull();

                        }
                    }
                }
                game.setPlayersTurn(false);
            } else {
                game.getOponent().play();
                game.setPlayersTurn(true);
            }
        } //ende while not finished
    }
}


// am anfang auswählen: gegnerstärke, wer fängt an.
// abwechselnd setzen: wenn schon besetzt FM, sonst eintragen.
// wenn gewinner: gewinner ausgeben.