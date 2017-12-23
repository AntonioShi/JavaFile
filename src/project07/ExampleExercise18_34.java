package project07;

import java.awt.*;//包含图形类java.awt.Graphics
import java.awt.event.*;//接受鼠标信号的事件
import javax.swing.*;//面板框架的包javax.swing.JFrame

public class ExampleExercise18_34 extends JApplet {//继承面板类
  private Cell[][] cells = new Cell[6][7];//cell规格
	//private Cell[][] cells = new Cell[6][6];//自定义数表
  private char nextDisc = 'R';//?
  private Timer timer = new Timer(100, new FlashingCells());//100ms后执行后面的功能

  private int[][] result;
//  private JButton jbtStartOver = new JButton("Start Over");//设计按钮
  private JButton jbtStartOver = new JButton("重新开始");//设计按钮
  
  class FlashingCells implements ActionListener { //监听事件   

    public void actionPerformed(ActionEvent e) {//给监听到的事件附加相应功能
      if (cells[result[0][0]][result[0][1]].token == ' ') {
        cells[result[0][0]][result[0][1]].token = nextDisc;
        cells[result[1][0]][result[1][1]].token = nextDisc;
        cells[result[2][0]][result[2][1]].token = nextDisc;
        cells[result[3][0]][result[3][1]].token = nextDisc;
      }
      else {
        cells[result[0][0]][result[0][1]].token = ' ';
        cells[result[1][0]][result[1][1]].token = ' ';
        cells[result[2][0]][result[2][1]].token = ' ';
        cells[result[3][0]][result[3][1]].token = ' ';        
      }
      repaint();//存在价值？
      /*
			public void repaint（）
			重新绘制这个组件。
			如果此组件是一个轻量级组件，
			则此方法会尽快调用此组件的paint方法。
			否则，此方法会尽快调用此组件的更新方法。
       */
    }
  }
  
