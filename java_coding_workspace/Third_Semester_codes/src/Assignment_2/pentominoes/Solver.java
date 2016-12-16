package pentominoes;

import java.util.Arrays;
import java.util.Scanner;

public class Solver
{

   public static void main(String[] args)
   {

       new Solver().start();
   }


      private int[][] board; //initializes the board array
      private int[][][] pents = {


              //The I pent x2
              { {1}, {0,0,1,0,2,0,3,0,4,0}},
              { {2}, {0,0,0,1,0,2,0,3,0,4}},


              //The L pent x8
              { {3}, {0,0,1,0,2,0,3,0,3,1}},
              { {4}, {0,0,0,1,0,2,0,3,1,0}},
              { {5}, {0,0,0,1,1,1,1,2,1,3}},
              { {6}, {0,0,1,-3,1,-2,1,-1,1,0}},
              { {7}, {0,0,1,0,2,0,3,0,3,1}},
              { {8}, {0,0,1,0,1,1,1,2,1,3}},
              { {9}, {0,0,0,1,1,0,2,0,3,0}},
              { {10}, {0,0,0,1,0,2,0,3,1,3}},

              //The Y pent x8
              { {11}, {0,0,1,0,2,0,3,0,1,-1}},
              { {12}, {0,0,1,-2,1,-1,1,0,1,1}},
              { {13}, {0,0,1,0,2,0,3,0,2,1}},
              { {14}, {0,0,0,1,0,2,0,3,1,1}},
              { {15}, {0,0,1,0,2,0,3,0,1,1}},
              { {16}, {0,0,0,1,0,2,0,3,1,2}},
              { {17}, {0,0,1,0,2,0,3,0,2,-1}},
              { {18}, {0,0,1,-1,1,0,1,1,1,2}},

              //The N pent x8
              { {19}, {0,0,0,1,1,1,1,2,1,3}},
              { {20}, {0,0,1,0,1,-1,2,-1,3,-1}},
              { {21}, {0,0,0,1,0,2,1,2,1,3}},
              { {22}, {0,0,1,0,2,0,2,-1,3,-1}},
              { {23}, {0,0,0,1,1,-2,1,-1,1,0}},
              { {24}, {0,0,1,0,1,1,2,1,3,1}},
              { {25}, {0,0,0,1,0,2,1,-1,1,0}},
              { {26}, {0,0,1,0,2,0,2,1,2,3}},
              //The P pent x8
              { {27}, {0,0,0,1,1,0,1,1,2,0}},
              { {28}, {0,0,0,1,0,2,1,1,1,2}},
              { {29}, {0,0,1,-1,1,0,2,-1,2,0}},
              { {30}, {0,0,0,1,1,0,1,1,1,2}},
              { {31}, {0,0,0,1,1,0,1,1,2,1}},
              { {32}, {0,0,0,1,1,-1,1,0,1,1}},
              { {33}, {0,0,1,0,1,1,2,0,2,1}},
              { {34}, {0,0,0,1,0,2,1,0,1,1}},

              //The F pent x8
              { {35}, {0,0,0,1,1,-1,1,0,2,0}},
              { {36}, {0,0,1,-1,1,0,1,1,2,1}},
              { {37}, {0,0,1,0,1,1,2,-1,2,0}},
              { {38}, {0,0,1,0,1,1,1,2,2,1}},
              { {39}, {0,0,0,1,1,1,1,2,2,1}},
              { {40}, {0,0,1,-2,1,-1,1,0,2,-2}},
              { {41}, {0,0,1,-1,1,0,2,0,2,1}},
              { {42}, {0,0,1,-1,1,0,1,1,2,-1}},

              //The Z pent x4
              { {43}, {0,0,0,1,1,1,2,1,2,2}},
              { {44}, {0,0,1,-2,1,-1,1,0,2,-2}},
              { {45}, {0,0,0,1,1,0,2,-1,2,0}},
              { {46}, {0,0,1,0,1,1,1,2,2,2}},

              //The W pent x4
              { {47}, {0,0,1,0,1,1,2,1,2,2}},
              { {48}, {0,0,0,1,-1,1,1,0,2,-1}},
              { {49}, {0,0,0,1,1,1,1,2,2,2}},
              { {50}, {0,0,1,-1,1,0,1,-2,2,-1}},

              //The T pent x4
              { {51}, {0,0,0,1,0,2,1,1,2,1}},
              { {52}, {0,0,1,-2,1,-1,1,0,2,0}},
              { {53}, {0,0,1,0,2,-1,2,0,2,1}},
              { {54}, {0,0,1,0,2,0,1,1,1,2}},

              //The U pent x4
              { {55}, {0,0,1,0,1,1,1,2,0,2}},
              { {56}, {0,0,0,1,1,0,2,0,2,1}},
              { {57}, {0,0,0,1,0,2,1,0,2,2}},
              { {58}, {0,0,0,1,1,1,2,1,2,0}},

              //The V pent x4
              { {59}, {0,0,1,0,2,0,2,1,2,2}},
              { {60}, {0,0,0,1,0,2,1,0,2,0}},
              { {61}, {0,0,0,1,0,2,1,1,1,2}},
              { {62}, {0,0,1,0,2,0,2,-2,2,-1}},

              //The X pent x1
              { {63}, {0,0,1,-1,1,0,1,1,2,0}}

      };

