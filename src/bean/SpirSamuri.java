/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.jme3.scene.shape.Sphere;
import mygame.GameStart;
import mygame.SamuriTestState;
import mygame.SamuriTestState2;
import mygame.SamuriTestState3;
import mygame.SamuriTestState4;
import mygame.SamuriTestState5;
import mygame.SamuriTestState6;

/**
 *
 * @author wshwbluebird
 */
public class SpirSamuri {
     private int index;
     private int armynumber;
     public int energy;
     private int direction;
     public  int fields;
     public int attackfields;
     public int px,pz;
     public int execute=0;
     public int initpx,initpz;
     
     public SpirSamuri(int index,int armynumber, int px ,int pz){
         this.index = index;
         this.armynumber = armynumber;
         this.px = px;
         this.pz = pz;
         this.initpx = px;
         this.initpz = pz;
         if(index<=3) direction = 0;
         else direction = 1;
         this.fields = 0;
         this.energy = 6;
         this.attackfields=4;
         
     }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return the armynumber
     */
    public int getArmynumber() {
        return armynumber;
    }

    /**
     * @return the energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy the energy to set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the fields
     */
    public int getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(int fields) {
        this.fields = fields;
    }

    /**
     * @return the attackfields
     */
    public int getAttackfields() {
        return attackfields;
    }

    /**
     * @param attackfields the attackfields to set
     */
    public void setAttackfields(int attackfields) {
        this.attackfields = attackfields;
    }
     public void attack(int attackfield){
         for (int i = 1; i <= attackfield ; i++) {
              if(direction == 0){
                  
                  if(pz+i>=0&&pz+i<=14){
                      int pre =  GameStart.chessmap.getmap1(px,pz+i);
                           if(pre==1) SamuriTestState.spirsamuri.fields--;
                           else if(pre==4) SamuriTestState2.spirsamuri.fields--;
                           else if(pre==2) SamuriTestState5.axsamuri.fields--;
                           else if(pre==5) SamuriTestState6.axsamuri.fields--;
                           else if(pre==3) SamuriTestState3.swordsamuri.fields--;
                           else if(pre==6) SamuriTestState4.swordsamuri.fields--;
                      GameStart.chessmap.setmap1(px,pz+i , index);
                      this.fields++;
                      int temp =  GameStart.chessmap.getmap2(px, pz+i);
                      
                      if((temp/4)+1!=armynumber){
                           if(temp==1) SamuriTestState.spirsamuri.execute=6;
                           if(temp==4) SamuriTestState2.spirsamuri.execute=6;
                           if(temp==2) SamuriTestState5.axsamuri.execute=6;
                           if(temp==5) SamuriTestState6.axsamuri.execute=6;
                           if(temp==3) SamuriTestState3.swordsamuri.execute=6;
                           if(temp==6) SamuriTestState4.swordsamuri.execute=6;
                      }
                      
                  }
    
              }
              if(direction == 1){
                  if(pz-i>=0&&pz-i<=14)   {
                      int pre =  GameStart.chessmap.getmap1(px,pz-i);
                           if(pre==1) SamuriTestState.spirsamuri.fields--;
                           else if(pre==4) SamuriTestState2.spirsamuri.fields--;
                           else if(pre==2) SamuriTestState5.axsamuri.fields--;
                           else if(pre==5) SamuriTestState6.axsamuri.fields--;
                           else if(pre==3) SamuriTestState3.swordsamuri.fields--;
                           else if(pre==6) SamuriTestState4.swordsamuri.fields--;
                      GameStart.chessmap.setmap1(px,pz-i , index);
                      this.fields++;
                      int temp =  GameStart.chessmap.getmap2(px, pz-i);
                       if((temp/4)+1!=armynumber){
                           if(temp==1) SamuriTestState.spirsamuri.execute=6;
                           if(temp==4) SamuriTestState2.spirsamuri.execute=6;
                           if(temp==2) SamuriTestState5.axsamuri.execute=6;
                           if(temp==5) SamuriTestState6.axsamuri.execute=6;
                           if(temp==3) SamuriTestState3.swordsamuri.execute=6;
                           if(temp==6) SamuriTestState4.swordsamuri.execute=6;
                      }
                      
                  }
    
              }
              if(direction == 2){
                  if(px+i>=0&&px+i<=14)   {
                      int pre =  GameStart.chessmap.getmap1(px+i,pz);
                           if(pre==1) SamuriTestState.spirsamuri.fields--;
                           else if(pre==4) SamuriTestState2.spirsamuri.fields--;
                           else if(pre==2) SamuriTestState5.axsamuri.fields--;
                           else if(pre==5) SamuriTestState6.axsamuri.fields--;
                           else if(pre==3) SamuriTestState3.swordsamuri.fields--;
                           else if(pre==6) SamuriTestState4.swordsamuri.fields--;
                      GameStart.chessmap.setmap1(px+i,pz , index);
                      this.fields++;
                      int temp =  GameStart.chessmap.getmap2(px+i, pz);
                       if((temp/4)+1!=armynumber){
                           if(temp==1) SamuriTestState.spirsamuri.execute=6;
                           if(temp==4) SamuriTestState2.spirsamuri.execute=6;
                           if(temp==2) SamuriTestState5.axsamuri.execute=6;
                           if(temp==5) SamuriTestState6.axsamuri.execute=6;
                           if(temp==3) SamuriTestState3.swordsamuri.execute=6;
                           if(temp==6) SamuriTestState4.swordsamuri.execute=6;
                      }
                      
                  }
    
              }
              if(direction == 3){
                  if(px-i>=0&&px-i<=14)   {
                      int pre =  GameStart.chessmap.getmap1(px-i,pz);
                           if(pre==1) SamuriTestState.spirsamuri.fields--;
                           else if(pre==4) SamuriTestState2.spirsamuri.fields--;
                           else if(pre==2) SamuriTestState5.axsamuri.fields--;
                           else if(pre==5) SamuriTestState6.axsamuri.fields--;
                           else if(pre==3) SamuriTestState3.swordsamuri.fields--;
                           else if(pre==6) SamuriTestState4.swordsamuri.fields--;
                      GameStart.chessmap.setmap1(px-i,pz , index);
                      this.fields++;
                      int temp =  GameStart.chessmap.getmap2(px-i, pz);
                       if((temp/4)+1!=armynumber){
                           if(temp==1) SamuriTestState.spirsamuri.execute=6;
                           if(temp==4) SamuriTestState2.spirsamuri.execute=6;
                           if(temp==2) SamuriTestState5.axsamuri.execute=6;
                           if(temp==5) SamuriTestState6.axsamuri.execute=6;
                           if(temp==3) SamuriTestState3.swordsamuri.execute=6;
                           if(temp==6) SamuriTestState4.swordsamuri.execute=6;
                      }
                      
                  }
    
              }
         }
     }
     
     
}
