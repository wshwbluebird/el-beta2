/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import bean.chesspadmap;
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.light.DirectionalLight;
import com.jme3.light.SpotLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Spatial;

/**
 *
 * @author wshwbluebird
 */
public class balltestState extends AbstractAppState{
    private SimpleApplication app;
    private Camera cam;
    private Node rootNode;
    private AssetManager assetManager;
    private Ray ray = new Ray();
    private static Box mesh = new Box(Vector3f.ZERO, 1, 1, 1);
    private chesspadmap chessmap ;
    private Vector3f locbase = new Vector3f(-7.5f, 0.2f, -6.5f);
    
    @Override
         public void update(float tpf) {
            /** A cone-shaped spotlight with location, direction, range */
            
              
         GameStart.chessmap.setmap1(1, 2, 3);
         
      
    }
    @Override
         public void cleanup() {}
    @Override
         public void initialize(AppStateManager stateManager,
                                Application app) {
            super.initialize(stateManager, app);
            this.app = (SimpleApplication) app;
            this.cam = this.app.getCamera();
            this.rootNode = this.app.getRootNode();
            this.assetManager = this.app.getAssetManager();
            this.chessmap = GameStart.chessmap;
         
          
    }
    
    
    
    
    
  
    
     public Geometry myBox(String name, Vector3f loc, ColorRGBA color)
    {
        Geometry geom = new Geometry(name, mesh);
        Material mat = new Material(assetManager,
            "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(loc);
        
        return geom;
        
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
 