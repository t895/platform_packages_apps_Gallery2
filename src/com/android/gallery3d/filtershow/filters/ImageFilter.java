
package com.android.gallery3d.filtershow.filters;

import android.graphics.Bitmap;

public class ImageFilter implements Cloneable {

    protected int mMaxParameter = 100;
    protected int mMinParameter = -100;
    protected int mDefaultParameter = 0;
    protected int mParameter = 0;
    protected String mName = "Original";
    private final String LOGTAG = "ImageFilter";
    public static final byte TYPE_BORDER =1;
    public static final byte TYPE_FX  = 2;
    public static final byte TYPE_WBALANCE = 3;
    public static final byte TYPE_VIGNETTE = 4;
    public static final byte TYPE_NORMAL = 5;
    private byte filterType = TYPE_NORMAL;

    public byte getFilterType(){
        return filterType;
    }

    protected void setFilterType(byte type){
        filterType = type;
    }

    @Override
    public ImageFilter clone() throws CloneNotSupportedException {
        ImageFilter filter = (ImageFilter) super.clone();
        filter.setName(getName());
        filter.setParameter(getParameter());
        filter.setFilterType(filterType);
        filter.mMaxParameter = mMaxParameter;
        filter.mMinParameter = mMinParameter;
        filter.mDefaultParameter = mDefaultParameter;
        return filter;
    }

    public boolean isNil() {
        if (mParameter == mDefaultParameter) {
            return true;
        }
        return false;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public Bitmap apply(Bitmap bitmap, float scaleFactor, boolean highQuality) {
        // do nothing here, subclasses will implement filtering here
        return bitmap;
    }

    public int getParameter() {
        return mParameter;
    }

    public void setParameter(int value) {
        mParameter = value;
    }

    /**
     * The maximum allowed value (inclusive)
     * @return maximum value allowed as input to this filter
     */
    public int getMaxParameter(){
        return mMaxParameter;
    }

    /**
     * The minimum allowed value (inclusive)
     * @return minimum value allowed as input to this filter
     */
    public int getMinParameter(){
        return mMinParameter;
    }

    /**
     * Returns the default value returned by this filter.
     * @return default value
     */
    public int getDefaultParameter(){
        return mDefaultParameter;
    }

    public boolean same(ImageFilter filter) {
        if (!filter.getName().equalsIgnoreCase(getName())) {
            return false;
        }
        return true;
    }

    native protected void nativeApplyGradientFilter(Bitmap bitmap, int w, int h,
            int[] redGradient, int[] greenGradient, int[] blueGradient);

}