      private int[] location;
      private Boolean[] pentsUsed = new Boolean[64];








      public void start()
      {
          Arrays.fill(pentsUsed, Boolean.TRUE);

          Scanner in = new Scanner(System.in);

          System.out.println("Welcome to Group 11's pentomino solver!");
          System.out.println("Please enter the pentominoes you want to use.");
          System.out.println("To do this, enter each letter for the pentomino into one string");
          System.out.println("The possible letters are: I L Y N P F Z W T U V X");
          System.out.println("For example: NPILVX");
          System.out.println("You can also type: ALL  if you want to use all pentominoes");
          System.out.println("Now it's your turn:");
          String pentsString = in.next();


          char[] pentsWanted = pentsString.toCharArray();

          if(pentsWanted[0]=='A'&&pentsWanted[1]=='L'&&pentsWanted[2]=='L')
          {
              Arrays.fill(pentsUsed, Boolean.FALSE);
          }
          else
          {
              for(int i =0;i<pentsWanted.length;i++)
              {
                  if(pentsWanted[i]=='I')
                  {
                      reservedPents(1,false);
                  }
                  if(pentsWanted[i]=='L')
                  {
                      reservedPents(3,false);
                  }
                  if(pentsWanted[i]=='Y')
                  {
                      reservedPents(11,false);
                  }
                  if(pentsWanted[i]=='N')
                  {
                      reservedPents(19,false);
                  }
                  if(pentsWanted[i]=='P')
                  {
                      reservedPents(27,false);
                  }
                  if(pentsWanted[i]=='F')
                  {
                      reservedPents(35,false);
                  }
                  if(pentsWanted[i]=='Z')
                  {
                      reservedPents(43,false);
                  }
                  if(pentsWanted[i]=='W')
                  {
                      reservedPents(47,false);
                  }
                  if(pentsWanted[i]=='T')
                  {
                      reservedPents(51,false);
                  }
                  if(pentsWanted[i]=='U')
                  {
                      reservedPents(55,false);
                  }
                  if(pentsWanted[i]=='V')
                  {
                      reservedPents(59,false);
                  }
                  if(pentsWanted[i]=='X')
                  {
                      reservedPents(63,false);
                  }

              }
          }




          //System.out.println(Arrays.toString(temp));



          System.out.println("Please enter the height of the grid:");

          int height = in.nextInt();
          System.out.println("Now enter the width of the grid:");
          int width = in.nextInt();


          //get the pents to be used, the width and the height
          if(initialize(pents,height,width))//I'm using these values as an example, in the actual program we need to ask the user for the values.
          {
              System.out.println("\nNo solution was found!");
          }

      }

      public boolean initialize(int[][][] pentsSelected, int height, int width)
      {

          if((height*width)%5!=0 || (height*width)>60 || (height*width)<5)
          {
              System.out.println("No solutions are possible, please retry with different dimensions");
              return false;
          }
          else
          {
              this.board = new int[height][width];

              for (int i = 0; i < height; i++)
                  for (int j = 0; j < width; j++)
                      this.board[i][j] = 0;

              this.location = nextFreeCell();
              backtracking(this.location);
              return true;
          }
      }

      public void backtracking(int[] coordinate)
      {
          for(int i = 1; i<64;i++)
          {

              if(doesPentFit(coordinate[0],coordinate[1],i)&&!pentsUsed[i])
              {
                  placePent(coordinate[0],coordinate[1],i);

                  //pentsUsed[i]=true;
                  reservedPents(i,true);

                  //printBoard();

                  if(nextFreeCell()==null)
                  {
                      System.out.println("A solution was found!");
                      printBoard();
                      Scanner in = new Scanner(System.in);
                      in.nextInt();
                  }
                  else
                  {
                      coordinate = nextFreeCell();
                      backtracking(nextFreeCell());
                  }

                  //System.out.println("The function got to this part");

                  removePreviousPent(i);
              }
          }
      }

