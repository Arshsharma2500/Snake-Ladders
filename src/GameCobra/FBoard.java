package GameCobra;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.event.*;

class Board extends JFrame{
	
	JPBoard jpb_1;
	Board(){
		super.setTitle("Sanke AND Ladders");
		jpb_1 = new JPBoard();
		add(jpb_1);
	}
	
}

class JPBoard extends JPanel implements ActionListener{
	
	ImageIcon img1;
	ImageIcon img2;
	ImageIcon img3;
	ImageIcon img3_resized;
	ImageIcon img4,img5,img6;
	ImageIcon img7,img8,img9,img10;
	
	
	Image swt;
	Image Gboard;
	Image Start_Img;
	Image P_Man;
	Image P_Girl;
	Image Play_Img;
	Image Dice_gif;
	Image Dice_png;
	Image Player_1,Player_2;
	
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	
	JTextField text_1;
	JTextField text_2;
	JTextField text_3;
	
	
	
	int px1 = 20,px2 = 100;// default:100 | st1_d:420, st1_u:490 | st2_d:770,st2_u:840 | st3_d: 630,st3_u:560 | st4_d:280,st4_u:350 | st5_d:210,st5_u:280 | st6_d:630,st6_u:700
	int py1 = 620,py2 = 620;// default:620| st1_d:620, st1_u:270 | st2_d:550,st2_u:340 | st3_d: 550,st3_u:270 | st4_d:480,st4_u:270 | st5_d:340,st5_u:130 | st6_d:270,st6_u:70
	//rightside => 10-11:840X550, 11-30:840x480, 30-31:840x410, 31-50:840x340, 50-51:840x280, 51-70:840x210, 70-71:840x140, 71-90:840x70, 90-91:840x0
	//leftside => 1-20:210x550 , 20-21:210x480 , 21-40:210x410 , 40-41:210x340 , 41-60:210x280 ,60-61:210x210 , 61-80:210x140 , 80-81:210x70 , 81-100:210x0 ;
	//snake => 37-3:350x620|420x410 , 28-10:840x620|700x480 , 47-16:490x550|630x340 , 75-32:770x410|560x140 , 94-71:280x340|490x0 , 96-42:840x130|630x0;
	
