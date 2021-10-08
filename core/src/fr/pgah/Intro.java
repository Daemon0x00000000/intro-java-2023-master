package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch;
  Texture[] imgs;
  Rectangle rectangle;
  int[] x;
  int[] y;
  int[] val;
  int[] val2;
  int hauteurFenetre;
  int[] hauteursImgs;
  int LargeurFenetre;
  int[] LargeursImgs;
  int min;
  int max;


  @Override
  public void create() {                        // 1 fois
    batch = new SpriteBatch();                  // Assignation pour un type objet en mémoire vive
    imgs = new Texture[2];
    imgs[0] = new Texture("sio.jpg");
    imgs[1] = new Texture("badlogic.jpg");
    x = new int[2];
    y = new int[2];
    x[0] = 0;
    x[1] = 100;
    y[0] = 0;
    y[1] = 100;
    val = new int[2];
    val2 = new int[2];
    val[0] = 5;                                      //Les entiers sont par défauts à 0
    val2[0] = 5;
    val[1] = 5;
    val2[1] = 5;
    hauteursImgs = new int[2];
    LargeursImgs = new int[2];
    hauteursImgs[0] = imgs[0].getHeight();
    hauteursImgs[1] = imgs[1].getHeight();
    hauteurFenetre = Gdx.graphics.getHeight();
    LargeurFenetre = Gdx.graphics.getWidth();
    LargeursImgs[0] = imgs[0].getWidth();
    LargeursImgs[1] = imgs[1].getWidth();
//    rectangle = new Rectangle(x, y, LargeurImg, hauteurImg);
    min = 0;
    max = 255;

  }

  @Override
  public void render() {                        //60 fois par seconde
    reinitialiserBackground();
    testerbordure();
    dessiner();
//    checkclic();
  }

  private void dessiner() {
    batch.begin();
    for (int i = 0; i <= 1; i++) {
      batch.draw(imgs[i], x[i], y[i]);
    }
    batch.end();
  }

//  private void checkclic() {
//    if(Gdx.input.isTouched()) {
//      rectangle = new Rectangle(x, y, LargeurImg, hauteurImg);
//      if (rectangle.contains(Gdx.input.getX(), Gdx.input.getY())) {
//      }
//    }
//  }

  private void testerbordure() {
    for (int i = 0; i <= 1; i++) {                        //int i = 0, on initialise à 0, i <= 1, on ne s'arrête pas tant que i est inférieur ou égal à 1, on incrémente de 1
      if (y[i] + hauteursImgs[i] >= hauteurFenetre) {
        val2[i] = -5;
      }
      if (x[i] + LargeursImgs[i] >= LargeurFenetre) {
        val[i] = -5;
      }
      if (y[i] <= 0) {
        val2[i] = 5;
      }
      if (x[i] <= 0) {
        val[i] = 5;
      }
      x[i] = x[i]+val[i]; // incrémentation
      y[i] = y[i]+val2[i];
    }
  }

  private void reinitialiserBackground() {
    ScreenUtils.clear(1,0, 0, 1);
  }
}