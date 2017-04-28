import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 */

public class GameView extends JFrame {
  
  private static final long serialVersionUID = 1L;
  
  /**
   * Reference to the view of the board
   */
  private BoardView board;
  private GameModel gameModel;
  private JButton buttonUndo;
  private JButton buttonRedo;
  
  
  /**
   * Constructor used for initializing the Frame
   * 
   * @param model
   *            the model of the game (already initialized)
   * @param gameController
   *            the controller
   */
  
  public GameView(GameModel model, GameController gameController) {
    super("Circle the Dot");
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.WHITE);
    
    gameModel = model;
    board = new BoardView(model, gameController);
    add(board, BorderLayout.CENTER);
    
    
    JButton buttonReset = new JButton("Reset");
    buttonReset.setFocusPainted(false);
    buttonReset.addActionListener(gameController);
   
    buttonUndo = new JButton ("Undo");
    buttonUndo.setEnabled(false);
    buttonUndo.setFocusPainted (false);
    buttonUndo.addActionListener (gameController);
    
    JButton buttonExit = new JButton("Quit");
    buttonExit.setFocusPainted(false);
    buttonExit.addActionListener(gameController);
    
    buttonRedo = new JButton("Redo");
    buttonRedo.setEnabled(false);
    buttonRedo.setFocusPainted(false);
    buttonRedo.addActionListener(gameController);
    
    JPanel control = new JPanel();
    control.setBackground(Color.WHITE);
    control.add(buttonReset);
    control.add(buttonExit);
    control.add (buttonUndo);
    control.add (buttonRedo);
    add(control, BorderLayout.SOUTH);
    
    pack();
    setResizable(false);
    setVisible(true);
  }
  
  public void setModel(GameModel model){
    gameModel = model;
    board.setModel (model);
  }
  
  
  public void update(){
    board.update();
    
  }
  //method used to change enabled state for undo button
  public void updateUndo(boolean state){
    buttonUndo.setEnabled(state);
  }
  //method used to change enabled state for redo button
  public void updateRedo(boolean state){
    buttonRedo.setEnabled(state);
  }
}