  //构造函数
  public ExampleExercise18_34() {
    JPanel panel1 = new JPanel(new GridLayout(6, 7));//这里的6行7列和上文对应
    /*
     * 公共GridLayout（int行，int cols）
	使用指定的行数和列数创建网格布局。 布局中的所有组件都被赋予相同的大小。
	行和列的一个（但不是两个）可以是零，这意味着可以将任何数量的对象放置在行或列中。
	参数：
	raws - 行，值为零表示任意行。
	cols - 列，值为零表示任意列。
     */
    for (int i = 0; i < cells.length; i++)//行
      for (int j = 0; j < cells[i].length; j++)//列
    	  //通过cells.length和cells[i].length对比，我们知道java多维数组的存储结构
    	  //按行存储
        panel1.add(cells[i][j] = new Cell(i, j));//为我们的小圆放置到指定的位置
    	/*
    	 * add(Component comp, Object constraints) 方法是把指定组件添加到指定位置。
			 * p.add(l,new Integer(Integer.MIN_VALUE));表示把I面板添加到p面板的尾部。
    	 */
    
    add(panel1, BorderLayout.CENTER);//中间
    JPanel panel2 = new JPanel();
    panel2.add(jbtStartOver);
    add(panel2, BorderLayout.SOUTH);//下南，把我们的按钮组件放置到面板的下南位置出
    
    jbtStartOver.addActionListener(
    		new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        timer.stop(); 
	        nextDisc = 'R';
	        result = null;
	        for (int i = 0; i < cells.length; i++)
	          for (int j = 0; j < cells[i].length; j++) 
	            cells[i][j].token = ' ';//重置面板，让我们重新开始吧。
	        repaint();
      }
    });//
  }

  class Cell extends JPanel {//继承面板类，设计cell类
    char token = ' ';
    int i, j;
    boolean isFlashing;
    
    private boolean available() {
      return (token == ' ' && (i == 5 || cells[i + 1][j].token != ' '));
      
//    	return (token == ' ');//如果按照修改过的参数，那么效果就是完全随意的四子棋啦
     
      /*
       * 玩游戏我们是从表格的下方开始，i = n - 1 
       * 但是，设计表格的时候，我们是从上面开始。i = 0
       * 在填图的时候，要确保当前要涂点的正下方一点已经被涂了，即cells[i + 1][j].token ！= ‘ ’
       * 要注意不要越界。
       * 所以当i == 5边界时，即我们玩游戏的第一行，可以随意涂
       */
    }
    
    public Cell(int i, int j) {
      this.i = i; this.j = j;
      this.addMouseListener(new MouseAdapter() {//监听鼠标信号
        public void mousePressed(MouseEvent e) {//鼠标点击
          if (result != null) //？
            return; // Game is over
        
          if (available()) {//如果可以涂当前点
            token = nextDisc;//涂
            
            result = isConsecutiveFour(cells);//判定是否四点相连
            if (result != null) {//result？？？
              timer.start();
            				}
            else if (nextDisc == 'R') //实现轮流的不同颜色的点
              nextDisc = 'Y';
            else
              nextDisc = 'R';
            
            repaint();//重新布局？
          }
          
        }
      });
    }
    
    protected void paintComponent(Graphics g) {//油漆
      int radius = Math.min(getWidth(), getHeight()) * 4 / 10;
      
      g.setColor(Color.BLUE);//设置颜色
      g.fillRect(0, 0, getWidth(), getHeight());//？
      
      if (token == ' ') {//未填写
        g.setColor(Color.WHITE);//给小圆设置颜色
        g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, //？含义
            radius * 2, radius * 2);
        //Graphics: fillOval(int x, int y, int width, int height)
      } 
      else if (token == 'R') {//红色
        g.setColor(Color.RED);//给小圆设置颜色
        g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 
            radius * 2, radius * 2);
      }      
      else if (token == 'Y') {//黄色
        g.setColor(Color.YELLOW);//给小圆设置颜色
        g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 
            radius * 2, radius * 2);
      }
      
    }
  }
  
  public static int[][] isConsecutiveFour(Cell[][] cells) {//是否四点相连
    char[][] values = new char[cells.length][cells[0].length];
    for (int i = 0; i < cells.length; i++)
      for (int j = 0; j < cells[i].length; j++)
        values[i][j] = cells[i][j].token;
    return isConsecutiveFour(values);//调用重载
  }

  public static int[][] isConsecutiveFour(char[][] values) {//重载参数为char二维数组
    int numberOfRows = values.length;
    int numberOfColumns = values[0].length;

    // Check rows
    for (int i = 0; i < numberOfRows; i++) {
      if (isConsecutiveFour(values[i]) != null) {
        int[][] result = new int[4][2];//？
        result[0][0] = result[1][0] = result[2][0] = result[3][0] = i;//
        int k = isConsecutiveFour(values[i]);
        
        result[0][1] = k; result[1][1] = k + 1;
        result[2][1] = k + 2; result[3][1] = k + 3;
   
        return result;
      }//？？？
    }

    // Check columns
    for (int j = 0; j < numberOfColumns; j++) {
      char[] column = new char[numberOfRows];
      // Get a column into an array
      for (int i = 0; i < numberOfRows; i++)
        column[i] = values[i][j];
      
      if (isConsecutiveFour(column) != null) {
        int[][] result = new int[4][2];
        result[0][1] = result[1][1] = result[2][1] = result[3][1] = j;
        int k = isConsecutiveFour(column);
        
               ///福娃深度发生
        result[0][0] = k; result[1][0] = k + 1;
        result[2][0] = k + 2; result[3][0] = k + 3;
   
        return result;        
      }
    }
        
    // Check major diagonal (lower part)   
    for (int i = 0; i < numberOfRows - 3; i++) {
      int numberOfElementsInDiagonal 
        = Math.min(numberOfRows - i, numberOfColumns);     
      char[] diagonal = new char[numberOfElementsInDiagonal];
      for (int k = 0; k < numberOfElementsInDiagonal; k++)
        diagonal[k] = values[k + i][k];
      
      if (isConsecutiveFour(diagonal) != null) {
        int[][] result = new int[4][2];
        int k = isConsecutiveFour(diagonal);        
        result[0][0] = k + i;
        result[1][0] = k + 1 + i;
        result[2][0] = k + 2 + i;
        result[3][0] = k + 3 + i;
        result[0][1] = k; 
        result[1][1] = k + 1;
        result[2][1] = k + 2; 
        result[3][1] = k + 3;   
        return result;        
      }
    }
    
    // Check major diagonal (upper part)
    for (int j = 1; j < numberOfColumns - 3; j++) {
      int numberOfElementsInDiagonal 
        = Math.min(numberOfColumns - j, numberOfRows);     
      char[] diagonal = new char[numberOfElementsInDiagonal];
      for (int k = 0; k < numberOfElementsInDiagonal; k++)
        diagonal[k] = values[k][k + j];
      
      if (isConsecutiveFour(diagonal) != null) {
        int[][] result = new int[4][2];
        int k = isConsecutiveFour(diagonal);        
        result[0][0] = k;
        result[1][0] = k + 1;
        result[2][0] = k + 2;
        result[3][0] = k + 3;
        result[0][1] = k + j; 
        result[1][1] = k + 1 + j;
        result[2][1] = k + 2 + j; 
        result[3][1] = k + 3 + j;   
        return result;        
      }
    }

    // Check sub-diagonal (left part)
    for (int j = 3; j < numberOfColumns; j++) {
      int numberOfElementsInDiagonal 
        = Math.min(j + 1, numberOfRows);     
      char[] diagonal = new char[numberOfElementsInDiagonal];
      
      for (int k = 0; k < numberOfElementsInDiagonal; k++)
        diagonal[k] = values[k][j - k];
      
      if (isConsecutiveFour(diagonal) != null) {
        int[][] result = new int[4][2];
        int k = isConsecutiveFour(diagonal);        
        result[0][0] = k;
        result[1][0] = k + 1;
        result[2][0] = k + 2;
        result[3][0] = k + 3;
        result[0][1] = j - k; 
        result[1][1] = j - k - 1;
        result[2][1] = j - k - 2; 
        result[3][1] = j - k - 3;   
        return result;        
      }
    }
    
    // Check sub-diagonal (right part)
    for (int i = 1; i < numberOfRows - 3; i++) {
      int numberOfElementsInDiagonal 
        = Math.min(numberOfRows - i, numberOfColumns);     
      char[] diagonal = new char[numberOfElementsInDiagonal];
    
      for (int k = 0; k < numberOfElementsInDiagonal; k++)
        diagonal[k] = values[k + i][numberOfColumns - k - 1];
    
      if (isConsecutiveFour(diagonal) != null) {
        int[][] result = new int[4][2];
        int k = isConsecutiveFour(diagonal);        
        result[0][0] = k + i;
        result[1][0] = k + i + 1;
        result[2][0] = k + i + 2;
        result[3][0] = k + i + 3;
        result[0][1] = numberOfColumns - k - 1; 
        result[1][1] = numberOfColumns - (k + 1) - 1;
        result[2][1] = numberOfColumns - (k + 2) - 1; 
        result[3][1] = numberOfColumns - (k + 3) - 1;   
        return result;        
      }
    }
    
    return null; 
  }
  
  public static Integer isConsecutiveFour(char[] values) {//重载，参数为char一维数组
    for (int i = 0; i < values.length - 3; i++) {
      boolean isEqual = true;        
      for (int j = i; j < i + 3; j++) {
        if (values[j] == ' ' || values[j] != values[j + 1]) {
          isEqual = false;
          break;
        }
      }
     
      if (isEqual) return new Integer(i);
    }
    
    return null;
  }

  public void GameStart() {
	  //人机下棋
	  
  }
  public static void main(String[] args) {
//    JFrame frame = new JFrame("Exercise18_34");//表头上的字
	  JFrame frame = new JFrame("四子棋");//表头上的字
    JApplet applet = new ExampleExercise18_34();
    frame.add(applet);
    frame.setSize(210, 220);//6行7列42个大小完全相同的白点
    //frame.setSize(400, 400);//设计表框大小，6行7列42个大小完全相同的白点
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //用户单击窗口的关闭按钮时程序执行的操作
    frame.setLocationRelativeTo(null);//在屏幕中出现的位置，定位
    frame.setVisible(true);//设置窗体可见，必须要有，true
    

    
    
  }
}
