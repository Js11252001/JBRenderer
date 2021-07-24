import java.util.Arrays;

public class Bitmap
{
    //像素的宽高
    private final int m_width;
    private final int m_height;
    private final byte m_components[];//代表像素的a，r，g，b

    /**
     * Creates and initializes a Bitmap
     * @param width The width, in pixels, of the image.
     * @param height The height, in pixels, of the image.
     */
    public Bitmap(int width, int height)
    {
        m_width = width;
        m_height = height;
        m_components = new byte[width * height * 4];
    }

    public int GetWidth()
    {
        return m_width;
    }

    public int GetHeight()
    {
        return m_height;
    }
    /**
     * Sets every pixel in the bitmap to a specific shade of grey
     */
    public void Clear(byte shade)
    {
        Arrays.fill(m_components,shade); //变成特定阴影
    }

    /**
     * Sets the pixel at (x,y) to the color specified by (a,r,g,b)
     */
    public void DrawPixel(int x, int y, byte a, byte b,byte g, byte r)
    {
        int index = (x + y * m_width) * 4;
        m_components[index] = a;
        m_components[index + 1] = b;
        m_components[index + 2] = g;
        m_components[index + 3] = r;
    }
    public void CopyToByteArray(byte[] dest)
    {
        for (int i = 0; i < m_width * m_height; i++)
        {
            dest[i * 3] = m_components[i * 4 + 1];
            dest[i * 3 + 1] = m_components[i * 4 + 2];
            dest[i * 3 + 2] = m_components[i * 4 + 3];
        }
    }

//    public void CopyToIntArray(int[] dest)//char一个字节 int是4个字节
//    {
//        for (int i = 0; i < m_width * m_height; i++)
//        {
//            //位操作 让一个int存储argb的所有数据
//            int a = (int)m_components[i * 4] << 24;
//            int r = (int)m_components[i * 4 + 1] << 16;
//            int g = (int)m_components[i * 4 + 2] << 8;
//            int b = (int)m_components[i * 4 + 3];
//
//            dest[i] = a | r | g | b;
//        }
//    }
}
