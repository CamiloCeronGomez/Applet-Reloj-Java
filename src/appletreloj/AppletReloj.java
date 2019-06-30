/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appletreloj;

/**
 *
 * @author camilo
 */
import java.applet.Applet;
import java.util.Date;
public class AppletReloj extends Applet implements Runnable {
Date d;
Thread t;
boolean activo;
public void run() {
while ( activo ) {
repaint();
try {
Thread.sleep(1000);
} catch (InterruptedException e) { e.printStackTrace(); }
}
}
public void init() {
t = new Thread(this);
}
public void start() {
activo = true;
t.start();
}
public void stop() {
activo = false;
}
public void paint(java.awt.Graphics g) {
d = new Date();
g.drawString( d.getHours()+":"+ d.getMinutes()+
":"+d.getSeconds(), 10, 10);
}
}
