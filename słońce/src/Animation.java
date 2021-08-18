import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Animation extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private int x, y, f, h, t, u, o, p, q, r,r1,q1, x1, y1, x2, y2, x3, y3, x11, y11, x12,
			y12, x13, y13, x14, y14;
	private double a, b, c, d, a1, b1, c1, d1;

	
	private Image Merkury;
	private Image Slonce;
	private Image Ksiezyc;
	private Image Ziemia;
	private Image Wenus;
	
	private Image Mars;
    private Thread animThreat;
   
	  

	int refreshRate = 10;
	private boolean isPaused = false;
	private boolean isVisible = false;

	public Animation() {

		setBackground(Color.BLACK);
		setDoubleBuffered(true);

		try {
			Slonce = ImageIO.read(this.getClass().getResource("slonce.png"));
			Merkury = ImageIO.read(this.getClass().getResource("merkury.png"));
			Wenus = ImageIO.read(this.getClass().getResource("wenus.png"));
			Ziemia = ImageIO.read(this.getClass().getResource("ziemia.png"));
			Mars = ImageIO.read(this.getClass().getResource("mars.png"));
			Ksiezyc = ImageIO.read(this.getClass().getResource("ksiezyc.png"));

		} catch (IOException e) {
			e.printStackTrace();
			return;
		}


		x = 40;
		y = 40;
		f = 40;
		h = 40;
		t = 40;
		u = 40;
		o = 40;
		p = 40;
		q = 40;
		r = 50;
		q1=100;
		r1=100;

		animThreat = new Thread(this);
		animThreat.start();
		a1 = 0.0791721;
		b1 = 0.01797608;
		c1 = 0.02922048;
		d1 = 0.0549568;

		x1 = 700;
		y1 = 350;
		x2 = 455;
		y2 = 455;
		x3 = 700;
		y3 = 350;
		x11 = 370;
		y11 = 370;
		x12 = 290;
		y12 = 290;
		x13 = 200;
		y13 = 200;
		x14 = 35;
		y14 = 35;
	}
	

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(Merkury.getScaledInstance(38, 38, 0), x, y, this);
		g.drawImage(Slonce.getScaledInstance(80, 80, 0), x3, y3, null);
		g2.drawImage(Wenus.getScaledInstance(94, 94, 0), f, h, this);
		g2.drawImage(Ziemia.getScaledInstance(100, 100, 0), t, u, this);
		g2.drawImage(Mars.getScaledInstance(53, 53, 0), o, p, this);
		g2.drawImage(Ksiezyc.getScaledInstance(50, 50, 0), q, r, this);
		
		
		if(isVisible){
			g2.setColor(Color.gray);
			g2.drawOval(x11, y11, 225, 225);
			g2.drawOval(x12, y12, 410, 410);
			g2.drawOval(x13, y13, 610, 610);
			g2.drawOval(x14, y14, 920, 920);
			g2.drawOval(t-50, u-50, q1+100, r1+100);
		}
		
		g.dispose();
		
		System.out.println("wylacz aplikacje");
	}
	


	public void OvalsVisibility(Graphics2D g3) {

		g3.setColor(getBackground());

	}

	public void movement() {

		x = (int) (x1 + (116.13 * Math.cos(a)));
		y = (int) (y1 + (116.13 * Math.sin(a)));

		a += a1;

		f = (int) (x1 + (216.99 * Math.cos(b)));
		h = (int) (y1 + (216.99 * Math.sin(b)));

		b += b1;

		t = (int) (x1 + (300 * Math.cos(c)));
		u = (int) (y1 + (300 * Math.sin(c)));

		c += c1;

		o = (int) (x1 + (457.2 * Math.cos(d)));
		p = (int) (y1 + (457.2 * Math.sin(d)));

		d += d1;

		q = (int) ((t+23) + (q1 * Math.cos(d)));
		r = (int) ((u+23) + (r1 * Math.sin(d)));

		d += d1;
		
	}
	

    public void run() {
        
        while (true) {

        	if (!isPaused)
        	{
        		movement();
        		repaint();
        	}

            try {
                Thread.sleep(refreshRate);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            
        }
    }
	   public void switchAnimationState()
	    {
	    	isPaused = !isPaused;
	    }
	   
	  public void switchFaster() {
	    	
	    	refreshRate = 5;
	    }
	    public void switchSlower() {
	    	refreshRate= 50;
	    
	    }

	
	  
	
}
	    