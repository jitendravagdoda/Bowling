/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Bowling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
       Scanner si=new Scanner(System.in);
       int n,temp=0,input;
       
       System.out.println("Enter the number players");
       n=si.nextInt();
       
       Player p[]=new Player[n];
       
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of player "+(i+1));
            p[i]=new Player(si.next());          
        }
        
    
        for (int f = 0; f < 10; f++) {
            
            for (int pt = 0; pt < n; pt++) {
                
                for (int s = 0; s < 2; s++) {
                    
                    
                    System.out.println("enter the score for "+p[pt].getP_name()+ "  frame "+(f+1)+"  turn " +(s+1));
                    input=si.nextInt();
                    if(input>10 || input< 0)
                    {
                        System.out.println("Enter Valid number between 0 and 10");
                        input=si.nextInt();
                    }
                    if(s==1 && f<9)
                    {
                        if((input+p[pt].getScore(f, 0))>10)
                        {
                            System.out.println("Enter the number between 0 and "+(10-p[pt].getScore(f, 0)));
                            input=si.nextInt();
                        }
                    }
                    p[pt].setScore(input,f,s);
                   
                    if(s==0 && p[pt].getScore(f, 0)==10 )
                    {
                       if(f!=9)
                        break;
                    }
                }
               
                if(f==9)
                {
                    int count=p[pt].getScore(f, 0)+p[pt].getScore(f, 1);
                    if(count>=10)
                    {
                   System.out.println("enter the score for "+p[pt].getP_name()+ "  frame "+(f+1)+" extra chance"); 
                   p[pt].extra_chance=si.nextInt();                    
                    }
                  p[pt].total_score();  
                }
            }
        }
        
        System.out.println("");
        
        Player temp1=new Player("g2");
        int count=0;
        
        System.out.println("Score Board");
   
        for (int i = 0; i < n; i++) {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Game score for "+p[i].getP_name()+" is "+p[i].total_score()); 
        System.out.println("----------------------------------------------------------------------------------------");
        p[i].didplay_score();
       p[i].display_frame();
      
            System.out.println(" ");
       
       if(count<p[i].total_score())
       {
           count=p[i].total_score();
           temp1=p[i];         
               
       }
       
        }
        
        System.out.println("Winner is "+ temp1.getP_name());
        
        
    }
    
}
