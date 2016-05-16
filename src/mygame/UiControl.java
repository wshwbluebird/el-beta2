/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.bounding.BoundingVolume;
import com.jme3.collision.Collidable;
import com.jme3.collision.CollisionResults;
import com.jme3.input.InputManager;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.ui.Picture;

/**
 *
 * @author wshwbluebird
 */
public class UiControl extends AbstractControl{
    private final static Trigger TRIGGER_Choose =
                     new MouseButtonTrigger(MouseInput.BUTTON_LEFT); 
    private final static String MAPPING_Choose = "Choose";
    private Ray ray = new Ray();
    private final Camera cam;
    private final Node rootNode;
    private InputManager inputManager;
    
    public UiControl(Camera cam, Node rootNode,InputManager inputManager) {
            this.cam = cam;
            this.rootNode = rootNode;
            this.inputManager = inputManager;
            inputManager.addMapping(MAPPING_Choose, TRIGGER_Choose);
            inputManager.addListener(analogListener,new String[]{MAPPING_Choose});
            
    }

    @Override
    protected void controlUpdate(float tpf) {
      
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private AnalogListener analogListener = new AnalogListener() {
         public void onAnalog(String name, float intensity, float tpf) {
           System.out.println("You triggered: "+name);
           if (name.equals(MAPPING_Choose)) {
               
               //CollisionResults results = new CollisionResults();
               Vector2f click2d = inputManager.getCursorPosition();
               float x =  Uiframe.start.getLocalTranslation().x;
               float y = Uiframe.start.getLocalTranslation().y;
               float deltx = Uiframe.start.getLocalScale().x;
               float delty = Uiframe.start.getLocalScale().y;
               if(click2d.x>x&&click2d.x<x+deltx&&click2d.y>y&&click2d.y<y+delty){
                   Uiframe.start.move(30, 0, 0);
                   GameStart.startflag=true;
                   GameStart.gaming =true;
                   inputManager.removeListener(analogListener);
                   
               }
                     
               
               
            }
         }
     
   };
    
}
