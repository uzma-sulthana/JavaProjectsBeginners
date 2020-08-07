import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
	private boolean play= false;
	private int score=0;

	private int totalBricks = 21;

	private Timer timer;
	private int delay = 8;

	private int playerX = 310;

	private int ballPostX = 120;
	private int ballPostY = 350;
	private int ballXdir= -1;
	private int ballYdir = -2;

	private MapGenerator map;


	public GamePlay() {
		map= new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay,this);
		timer.start();



	}

	public void paint(Graphics g) {
		// set  background 
		g.setColor(Color.white);
		g.fillRect(1, 1, 692, 592);
		map.draw((Graphics2D)g);

		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);

		//Set Attributes of the color

		g.setColor(Color.blue);
		g.fillRect(playerX, 550, 100, 8);

		// Add the ball 
		g.setColor(Color.green);
		g.fillOval(ballPostX, ballPostY, 20, 20);

		g.setColor(Color.black);
		g.setFont(new Font("serif",Font.BOLD,25));
		g.drawString(""+score, 590, 30);
		
		
		
		if(totalBricks <=0) {
			play = false;
			ballXdir = 0;
			ballYdir=0;
			g.setColor(Color.green);
			g.setFont(new Font("serif", Font.BOLD,30));
			g.drawString("You Won ,Score :" + score, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD,20));
			g.drawString("Press Enter to Restart.", 230, 350);
		}
		//displaying game over msg
		
		if(ballPostY > 570) {
			play = false;
			ballXdir = 0;
			ballYdir=0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD,30));
			g.drawString("Game Over ,Score :" + score, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD,20));
			g.drawString("Press Enter to Restart.", 230, 350);
			
		}
		

		// add dispose function 
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();

		if(play) {
			// Ball - pedal interaction  
			if(new Rectangle(ballPostX,ballPostY,20, 20).intersects(new Rectangle(playerX,550,100,8))) {
				ballYdir= -ballYdir;

			}

			// brick interact 
			for(int i =0; i<map.map.length;i++) {
				for(int j= 0; j<map.map[0].length; j++) {
					if(map.map[i][j] > 0) {
						int brickX= j*map.brickWidth + 80;
						int brickY= i*map.brickHeight +50;
						int brickWidth =map.brickWidth;
						int brickHeight= map.brickHeight;

						Rectangle rect = new Rectangle(brickX, brickY,brickWidth,brickHeight);
						Rectangle ballRect = new Rectangle(ballPostX,ballPostY,20,20);
						Rectangle brickRect = rect;

						if(ballRect.intersects(brickRect)) {
							map.setBrickValue(0,i,j);
							totalBricks--;
							score +=5;

							if(ballPostX+19 <= brickRect.x || ballPostX+1 <= brickRect.x+brickRect.width) {
								ballXdir = - ballXdir; // to be reversed 
							}
							else {
								ballYdir = -ballYdir;

							}
						}

					}
				}
			}

			ballPostX += ballXdir;
			ballPostY += ballYdir;
			if(ballPostX <0) {
				ballXdir = - ballXdir;
			}
			if(ballPostY <0) {
				ballYdir = - ballYdir;
			}
			if(ballPostX > 670) {
				ballXdir = -ballXdir; // ball rebounce
			}

		}
		repaint();


	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()== KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX =600;
			}
			else {
				moveRight();

			}
		}
		if(arg0.getKeyCode()== KeyEvent.VK_LEFT) {
			if(playerX <10) {
				playerX =10;
			}
			else {
				moveLeft();

			}
		}
		// press enter we want to restart the game 
		
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play=true;
				ballPostX =120;
				ballPostY = 350;
				ballXdir = -1;
				ballYdir = -2;
				score =0;
				totalBricks = 21;
				map = new MapGenerator(3,7);
				repaint();
				
			}
		}

	}
	public void moveRight() {
		play = true;
		playerX +=20;
	}
	public void moveLeft() {
		play = true;
		playerX -=20;
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