      public int[] nextFreeCell()
      {
          for(int i = 0; i < this.board.length; i++)
          {
              for(int j = 0; j < this.board[0].length; j++)
              {
                  if(this.board[i][j]==0)
                  {
                      int[] nextFreeCell = {i,j};
                      //System.out.println("Next free cell exists at ["+i+"],["+j+"]");
                      return nextFreeCell;
                  }
              }
          }
          return null;
      }


      public boolean doesPentFit(int xLocation,int yLocation,int pent)
      {
          boolean allEmpty = true;
          boolean loopDone = false;

          while(allEmpty||!loopDone)
          {
              for(int i = 0; i<=9;i=i+2)
              {
                  //System.out.println("In the loop");

                  try
                  {
                      if(board[(xLocation+this.pents[pent-1][1][i])][(yLocation+this.pents[pent-1][1][i+1])]!=0)
                      {
                          //System.out.println("Not all cells are empty");
                          allEmpty = false;
                          break;
                      }
                  }
                  catch(ArrayIndexOutOfBoundsException e)
                  {
                      //System.out.println("The pent overlapped the board");
                      allEmpty = false;
                      break;
                  }
              }
              break;
          }

          if(allEmpty)
          {
              //System.out.println("All cells are empty");
              return true;
          }
          else
              return false;
      }

      public void placePent(int xLocation,int yLocation, int pent)
      {
          //System.out.println("In the place loop");
          for(int i = 0; i<=9;i=i+2)
          {
              this.board[(xLocation+this.pents[pent-1][1][i])][(yLocation+this.pents[pent-1][1][i+1])]=pent;
          }
      }

      public void removePreviousPent(int pentNumber)
      {
          for (int i = 0; i < this.board.length; i++)
          {
              for (int j = 0; j < this.board[1].length; j++)
              {
                  if (this.board[i][j] == pentNumber)
                  {
                      this.board[i][j] = 0;
                  }
              }
          }
          reservedPents(pentNumber,false);
          //pentsUsed[pentNumber]=false;
      }

      public void reservedPents(int pentNumber, boolean bool)
      {
          if(pentNumber==1||pentNumber==2)
          {
              pentsUsed[1]=bool;
              pentsUsed[2]=bool;
          }
          else if (pentNumber==3||pentNumber==4||pentNumber==5||pentNumber==6||pentNumber==7||pentNumber==8||pentNumber==9||pentNumber==10)
          {
              for(int i=3;i<11;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==11||pentNumber==12||pentNumber==13||pentNumber==14||pentNumber==15||pentNumber==16||pentNumber==17||pentNumber==18)
          {
              for(int i=11;i<19;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==19||pentNumber==20||pentNumber==21||pentNumber==22||pentNumber==23||pentNumber==24||pentNumber==25||pentNumber==26)
          {
              for(int i=19;i<27;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==27||pentNumber==28||pentNumber==29||pentNumber==30||pentNumber==31||pentNumber==32||pentNumber==33||pentNumber==34)
          {
              for(int i=27;i<35;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==35||pentNumber==36||pentNumber==37||pentNumber==38||pentNumber==39||pentNumber==40||pentNumber==41||pentNumber==42)
          {
              for(int i=35;i<43;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==43||pentNumber==44||pentNumber==45||pentNumber==46)
          {
              for(int i=43;i<47;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==47||pentNumber==48||pentNumber==49||pentNumber==50)
          {
              for(int i=47;i<51;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==51||pentNumber==52||pentNumber==53||pentNumber==54)
          {
              for(int i=51;i<55;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==55||pentNumber==56||pentNumber==57||pentNumber==58)
          {
              for(int i=55;i<59;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==59||pentNumber==60||pentNumber==61||pentNumber==62)
          {
              for(int i=59;i<63;i++)
              {
                  pentsUsed[i]=bool;
              }
          }
          else if (pentNumber==63)
          {
              pentsUsed[63]=bool;
          }
      }

      public void printBoard()
      {
          System.out.println("The board is: ");
          for(int i=0;i<board.length;i++)
          {
              System.out.println(Arrays.toString(board[i]));
          }
          System.out.println("");
      }
}
