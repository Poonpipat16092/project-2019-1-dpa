package object;


import exception.BarrierOnException;
import exception.MaxHealthException;
import graphic.AudioLoader;
import graphic.GameScreen;
import graphic.ImageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Player extends BattleshipObject {
	private boolean isBarrier;
	private int shootMode=-1;
	private int gunTimer=0;
	private int modeTimer=0;
	private Image currentImage;

	public Player(ObjectHandler handler) {
		super(400,500,ID.Player,handler,70,70);
		setDamage(1);
		hp=10;
		isBarrier=false;
		velX=0;
		velY=0;
		limitX=800;
		limitY=600;
		handler.addObject(this);
	}
	
	@Override
	public void tick() {
		if(!isShow) return;
		x+=velX;
		y+=velY;
		shooting();
		// find the limit of scene(edit this when got fix size)
		if(x<=0) x=0;
		if(x>=limitX-width) x=limitX-width;
		if(y<=0) y=0;
		if(y>=limitY-height*4/3) y=limitY-height*4/3;

		collision();
		gunTimer++;
	}
	
	public void collision() {
		//when being hit //can minimize round with getZ to only check some Z
		for(GameObject temp:handler.getObjects()) {
			if(temp.getId()==ID.Enemy || temp.getId()==ID.Boss) {
				if(getBounds().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow){
					getHit(temp);
					temp.getHit(this);
				}
				else if(getBounds2().intersects(temp.getBounds().getBoundsInLocal()) && temp.isShow) {
					getHit(temp);
					temp.getHit(this);
				}
			}
		}
		
	}
	
	public void getHit(GameObject object) {
		if(isBarrier) isBarrier=false;
		else hp-=((Damagable) object).getDamage();
		checkShow();
	}
	
	public void getHealth(int health) {
		try {
			if(hp>=15) {
				throw new MaxHealthException();
			}
			hp+=health;
		}
		catch(MaxHealthException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		if(!isShow) return;
//		gc.setFill(Color.WHITE);
//		gc.fillRect(x+width/3,y,width/3, height-5);
//		gc.fillRect(x,y+height/3,width, height/4);
		if(isBarrier) {
			gc.drawImage(ImageLoader.BARRIER, x, y);
		}
		gc.drawImage(currentImage, x, y);
		//check hp
	}
	
	public void shooting() {
		if(modeTimer>=35) {
			setMode(-1);
			modeTimer=0;
		}
		if(shootMode==-1) {
			if(gunTimer>=20) {
				Bullet bullet=new Bullet(x+width/2, y,0,-7,id,1,handler);
				gunTimer=0;
			}
		}
		else if(shootMode==0) {
			if(gunTimer>=15) {
				Bullet bullet1=new Bullet(x+width/2, y,1,-7,id,1,handler);	
				Bullet bullet2=new Bullet(x+width/2, y,0,-7,id,1,handler);
				Bullet bullet3=new Bullet(x+width/2, y,-1,-7,id,1,handler);
				gunTimer=0;
				modeTimer++;
			}
		}
		else if(shootMode==1) {
			if(gunTimer>=15) {
				Bullet bullet1=new Bullet(x+width/2+10, y,0,-7,id,2,handler);
				Bullet bullet2=new Bullet(x+width/2-10, y,0,-7,id,2,handler);
				gunTimer=0;
				modeTimer++;
			}
		}
		
	}
	
	public int getZ() {
		return 0;
	}
		
	public void setPlayer(String player) {
		if(player=="Player1") {
			currentImage=ImageLoader.INGAME_PLAYER1;
		}
		if(player=="Player2") {
			currentImage=ImageLoader.INGAME_PLAYER2;
		}
	}
	
	public Shape getBounds() {
		//size of the hit box
		return new Rectangle(x+width/3,y,width/3, height-5);
		}
	
	public Shape getBounds2() {
		return new Rectangle(x,y+height/3,width, height/4);
		}
	
	public void setBarrier(boolean on) {
		try {
			if(isBarrier && on) throw new BarrierOnException();
			isBarrier=on;
		}
		catch(BarrierOnException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public boolean isBarrier() {
		return isBarrier;
	}

	public void setMode(int mode){
		shootMode=mode;
		modeTimer=0;
	}
}
