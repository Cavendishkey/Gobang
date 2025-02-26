package lql2022.lql0805;

import java.sql.SQLOutput;
import java.util.HashMap;

public class AI {
      public static void main(String[] args) {
        int[][] arr={
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        };
        new AI().getMaxvalue(arr);
    }


    int max=0;
    int r=0;
    int c=0;
    HashMap<String,Integer>  codeMap =new HashMap<>();

    {
        codeMap.put("000",0);

        codeMap.put("010", 20);
        codeMap.put("0110", 65);
        codeMap.put("01110", 120);
        codeMap.put("011110", 210);

        codeMap.put("020", 20);
        codeMap.put("0220",65);
        codeMap.put("02220",120);
        codeMap.put("022220", 210);

        codeMap.put("01", 6);
        codeMap.put("011", 30);
        codeMap.put("0111", 35);
        codeMap.put("01111", 200);

        codeMap.put("02", 6);
        codeMap.put("022", 30);
        codeMap.put("0222", 35);
        codeMap.put("02222", 200);
    }

    public void getMaxvalue(int[][] arr)
    {
        int[][] value=new int[19][19];
        for(int i=0;i<19;i++) {
            for (int j = 0; j < 19; j++) {
                if(arr[i][j]!=0)
                    value[i][j]=0;
            }
        }

        for(int i=0;i<19;i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] == 0) {
                    setvalue1(value, arr, i, j);
                    setvalue2(value, arr, i, j);
                    setvalue3(value, arr, i, j);
                    setvalue4(value, arr, i, j);
                    setvalue5(value, arr, i, j);
                    setvalue6(value, arr, i, j);
                    setvalue7(value, arr, i, j);
                    setvalue8(value, arr, i, j);
                }
            }
        }

        for(int i=0;i<19;i++)
        {
            for (int j = 0; j <19; j++)
            {
                if(value[i][j]>max) {
                    max = value[i][j];
                    r = i;
                    c = j;
                }
            }
        }

    }

    //向右
    public void setvalue1(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (j == 18) {
            return;
        }
        if (j < 18) {
            int flag1 = arr[i][j + 1];
            for (int k = j; k < arr[i].length-1; k++) {
                if (arr[i][k + 1] == flag1) {
                    s += flag1;
                }
                if (arr[i][k + 1] == 0) {
                    s += 0;
                    break;
                }
                if (arr[i][k + 1] != flag1)
                    break;
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

    //向左
    public void setvalue2(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (j == 0) {
            return;
        }
        if (j > 0) {
            int flag1 = arr[i][j -1];
            for (int k = j; k >0; k--) {
                if (arr[i][k - 1] == flag1) {
                    s += flag1;
                }
                if (arr[i][k - 1] == 0) {
                    s += 0;
                    break;
                }
                if (arr[i][k - 1] != flag1)
                    break;
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

    //向下
    public void setvalue3(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (i == 18) {
            return;
        }
        if (i < 18) {
            int flag1 = arr[i+1][j];
            for (int k = i; k < arr[j].length-1; k++) {
                if (arr[k+1][j] == flag1) {
                    s += flag1;
                }
                if (arr[k+1][j] == 0) {
                    s += 0;
                    break;
                }
                if (arr[k+1][j] != flag1)
                    break;
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

    //向上
    public void setvalue4(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (i==0) {
            return;
        }
        if (i>0) {
            int flag1 = arr[i-1][j];
            for (int k = i; k >0; k--) {
                if (arr[k-1][j] == flag1) {
                    s += flag1;
                }
                if (arr[k-1][j] == 0) {
                    s += 0;
                    break;
                }
                if (arr[k-1][j] != flag1)
                    break;
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

    //向右下
    public void setvalue5(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (j == 18||i==18) {
            return;
        }
        if (j < 18&&i<18) {
            int flag1 = arr[i+1][j+ 1];
            if(i>j)
            {
                for (int k = i; k < arr[j].length - 1; k++) {
                    if (arr[k + 1][j + 1+k-i] == flag1) {
                        s += flag1;
                    }
                    if (arr[k + 1][j + 1+k-i] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[k + 1][j + 1+k-i] != flag1)
                        break;
                }
            }
            else
            {
                for (int k = j; k < arr[i].length - 1; k++) {
                    if (arr[i + 1+k-j][k + 1] == flag1) {
                        s += flag1;
                    }
                    if (arr[i + 1+k-j][k + 1] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[i + 1+k-j][k + 1] != flag1)
                        break;
                }
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

    //向左上
    public void setvalue6(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (j ==0||i==0) {
            return;
        }
        if (j >0&&i>0) {
            int flag1 = arr[i-1][j -1];
            if(i>j) {
                for (int k = j; k > 0; k--) {
                    if (arr[i - 1+k-j][k - 1] == flag1) {
                        s += flag1;
                    }
                    if (arr[i-1+k-j][k -1] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[i-1+k-j][k - 1] != flag1)
                        break;
                }
            }else
            {
                for (int k = i; k > 0; k--) {
                    if (arr[k-1][j - 1+k-i] == flag1) {
                        s += flag1;
                    }
                    if (arr[k-1][j -1+k-i] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[k-1][j- 1+k-i] != flag1)
                        break;
                }
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

    //向右上
    public void setvalue7(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (j == 18||i==0) {
            return;
        }
        if (j < 18&&i>0) {
            int flag1 = arr[i-1][j + 1];
            if((18-j)>i) {
                for (int k = i; k >0; k--) {
                    if (arr[k-1][j+ 1-k+i] == flag1) {
                        s += flag1;
                    }
                    if (arr[k-1][j + 1-k+i] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[k-1][j+ 1-k+i] != flag1)
                        break;
                }
            }else
            {
                for (int k = j; k < arr[j].length - 1; k++) {
                    if (arr[i-1-k+j][k+1] == flag1) {
                        s += flag1;
                    }
                    if (arr[i-1-k+j][k+1] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[i-1-k+j][k+1] != flag1)
                        break;
                }
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

    //向左下
    public void setvalue8(int[][]value,int[][]arr,int i,int j) {
        String s = "0";
        if (i == 18||j==0) {
            return;
        }
        if (i < 18&&j>0) {
            int flag1 = arr[i+1][j - 1];
            if(j<(18-i)) {
                for (int k = j; k >0; k--) {
                    if (arr[i+1-k+j][k-1] == flag1) {
                        s += flag1;
                    }
                    if (arr[i+1-k+j][k - 1] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[i+1-k+j][k - 1] != flag1)
                        break;
                }
            }else
            {
                for (int k = i; k <arr[j].length; k++) {
                    if (arr[k+1][j-1-k+i] == flag1) {
                        s += flag1;
                    }
                    if (arr[k+1][j - 1-k+i] == 0) {
                        s += 0;
                        break;
                    }
                    if (arr[k+1][j- 1-k+i] != flag1)
                        break;
                }
            }
            int val = codeMap.get(s);
            value[i][j] += val;
        }
    }

}
