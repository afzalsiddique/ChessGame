//import BackEndLogic.*;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//
//public class TestAI_Agent {
//    // out of 8
//    // 1 -> 7
//    // 2 -> 7
//    // 3 -> 7
//    // 4 -> 6
//    // 5 -> 5
//    // 6 -> 4. it Takes 73 sec
//    @Test
//    public void test1(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(true, new Spot(6,1));
//        Piece piece2 = new Pawn(true, new Spot(6,2));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        AI_Agent ai_agent = new AI_Agent(board);
//        int actual = ai_agent.evaluate(board);
//        int expected = 20;
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void test2(){
//        Board board = new Board();
////        Piece piece1 = new Pawn(true, new Spot(7,0));
//        Piece piece3 = new Pawn(true, new Spot(7,1));
//        Piece piece2 = new Pawn(false, new Spot(0,0));
////        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        AI_Agent ai_agent = new AI_Agent(board);
//        int actual = ai_agent.minimax(board,2, false);
//        int expected = 0;
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void test3(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(true, new Spot(7,0));
//        Piece piece2 = new Pawn(true, new Spot(7,1));
//        Piece piece3 = new Pawn(false, new Spot(0,0));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        AI_Agent ai_agent = new AI_Agent(board);
//        int actual = ai_agent.minimax(board,2, false);
//        int expected = 10;
//        Assert.assertEquals(expected, actual);
//    }
//    @Test
//    public void test4(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(false, new Spot(0,0));
//        Piece piece2 = new Pawn(false, new Spot(0,1));
//        Piece piece3 = new Pawn(true, new Spot(7,0));
//        Piece piece4 = new Rook(true, new Spot(7,1));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        board.addPiece(piece4);
//        AI_Agent ai_agent = new AI_Agent(board);
//        int actual = ai_agent.minimax(board,2, false);
//        int expected = 50;
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void test5(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(false, new Spot(0,2));
//        Piece piece2 = new Pawn(false, new Spot(0,3));
//        Piece piece3 = new Pawn(true, new Spot(1,2));
//        Piece piece4 = new Pawn(true, new Spot(1,5));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        board.addPiece(piece4);
//        AI_Agent ai_agent = new AI_Agent(board);
//        Spot[] actual = ai_agent.findBestMove(board); // this is actually returning which spot has the best move
//        Spot[] expected = {new Spot(1,2), new Spot(0,3)};
//        Assert.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void test6(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(false, new Spot(0,0));
//        Piece piece2 = new Pawn(false, new Spot(0,3));
//        Piece piece3 = new Pawn(false, new Spot(2,1));
//        Piece piece4 = new Pawn(false, new Spot(3,1));
//        Piece piece5 = new Pawn(false, new Spot(5,1));
//        Piece piece6 = new Pawn(true, new Spot(1,0));
//        Piece piece7 = new Pawn(true, new Spot(2,3));
//        Piece piece8 = new Pawn(true, new Spot(3,2));
//        Piece piece9 = new Pawn(true, new Spot(5,3));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        board.addPiece(piece4);
//        board.addPiece(piece5);
//        board.addPiece(piece6);
//        board.addPiece(piece7);
//        board.addPiece(piece8);
//        board.addPiece(piece9);
//        AI_Agent ai_agent = new AI_Agent(board);
//        Spot[] actual = ai_agent.findBestMove(board); // this is actually returning which spot has the best move
//        Spot[] expected = {new Spot(3,2), new Spot(2,1)};
//        Assert.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void test7(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(false, new Spot(0,0));
//        Piece piece10 = new Pawn(false, new Spot(0,3));
//        Piece piece2 = new Rook(false, new Spot(0,5));
//        Piece piece3 = new Pawn(false, new Spot(2,1));
//        Piece piece4 = new Pawn(false, new Spot(3,1));
//        Piece piece5 = new Pawn(false, new Spot(5,1));
//        Piece piece6 = new Pawn(true, new Spot(1,0));
//        Piece piece7 = new Pawn(true, new Spot(2,3));
//        Piece piece8 = new Pawn(true, new Spot(3,2));
//        Piece piece9 = new Pawn(true, new Spot(5,3));
//        Piece piece11 = new Rook(true, new Spot(7,5));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        board.addPiece(piece4);
//        board.addPiece(piece5);
//        board.addPiece(piece6);
//        board.addPiece(piece7);
//        board.addPiece(piece8);
//        board.addPiece(piece9);
//        board.addPiece(piece10);
//        board.addPiece(piece11);
//        AI_Agent ai_agent = new AI_Agent(board);
//        Spot[] actual = ai_agent.findBestMove(board); // this is actually returning which spot has the best move
//        Spot[] expected = {new Spot(7,5), new Spot(0,5)};
//        Assert.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void test8(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(false, new Spot(0,0));
//        Piece piece10 = new Pawn(false, new Spot(0,3));
//        Piece piece2 = new Rook(false, new Spot(0,5));
//        Piece piece3 = new Pawn(false, new Spot(2,1));
//        Piece piece4 = new Pawn(false, new Spot(3,1));
//        Piece piece5 = new Pawn(false, new Spot(5,1));
//        Piece piece12 = new Pawn(false, new Spot(7,6));
//        Piece piece6 = new Pawn(true, new Spot(1,1));
//        Piece piece7 = new Pawn(true, new Spot(1,2));
//        Piece piece8 = new Pawn(true, new Spot(3,2));
//        Piece piece9 = new Pawn(true, new Spot(5,3));
//        Piece piece11 = new Rook(true, new Spot(7,5));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        board.addPiece(piece4);
//        board.addPiece(piece5);
//        board.addPiece(piece6);
//        board.addPiece(piece7);
//        board.addPiece(piece8);
//        board.addPiece(piece9);
//        board.addPiece(piece10);
//        board.addPiece(piece11);
//        AI_Agent ai_agent = new AI_Agent(board);
//        Spot[] actual = ai_agent.findBestMove(board); // this is actually returning which spot has the best move
//        Spot[] expected = {new Spot(7,5), new Spot(0,5)};
//        Assert.assertArrayEquals(expected, actual);
//    }
//    @Test
//    public void test9(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(false, new Spot(0,2));
//        Piece piece2 = new Pawn(false, new Spot(0,3));
//        Piece piece7 = new Pawn(false, new Spot(0,4));
//        Piece piece6 = new Rook(false, new Spot(0,5));
//        Piece piece8 = new Pawn(false, new Spot(0,6));
//        Piece piece3 = new Pawn(true, new Spot(1,3));
//        Piece piece9 = new Pawn(true, new Spot(1,4));
//        Piece piece5 = new Pawn(true, new Spot(2,5));
//        Piece piece4 = new Pawn(true, new Spot(1,0));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        board.addPiece(piece4);
//        board.addPiece(piece5);
//        board.addPiece(piece6);
//        board.addPiece(piece7);
//        board.addPiece(piece8);
//        board.addPiece(piece9);
//        AI_Agent ai_agent = new AI_Agent(board);
//        Spot[] actual = ai_agent.findBestMove(board); // this is actually returning which spot has the best move
//        Spot[] expected = {new Spot(1,3), new Spot(0,3)};
//        Assert.assertArrayEquals(expected, actual);
//    }
//    @Test
//    public void test10(){
//        Board board = new Board();
//        Piece piece1 = new Pawn(false, new Spot(0,2));
//        Piece piece2 = new Pawn(false, new Spot(0,3));
//        Piece piece3 = new Pawn(true, new Spot(4,3));
//        Piece piece9 = new Pawn(true, new Spot(4,4));
//        Piece piece5 = new Pawn(true, new Spot(4,5));
//        Piece piece4 = new Pawn(true, new Spot(4,0));
//        board.addPiece(piece1);
//        board.addPiece(piece2);
//        board.addPiece(piece3);
//        board.addPiece(piece4);
//        board.addPiece(piece5);
//        board.addPiece(piece9);
//        AI_Agent ai_agent = new AI_Agent(board);
//        Spot[] actual = ai_agent.findBestMove(board); // this is actually returning which spot has the best move
//        Spot[] expected = {new Spot(4,0), new Spot(0,3)};
//        Assert.assertArrayEquals(expected, actual);
//    }
//
//}
