/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.jme3.math.Vector3f;

/**
 *
 * @author wshwbluebird
 */
public class chesspadmap {
    private int[][] map1  = new int[15][15];//记录棋盘的占领信息
    private int[][] map2  = new int[15][15];//记录期盼武士的位置信
    public chesspadmap(){
        map1[0][0] = -1;//表示不可变动的点
        map2[0][0] = 1;//表示0，0坐标上的为武士1
        map1[7][0] = -1;
        map2[7][0] = 2;
        map1[14][0] = -1;
        map2[14][0] = 3;
        map1[0][14] = -1;
        map2[0][14] = 4;
        map1[7][14] = -1;
        map2[7][14] = 5;
        map1[14][14] = -1;
        map2[14][14] = 6;
    }
     public void setmap1(int x,int z,int value){
         map1[x][z] = value;
     }
     public void setmap2(int x,int z,int value){
         map2[x][z] = value;
     }
     public int getmap1(int x,int z){
        return map1[x][z] ;
     }
     public int getmap2(int x,int z){
         return map2[x][z] ;
     }
}
