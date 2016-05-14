/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import bean.SpirSamuri;
import bean.SwordSamuri;
import com.jme3.app.Application;
import com.jme3.app.FlyCamAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.collision.CollisionResults;
import com.jme3.input.FlyByCamera;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;

import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import com.jme3.scene.shape.Sphere;


/**
 *
 * @author wshwbluebird
 */
public class SamuriTestState3 extends AbstractAppState{
    private int clicktime = 0;
    private Vector3f locbase = new Vector3f(-7.5f, 0.2f, -6.5f);

    public static SwordSamuri swordsamuri = new SwordSamuri(3, 1, 14, 0);
    private int currentEnergy = swordsamuri.energy;
    
    private final static Trigger TRIGGER_Choose =
                     new MouseButtonTrigger(MouseInput.BUTTON_LEFT);   
    private final static Trigger TRIGGER_Up =
           new KeyTrigger(KeyInput.KEY_UP);
    private final static Trigger TRIGGER_Down =
           new KeyTrigger(KeyInput.KEY_DOWN);
    private final static Trigger TRIGGER_Left =
           new KeyTrigger(KeyInput.KEY_LEFT);
    private final static Trigger TRIGGER_Right =
           new KeyTrigger(KeyInput.KEY_RIGHT);
    private final static Trigger TRIGGER_Attack =
           new KeyTrigger(KeyInput.KEY_SPACE);
   
    private final static String MAPPING_Choose = "Choose";
    private final static String MAPPING_Up  = "Up";
    private final static String MAPPING_Down  = "Down";
    private final static String MAPPING_Left  = "Left";
    private final static String MAPPING_Right  = "Right";
    private final static String MAPPING_Attack  = "Attack";
    
    
    
    
    
