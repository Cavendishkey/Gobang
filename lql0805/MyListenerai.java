package lql2022.lql0805;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * MouseListener: 鼠标监听 监听鼠标的 点击  按下 释放
 * 1： 创建一个类 实现 鼠标监听接口
 * 实现： 抽象 - 具体
 */
public class MyListenerai implements MouseListener, ActionListener {

    int a, b, c, r;
    Graphics g = null;

    int count = 0;
    int flag = 0;
    int[][] arr = new int[19][19];
    Chess[] chessList = new Chess[19 * 19];

    Gobangai go ;

    public void actionPerformed(ActionEvent e) {
        // 监听按钮是否被点击
        // 通过事件对象获取按钮对象
        JButton btn = (JButton) e.getSource();
        String btnStr = btn.getText();
        if (btnStr.equals("开始游戏")) {
            flag = 1;
            btn.setText("结束对局");
        } else if (btnStr.equals("结束对局")) {
            flag = 0;
            // 清空棋盘
            // 清空list
            btn.setText("开始游戏");
            for(int i=0;i<19;i++)
            {
                for(int j=0;j<19;j++)
                {
                    arr[i][j]=0;
                }
            }
       for(int i=1;i<=count;i++)
            {
                chessList[i-1]=null;
            }
            go.paint(g);
            count = 0;
        } else if (btnStr.equals("悔棋")) {
            if(flag == 0){
                return;
            }
            if(count<=1){
                return;
            }
            //if(count>1)
            {
                // 取出List中最后的两颗棋子
                Chess chess1 = chessList[count - 1];
                Chess chess2 = chessList[count - 2];
                // 删除二维数组中最后的两颗棋子
                arr[chess1.r-1][chess1.c-1] = 0;
                arr[chess2.r-1][chess2.c-1] = 0;
                // 删除list中的最后两颗棋子
                chessList[count - 1] = null;
                chessList[count - 2] = null;
                count -= 2;
                go.paint(g);
                go.paint1(g);
            }
            // 界面刷新
            }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        c = (x - 35) / 30 + 1;
        r = (y - 35) / 30 + 1;
        a = 36 + 30 * (c - 1);
        b = 36 + 30 * (r - 1);
        if (x <= 35 || x > 605 || y <= 35 || y > 605) {
            JOptionPane.showMessageDialog(null, "不在下棋范围内！！");
            return;
        }
        if (arr[r - 1][c - 1] != 0) {
            JOptionPane.showMessageDialog(null, "此处已有棋子！！");
            return;
        }

        if (flag == 1) {                               //黑棋
            Color color1 = new Color(0, 0, 0);
            g.setColor(color1);
            g.fillOval(a, b, 28, 28);
            arr[r - 1][c - 1] = 1;
            Chess chess = new Chess(r, c, count, 1);
            chessList[count] = chess;
            count++;
            g.setColor(Color.WHITE);
            g.setFont(new Font("黑体", Font.BOLD, 15));
            g.drawString("" + count, a + 7, b + 20);
            for (int i = 4; i < 19; i++) {
                for (int j = 0; j < 15; j++) {
                    //上方
                    if (arr[i][j] == 1 && arr[i - 1][j] == 1 && arr[i - 2][j] == 1 && arr[i - 3][j] == 1 && arr[i - 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;

                    }
                    //右上方
                    else if (arr[i][j] == 1 && arr[i - 1][j + 1] == 1 && arr[i - 2][j + 2] == 1 && arr[i - 3][j + 3] == 1 && arr[i - 4][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j + 3] == 1 && arr[i][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 4; i < 19; i++) {
                for (int j = 4; j < 19; j++) {
                    //上方
                    if (arr[i][j] == 1 && arr[i - 1][j] == 1 && arr[i - 2][j] == 1 && arr[i - 3][j] == 1 && arr[i - 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //左上方
                    else if (arr[i][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i - 2][j - 2] == 1 && arr[i - 3][j - 3] == 1 && arr[i - 4][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //左方
                    else if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 1 && arr[i][j - 3] == 1 && arr[i][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    //下方
                    if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 2][j] == 1 && arr[i + 3][j] == 1 && arr[i + 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //右下方
                    else if (arr[i][j] == 1 && arr[i + 1][j + 1] == 1 && arr[i + 2][j + 2] == 1 && arr[i + 3][j + 3] == 1 && arr[i + 4][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j + 3] == 1 && arr[i][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 4; j < 19; j++) {
                    //左方
                    if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 1 && arr[i][j - 3] == 1 && arr[i][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //下方
                    else if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 2][j] == 1 && arr[i + 3][j] == 1 && arr[i + 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //左下方
                    else if (arr[i][j] == 1 && arr[i + 1][j - 1] == 1 && arr[i + 2][j - 2] == 1 && arr[i + 3][j - 3] == 1 && arr[i + 4][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 4; i < 19; i++) {
                for (int j = 0; j < 15; j++) {
                    //上方
                    if (arr[i][j] == 2 && arr[i - 1][j] == 2 && arr[i - 2][j] == 2 && arr[i - 3][j] == 2 && arr[i - 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右上方
                    else if (arr[i][j] == 2 && arr[i - 1][j + 1] == 2 && arr[i - 2][j + 2] == 2 && arr[i - 3][j + 3] == 2 && arr[i - 4][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2 && arr[i][j + 3] == 2 && arr[i][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 4; i < 19; i++) {
                for (int j = 4; j < 19; j++) {
                    //上方
                    if (arr[i][j] == 2 && arr[i - 1][j] == 2 && arr[i - 2][j] == 2 && arr[i - 3][j] == 2 && arr[i - 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //左上方
                    else if (arr[i][j] == 2 && arr[i - 1][j - 1] == 2 && arr[i - 2][j - 2] == 2 && arr[i - 3][j - 3] == 2 && arr[i - 4][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //左方
                    else if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 2 && arr[i][j - 3] == 2 && arr[i][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    //下方
                    if (arr[i][j] == 2 && arr[i + 1][j] == 2 && arr[i + 2][j] == 2 && arr[i + 3][j] == 2 && arr[i + 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右下方
                    else if (arr[i][j] == 2 && arr[i + 1][j + 1] == 2 && arr[i + 2][j + 2] == 2 && arr[i + 3][j + 3] == 2 && arr[i + 4][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2 && arr[i][j + 3] == 2 && arr[i][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 4; j < 19; j++) {
                    //左方
                    if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 2 && arr[i][j - 3] == 2 && arr[i][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //下方
                    else if (arr[i][j] == 2 && arr[i + 1][j] == 2 && arr[i + 2][j] == 2 && arr[i + 3][j] == 2 && arr[i + 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //左下方
                    else if (arr[i][j] == 2 && arr[i + 1][j - 1] == 2 && arr[i + 2][j - 2] == 2 && arr[i + 3][j - 3] == 2 && arr[i + 4][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }


            AI ai = new AI();
            ai.getMaxvalue(arr);
            Color color2 = new Color(255, 255, 255);
            g.setColor(color2);
            g.fillOval(36 + 30 * ai.c, 36 + 30 * ai.r, 28, 28);
            arr[ai.r][ai.c] = 2;
            Chess chess1 = new Chess(ai.r+1, ai.c+1, count, 2);
            chessList[count] = chess1;
            count++;
            g.setColor(Color.BLACK);
            g.setFont(new Font("黑体", Font.BOLD, 15));
            g.drawString("" + count, 36 + 30 * ai.c + 7, 36 + 30 * ai.r + 20);

            //判断输赢
            //黑棋胜
            // if (r >= 5 && c <= 15) {
            for (int i = 4; i < 19; i++) {
                for (int j = 0; j < 15; j++) {
                    //上方
                    if (arr[i][j] == 1 && arr[i - 1][j] == 1 && arr[i - 2][j] == 1 && arr[i - 3][j] == 1 && arr[i - 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;

                    }
                    //右上方
                    else if (arr[i][j] == 1 && arr[i - 1][j + 1] == 1 && arr[i - 2][j + 2] == 1 && arr[i - 3][j + 3] == 1 && arr[i - 4][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j + 3] == 1 && arr[i][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 4; i < 19; i++) {
                for (int j = 4; j < 19; j++) {
                    //上方
                    if (arr[i][j] == 1 && arr[i - 1][j] == 1 && arr[i - 2][j] == 1 && arr[i - 3][j] == 1 && arr[i - 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //左上方
                    else if (arr[i][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i - 2][j - 2] == 1 && arr[i - 3][j - 3] == 1 && arr[i - 4][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //左方
                    else if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 1 && arr[i][j - 3] == 1 && arr[i][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    //下方
                    if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 2][j] == 1 && arr[i + 3][j] == 1 && arr[i + 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //右下方
                    else if (arr[i][j] == 1 && arr[i + 1][j + 1] == 1 && arr[i + 2][j + 2] == 1 && arr[i + 3][j + 3] == 1 && arr[i + 4][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j + 3] == 1 && arr[i][j + 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 4; j < 19; j++) {
                    //左方
                    if (arr[i][j] == 1 && arr[i][j - 1] == 1 && arr[i][j - 2] == 1 && arr[i][j - 3] == 1 && arr[i][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //下方
                    else if (arr[i][j] == 1 && arr[i + 1][j] == 1 && arr[i + 2][j] == 1 && arr[i + 3][j] == 1 && arr[i + 4][j] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                    //左下方
                    else if (arr[i][j] == 1 && arr[i + 1][j - 1] == 1 && arr[i + 2][j - 2] == 1 && arr[i + 3][j - 3] == 1 && arr[i + 4][j - 4] == 1) {
                        JOptionPane.showMessageDialog(null, "黑棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 4; i < 19; i++) {
                for (int j = 0; j < 15; j++) {
                    //上方
                    if (arr[i][j] == 2 && arr[i - 1][j] == 2 && arr[i - 2][j] == 2 && arr[i - 3][j] == 2 && arr[i - 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右上方
                    else if (arr[i][j] == 2 && arr[i - 1][j + 1] == 2 && arr[i - 2][j + 2] == 2 && arr[i - 3][j + 3] == 2 && arr[i - 4][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2 && arr[i][j + 3] == 2 && arr[i][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 4; i < 19; i++) {
                for (int j = 4; j < 19; j++) {
                    //上方
                    if (arr[i][j] == 2 && arr[i - 1][j] == 2 && arr[i - 2][j] == 2 && arr[i - 3][j] == 2 && arr[i - 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //左上方
                    else if (arr[i][j] == 2 && arr[i - 1][j - 1] == 2 && arr[i - 2][j - 2] == 2 && arr[i - 3][j - 3] == 2 && arr[i - 4][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //左方
                    else if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 2 && arr[i][j - 3] == 2 && arr[i][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    //下方
                    if (arr[i][j] == 2 && arr[i + 1][j] == 2 && arr[i + 2][j] == 2 && arr[i + 3][j] == 2 && arr[i + 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右下方
                    else if (arr[i][j] == 2 && arr[i + 1][j + 1] == 2 && arr[i + 2][j + 2] == 2 && arr[i + 3][j + 3] == 2 && arr[i + 4][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //右方
                    else if (arr[i][j] == 2 && arr[i][j + 1] == 2 && arr[i][j + 2] == 2 && arr[i][j + 3] == 2 && arr[i][j + 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 4; j < 19; j++) {
                    //左方
                    if (arr[i][j] == 2 && arr[i][j - 1] == 2 && arr[i][j - 2] == 2 && arr[i][j - 3] == 2 && arr[i][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //下方
                    else if (arr[i][j] == 2 && arr[i + 1][j] == 2 && arr[i + 2][j] == 2 && arr[i + 3][j] == 2 && arr[i + 4][j] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                    //左下方
                    else if (arr[i][j] == 2 && arr[i + 1][j - 1] == 2 && arr[i + 2][j - 2] == 2 && arr[i + 3][j - 3] == 2 && arr[i + 4][j - 4] == 2) {
                        JOptionPane.showMessageDialog(null, "白棋获胜");
                        flag = 0;
                        return;
                    }
                }
            }
            AI ai1 = new AI();
            ai1.getMaxvalue(arr);
        }
    }


    public void mousePressed(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }

}
