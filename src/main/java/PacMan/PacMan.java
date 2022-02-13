package PacMan;
import java.util.Scanner;
import java.util.Random;

public class PacMan {

   
    public static void main(String[] args) {
        boolean q = true, ga = true;
        Scanner scan = new Scanner(System.in);
        String mat[][];
        String hist[][] = new String[10][4];
            hist[0][0]="Nombre";
            hist[0][1]="Carnet";
            hist[0][2]="Puntaje";
            hist[0][3]="Movimientos";

        String sup, op, nombre, mov,carnet;
        int row, col, puntaje, movimientos, i, j,m;
        m=1;
        puntaje=10;
        movimientos=0;
        int multi=1;
        while(q){
            System.out.println("Elija una opcion:\n1. JUGAR\n2. HISTORIAL\n3. SALIR\n");
            op = scan.next();
            if(op.equals("1")){
                ga = true;

                System.out.println("Ingrese su Nombre:");
                nombre = scan.next();
                System.out.println("Ingrese su Carnet:");
                carnet = scan.next();
                    hist[m][0]=nombre;
                    hist[m][1]=carnet;
                 if(m==9){  
                        q=false;
                    }
                do{
                    System.out.println("Ingrese las dimensiones del tablero que sean mayor a 6\nFILAS:");
                    row = scan.nextInt();
                }while(row<7);
                do{
                    System.out.println("COLUMNAS:");
                    col = scan.nextInt();
                }while(col<7);
                mat= new String[row][col];
                i = new Random().nextInt(row);
                j = new Random().nextInt(col);
                mat[i][j] = "[V:]";
                
            //Items # $ @
                double mul=0.25*row*col;
                int re=(int)mul;
                for(int g=0;g<re;g++){
                    int n1=new Random().nextInt(row);
                    int n2=new Random().nextInt(col);  

                    while(mat[n1][n2]=="[# ]"||mat[n1][n2]=="[$ ]"||mat[n1][n2]=="[@ ]"||mat[n1][n2]=="[V:]"){
                        n1=new Random().nextInt(row);
                        n2=new Random().nextInt(col); 
                    }
                        mat[n1][n2]="[# ]"; 
                    }

                double mul_1=0.20*row*col;
                int re1=(int)mul_1;
                for(int g=0;g<re1;g++){  
                    int n3=new Random().nextInt(row);
                    int n4=new Random().nextInt(col);

                    while(mat[n3][n4]=="[# ]"||mat[n3][n4]=="[$ ]"||mat[n3][n4]=="[@ ]"||mat[n3][n4]=="[V:]"){
                        n3=new Random().nextInt(row);
                        n4=new Random().nextInt(col);
                    }
                        mat[n3][n4]="[$ ]";
                    }

                double mul_2=0.30*row*col;
                int re2=(int)mul_2;
                for(int g=0;g<re2;g++){
                    int n5=new Random().nextInt(row);
                    int n6=new Random().nextInt(col);
                        
                    while(mat[n5][n6]=="[# ]"||mat[n5][n6]=="[$ ]"||mat[n5][n6]=="[@ ]"||mat[n5][n6]=="[V:]"){
                         n5=new Random().nextInt(row);
                         n6=new Random().nextInt(col);   
                    }
                        mat[n5][n6]="[@ ]";
                    
                    }

                Random num4=new Random();
                int num3;
                do{
                    num3= num4.nextInt(6);
                }while(num3<3);
                for(int r=0;r<num3;r++){
                   int n7=new Random().nextInt(row);
                    int n8=new Random().nextInt(col);
                        
                    while(mat[n7][n8]=="[# ]"||mat[n7][n8]=="[$ ]"||mat[n7][n8]=="[@ ]"||mat[n7][n8]=="[V:]"){
                         n7=new Random().nextInt(row);
                         n8=new Random().nextInt(col);   
                    }
                        mat[n7][n8]="[+ ]"; 
                }//Fin de Items

                while(ga){
                if(multi==0){
                   multi=1;
                }
                sup = "---------------------------------------------\n"
                        +nombre + " - " + carnet + " - IPC1 A\n"+"Puntaje: "+puntaje+" - "+"Movimientos:"+movimientos+
                             "\n" + "---------------------------------------------";
                    System.out.println(sup);
                    mat[i][j] = "[V:]";
                    for(int a = 0; a<mat.length; a++){
                        for(int b = 0; b<mat[a].length; b++){
                            if(mat[a][b] == null){
                                mat[a][b] = "[  ]";
                            }
                            System.out.print(mat[a][b]);
                        }
                        System.out.println(" ");
                    }
                    mov = scan.next();//movimintos con las latras
                        if(mov.equalsIgnoreCase("D")){
                            mat[i][j]=mat[i][j].replace("[V:]", "[  ]");
                                j++;
                            movimientos++;
                        }
                        if(j==col){
                            j=0;
                        }

                        if(mov.equalsIgnoreCase("A")){
                                mat[i][j]=mat[i][j].replace("[V:]", "[  ]");
                                j--;
                              movimientos++;      
                        }
                        if(j==-1){
                            j=(col-1);
                        }

                        if(mov.equalsIgnoreCase("W")){
                                mat[i][j]=mat[i][j].replace("[V:]", "[  ]");
                                i--;
                            movimientos++;      
                        }
                        if(i==-1){
                            i=(row-1);
                        }

                        if(mov.equalsIgnoreCase("S")){
                                mat[i][j]=mat[i][j].replace("[V:]", "[  ]");
                                i++;
                            movimientos++;      
                        }
                        if(i==row){
                            i=0;
                        }// fin del movimintos con las latras

                         if(mat[i][j]=="[+ ]"){
                                switch(multi){
                                    case 1:  
                                     multi=2;
                                    break;
                                    case 2:  
                                     multi=4;
                                    break;
                                    case 4:  
                                     multi=6;
                                    break;
                                    case 6:
                                    multi=8;
                                    break;
                                    case 8:
                                    multi=10;
                                    break;
                                    }
                            }
                                if(mat[i][j]=="[# ]"){
                                   puntaje=puntaje-10*multi;
                                   switch(multi){
                                    case 2:  
                                     multi-=2;
                                    break;
                                    case 4:  
                                     multi-=4;
                                    break;
                                    case 6:  
                                     multi-=6;
                                    break;
                                    case 8:
                                    multi-=8;
                                    break;
                                    case 10:
                                    multi-=10;
                                    break;
                                    case 12:
                                    multi-=12;
                                    break;
                                    }
                                }
                                if(mat[i][j]=="[$ ]"){
                                   puntaje=puntaje+15*multi;
                                    switch(multi){
                                    case 2:  
                                     multi-=2;
                                    break;
                                    case 4:  
                                     multi-=4;
                                    break;
                                    case 6:  
                                     multi-=6;
                                    break;
                                    case 8:
                                    multi-=8;
                                    break;
                                    case 10:
                                    multi-=10;
                                    break;
                                    case 12:
                                    multi-=12;
                                    break;
                                    }
                                }
                                if(mat[i][j]=="[@ ]"){
                                   puntaje=puntaje+10*multi;
                                    switch(multi){
                                    case 2:  
                                     multi-=2;
                                    break;
                                    case 4:  
                                     multi-=4;
                                    break;
                                    case 6:  
                                     multi-=6;
                                    break;
                                    case 8:
                                    multi-=8;
                                    break;
                                    case 10:
                                    multi-=10;
                                    break;
                                    case 12:
                                    multi-=12;
                                    break;
                                    }
                                }
                            
                        if(mov.equalsIgnoreCase("M")||puntaje<=0||puntaje>=100){
                            ga=false;
                            String numpun=Integer.toString(puntaje);
                             hist[m][2]=numpun;

                            String nummov=Integer.toString(movimientos);
                             hist[m][3]=nummov;
                                m++;
                    }
                    if(puntaje<=0||puntaje>=100||mov.equalsIgnoreCase("M")){
                        puntaje=10;
                        movimientos=0;
                    } 
                }
                
            } else if(op.equals("2")){//Aqui esta el historial
                     for(int a = 0; a<10; a++){
                        for(int b = 0; b<4; b++){
                            if(hist[a][b] == null){
                                hist[a][b] = "  ";
                            }
                            System.out.printf("%-20s",hist[a][b]);
                        }
                        System.out.println(" ");
                    }
                
            } else if(op.equals("3")){
                q = false;
            } else {
                System.out.println("Ingresar valor valido, Por favor.\n");
            }
        }if(q==false & m>9){
            System.out.println("Fin de la partida.");
            for(int a = 0; a<10; a++){
                for(int b = 0; b<4; b++){
                    System.out.printf("%-20s",hist[a][b]);
                }
                System.out.println(" ");
            } 
        }
    }
    
}