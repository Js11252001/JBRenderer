public class Stars3D
{
    private final float m_speed;
    private final float m_spread;

    private final float mStarX[];
    private final float mStarY[];
    private final float mStarZ[];
    public Stars3D(int numbers, float spread, float speed)
    {
        m_speed = speed;
        m_spread = spread;
        mStarX = new float[numbers];
        mStarY = new float[numbers];
        mStarZ = new float[numbers];

        for (int i = 0; i < mStarX.length; i++)
        {
            InitStar(i);
        }
    }

    private void InitStar(int index)
    {
        mStarX[index] = 2 * ((float)Math.random() - 0.5f) * m_spread;
        mStarY[index] = 2 * ((float)Math.random() - 0.5f) * m_spread;
        mStarZ[index] = ((float)Math.random() + 0.00001f) * m_spread;
    }

    public void UpdateAndRender(Bitmap target, float delta)
    {
        target.Clear((byte)0x00);

        float halfWidth = target.GetWidth()/2.0f;
        float halfHeight = target.GetHeight()/2.0f;
        for (int i = 0; i < mStarX.length; i++)
        {
            mStarZ[i] -= delta * m_speed;
            if(mStarZ[i] <= 0)
            {
                InitStar(i);
            }
            int x = (int)((mStarX[i])/mStarZ[i] * halfWidth + halfWidth);
            int y = (int)((mStarY[i])/mStarZ[i] * halfHeight + halfHeight);

            if ( x < 0 || x >= target.GetWidth() || (y < 0 || y >= target.GetHeight()) )
            {
                InitStar(i);
            }
            else
            {
                target.DrawPixel(x,y,(byte)0xFF,(byte)0xFF,(byte)0xFF,(byte)0xFF);
            }
        }
    }
}
