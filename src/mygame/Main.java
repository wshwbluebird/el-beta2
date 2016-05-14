package mygame;

import bean.chesspadmap;
import com.jme3.app.SimpleApplication;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.font.BitmapText;
import com.jme3.font.Rectangle;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import java.util.Scanner;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
     
      
    public static void main(String[] args) {
        testscript app = new testscript();
        app.start();
  
        
        
    }

    @Override
    public void simpleInitApp() {
        
    }

    @Override
    public void simpleUpdate(float tpf) {
                   /** Write text on the screen (HUD) */
        
        
    }
    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
   
     
}