    private SimpleApplication app;
    private Camera cam;
    private Node rootNode;
    private AssetManager assetManager;
    private InputManager inputManager;
    private Spatial pawn;
    
    
    @Override
         public void update(float tpf) {
         
        if(GameStart.right%6==2){
             

             inputManager.addListener(actionListener, new String[]{MAPPING_Up});
             inputManager.addListener(actionListener, new String[]{MAPPING_Down});
             inputManager.addListener(actionListener, new String[]{MAPPING_Left});
             inputManager.addListener(actionListener, new String[]{MAPPING_Right});
             inputManager.addListener(actionListener, new String[]{MAPPING_Attack});
             inputManager.addListener(analogListener,new String[]{MAPPING_Choose});
            
             
         }else {
             inputManager.removeListener(analogListener);
             inputManager.removeListener(actionListener);
         }
          if(swordsamuri.execute==0&&currentEnergy==0){
             GameStart.right++;
             currentEnergy = swordsamuri.energy;      
         }else if(swordsamuri.execute==6){
             pawn.setLocalTranslation(swordsamuri.initpx*1.0f+locbase.x, 0.2f, swordsamuri.initpz*1.0f+locbase.z);
             GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz, 0);
             swordsamuri.px = swordsamuri.initpx;
             swordsamuri.pz = swordsamuri.initpz;
             currentEnergy = swordsamuri.energy;  
             swordsamuri.execute=5;
         }else if(swordsamuri.execute==5&&GameStart.right%6==2){
             GameStart.right++;
             swordsamuri.energy =2;
             currentEnergy = swordsamuri.energy;
             swordsamuri.execute=4;
         }else if(swordsamuri.execute==4&&currentEnergy==0&&GameStart.right%6==2){
             GameStart.right++;
             swordsamuri.energy =4;
             currentEnergy = swordsamuri.energy;  
             swordsamuri.execute=2;
         }else if(swordsamuri.execute==2&&currentEnergy==0&&GameStart.right%6==2){
             GameStart.right++;
             swordsamuri.energy =6;
             currentEnergy = swordsamuri.energy;  
             swordsamuri.execute=0;
         }
         
      
    }
    @Override
         public void cleanup() {}
    @Override
         public void initialize(AppStateManager stateManager,
                                Application app ) {
            super.initialize(stateManager, app);
            this.app = (SimpleApplication) app;
            this.cam = this.app.getCamera();
            this.rootNode = this.app.getRootNode();
            this.assetManager = this.app.getAssetManager();
            this.inputManager = this.app.getInputManager();
            
             Vector3f loc1 = new Vector3f(swordsamuri.px*1.0f+locbase.x,0.2f,swordsamuri.pz*1.0f+locbase.z);
             pawn = assetManager.loadModel("Textures/chesspawn/spearC.j3o");
             pawn.setLocalTranslation(loc1);
             pawn.setName("ball3");
             final Quaternion ROLL270  = new Quaternion().fromAngleAxis(-FastMath.PI/2, 
                 new Vector3f(0,1,0));
             pawn.rotate(ROLL270);
             rootNode.attachChild(pawn);
             inputManager.addMapping(MAPPING_Up, TRIGGER_Up);
             inputManager.addMapping(MAPPING_Down, TRIGGER_Down);
             inputManager.addMapping(MAPPING_Left, TRIGGER_Left);
             inputManager.addMapping(MAPPING_Right, TRIGGER_Right);
             inputManager.addMapping(MAPPING_Choose, TRIGGER_Choose);
             inputManager.addMapping(MAPPING_Attack, TRIGGER_Attack);
    }
 
      private ActionListener actionListener = new ActionListener() {
         public void onAction(String name, boolean isPressed, float tpf)
       {   
           
           System.out.println("You triggered: "+name);          
                   if(name.equals(MAPPING_Up) && !isPressed) {
                       if(clicktime==0){
                        if(swordsamuri.pz-1>=0&&GameStart.chessmap.getmap2(swordsamuri.px, swordsamuri.pz-1)==0){
                       
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,0);
                        pawn.move(0.0f, 0.0f, -1.0f);
                        currentEnergy--;
                        swordsamuri.pz--;
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,3);
                        }
                      }else{
                       pawn.move(0.0f, -0.5f, 0.0f);
                       chagedirectoinn(SamuriTestState3.swordsamuri.getDirection(), 1);
                       swordsamuri.setDirection(1);
                       currentEnergy--;
                       clicktime=0;
                    }
                   }
                   if (name.equals(MAPPING_Down) && !isPressed) {
                       if(clicktime==0){
                           System.out.println("ok1");
                       if(swordsamuri.pz+1<=14&&GameStart.chessmap.getmap2(swordsamuri.px, swordsamuri.pz+1)==0){
                           System.out.println("ok2");
                        
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,0);
                        pawn.move(0.0f, 0.0f, 1.0f);  
                        currentEnergy--;
                        swordsamuri.pz++;
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,3);
                        }
                       
                      }else{
                       pawn.move(0.0f, -0.5f, 0.0f);
                       chagedirectoinn(SamuriTestState3.swordsamuri.getDirection(), 0);
                       swordsamuri.setDirection(0);
                       clicktime=0;
                       currentEnergy--;
                       }
                   }
                    if (name.equals(MAPPING_Left) && !isPressed) {
                        if(clicktime==0){
                        if(swordsamuri.px-1>=0&&GameStart.chessmap.getmap2(swordsamuri.px-1, swordsamuri.pz)==0){
                        ;
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,0);
                        pawn.move(-1.0f, 0.0f, 0.0f);                       
                        swordsamuri.px--;
                        currentEnergy--;
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,3);
                        }
                      }else{
                       pawn.move(0.0f, -0.5f, 0.0f);
                       chagedirectoinn(SamuriTestState3.swordsamuri.getDirection(), 3);
                       swordsamuri.setDirection(3);
                       clicktime=0;
                       currentEnergy--;
                      }
                    }
                   if (name.equals(MAPPING_Right) && !isPressed) {
                        if(clicktime==0){
                         if(swordsamuri.px+1<=14&&GameStart.chessmap.getmap2(swordsamuri.px+1, swordsamuri.pz)==0){
                        
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,0);
                        pawn.move(1.0f, 0.0f, 0.0f);    
                        currentEnergy--;
                        swordsamuri.px++;
                        GameStart.chessmap.setmap2(swordsamuri.px, swordsamuri.pz,3);
                        }
                      }else{
                       pawn.move(0.0f, -0.5f, 0.0f);
                       chagedirectoinn(SamuriTestState3.swordsamuri.getDirection(), 2);
                       swordsamuri.setDirection(2);
                       clicktime=0;
                       currentEnergy--;
                       }
                   }
                   if (name.equals(MAPPING_Attack) && !isPressed) {
                        if(clicktime==0&&currentEnergy>=2){
                       swordsamuri.attack();
                       currentEnergy = currentEnergy-2;
                      }
                   }
              }
         

   };
     private AnalogListener analogListener = new AnalogListener() {
         public void onAnalog(String name, float intensity, float tpf) {
           System.out.println("You triggered: "+name);
           if (name.equals(MAPPING_Choose)) {
               
               CollisionResults results = new CollisionResults();
               Vector2f click2d = inputManager.getCursorPosition();
               Vector3f click3d = cam.getWorldCoordinates(
                                   new Vector2f(click2d.getX(), click2d.getY()), 0f);
               Vector3f dir = cam.getWorldCoordinates(
                                  new Vector2f(click2d.getX(), click2d.getY()), 1f).
                                   subtractLocal(click3d);
               Ray ray = new Ray(click3d, dir);
               rootNode.collideWith(ray, results);
              
                if (results.size() > 0) {
                        Geometry target = results.getClosestCollision().getGeometry();  
                         if(target.getName().equals("ball3")&&clicktime==0){
                             target.move(0,0.5f,0);           
                             clicktime  = 1;
                          } else {
                        System.out.println("Selection: Nothing" );
                         }
              }
            }
         }
     
   };
       private void chagedirectoinn(int ori ,int now){
         
         int first = modedir(ori);
         int second = modedir(now);
         final Quaternion ROLL090  = new Quaternion().fromAngleAxis(FastMath.PI/2*(first-second), 
                 new Vector3f(0,1,0));
         pawn.rotate(ROLL090);
     }
         private int modedir(int d){
             if(d==0) return 5;
             if(d==3) return 6;
             if(d==1) return 7;
             if(d==2) return 8;
             else return 0;
         }
 }