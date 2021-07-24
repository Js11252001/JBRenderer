import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

//生成图像渲染画布
public class Display extends Canvas
{
    private final JFrame m_frame;//windows to display the canvas
    // 帧缓存——用于显示图像的缓存 包含图像的各种深度颜色等信息
    // 位图——使用像素阵列表示的图像
    private final Bitmap m_frameBuffer;
    //显示图片的像素，数组组件
    private final byte[] m_displayComponents;
    private final BufferStrategy m_bufferStrategy;
    //用于绘制的图形对象
    private final Graphics m_graphics;
    //有图形缓冲区的图像
    private final BufferedImage m_displayImage;
    /**
     * Create and initializes a new display.
     * @param width How wide the display is, in pixels.
     * @param height How tall the display is, in pixels.
     * @param title The text displayed in the window's title bar.
     */
    public Display(int width, int height, String title)
    {
        Dimension size = new Dimension(width,height);
        //固定大小
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        m_frameBuffer = new Bitmap(width,height);
        m_displayImage = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);//用于像素的数据类型bgr
        m_displayComponents = ((DataBufferByte)m_displayImage.getRaster().getDataBuffer()).getData();

        m_frame = new JFrame();
        m_frame.add(this);//添加画布
        m_frame.pack();//调整frame大小适应画布
        m_frame.setResizable(false);//不能修改分辨率
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//有关闭的x按钮
        m_frame.setLocationRelativeTo(null);//窗口在屏幕中间
        m_frame.setTitle(title);
        m_frame.setVisible(true);

        //分配缓冲区 通过strategy和graphic来访问
        createBufferStrategy(1);
        m_bufferStrategy = getBufferStrategy();
        m_graphics = m_bufferStrategy.getDrawGraphics();
    }

    /**
     * Displays in the window
     */
    public void SwapBuffers()
    {
        m_frameBuffer.CopyToByteArray(m_displayComponents);
        m_graphics.drawImage(m_displayImage,0,0,m_frameBuffer.GetWidth(), m_frameBuffer.GetHeight(), null);
        m_bufferStrategy.show();
    }
    public Bitmap GetFrameBuffer()
    {
        return m_frameBuffer;
    }
}