	JPBoard(){
		setBackground(Color.DARK_GRAY);
		img1 = new ImageIcon(getClass().getResource("swt.png"));
		img2 = new ImageIcon(getClass().getResource("gameboard.jpg"));
		img3 = new ImageIcon(getClass().getResource("startimg.png"));
		img3_resized = new ImageIcon(img3.getImage().getScaledInstance(150, 110, Image.SCALE_DEFAULT));
		img4 = new ImageIcon(getClass().getResource("man.png"));
		img5 = new ImageIcon(getClass().getResource("girl.png"));
		img6 = new ImageIcon(getClass().getResource("play.png"));
		img7 = new ImageIcon(getClass().getResource("dice.gif"));
		img8 = new ImageIcon(getClass().getResource("dice1.png"));
		img9 = new ImageIcon(getClass().getResource("Pawn_1.png"));
		img10 = new ImageIcon(getClass().getResource("Pawn_2.png"));
		
		
		swt = img1.getImage();
		Gboard = img2.getImage();
		Start_Img = img3.getImage();
		P_Man = img4.getImage();
		P_Girl = img5.getImage();
		Play_Img = img6.getImage();
		Dice_gif = img7.getImage();
		Dice_png = img8.getImage();
		Player_1 = img9.getImage();
		Player_2 = img10.getImage();
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(swt, 0, 0, 200, 150, this);
        g.drawImage(Gboard, 200, 0, 700, 700, this);
        g.drawImage(P_Man,0,310, 30,30, this);
        g.drawImage(P_Girl,0,350, 30,30, this);
        g.drawImage(Play_Img,3,270, 30,30, this );
        g.drawImage(Dice_gif,20,420, 60,60, this );
        g.drawImage(Dice_png,110,420, 65,65, this );
        g.drawImage(Player_1,px1,py1, 65,85, this );
        g.drawImage(Player_2,px2,py2, 65,85, this );
        
        g.setColor(new Color(59, 59, 59));
        g.fillRect(900,0,100,735);
        // Set the font style to bold and italic
        Font font = new Font("Serif", Font.BOLD | Font.ITALIC, 40);
        g.setFont(font);
        g.setColor(new Color(203, 76, 21));
        
        
        // Draw the text vertically on the right side of the frame
        String text = "Snake and Ladders";
        
        // Calculate the base position to start drawing the text
        int startX = this.getWidth() - 45; // 40px padding from right side
        int startY = 35; // Starting from the top
        
        // Rotate the graphics context by 90 degrees to write the text vertically
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform originalTransform = g2d.getTransform(); // Save the original transform
        g2d.rotate(Math.toRadians(0), startX, startY);
        
        
        
        // Draw each character of the text
        for (int i = 0; i < text.length(); i++) {
            // Draw each character at a different y-position, starting from the base position
            g2d.drawString(String.valueOf(text.charAt(i)), startX, startY + i * font.getSize());
        }
        
        // Restore the original transform
        g2d.setTransform(originalTransform);
        
        //Buttons add to Panel
        setLayout(null);
        jb1 = new JButton("About");
        jb1.setBounds(50, 170, 100, 40);
        jb1.setBackground(new Color(203, 76, 21));
        add(jb1);
        jb2 = new JButton("Restart");
        jb2.setBounds(50,220,100,40);
        jb2.setBackground(new Color(6,92,178));
        add(jb2);
        jb3 = new JButton("Roll");
        jb3.setBounds(60,500,80,30);
        jb3.setBackground(new Color(128,255,0));
        jb3.addActionListener(this);
        add(jb3);
        jb4 = new JButton(img3_resized);
        jb4.setBounds(20,560,150,50);
        jb4.setBackground(Color.DARK_GRAY);
        add(jb4);
        
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
        
        // Add an ActionListener to the button
        jb2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "restart now");
        		px1 = 20;
        		py1 = 620;
        		px2 = 100;
        		py2 = 620;
        		count = 0;
        		countp2 = 0;
//        		System.out.print(count);
        	}
        });
        
        Font f1 = new Font("BANKGOTHIC MD BT",Font.CENTER_BASELINE,15);
        
        text_1 = new JTextField("Start Game");
        text_1.setBounds(35, 270, 150, 30);
        text_1.setBackground(Color.DARK_GRAY);
        text_1.setForeground(new Color(203, 76, 21));
        text_1.setFont(f1);
        add(text_1);
        
        text_2 = new JTextField("player 1");
        text_2.setBounds(35, 310, 150, 30);
        text_2.setBackground(Color.DARK_GRAY);
        text_2.setForeground(new Color(6,92,178));
        text_2.setFont(f1);
        add(text_2);
        
        text_3 = new JTextField("Player 2");
        text_3.setBounds(35, 350, 150, 30);
        text_3.setBackground(Color.DARK_GRAY);
        text_3.setForeground(new Color(6,92,178));
        text_3.setFont(f1);
        add(text_3);
        
    }
	
	
	int count = 0;
	int prevalue = 0;
	int switchcount = 0;
	int countp2 = 0;
	
	public void actionPerformed(ActionEvent e) {
		
		String p1_name = text_2.getText();
		String p2_name = text_3.getText();
		
		switchcount++;
		System.out.print(switchcount);
		
	    int random = (int) Math.round(Math.random() * 5 + 1);
	    
	    
	    if(switchcount%2==0) {
	    	
	    	
	    if (px1 == 20) px1 = 140;
	    
	    px1 = 140;
	    py1 = 620;
	    int k = 0;
	    count += random;
	    int count1 = 0;
	    
	    //stairs logic 
	    switch(count) {
	    case 4:
	    	count = 56;
	    	break;
	    case 12:
	    	count = 50;
	    	break;
	    case 14:
	    	count = 55;
	    	break;
	    case 22:
	    	count = 58;
	    	break;
	    case 41:
	    	count = 79;
	    	break;
	    case 54:
	    	count = 88;
	    	break;
	    	
	    	//snake logic
	    case 28:
	    	count = 10;
	    	break;
	    case 37:
	    	count = 3;
	    	break;
	    case 47:
	    	count = 16;
	    	break;
	    case 75:
	    	count = 32;
	    	break;
	    case 94:
	    	count = 71;
	    	break;
	    case 96:
	    	count = 42;
	    	break;	
	    }
	    
	    if(random!=6) {
	    	switchcount++;
	    }
	    

	    for (int i = 1; i <= 10; i++) {
	        if (k == 10) {
	            px1 -= 70;
	            k--;
	        }
	        if (k == 0) {
	            px1 += 70;
	            k++;
	        }
	        for (int j = 1; j <= 10; j++) {
	            count1++;
	            if (count1 == count) {
	                return;
	            }
	            if (i % 2 == 1) {
	                px1 += 70;
	                k++;
	            } else {
	                px1 -= 70;
	                k--;
	                prevalue = px1;
	            }
	            // Update y-coordinate conditionally
	            if (px1 > 840) {
	                px1 = 840;
	                py1 -= 70;
	            }
	            
	            if (px1 < 210) {
	                px1 = 210;
	                py1 -= 70;
	            }
	            //win point
	            if(count>=100) {
	  
	            	prevalue = px1;
	            	
	            	px1 = 210;
	            	py1 = 0;
	            	JOptionPane.showMessageDialog(null, p1_name + " Won!");
                    System.exit(0); // Close the application
	            	break;
	            }
	            Dice_png = new ImageIcon(getClass().getResource("Dice_" + random + ".png")).getImage();
	            repaint();
	            
	        }
	    
	    }
	    
	    
	}// for another player
	    else if(switchcount%2!=0){
//	    	int random = (int) Math.round(Math.random() * 5 + 1);
	    	px2 = 140;
		    py2 = 620;
		    int k = 0;
		    countp2 += random;
		    int count1 = 0;
		    
		    //stairs logic 
		    switch(countp2) {
		    case 4:
		    	countp2 = 56;
		    	break;
		    case 12:
		    	countp2 = 50;
		    	break;
		    case 14:
		    	countp2 = 55;
		    	break;
		    case 22:
		    	countp2 = 58;
		    	break;
		    case 41:
		    	countp2 = 79;
		    	break;
		    case 54:
		    	countp2 = 88;
		    	break;
		    	
		    	//snake logic
		    case 28:
		    	countp2 = 10;
		    	break;
		    case 37:
		    	countp2 = 3;
		    	break;
		    case 47:
		    	countp2 = 16;
		    	break;
		    case 75:
		    	countp2 = 32;
		    	break;
		    case 94:
		    	countp2 = 71;
		    	break;
		    case 96:
		    	countp2 = 42;
		    	break;	
		    }
		    
		    
		    if(random!=6) {
		    	switchcount++;
		    }

		    for (int i = 1; i <= 10; i++) {
		        if (k == 10) {
		            px2 -= 70;
		            k--;
		        }
		        if (k == 0) {
		            px2 += 70;
		            k++;
		        }
		        for (int j = 1; j <= 10; j++) {
		            count1++;
		            if (count1 == countp2) {
		                return;
		            }
		            if (i % 2 == 1) {
		                px2 += 70;
		                k++;
		            } else {
		                px2 -= 70;
		                k--;
		                prevalue = px1;
		            }
		            // Update y-coordinate conditionally
		            if (px2 > 840) {
		                px2 = 840;
		                py2 -= 70;
		            }
		            
		            if (px2 < 210) {
		                px2 = 210;
		                py2 -= 70;
		            }
		            //win point
		            if(countp2>=100) {
		          	  
//		            	prevalue = px2;
		            	px2 = 210;
		            	py2 = 0;
		            	JOptionPane.showMessageDialog(null,p2_name +" Won!");
	                    System.exit(0); // Close the application
		            	break;
		            }
		            Dice_png = new ImageIcon(getClass().getResource("Dice_" + random + ".png")).getImage();
		            repaint();
		            
		        }
		    
		    }
		    
		    
		}
	    }
	
}

public class FBoard{
	    public static void main(String[] args) {
	        Board fb = new Board();
	        fb.setVisible(true);
	        fb.setBounds(300, 50, 990, 735);
	        fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	}