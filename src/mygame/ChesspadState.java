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
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Spatial;
import java.awt.Color;

/**
 *
 * @author wshwbluebird
 */
public class ChesspadState extends AbstractAppState{
    private SimpleApplication app;
    private Camera cam;
    private Node rootNode;
    private AssetManager assetManager;
    private Ray ray = new Ray();
    private static Box mesh = new Box(Vector3f.ZERO, 0.2f, 0.001f, 0.2f);
    public static final Quaternion ROLL090  = new Quaternion().fromAngleAxis(FastMath.PI/2*3,   new Vector3f(1,0,0));
    
    private Vector3f locbase = new Vector3f(-7.5f, 0.2f, -6.5f);
    private Geometry[][] geom = new Geometry[15][15];
    @Override
         public void update(float tpf) {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                 if(GameStart.chessmap.getmap1(i, j)==1){
                     geom[i][j].getMaterial().setColor("Color",ColorRGBA.Blue);
                 }else if(GameStart.chessmap.getmap1(i, j)==4){
                     geom[i][j].getMaterial().setColor("Color",ColorRGBA.Pink);
                 }else if(GameStart.chessmap.getmap1(i, j)==3){
                     geom[i][j].getMaterial().setColor("Color",ColorRGBA.Orange);
                 }else if(GameStart.chessmap.getmap1(i, j)==6){
                     geom[i][j].getMaterial().setColor("Color",ColorRGBA.Green);
                 }else if(GameStart.chessmap.getmap1(i, j)==2){
                     geom[i][j].getMaterial().setColor("Color",ColorRGBA.Red);
                 }else if(GameStart.chessmap.getmap1(i, j)==5){
                     geom[i][j].getMaterial().setColor("Color",ColorRGBA.Cyan);
                 }
            }
        }

         
         
      
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
            Spatial  mymodel = assetManager.loadModel(
                   "Textures/chessboard/chesspad5.j3o");
            mymodel.setLocalTranslation(-0.5f, -0.75f, 0.5f);
         mymodel.scale(0.1f);
         mymodel.rotate(ROLL090);
        
         DirectionalLight sun = new DirectionalLight();
         sun.setDirection((new Vector3f(0.0f, -1.0f, -2.0f)));
         sun.setColor(ColorRGBA.White);
         mymodel.addLight(sun);
         //DirectionalLight sun2 = new DirectionalLight();
//         sun2.setDirection((new Vector3f(0.0f, 0.0f, 5.0f)));
//         sun2.setColor(ColorRGBA.Green);
         mymodel.addLight(sun);
         rootNode.addLight(sun);
        // rootNode.addLight(sun2);
         rootNode.attachChild(mymodel);
        
        
         
        
        
        for(int i = 0 ;i <15;i++) {
           for(int j = 0 ; j<15;j++){
               
               Vector3f loc  = new Vector3f(i*1.0f+locbase.x, 0.2f, j*1.0f+locbase.z);
               if((i+j)%2==0)
               rootNode.attachChild( geom[i][j]=myBox("aa"+i,loc));
               else
               rootNode.attachChild( geom[i][j]=myBox("aa"+i,loc) );
          
          }
    
        }
    
    }
    
  
    
     public Geometry myBox(String name, Vector3f loc)
    {
        Geometry geom = new Geometry(name, mesh);
        Material mat = new Material(assetManager,
            "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", color);
        //mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        mat.setTransparent(false);
        mat.setColor("Color",new ColorRGBA(0, 0, 0, 0));
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
 