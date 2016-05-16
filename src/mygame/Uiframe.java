/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;


import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;

import com.jme3.ui.Picture;

/**
 *
 * @author wshwbluebird
 */
public class Uiframe extends AbstractAppState{
    private SimpleApplication app;
    private Camera cam;
    private Node rootNode;
    private AssetManager assetManager;
    private Node guiNode;
    static Picture start;
   
    @Override
         public void update(float tpf) {

      
         
         
      
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
            this.guiNode = this.app.getGuiNode();
            System.out.print("DSfdsfdsf");
             start = new Picture("Start");   
             start.setWidth(GameStart.sx/5);
             start.setHeight(GameStart.sy/4);
             start.setImage(assetManager, "Scenes/nju.png", true );
      
             start.worldToLocal(new Vector3f(0, 0, 0), new Vector3f(1, 1, 1));
             start.setLocalTranslation(GameStart.sx/15*7, GameStart.sy/3*2, 0);
             start.addControl(new UiControl(cam, rootNode, app.getInputManager()));
             guiNode.attachChild(start);
    }
    
  
    
}
 