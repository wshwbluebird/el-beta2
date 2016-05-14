package mygame;

import bean.chesspadmap;
import com.jme3.app.SimpleApplication;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.font.BitmapText;
import com.jme3.font.Rectangle;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.light.SpotLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import java.util.Scanner;

/**
 * test
 * @author normenhansen
 */
public class testscript extends SimpleApplication {
    
      
    public static void main(String[] args) {
        testscript app = new testscript();
        app.start();
        
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(20f);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
                   /** Write text on the screen (HUD) */
        
        
        
    }
    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
   
   
    public void addFire (String name , Vector3f loc,ColorRGBA color1,ColorRGBA color2){
        ParticleEmitter fireEffect = new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 30);
                  Material fireMat = new Material(assetManager, "Common/MatDefs/Misc/Particle.j3md");
                   fireEffect.setName(name);
                  fireEffect.setMaterial(fireMat);
                  fireEffect.setLocalTranslation(loc);
                  fireEffect.setImagesX(2); fireEffect.setImagesY(2); // 2x2 texture animation
                 // fireEffect.setEndColor( new ColorRGBA(4f, 1f, 0f, 1f) );   // red
                  fireEffect.setEndColor( color1); 
                 // fireEffect.setStartColor( new ColorRGBA(3f, 1f, 3f, 2.5f) ); // yellow
                  fireEffect.setStartColor( ColorRGBA.Black);
                  fireEffect.getParticleInfluencer().setInitialVelocity(new Vector3f(0, 2, 0));
                  fireEffect.setStartSize(0.2f);
                  fireEffect.setEndSize(0.05f);
                  fireEffect.setGravity(0f,1f,0f);
                  fireEffect.setLowLife(0.02f);
                  fireEffect.setHighLife(0.2f);
                  fireEffect.getParticleInfluencer().setVelocityVariation(0.3f);
                  rootNode.attachChild(fireEffect);
    }
}
