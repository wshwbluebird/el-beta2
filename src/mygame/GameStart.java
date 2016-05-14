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

/**
 * test
 * @author normenhansen
 */
public class GameStart extends SimpleApplication {
     
     private Sphere bb = new
                      Sphere(16, 16, 0.2f);
      public static chesspadmap chessmap = new chesspadmap();
      public static int right = 0;
      int remain = -1;
      private Vector3f loc ;
      private Vector3f locbase = new Vector3f(-7.5f, 0.2f, -6.5f);
      
      
    public static void main(String[] args) {
       //Main app = new Main();
       //app.start();
        AppSettings settings = new AppSettings(true);
        settings.setResolution(1024,768);
        //settings.setFullscreen(true);
        settings.setSamples(4);
        GameStart app = new GameStart();
        app.setShowSettings(false); // skip built-in dialog
        app.setSettings(settings);
       
         app.start();
        
        
    }
    /** Translucent/transparent cube. Uses Texture from jme3-test-data library! */
    
    @Override
    public void simpleInitApp() {
          
           
           init();
//        flyCam.setDragToRotate(true);
//        flyCam.setMoveSpeed(20f);
//        simpleRender(renderManager);
//
//        attachCenterMark();
//        ChesspadState state = new ChesspadState();
//         stateManager.attach(state);
//         SamuriTestState state1 = new SamuriTestState();
//        stateManager.attach(state1);
//        SamuriTestState2 state2 = new SamuriTestState2();
//        stateManager.attach(state2);
//        SamuriTestState3 state3 = new SamuriTestState3();
//        stateManager.attach(state3);
//        SamuriTestState4 state4 = new SamuriTestState4();
//        stateManager.attach(state4);
//         SamuriTestState5 state5 = new SamuriTestState5();
//         stateManager.attach(state5);
//        SamuriTestState6 state6 = new SamuriTestState6();
//        stateManager.attach(state6);
    }

