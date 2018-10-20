/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bennu;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.*;
import javax.swing.*;
/**
 *
 * @author DELL
 */
public class Bennu implements ActionListener, MouseListener{
public static Bennu bennu;
static Thread thread = new Thread();
    public final int WIDTH = 800, HEIGHT = 660;
    public Renderer renderer;
    public Rocket rocket;
    public End end;
    public ArrayList<Astriod> astroids; //because i want multiple blocks
    public ArrayList<Lives> lives;
    public Random rand;
    public int clicks, score, motion;
    public boolean gameOver, started;
    public int lifecount = 3;
    JFrame frame = new JFrame();
    Timer timer;
     public Bennu() {
          timer = new Timer(20, this);
        

        rand = new Random();
        renderer = new Renderer();
        rocket = new Rocket(800 / 2 - 10, 690/ 2 - 10,"C:\\Users\\DELL\\Desktop\\spaceApps\\picture1.png");
        end=new End(800 / 2 - 10, 690/ 2 - 10,"C:\\Users\\DELL\\Desktop\\spaceApps\\end.jpg");
        frame.add(renderer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
       
        astroids = new ArrayList<>();
        lives = new ArrayList<>(4);
       
        addAstroid(true);//calling method add block 4 times to add for blocks
        addAstroid(true);
        addAstroid(true);
        addAstroid(true);

        addLife(true);
        addLife(true);
        addLife(true);
        addLife(true);

        timer.start();
    }
     public void addLife(boolean atStart) {
        int width = 900;
        int height = 75 + rand.nextInt(200);//the minumum height is 100 and the max is 300
        if (atStart) 
        {
            lives.add(new Lives(WIDTH + width + lives.size() * 300, height, "C:\\Users\\DELL\\Desktop\\spaceApps\\pic2.png"));
        } else {
            lives.add(new Lives(lives.get(lives.size() - 1).x + 700, height, "C:\\Users\\DELL\\Desktop\\spaceApps\\pic2.png"));
        }
    }
     
       public void addAstroid(boolean atStart) {
        int width = 100;
        int height = 100 + rand.nextInt(300);//the minumum height is 100 and the max is 300
        if (atStart) //if its a starting block 
        {
            
            astroids.add(new Astriod(WIDTH + width + astroids.size() * 300, height, "C:\\Users\\DELL\\Desktop\\spaceApps\\metor1.png"));//position of bottom block
            astroids.add(new Astriod(WIDTH + width + (astroids.size() - 1) * 250, 0, "C:\\Users\\DELL\\Desktop\\spaceApps\\metor1.png"));//position of top block
        } else//if its not append it to the last block that we had
        {
          
            astroids.add(new Astriod(astroids.get(astroids.size() - 1).x + 700, height, "C:\\Users\\DELL\\Desktop\\spaceApps\\metor1.png"));
            astroids.add(new Astriod(astroids.get(astroids.size() - 1).x, 0, "C:\\Users\\DELL\\Desktop\\spaceApps\\metr0r1.png"));
            
            
            
        }
    }
        @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 5;
        clicks++;
        if (started) {
            if (clicks % 2 == 0 && motion < 15) {
                motion += 1.5;
            }
            rocket.y += motion;

            for (int i = 0; i < astroids.size(); i++)//move the blocks
            {
                Astriod block = astroids.get(i);
                block.x -= speed;
            }
            for (int i = 0; i < astroids.size(); i++)//move the rest of the blocks after the first 4 
            {
                Astriod block = astroids.get(i);
                if (block.x + 150 < 0) {
                    astroids.remove(block);
                    if (block.y == 0) {
                        addAstroid(false);
                    }
                }
            }
            if (rocket.y > HEIGHT || rocket.y < 0) { //ends the game if fish is less or more than the frame size
                gameOver = true;
            }
           
            for (int i = 0; i < lives.size(); i++)//move the lives
            {
                Lives life = lives.get(i);
                life.x -= speed;
            }
            for (int i = 0; i < lives.size(); i++)
            {
                Lives life = lives.get(i);
                if (life.x + 150 < 0) {
                    lives.remove(life);
                    if (life.y == 0) {
                        addLife(false);
                    }
                }
            }
            
            for (Astriod block : astroids) { //increase score when u go through or under or above blocks
                if (block.y == 0 && rocket.x + 100 / 2 > block.x + 150 / 2 - 10 && rocket.x + 100 / 2 < block.x + 150 / 2 + 10) {
                    score++;

                }
                if (checkBlockcollision()) { //checks block collision
                    if (lifecount == 0) {
                        gameOver = true;
                        rocket.x = block.x - 100;
                    }
                }

            }
            for (Lives life : lives) { //checks the life collision
                if (lifecollision()) {
                    lifecount++;
                }
            }

        }
        renderer.repaint();
    }
    
    
     public void repaint(Graphics g)  {


        ImageIcon back = new ImageIcon("C:\\Users\\DELL\\Desktop\\spaceApps\\back2.jpg");//color of background
        g.drawImage(back.getImage(), 0, 0, null);

        rocket.drawrocket(g);
      
   

        for (Astriod block : astroids)//for each loop to paint the blocks
        {
            block.drawastroid(g);
        }

        for (Lives life : lives) {
            life.drawLives(g);
        }

        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Ms Gothic", 1, 80));

        if (!started) {
            g.drawString("Click To Play", 95, HEIGHT / 2 - 5);
        }
        if (gameOver) {
             new GameOver().setjLabel_score(score);          
             frame.dispose();  
            g.drawString("Game Over!", 170, HEIGHT / 2 - 5);
        }
        
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Ms Gothic", 1, 28));
        if (!gameOver && started) {
            g.drawString("Score:"+String.valueOf(score), 30, 60);
            
        }
        
        if (!gameOver && started) {
            g.drawString("lives: " + String.valueOf(lifecount), 180, 60);

        }
        if(score>=12){
           new win();                 
           frame.dispose();    
        }
       

    }
    
