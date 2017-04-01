/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author USER
 */
public class Player {
    
    String p_name;
    int frame[];
    int score[][];
    final int turn=2;
    final int no_frame=10;
    int temp_frame_score,current_frame,extra_chance;
    

    public Player(String name) {
        p_name=name;
        frame= new int[no_frame];
        score = new int[no_frame][2];
        temp_frame_score=0;
        current_frame=0;
        extra_chance=0;
        }

    
    
    
    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getFramescore(int i) {
        return frame[i];
    }

    public void setFramescore(int f,int i) {
        frame[i]=f;
        temp_frame_score=temp_frame_score+f;
    }

    public int getScore(int i,int j) {
        return score[i][j];
    }

    public void setScore(int s,int i,int j) {
        score[i][j]=s;
    }
    
    
   public int total_score()
   {
       int temp=0;
       
       for (int i = 0; i < 10; i++) {
 
           if(i<=7)
           {
           if(score[i][0]==10)
           {
               if(score[i+1][0]==10)
               {
                   frame[i]=score[i][0]+score[i+1][0]+score[i+2][0];
               }
               else
               {
                   frame[i]=score[i][0]+score[i+1][0]+score[i+1][1];
               }
           }
           else if((score[i][0]+score[i][1])==10)
           {
               frame[i]=score[i][0]+score[i][1]+score[i+1][0];
           }
           else
           {
               frame[i]=score[i][0]+score[i][1];
           }
           
           temp=temp+frame[i];
          
           
       }
           else if(i==8)
           {  
               if(score[i][0]==10)
           {
               if(score[i+1][0]==10)
               {
                   frame[i]=score[i][0]+score[i+1][0]+score[i+1][1];
               }
               else
               {
                   frame[i]=score[i][0]+score[i+1][0]+score[i+1][1];
               }
           }
           else if((score[i][0]+score[i][1])==10)
           {
               frame[i]=score[i][0]+score[i][1]+score[i+1][0];
           }
           else
           {
               frame[i]=score[i][0]+score[i][1];
           }
           
           temp=temp+frame[i];
           }
           
           else if(i==9)
           {
               frame[i]=score[i][0]+score[i][1]+extra_chance;
               temp=temp+frame[i];
           }
           
       }       
       return temp;
   }
    
   
   public void display_frame()
   {
       int temp=0;
       for (int i = 0; i < 10; i++) {
           temp=temp+frame[i];
           System.out.print(temp+" \t");
       }
       System.out.println("");
   }
   
   public void didplay_score()
   {
       for (int i = 0; i < 10; i++) {
           
           for (int j = 0; j < 2; j++) {
               
               if(score[i][j]==10)
               {
                   if(i!=9)
                   { 
                   System.out.print("X "+"  "); 
                   break;
                   }
                   else
                   {
                       System.out.print("X"+" "); 
                   }
                   
               }
                   else if(j==1)
               {
                   int temp1=score[i][j]+score[i][j];
                   if(temp1==10)
                       System.out.print("/"+" "); 
                       else
                     System.out.print(score[i][j]+" "); 
               }
               else
               System.out.print(score[i][j]+" ");
           }
           if(i<9)
           System.out.print("\t");
       }
       if(extra_chance==10)
       System.out.print("X");
       else if((score[9][0]+score[9][1])>=10)
       System.out.print(extra_chance);
       System.out.println("");   
   }
     
    
}
