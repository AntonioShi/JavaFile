package project07;

import java.awt.*;//包含图形类java.awt.Graphics
import java.awt.event.*;//接受鼠标信号的事件
import javax.swing.*;//面板框架的包javax.swing.JFrame

public class Exercise18_34 extends JApplet {//继承面板类
  private Cell[][] cells = new Cell[6][7];
  private char nextDisc = 'R';
  private Timer timer = new Timer(100, new FlashingCells());
  private int[][] result;
  private JButton jbtStartOver = new JButton("Start Over");
  
  class FlashingCells implements ActionListener {    
    public void actionPerformed(ActionEvent e) {
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
      repaint();
    }
  }
  
  //构造函数
  public Exercise18_34() {
    JPanel panel1 = new JPanel(new GridLayout(6, 7));//?    
    for (int i = 0; i < cells.length; i++)
      for (int j = 0; j < cells[i].length; j++)
        panel1.add(cells[i][j] = new Cell(i, j));
    
    add(panel1, BorderLayout.CENTER);
    JPanel panel2 = new JPanel();
    panel2.add(jbtStartOver);
    add(panel2, BorderLayout.SOUTH);
    
    jbtStartOver.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        timer.stop(); 
        nextDisc = 'R';
        result = null;
        for (int i = 0; i < cells.length; i++)
          for (int j = 0; j < cells[i].length; j++) 
            cells[i][j].token = ' ';        
        repaint();
      }
    });
  }

  class Cell extends JPanel {//继承面板类，设计cell类
    char token = ' ';
    int i, j;
    boolean isFlashing;
    
    private boolean available() {
      return (token == ' ' && (i == 5 || cells[i + 1][j].token != ' '));
    }
    
    public Cell(int i, int j) {
      this.i = i; this.j = j;
      this.addMouseListener(new MouseAdapter() {//监听鼠标信号
        public void mousePressed(MouseEvent e) {//鼠标点击
          if (result != null) 
            return; // Game is over
        
          if (available()) {
            token = nextDisc;
            
            result = isConsecutiveFour(cells);
            if (result != null) {
              timer.start();
              
            }
            else if (nextDisc == 'R') 
              nextDisc = 'Y';
            else
              nextDisc = 'R';
            repaint();//？含义
          }
        }
      });
    }
    
    protected void paintComponent(Graphics g) {//油漆
      int radius = Math.min(getWidth(), getHeight()) * 4 / 10;
      
      g.setColor(Color.BLUE);//设置颜色
      g.fillRect(0, 0, getWidth(), getHeight());
      
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
  
  public static int[][] isConsecutiveFour(Cell[][] cells) {
    char[][] values = new char[cells.length][cells[0].length];
    for (int i = 0; i < cells.length; i++)
      for (int j = 0; j < cells[i].length; j++)
        values[i][j] = cells[i][j].token;
    return isConsecutiveFour(values);
  }

  public static int[][] isConsecutiveFour(char[][] values) {
    int numberOfRows = values.length;
    int numberOfColumns = values[0].length;

    // Check rows
    for (int i = 0; i < numberOfRows; i++) {
      if (isConsecutiveFour(values[i]) != null) {
        int[][] result = new int[4][2];
        result[0][0] = result[1][0] = result[2][0] = result[3][0] = i;
        int k = isConsecutiveFour(values[i]);
        
        result[0][1] = k; result[1][1] = k + 1;
        result[2][1] = k + 2; result[3][1] = k + 3;
   
        return result;
      }
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
  
  public static Integer isConsecutiveFour(char[] values) {    
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
  
  public static void main(String[] args) {
//    JFrame frame = new JFrame("Exercise18_34");//表头上的字
	  JFrame frame = new JFrame("四子棋");//表头上的字
    JApplet applet = new Exercise18_34();
    frame.add(applet);
    //frame.setSize(210, 220);//6行7列42个大小完全相同的白点
    frame.setSize(400, 400);//设计表框大小，6行7列42个大小完全相同的白点
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //用户单击窗口的关闭按钮时程序执行的操作
    frame.setLocationRelativeTo(null);//在屏幕中出现的位置，定位
    frame.setVisible(true);//设置窗体可见，必须要有，true
    
/*   实例1：一个空的java窗口
 // JFrameDemo1.java
 import javax.swing.*;     //使用Swing类，必须引入Swing包
 public class JFrameDemo1{
   public staticvoid main( String args[]) {
          //定义一个窗体对象f，窗体名称为"一个简单窗口"        
          Jframe  f = new JFrame("一个简单窗口");
          //设置窗体左上角与显示屏左上角的坐标，     
          f.setLocation(300,300);           //离显示屏上边缘300像素，里显示屏左边缘300像素
          f.setSize(300,200);            //设置窗体的大小为300*200像素大小
          f.setResizable(false);       //设置窗体是否可以调整大小，参数为布尔值
          //设置窗体可见，没有该语句，窗体将不可见，此语句必须有，否则没有界面就没有如何意义了
 f.setVisible( true);   
 //用户单击窗口的关闭按钮时程序执行的操作
          f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
  }
 }
  
 程序运行结果生成一个窗体。
 可以根据程序代码的注释，依次修改相应的方法参数查看效果。

 setDefaultCloseOperation(int operation)：设置用户在此窗体上发起 "close" 时默认执行的操作。方法中的参数解释如下：
  为“0”或DO_NOTHING_ON_CLOSE：
 （在 WindowConstants 中定义）：不执行任何操作；
 要求程序在已注册的WindowListener 对象的 windowClosing 方法中处理该操作。
 比如实例程序代码中更改为f.setDefaultCloseOperation(f. DO_NOTHING_ON_CLOSE);
 或者f.setDefaultCloseOperation(0),然后查看效果，可以发现窗口无法关闭，下面是相同测试方法，不再解释了。

  为“1”或HIDE_ON_CLOSE
 调用任意已注册的 WindowListener 对象后自动隐藏该窗体。
 此时没有关闭程序，只是将程序界面隐藏了。
 可以打开任务管理器，可以看到一个叫“java.exe”的进程（如果调试运行了多个java程序，则会看到多个“java.exe”的进程），
 如果此时用EditPlus测试程序，会发现当单击窗口的关闭按钮关闭窗口后，却无法再次对程序进行调试，
 因为程序线程没有关闭，在任务管理器中关闭java.exe（如果有多个“java.exe”的进程，则先都关闭掉，再来测试该问题）基础后，
 EditPlus才可以重新编译改程序。

 为“2”或DISPOSE_ON_CLOSE
 调用任意已注册 WindowListener 的对象后自动隐藏并释放该窗体。
 但继续运行应用程序，释放了窗体中占用的资源。
  为“3”EXIT_ON_CLOSE（在 JFrame 中定义）：使用 System exit 方法退出应用程序。
  仅在应用程序中使用。结束了应用程序。

 默认情况下，该值被设置为 HIDE_ON_CLOSE。
 当注释掉实例中的f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
 语句时，起到的效果和f.setDefaultCloseOperation(f. HIDE_ON_CLOSE); 
 或者f.setDefaultCloseOperation(1);一样。
*/
    
    
  }
}
