package lql2022.lql0805;

import javax.swing.*;
import java.awt.*;

public class Gobangai extends JFrame {

    public static void main(String[] args) {
        // 启动界面
        Gobangai go = new Gobangai();
        go.initUI("AI");
    }
    MyListenerai mylisten = new MyListenerai();

    public void initUI(String title) {
        setTitle(title);
        setSize(800, 800);
        setLayout (null);
        setVisible(true);
        setLocationRelativeTo(null);

        // 创建按钮对象
        JButton btn1 = new JButton ("开始游戏");
        JButton btn2 = new JButton ("悔棋");
        // 设置按钮位置
        btn1.setBounds (650,75,100,40);
        btn2.setBounds (650,120,100,40);
        // 添加到窗体上
        add (btn1);
        add (btn2);
        addMouseListener(mylisten);
        btn1.addActionListener(mylisten);
        btn2.addActionListener(mylisten);
        //继承JFrame 就可以直接调用getGraphics(); 返回一个Graphics 对象 赋给 mylisten.g
        mylisten.g =getGraphics();
        mylisten.go=this;
    }

    /**
     * 继承了窗体之后，这个方法才会被执行
     * @param g the specified Graphics window

     * 重写方法：在父类 方法的基础上改造
     *          paint：界面可视化时/窗体被拖动改变尺寸的时候/最小/大化时
     */

    //棋盘
    public void paint(Graphics g) {
        super.paint(g);
        Color color = new Color(40, 143, 69);
        g.setColor(color);
        g.fillRect(35, 35, 570, 570);
        int clonum = 18, row = 18, size = 30, x = 50, y = 50;
        Color color1 = new Color(0, 0, 0);
        g.setColor(color1);
        for (int i = 0; i < 19; i++) {
            g.drawLine(x, y + i * size, x + clonum * size, y + i * size);
            g.drawLine(x + i * size, y, x + i * size, y + row * size);
        }
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                g.fillOval(x + (3 + 6 * k) * size - 3, y + (3 + 6 * j) * size - 3, 6, 6);
            }
        }
    }

    //棋子
    public void paint1(Graphics g)
        {
         Chess[] chessList1=mylisten.chessList;
            for (Chess chess : chessList1)
            {
            if(chess!=null)
             {
                //g.setColor(chess.flag==1?Color.BLACK:Color.WHITE);
                if(chess.flag==1)
                {
                    g.setColor(Color.BLACK);
                    int cx = (chess.c - 1) * 30 + 50 - 14;
                    int cy = (chess.r - 1) * 30+ 50 - 14;
                    g.fillOval(cx, cy, 28, 28);
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("黑体", Font.BOLD, 15));
                    g.drawString("" + (chess.index+1), cx+ 7, cy + 20);
                }
                if(chess.flag==2)
                {
                    g.setColor(Color.WHITE);
                    int cx = (chess.c - 1) * 30 + 50 - 14;
                    int cy = (chess.r - 1) * 30+ 50 - 14;
                    g.fillOval(cx, cy, 28, 28);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("黑体", Font.BOLD, 15));
                    g.drawString("" + (chess.index+1), cx+ 7, cy + 20);
                }
             }
            }
        }
}