     public void jump(){
        if (gameOver)//i want the game to end
        {

            rocket = new Rocket(WIDTH / 2 - 10, HEIGHT / 2 - 10, "C:\\Users\\DELL\\Desktop\\spaceApps\\picture1.png");
            astroids.clear();
            motion = 0;
            
           
            
            addAstroid(true);
            addAstroid(true);
            addAstroid(true);
            addAstroid(true);


            
        }
        if (!started)//i want the game to begin
        {
            started = true;
        } else if (!gameOver) {
            if (motion > 0) {
                motion = 0;
            }
            motion -= 10;
        }
    }
     
      public boolean lifecollision() {
        Rectangle fishrect = new Rectangle(rocket.x, rocket.y, 100, 52);
        for (Lives life : lives) {
            Rectangle liferect = new Rectangle(life.x, life.y, 50, 42);
            if (fishrect.intersects(liferect)) {
                 try {
            File sound = new File("sounds//life.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e);
        }
                life.x = -5000;
                return true;
            }
        }
        return false;
    }
    
        public boolean checkBlockcollision() {
        Rectangle fishrect = new Rectangle(rocket.x, rocket.y, 100, 52);
        for (Astriod block : astroids) {
            Rectangle blockrect = new Rectangle(block.x, block.y, 145, 150);
            if (fishrect.intersects(blockrect)) {
                     try {
            File sound = new File("sounds//ex.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e);
        }
                block.x = 5000;
                lifecount--;
                return true;
            }
        }
        return false;
    }
    //////////////////////////////////////////////
        
        public static void main(String[] args)
	{
		bennu = new Bennu();
        
        }
    //////////////////////////////////////////////    
        
     @Override
    public void mouseClicked(MouseEvent me) {
        if(!gameOver){
        jump();
        try {
            File sound = new File("sounds//jump.wav");
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println(e);
        }
    }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