    @Override
    public void simpleUpdate(float tpf) {
                   /** Write text on the screen (HUD) */
        int num1 = SamuriTestState.spirsamuri.fields+SamuriTestState3.swordsamuri.fields+SamuriTestState5.axsamuri.fields;
        int num2 = SamuriTestState2.spirsamuri.fields+SamuriTestState4.swordsamuri.fields+SamuriTestState6.axsamuri.fields;
                
        guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText heText = new BitmapText(guiFont, false);
        heText.setSize(guiFont.getCharSet().getRenderedSize());
        heText.setText("Team1: "+num1 +"  vs  Team2: "+num2);
        heText.setColor(ColorRGBA.Blue);
        heText.setLocalTranslation(100, heText.getLineHeight()+500, 0);
        heText.setLocalScale(2);
        guiNode.attachChild(heText);
        //
        
        
        
        if(right==180){
//               int number1 = SamuriTestState.spirsamuri.fields+SamuriTestState3.swordsamuri.fields+SamuriTestState5.axsamuri.fields;
//               int number2 = SamuriTestState2.spirsamuri.fields+SamuriTestState4.swordsamuri.fields+SamuriTestState6.axsamuri.fields;
//                       /** Write text on the screen (HUD) */
        guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText helloText = new BitmapText(guiFont, false);
        helloText.setBox(new Rectangle(100, 500, 40, 40));
       
        helloText.setSize(guiFont.getCharSet().getRenderedSize());
        if(num1>num2)
        helloText.setText("Team1 won");
        if(num1<num2)
        helloText.setText("Team2 won");
        helloText.setLocalTranslation(100, helloText.getLineHeight()+500, 0);
        guiNode.attachChild(helloText);
 
               //stateManager.cleanup();
               
               System.out.println(num1+"  :  "+num2);
               rootNode.detachAllChildren();
               
           }
        
        if(right%6==0&&remain!=0){
            
            loc = new Vector3f(SamuriTestState.spirsamuri.px*1.0f 
                    + locbase.x,locbase.y, SamuriTestState.spirsamuri.pz*1.0f+locbase.z);
            Vector3f to = new Vector3f(loc.x, loc.y+7.0f, loc.z+8.0f);
            cam.setLocation(to);
            cam.lookAt(loc, new Vector3f(0, 0, 0));
            
            remain =0;
            
            if(SamuriTestState.spirsamuri.fields>=25)   SamuriTestState.spirsamuri.attackfields=5;
            else if(SamuriTestState.spirsamuri.fields<25) SamuriTestState.spirsamuri.attackfields=4;
           
        }else  if(right%6==1&&remain!=1)  {
            //waitfor();
            loc = new Vector3f(SamuriTestState2.spirsamuri.px*1.0f 
                    + locbase.x,locbase.y, SamuriTestState2.spirsamuri.pz*1.0f+locbase.z);
            Vector3f to = new Vector3f(loc.x, loc.y+7.0f, loc.z+8.0f);
            cam.setLocation(to);
            cam.lookAt(loc, new Vector3f(0, 0, 0));
            remain =1 ;
            if(SamuriTestState2.spirsamuri.fields>=25)   SamuriTestState2.spirsamuri.attackfields=5;
            else if(SamuriTestState2.spirsamuri.fields<25) SamuriTestState2.spirsamuri.attackfields=4;
           
        }else  if(right%6==2&&remain!=2)  {
            loc = new Vector3f(SamuriTestState3.swordsamuri.px*1.0f 
                    + locbase.x,locbase.y, SamuriTestState3.swordsamuri.pz*1.0f+locbase.z);
            Vector3f to = new Vector3f(loc.x, loc.y+7.0f, loc.z+8.0f);
            cam.setLocation(to);
            cam.lookAt(loc, new Vector3f(0, 0, 0));
            remain =2;
            if(SamuriTestState3.swordsamuri.execute==0&&SamuriTestState3.swordsamuri.fields>=25)   SamuriTestState3.swordsamuri.energy=7;
            else if(SamuriTestState3.swordsamuri.execute==0&&SamuriTestState3.swordsamuri.fields>=25) SamuriTestState3.swordsamuri.energy=6;
           
        }else  if(right%6==3&&remain!=3)  {
           loc = new Vector3f(SamuriTestState4.swordsamuri.px*1.0f 
                    + locbase.x,locbase.y, SamuriTestState4.swordsamuri.pz*1.0f+locbase.z);
            Vector3f to = new Vector3f(loc.x, loc.y+7.0f, loc.z+8.0f);
            cam.setLocation(to);
            cam.lookAt(loc, new Vector3f(0, 0, 0));
            remain = 3;
             if(SamuriTestState4.swordsamuri.execute==0&&SamuriTestState4.swordsamuri.fields>=25)   SamuriTestState4.swordsamuri.energy=7;
            else if(SamuriTestState4.swordsamuri.execute==0&&SamuriTestState4.swordsamuri.fields<25) SamuriTestState4.swordsamuri.energy=6;
           
        }else  if(right%6==4&&remain!=4)  {
            loc = new Vector3f(SamuriTestState5.axsamuri.px*1.0f 
                    + locbase.x,locbase.y, SamuriTestState5.axsamuri.pz*1.0f+locbase.z);
            Vector3f to = new Vector3f(loc.x, loc.y+7.0f, loc.z+8.0f);
            cam.setLocation(to);
            cam.lookAt(loc, new Vector3f(0, 0, 0));
            remain = 4;
             if(SamuriTestState6.axsamuri.execute==0&&SamuriTestState5.axsamuri.fields>=25)   SamuriTestState6.axsamuri.energy=5;
            else if(SamuriTestState6.axsamuri.execute==0&&SamuriTestState5.axsamuri.fields<25) SamuriTestState6.axsamuri.energy=6;
           
        }else  if(right%6==5&&remain!=5)  {
            loc = new Vector3f(SamuriTestState6.axsamuri.px*1.0f 
                    + locbase.x,locbase.y, SamuriTestState6.axsamuri.pz*1.0f+locbase.z);
            Vector3f to = new Vector3f(loc.x, loc.y+7.0f, loc.z+8.0f);
            cam.setLocation(to);
            cam.lookAt(loc, new Vector3f(0, 0, 0));
            remain = 5;
            if(SamuriTestState5.axsamuri.execute==0&&SamuriTestState6.axsamuri.fields>=25)   SamuriTestState5.axsamuri.energy=5;
            else if(SamuriTestState5.axsamuri.execute==0&&SamuriTestState6.axsamuri.fields<25) SamuriTestState5.axsamuri.energy=6;
           
        }
        
    }
    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    private void attachCenterMark() {
           Geometry c = myBox("center mark",
             Vector3f.ZERO, ColorRGBA.White);
           c.scale(4);
           c.setLocalTranslation( settings.getWidth()/2,
             settings.getHeight()/2, 0 );
           guiNode.attachChild(c); // attach to 2D user interface
}
    public Geometry myBox(String name, Vector3f loc, ColorRGBA color)
    {
        Geometry geom = new Geometry(name, bb);
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
    void init(){
        flyCam.setDragToRotate(true);
        flyCam.setMoveSpeed(20f);
        simpleRender(renderManager);

        attachCenterMark();
        ChesspadState state = new ChesspadState();
         stateManager.attach(state);
         SamuriTestState state1 = new SamuriTestState();
        stateManager.attach(state1);
        SamuriTestState2 state2 = new SamuriTestState2();
        stateManager.attach(state2);
        SamuriTestState3 state3 = new SamuriTestState3();
        stateManager.attach(state3);
        SamuriTestState4 state4 = new SamuriTestState4();
        stateManager.attach(state4);
         SamuriTestState5 state5 = new SamuriTestState5();
         stateManager.attach(state5);
        SamuriTestState6 state6 = new SamuriTestState6();
        stateManager.attach(state6);
    }

     
}