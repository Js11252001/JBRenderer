import javax.swing.*;
import java.awt.*;

//生成图像渲染画布
public class Display extends Canvas {
    private final JFrame m_frame;//windows to display the canvas

    public Display(int width, int height, String title)
    {
        Dimension size = new Dimension(width,height);
        //固定大小
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        m_frame = new JFrame();
        m_frame.add(this);//添加画布
        m_frame.pack();//调整frame大小适应画布
        m_frame.setResizable(false);//不能修改分辨率
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//有关闭的x按钮
        m_frame.setLocationRelativeTo(null);//窗口在屏幕中间
        m_frame.setTitle(title);
        m_frame.setVisible(true);
    }
}
